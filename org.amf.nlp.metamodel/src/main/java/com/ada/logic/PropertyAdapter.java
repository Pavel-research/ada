package com.ada.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

import com.onpositive.clauses.impl.ContainingProperty;
import com.onpositive.clauses.impl.InverseProperty;
import com.onpositive.clauses.impl.JoinProperty;
import com.onpositive.clauses.impl.PathProperty;
import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class PropertyAdapter {

	public static IProperty adaptProperty(IProperty p, IType t) {
		return adaptProperty(p, t, 0, new HashSet<>());
	}

	protected static IProperty adaptProperty(IProperty p, IType t, int level, HashSet<IProperty> visited) {
		if (t.isSubtypeOf(p.domain())) {
			return p;
		}
		if (p.range() instanceof IClass && t instanceof IClass) {
			IProperty findPath = findPath((IClass)p.range(),(IClass) t,0,new HashSet<>());
			if (findPath!=null){
				return buildPath(p, findPath);
			}
			findPath = findPath((IClass) t,p.domain(),0,new HashSet<>());
			if (findPath!=null){
				return buildPath(findPath,p);
			}
		}
		return p;
	}

	static class Pair {
		public final IClass c0;
		public final IClass c1;

		public Pair(IClass c0, IClass c1) {
			super();
			this.c0 = c0;
			this.c1 = c1;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((c0 == null) ? 0 : c0.hashCode());
			result = prime * result + ((c1 == null) ? 0 : c1.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (c0 == null) {
				if (other.c0 != null)
					return false;
			} else if (!c0.equals(other.c0))
				return false;
			if (c1 == null) {
				if (other.c1 != null)
					return false;
			} else if (!c1.equals(other.c1))
				return false;
			return true;
		}
	}

	static HashMap<Pair, IProperty> cache = new HashMap<>();

	public static IProperty findPath(IClass c0, IClass c1) {
		Pair key = new Pair(c0, c1);
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		IProperty res = findPath(c0, c1, 0, new HashSet<>());
		if (res == null) {
			res = findPath(c1, c0, 0, new HashSet<>());
			if (res != null) {
				res = InverseProperty.createInverseProperty(res);
			}
		}
		cache.put(key, res);
		return res;
	}

	public static IProperty findPath(IClass c0, IClass c1, int level, HashSet<IClass> visited) {
		if (visited.contains(c0)) {
			return null;
		} else {
			visited.add(c0);
		}
		if (level > 2) {
			return null;
		}
		ArrayList<IProperty> props = new ArrayList<>();
		c0.allProperties().forEach(v -> {
			IType range = v.range();
			if (range.isSubtypeOf(c1)) {
				props.add(v);
			}
		});
		if (props.isEmpty()) {
			c0.allProperties().forEach(v -> {
				IType range = v.range();
				if (range instanceof IClass) {
					IClass m = (IClass) range;
					IProperty findPath = findPath(m, c1, level + 1, visited);
					if (findPath != null) {
						findPath = buildPath(v, findPath);
						props.add(findPath);
					}

				}
			});
		}
		if (!props.isEmpty()) {
			if (props.size() == 1) {
				return props.get(0);
			}
			return new JoinProperty(new ArrayList<>(new LinkedHashSet<>(props)));
		}
		return null;
	}

	private static IProperty buildPath(IProperty v, IProperty findPath) {
		if (findPath instanceof PathProperty) {
			PathProperty ps = (PathProperty) findPath;
			ArrayList<IProperty> newPath = new ArrayList<>(ps.getPath());
			newPath.add(0, v);
			findPath = new PathProperty(newPath);
		} else {
			ArrayList<IProperty> newPath = new ArrayList<>();
			newPath.add(v);
			newPath.add(findPath);
			findPath = new PathProperty(newPath);
		}
		return findPath;
	}

	public static IProperty findContainmentPath(IClass base, IClass parts) {
		if (parts.isPartOf(base)){
			return new ContainingProperty(parts, base);
		}
		for (IClass c:base.contained()){
			if (parts.isPartOf(c)){
				ArrayList<IProperty>ps=new ArrayList<>();
				ps.add(new ContainingProperty(c,base));
				ps.add(new ContainingProperty(parts,c));
				return new PathProperty(ps);
			}
		}
		return null;
	}
}
