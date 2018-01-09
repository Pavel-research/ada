package org.ada.metamodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.ocpsoft.prettytime.shade.edu.emory.mathcs.backport.java.util.Collections;
import org.raml.store.IResolvableCollection;
import org.raml.store.IResolvableEntityType;
import org.raml.store.Store;
import org.raml.store.StoreEntity;
import org.raml.store.StoreManager;
import org.raml.vocabularies.Vocabulary;

import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.impl.ContainingProperty;
import com.onpositive.clauses.impl.InverseProperty;
import com.onpositive.clauses.impl.JoinProperty;
import com.onpositive.clauses.impl.PathProperty;
import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;
import com.onpositive.model.ITypedEntity;
import com.onpositive.model.ITypedStore;
import com.onpositive.model.IUniverse;

public class TypedStore implements ITypedStore {

	protected Store ts;
	protected Universe universe;
	private String storePrefix;

	public TypedStore(Store ts, Universe universe, String storePrefix) {
		super();
		this.ts = ts;
		this.storePrefix = storePrefix;
		this.universe = universe;
	}

	public static ITypedStore getDebugInstance() throws IOException {
		Store st = StoreManager.getDebugStore();
		Universe loadFrom = new VocabularyLoader()
				.loadFrom(new Vocabulary(Universe.class.getResource("/definition.yaml")));
		TypedStore typedStore = new TypedStore(st, loadFrom, "http://github.org/model#");
		return typedStore;
	}

	protected ArrayList<ITypedEntity> all;
	protected HashMap<String, ITypedEntity> map;

	public ITypedEntity getInstance(String id) {
		if (all == null) {
			allInstances();
		}
		return map.get(id);
	}

	@Override
	public Collection<ITypedEntity> allInstances() {
		if (all == null) {
			all = new ArrayList<>();
			map = new HashMap<>();
			ts.entities().forEach(e -> {
				IResolvableEntityType type = e.type();
				TypedEntity e2 = new TypedEntity(e, getType(type));
				map.put(e2.id(), e2);
				all.add(e2);
			});
		}
		return all;
	}

	private EntityClass getType(IResolvableEntityType type) {
		EntityClass entityClass = universe.types.get(storePrefix + type.name());
		if (entityClass == null) {
			throw new IllegalStateException();
		}
		return entityClass;
	}

	@Override
	public IType get(String name) {
		return universe.types.get(storePrefix + name);
	}

	@Override
	public Collection<Object> execute(ISelector selector) {
		Stream<Object> values = selector.values(new BasicContext(this));
		Set<Object> collect = values.collect(Collectors.toSet());
		return collect;
	}

	Object convert(Object property, IProperty p) {
		if (property instanceof StoreEntity) {
			StoreEntity st = (StoreEntity) property;
			return getInstance(st.iri());
		}
		if (property instanceof Collection<?>) {
			Collection<?> mm = (Collection<?>) property;
			return mm.stream().map(x -> convert(x, p)).collect(Collectors.toList());
		}
		if (p.range() instanceof IClass && property instanceof String) {
			if (map.containsKey(property)) {
				return map.get(property);
			}
		}
		return property;
	}

	static class InversePropertyCache {
		protected HashMap<Object, LinkedHashSet<Object>> values = new HashMap<>();

		void record(Object o, Object val) {
			LinkedHashSet<Object> linkedHashSet = values.get(o);
			if (linkedHashSet == null) {
				linkedHashSet = new LinkedHashSet<>();
				values.put(o, linkedHashSet);
			}
			linkedHashSet.add(val);
		}
	}

	HashMap<InverseProperty, InversePropertyCache> ic = new HashMap<>();

	public Object getValue(Object obj, IProperty p) {

		if (p instanceof ContainingProperty) {
			ContainingProperty cp = (ContainingProperty) p;
			IType range = cp.range();
			TypedEntity te = (TypedEntity) obj;
			IResolvableEntityType type = te.entity.type();
			Collection<? extends IResolvableCollection> nested = type.nested();
			for (IResolvableCollection m : nested) {
				if (m.componentType().name().equals(range.name())) {
					List<StoreEntity> children = te.entity.children(m.name());
					if (children != null) {
						ArrayList<ITypedEntity> tes = new ArrayList<>(children.size());
						for (StoreEntity e : children) {
							tes.add(map.get(e.iri()));
						}
						return tes;
					}
				}
			}
			return Collections.emptyList();
		}
		if (p instanceof InverseProperty) {
			InverseProperty new_name = (InverseProperty) p;
			InversePropertyCache ck = ic.get(new_name);
			if (ck == null) {
				IProperty original = new_name.getOriginal();
				InversePropertyCache lc = new InversePropertyCache();
				ck = lc;
				ic.put(new_name, ck);
				allInstancesOf(original.domain()).forEach(v -> {
					Collection<?> mm = getAsCollection(original, v);
					for (Object z : mm) {
						lc.record(z, v);
					}
				});
			}
			LinkedHashSet<Object> linkedHashSet = ck.values.get(obj);
			if (linkedHashSet == null) {
				linkedHashSet = new LinkedHashSet<>();
			}
			return linkedHashSet;
		} else if (obj instanceof TypedEntity) {
			TypedEntity ts = (TypedEntity) obj;
			if (p instanceof Property) {
				Object property = ts.entity.property(((Property) p).getStoreId());
				return convert(property, p);
			}
			if (p instanceof JoinProperty) {
				JoinProperty pa = (JoinProperty) p;
				LinkedHashSet<Object> vls = new LinkedHashSet<>();
				pa.getPath().forEach(p0 -> {
					vls.addAll(getAsCollection(p0, ts));
				});
				return vls;
			}
			if (p instanceof PathProperty) {
				PathProperty ps = (PathProperty) p;
				List<IProperty> path = ps.getPath();
				Collection<Object> step = Collections.singleton(ts);
				for (int i = 0; i < path.size(); i++) {
					IProperty iProperty = path.get(i);
					LinkedHashSet<Object> results = new LinkedHashSet<>();
					for (Object o : step) {
						if (o instanceof ITypedEntity) {
							Collection<?> asCollection = getAsCollection(iProperty, (ITypedEntity) o);
							results.addAll(asCollection);
						}
					}
					step=results;
				}
				return step;
			}
			Object property = ts.entity.property(p.name());
			return convert(property, p);
		}
		return null;
	}

	private Collection<?> getAsCollection(IProperty original, ITypedEntity v) {
		Object val = getValue(v, original);
		if (val == null) {
			return Collections.emptySet();
		}
		Collection<?> mm = null;
		if (val instanceof Collection<?>) {
			mm = (Collection<?>) val;
		} else {
			mm = Collections.singleton(val);
		}
		return mm;
	}

	@Override
	public IUniverse universe() {
		return universe;
	}

	HashMap<IType, Collection<ITypedEntity>> instancesCache = new HashMap<>();

	@Override
	public Stream<ITypedEntity> allInstancesOf(IType t) {
		if (instancesCache.containsKey(t)) {
			return instancesCache.get(t).stream();
		}
		Stream<ITypedEntity> filter = allInstances().stream().filter(x -> x.type().isSubtypeOf(t));
		Set<ITypedEntity> rs = filter.collect(Collectors.toSet());
		instancesCache.put(t, rs);
		return rs.stream();
	}

	@Override
	public Object property(Object x, IProperty property) {
		return getValue(x, property);
	}

	@Override
	public ITypedStore store() {
		return this;
	}
}
