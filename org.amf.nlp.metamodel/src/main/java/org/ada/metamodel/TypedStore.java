package org.ada.metamodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.raml.store.IResolvableEntityType;
import org.raml.store.Store;
import org.raml.store.StoreEntity;
import org.raml.store.StoreManager;
import org.raml.vocabularies.Vocabulary;

import com.onpositive.clauses.IClause;
import com.onpositive.clauses.ICompositeSelector;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.impl.Aggregators;
import com.onpositive.clauses.impl.AllInstancesOf;
import com.onpositive.clauses.impl.AndSelector;
import com.onpositive.clauses.impl.ClauseSelector;
import com.onpositive.clauses.impl.MapByProperty;
import com.onpositive.clauses.impl.PropertyFilter;
import com.onpositive.clauses.impl.SingleSelector;
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

	public static ITypedStore getDebugInstance() throws IOException{
		Store st=StoreManager.getDebugStore();
		Universe loadFrom = new VocabularyLoader().loadFrom(new Vocabulary(Universe.class.getResource("/definition.yaml")));
		TypedStore typedStore = new TypedStore(st, loadFrom,"http://github.org/model#");
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
		if (selector instanceof ICompositeSelector) {
			ICompositeSelector as = (ICompositeSelector) selector;
			List<Collection<Object>> map = as.members().stream().map(x -> execute(selector))
					.collect(Collectors.toList());
			LinkedHashSet<Object> object = null;
			for (Collection<Object> m : map) {
				if (object == null) {
					object = new LinkedHashSet<>();
					object.addAll(m);
				} else {
					if (selector instanceof AndSelector) {
						object.retainAll(m);
					} else {
						object.addAll(m);
					}
				}
			}
			return object;
		} else if (selector instanceof SingleSelector) {
			SingleSelector sl = (SingleSelector) selector;
			return sl.getValue();
		} else if (selector instanceof AllInstancesOf) {
			return allInstances().stream().filter(x -> x.type().isSubtypeOf(selector.domain()))
					.collect(Collectors.toList());
		} else if (selector instanceof ClauseSelector) {
			ClauseSelector cl = (ClauseSelector) selector;
			ISelector parent = cl.parent();
			Collection<Object> execute = execute(parent);
			IClause clause = cl.clause();
			if (clause instanceof Aggregators) {
				Aggregators agg = (Aggregators) clause;
				Object result = null;
				switch (agg.getMode()) {
				case COUNT:
					result = execute.size();
					break;
				case AVG:

				case MAX:
				case MIN:
				case SUM:
					throw new IllegalStateException("Not Implemented");
				default:
					break;
				}
				return Collections.singletonList(result);
			} else if (clause instanceof MapByProperty) {
				MapByProperty mp = (MapByProperty) clause;
				IProperty property = mp.property();
				return execute.stream().map(x -> getValue(x, property)).collect(Collectors.toList());
			} else if (clause instanceof PropertyFilter) {
				PropertyFilter pf = (PropertyFilter) clause;
//				ISelector predicate = pf.predicate();
//				IProperty property = pf.property();
//				PropertyFilterMode mode = pf.mode();
//				Collection<Object> values = execute(predicate);
//				LinkedHashSet<Object> fvalues = new LinkedHashSet<>(values);
//				return execute.stream().filter(x -> filter(getValue(x, property), mode, fvalues))
//						.collect(Collectors.toList());
			} else {
				throw new IllegalStateException("Unknown clause:" + cl);
			}
		}
		return null;
	}

//	boolean filter(Object obj, PropertyFilterMode mode, Collection<Object> args) {
//		Collection<Object> collection = toCollection(obj);
//		switch (mode) {
//		case COUNT_EQUAL:
//			int nm = toNumb(args);
//			return collection.size() == nm;
//		case COUNT_GREATER:
//			nm = toNumb(args);
//			return collection.size() > nm;
//		case COUNT_LESS:
//			nm = toNumb(args);
//			return collection.size() < nm;
//		case HAS_ALL:
//			for (Object o:args){
//				if (!collection.contains(o)){
//					return false;
//				}
//			}
//			return true;
//		case HAS_ANY:
//			for (Object o:args){
//				if (collection.contains(o)){
//					return true;
//				}
//			}
//		case HAS_GREATER:
//			throw new UnsupportedOperationException();
//		case HAS_LESS:
//			throw new UnsupportedOperationException();
//		case HAS_NOT_ALL:
//			for (Object o:args){
//				if (collection.contains(o)){
//					return false;
//				}
//			}
//			return true;
//		case HAS_NOT_ANY:
//			for (Object o:args){
//				if (collection.contains(o)){
//					return false;
//				}
//			}
//			return true;
//		default:
//			break;
//		}
//		return false;
//	}

	@SuppressWarnings("unchecked")
	private Collection<Object> toCollection(Object obj) {
		if (obj instanceof Collection<?>) {
			return (Collection<Object>) obj;
		}
		return Collections.singleton(obj);
	}

	private int toNumb(Collection<Object> args) {
		if (args.size() == 1) {
			if (args.iterator().next() instanceof Number) {
				return ((Number) args.iterator().next()).intValue();
			}
		}
		return args.size();
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
		return property;
	}

	public Object getValue(Object obj, IProperty p) {
		if (obj instanceof TypedEntity) {
			TypedEntity ts = (TypedEntity) obj;
			Object property = ts.entity.property(p.name());
			return convert(property, p);

		}
		return null;
	}

	@Override
	public IUniverse universe() {
		return universe;
	}
}
