package com.ada.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.ada.metamodel.Property;

import com.ada.model.AndComparison;
import com.ada.model.Comparative;
import com.ada.model.Comparative.Kind;
import com.ada.model.Comparison;
import com.ada.model.GenericTime;
import com.ada.model.IScalarWithDimension;
import com.ada.model.Measure;
import com.ada.model.NumberInDomain;
import com.ada.model.OrComparison;
import com.ada.model.PropertyComparison;
import com.ada.model.PropertyValue;
import com.ada.model.SimpleRelativeComparison;
import com.ada.model.TopValues;
import com.ada.model.conditions.IHasDomain;
import com.onpositive.clauses.IClause;
import com.onpositive.clauses.IComparison;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.clauses.impl.Aggregators;
import com.onpositive.clauses.impl.AllInstancesOf;
import com.onpositive.clauses.impl.Clause;
import com.onpositive.clauses.impl.ClauseSelector;
import com.onpositive.clauses.impl.ContainmentClause;
import com.onpositive.clauses.impl.ContainmentNestedClause;
import com.onpositive.clauses.impl.InverseProperty;
import com.onpositive.clauses.impl.JoinProperty;
import com.onpositive.clauses.impl.MapByProperty;
import com.onpositive.clauses.impl.NumberProperty;
import com.onpositive.clauses.impl.OrSelector;
import com.onpositive.clauses.impl.PathProperty;
import com.onpositive.clauses.impl.PropertyFilter;
import com.onpositive.clauses.impl.SingleSelector;
import com.onpositive.model.Builtins;
import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class BasicLogic {

	@Clause("LAST_DATE")
	public static IHasDomain lastDate(GenericTime t) {
		return t.last();
	}

	@Clause("PREV_DATE")
	public static IHasDomain prevDate(GenericTime t) {
		return t.prev();
	}

	@Clause("NEXT_DATE")
	public static IHasDomain nextDate(GenericTime t) {
		return t.next();
	}

	@Clause("COMPARISON_NUMB2")
	public static IClause nextDate(Number n, IProperty p) {
		if (p.range().equals(Builtins.INTEGER) || p.range().equals(Builtins.NUMBER)) {
			return PropertyFilter.propertyFilter(p,
					new Comparison(new NumberInDomain(p.range(), n), new Comparative(Kind.EQUAL, "eq")));
		}
		return null;
	}

	@Clause("OWNED2")
	public static IHasDomain ownedEntities(SingleSelector s, ISelector sel) {
		if (s.clazz().isPresent() && sel.clazz().isPresent()) {
			IProperty findPath = PropertyAdapter.findPath(s.clazz().get(), sel.clazz().get());
			if (findPath != null) {
				MapByProperty map = MapByProperty.map(findPath);
				if (sel instanceof ClauseSelector) {
					ClauseSelector cla = (ClauseSelector) sel;
					ClauseSelector root = cla.getRoot();
					ISelector parent = root.parent();
					if (parent instanceof AllInstancesOf && sel.domain().equals(parent.domain())) {
						return cla.cloneWithNewRoot(map.produce(s));
					}
				} else if (sel instanceof AllInstancesOf) {
					return map.produce(s);
				}
			}
		}
		return null;
	}

	@Clause("COLLAPSE_PROPVAL")
	public static ISelector collapsePropVal(PropertyValue p, ISelector s) {
		if (p.getProperty().domain().equals(s.domain())) {
			PropertyFilter propertyFilter = PropertyFilter.propertyFilter(p.getProperty(),
					new Comparison(p, new Comparative(Kind.IN, "in")));
			return propertyFilter.produce(s);
		}
		return null;
	}

	@Clause("COLLAPSE_ENTITY")
	public static ISelector collapse(ISelector s0, AllInstancesOf clazz) {
		if (s0.domain().isSubtypeOf(clazz.domain())) {
			return s0;
		}
		return null;
	}

	@Clause("MEASURE")
	public static Measure dim(Number n, ISelector sel) {
		return new Measure(n, sel);
	}

	// PROPERTY_COMPARATIVE
	@Clause("PROPERTY_COMPARATIVE")
	public static IComparison cmp(Comparative cmp, IProperty p) {
		if (cmp.getOperation() == Kind.MIN || cmp.getOperation() == Kind.MAX) {
			return new PropertyComparison(cmp, p);
		}
		return null;
	}

	@Clause("COMPARISON_NUMB")
	public static IClause cmpNump(Comparative cmp, Number n, IProperty p) {
		if (p.range().equals(Builtins.NUMBER) || p.range().equals(Builtins.INTEGER)) {
			return PropertyFilter.propertyFilter(p, new Comparison(new NumberInDomain(p.range(), n), cmp));
		}
		return null;
	}

	@Clause("OR")
	public static ISelector or(List<ISelector> prop) {
		return OrSelector.or(prop);
	}

	@Clause("TAKE_PROPERTY")
	public static ISelector takeProperty(IProperty prop, ISelector s) {
		if (s.domain().isSubtypeOf(prop.domain())) {
			return MapByProperty.map(prop).produce(s);
		}
		if (prop.range() instanceof IClass) {
			IProperty inverseProperty = InverseProperty.createInverseProperty(prop);
			if (s.domain().isSubtypeOf(inverseProperty.domain())) {
				return MapByProperty.map(inverseProperty).produce(s);
			}
		}
		IProperty adaptProperty = PropertyAdapter.adaptProperty(prop, s.domain());
		if (adaptProperty != null) {
			return new MapByProperty(adaptProperty).produce(s);
		}
		return null;
	}

	@Clause("NUMP")
	public static IProperty numberOf(IProperty prop) {
		if (prop.range().equals(Builtins.INTEGER)) {
			return prop;
		}
		return new NumberProperty(prop);
	}

	@Clause("NUMP2")
	public static ISelector numberOf(ISelector prop) {
		return Aggregators.COUNT.produce(prop);
	}

	@Clause("HAVING")
	public static ISelector partOf(ISelector base, IHasDomain parts) {
		if (base.clazz().isPresent() && parts.clazz().isPresent()) {
			IProperty ps = PropertyAdapter.findContainmentPath(base.clazz().get(), parts.clazz().get());
			if (ps != null) {
				if (parts instanceof PropertyComparison){
					//we are here;
					PropertyComparison mm=(PropertyComparison) parts;
					IProperty prop = mm.getProp();
					ArrayList<IProperty>mms=new ArrayList<>();
					mms.add(ps);
					mms.add(prop);
					return ClauseSelector.produce(base, base.domain(), Multiplicity.SINGLE, new TopValues(new PathProperty(mms), mm.getCmp().getOperation()));
				}
				return new ContainmentClause(parts, false, ps).produce(base);
			}
		}
		if (base.domain() instanceof IClass && !(base instanceof SingleSelector)) {
			if (base.domain().equals(parts.domain()) && parts instanceof PropertyComparison) {
				PropertyComparison propertyComparison = (PropertyComparison)parts;
				return new TopValues(propertyComparison.getProp(), propertyComparison.getCmp().getOperation()).produce(base);
			}
			if (parts instanceof Comparison) {
				Comparison propertyComparison = (Comparison)parts;
				IHasDomain target = propertyComparison.getTarget();
				if (target.originalDomain().equals(base.domain())){
					if (target instanceof ClauseSelector){
						ClauseSelector mmm=(ClauseSelector) target;
						IClause clause = mmm.getClause();
						if (clause instanceof MapByProperty){
							MapByProperty mp=(MapByProperty) clause;
							return ClauseSelector.produce(base, base.domain(), Multiplicity.MULTIPLE,PropertyFilter.propertyFilter(mp.property(), propertyComparison));						
						}
					}					
				}
				
			}
			if (has(base.properties(), x -> x.hasCompatibleRange(parts.domain())) && parts.clazz().isPresent()) {
				return new ContainmentClause(parts, false,
						InverseProperty.createInverseProperty(PropertyAdapter.findPath(parts.clazz().get(), base.clazz().get())))
								.produce(base);
			}
			if (has(parts.properties(), x -> x.hasCompatibleRange(base.domain()))) {
				return new ContainmentClause(parts, false,
						PropertyAdapter.findPath(base.clazz().get(), parts.clazz().get())).produce(base);
			}
		}
		return null;
	}

	@Clause("CONTAINED_SC")
	public static ISelector contained(ISelector base, IScalarWithDimension owner) {
		List<IProperty> properties = base.properties().stream().filter(x -> x.range().isSubtypeOf(owner.domain()))
				.collect(Collectors.toList());
		if (!properties.isEmpty()) {
			if (properties.size() == 1) {
				PropertyFilter vv = PropertyFilter.propertyFilter(properties.get(0),
						new Comparison(owner, new Comparative(Kind.IN, "in")));
				return vv.produce(base);
			}
			List<IProperty> usedProperties = base.usedProperties();
			for (IProperty p : usedProperties) {
				if (p instanceof Property) {
					Property mm = (Property) p;
					List<IProperty> related = mm.getRelated();
					properties.retainAll(related);
					if (properties.size() == 1) {
						PropertyFilter vv = PropertyFilter.propertyFilter(properties.get(0),
								new Comparison(owner, new Comparative(Kind.IN, "in")));
						return vv.produce(base);
					}
				}
			}
		}
		return null;
	}

	@Clause("CONTAINED")
	public static ISelector contained(ISelector base, IHasDomain owner) {
		if (base.clazz().isPresent() && owner.clazz().isPresent()) {
			IProperty ps = PropertyAdapter.findContainmentPath(owner.clazz().get(), base.clazz().get());
			if (ps != null) {
				return new ContainmentClause(owner, true,InverseProperty.createInverseProperty(ps)).produce(base);
			}
		}
		if (base.domain() instanceof IClass && !(base instanceof SingleSelector)) {
			IType d = owner.domain();
			if (d instanceof IClass) {
				IProperty findPath = PropertyAdapter.findPath((IClass) base.domain(), (IClass) d);
				if (findPath != null || (d == Builtins.ALLMATCH)) {

					return new ContainmentClause(owner, true, findPath).produce(base);

				}
			}
		}
		return null;
	}

	static IProperty findPath(IClass owner, IClass target) {
		return null;
	}

	@Clause("NOT")
	public static IHasDomain not(IHasDomain d) {
		if (d instanceof Comparison) {
			return ((Comparison) d).negate();
		} else if (d instanceof Measure) {
			Comparative comparative = new Comparative(Kind.EQUAL, "!=");
			return new Comparison(d, comparative);
		} else if (d instanceof PropertyFilter) {
			PropertyFilter m = (PropertyFilter) d;
			return m.negate();
		} else if (d instanceof ISelector) {
			Comparative comparative = new Comparative(Kind.NOT_IN, "in");
			return new Comparison(d, comparative);
		}
		return null;
	}

	@Clause("COMBINE")
	public static ISelector combine(ISelector s, IClause cl) {

		return cl.produce(s);
	}

	@Clause("COMPARISON")
	public static Comparison compare(Comparative c, Measure m) {
		return new Comparison(m, c);
	}

	@Clause("COMBINE_COMPARISON")
	public static IHasDomain combineAnd(List<Comparison> cls) {
		if (cls.stream().filter(x -> x.isNotSolved()).findAny().isPresent()) {
			return null;
		}
		if (cls.stream().map(x -> x.domain()).distinct().count() == 1) {
			return new AndComparison(cls, cls.stream().map(x -> x.domain()).distinct().findFirst().get());
		}
		return null;
	}

	@Clause("OR_COMPARISON")
	public static IHasDomain combineOr(List<Comparison> cls) {
		if (cls.stream().filter(x -> x.isNotSolved()).findAny().isPresent()) {
			return null;
		}
		if (cls.stream().map(x -> x.domain()).distinct().count() == 1) {
			return new OrComparison(cls, cls.stream().map(x -> x.domain()).distinct().findFirst().get());
		}
		return null;
	}

	@Clause("COMPARISON2")
	public static SimpleRelativeComparison compare_relative(Comparative c, ISelector s0, IHasDomain s1) {
		SimpleRelativeComparison simpleRelativeComparison = new SimpleRelativeComparison(c, s0, s1);
		if (s1.domain().isSubtypeOf(s0.domain())) {
			return simpleRelativeComparison;
		} else {
			simpleRelativeComparison.setNotSolved(true);
		}
		return simpleRelativeComparison;
	}

	@Clause("COMPARISON3")
	public static Comparison compare_relative(Comparative c, IProperty s0, ISelector s1) {
		// if (s1.domain().isSubtypeOf(s0.domain())){
		// return new SimpleRelativeComparison(c, s0, s1);
		// }
		if (s1.multiplicity() == Multiplicity.SINGLE) {
			if (s1.properties().contains(s0)) {
				return new Comparison(new MapByProperty(s0).produce(s1), c);
			}

		}
		return null;
	}

	@Clause("FILTER")
	public static PropertyFilter propertyFilter(IProperty prop, IHasDomain predicate) {
		IComparison c = null;
		if (predicate instanceof ISelector) {
			Comparative comparative = new Comparative(Kind.IN, "in");
			c = new Comparison(predicate, comparative);
		} else if (predicate instanceof GenericTime) {
			Comparative comparative = new Comparative(Kind.IN, "in");
			c = new Comparison(predicate, comparative);
		} else if (predicate instanceof Measure) {
			Comparative comparative = new Comparative(Kind.EQUAL, "==");
			c = new Comparison(predicate, comparative);
		} else if (predicate instanceof IComparison) {
			IComparison mm=(IComparison) predicate;
			if (mm instanceof Comparison){
				
			}
			c = (IComparison) predicate;
		}

		if (c == null) {
			return null;
		}
		if (c.isNotSolved()) {
			c = c.solve(prop);
			if (c == null) {
				return null;
			}
		}

		if (!c.domain().isSubtypeOf(prop.range())) {
			if (prop.domain().isSubtypeOf(c.domain())) {
				prop = InverseProperty.createInverseProperty(prop);
			} else {
				return null;
			}
		}
		return PropertyFilter.propertyFilter(prop, c);
	}

	private static <T> boolean has(List<T> b, Predicate<T> p) {
		return b.stream().filter(p).findAny().isPresent();
	}
}
