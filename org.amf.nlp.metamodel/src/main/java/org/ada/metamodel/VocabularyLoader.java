package org.ada.metamodel;

import java.util.HashMap;

import org.raml.vocabularies.Builtins;
import org.raml.vocabularies.ClassTerm;
import org.raml.vocabularies.DataType;
import org.raml.vocabularies.PropertyTerm;
import org.raml.vocabularies.Vocabulary;

import com.onpositive.model.IType;

public class VocabularyLoader {

	public Universe loadFrom(Vocabulary voc){
		Universe v=new Universe(voc.getBase());
		for (ClassTerm t:voc.getClassTerms().values()){
			v.types.put(voc.getBase()+t.getName(), toClass(t));
		}
		return v;
	}
	
	protected HashMap<String,EntityClass>classes=new HashMap<>();
	protected HashMap<String,Property>props=new HashMap<>();

	private EntityClass toClass(ClassTerm t) {
		String id = t.getVocabulary().getBase()+t.getName();
		if (classes.containsKey(id)){
			return classes.get(id);
		}
		EntityClass ec=new EntityClass(id,t.getName());
		classes.put(id, ec);
		t.getDeclaredProperties().forEach(p->{
			ec.addProperty(toProperty(p,ec));
		});
		t.getSuperTypes().forEach(st->{
			ec.addParent(toClass(st));
		});
		return ec;
	}

	private Property toProperty(PropertyTerm p,EntityClass cl) {
		String id = p.getVocabulary().getBase()+p.getName()+cl.id;
		if (props.containsKey(id)){
			return props.get(id);
		}
		DataType range = p.getRange();
		Property pr=new Property(id,p.getName(), cl, toType(range));
		props.put(id, pr);
		PropertyTerm superProperty = p.getSuperProperty();
		if (superProperty!=null){
			pr.addParent(toProperty(superProperty,cl));
		}
		return pr;
	}

	private IType toType(DataType range) {
		if (range instanceof ClassTerm){
			return toClass((ClassTerm) range);
		}
		Builtins bs=(Builtins) range;
		switch (bs) {
		case BOOLEAN:
			return com.onpositive.model.Builtins.BOOLEAN;
		case DATETIME:
			return com.onpositive.model.Builtins.DATETIME;
		case STRING:
			return com.onpositive.model.Builtins.STRING;
		case NUMBER:
			return com.onpositive.model.Builtins.NUMBER;
		case INTEGER:
			return com.onpositive.model.Builtins.INTEGER;	

		default:
			break;
		}
		return null;
	}
}
