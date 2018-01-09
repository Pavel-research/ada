package com.ada.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.ocpsoft.prettytime.shade.edu.emory.mathcs.backport.java.util.Collections;

import com.onpositive.model.IProperty;

public class SimpleDisambiguator {

	Comparator<IParsedEntity> countEstimator = new Comparator<IParsedEntity>() {

		@Override
		public int compare(IParsedEntity o1, IParsedEntity o2) {
			
			
			List<? extends IParsedEntity> children = o1.children();
			int size = children.size();
			List<? extends IParsedEntity> children2 = o2.children();
			int size2 = children2.size();
			if (size>size2){
				return 1;
			}
			if (size<size2){
				return -1;
			}
			int sum=0;
			for (int i=0;i<size;i++){
				IParsedEntity c1=children.get(i);
				IParsedEntity c2=children2.get(i);
				int compare = countEstimator.compare(c1, c2);
				sum+=compare;
			}
			return sum;
		}
	};
	
	Comparator<IParsedEntity> propEstimator = new Comparator<IParsedEntity>() {

		@Override
		public int compare(IParsedEntity o1, IParsedEntity o2) {
			List<IProperty> p1 = gatherProperties(o1);
			List<IProperty> p2 = gatherProperties(o2);
			int e0=estimate(p1);
			int e1=estimate(p2);
			return e0-e1;
		}
	};
	int estimate(List<IProperty>pl){
		int sum=0;
		for (IProperty p:pl){
			sum+=p.complexity();
		}
		return sum;
	}
	
	
	public List<IProperty>gatherProperties(IParsedEntity e0){
		ArrayList<IProperty>res=new ArrayList<>();
		res.addAll(e0.usedProperties());
		e0.children().forEach(v->{
			res.addAll(gatherProperties(v));
		});
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<List<Object>> disambiguate(Collection<List<Object>>ms){
		List<IParsedEntity> collect = ms.stream().filter(x->x.size()==1&&(x.get(0) instanceof IParsedEntity)).map(x->(IParsedEntity)x.get(0)).collect(Collectors.toList());
		if (collect.size()>0){
			if (collect.size()>1){
				collect.sort(countEstimator);
				
			}
			return Collections.singletonList(Collections.singletonList(collect.get(0)));
		}
		return ms;		
	}

	@SuppressWarnings("unchecked")
	public Collection<List<Object>> finalDisambig(Collection<List<Object>> ms) {
		List<IParsedEntity> collect = ms.stream().filter(x->x.size()==1&&(x.get(0) instanceof IParsedEntity)).map(x->(IParsedEntity)x.get(0)).collect(Collectors.toList());
		if (collect.size()>0){
			if (collect.size()>1){
				collect.sort(propEstimator);
				
			}
			return Collections.singletonList(Collections.singletonList(collect.get(0)));
		}
		return ms;		
		
	}
}
