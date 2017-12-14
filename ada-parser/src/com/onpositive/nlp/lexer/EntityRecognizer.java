package com.onpositive.nlp.lexer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.atteo.evo.inflector.English;

import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.engine.Word;

public class EntityRecognizer implements IEntityRecognizer{

	protected HashMap<String,ArrayList<Object>>entities=new HashMap<>();
	
	protected SpellDictionaryHashMap sp;
	
	public EntityRecognizer() {
		try {
			sp=new SpellDictionaryHashMap();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public void addEntity(String entityName,Object value) {
		
		entityName=entityName.toLowerCase();
		entityName=entityName.replace(" ", "");
		entityName=entityName.replace("_", "");
		innerEnd(entityName, value);
		innerEnd(English.plural(entityName),value);
		
	}

	private void innerEnd(String entityName, Object value) {
		ArrayList<Object> arrayList = entities.get(entityName);
		if (arrayList==null) {
			arrayList=new ArrayList<>();
			entities.put(entityName, arrayList);
		}
		arrayList.add(value);
		if (entityName.length()<25){
		sp.addWord(entityName);
		}
	}

	@Override
	public ArrayList<Object> tryMatch(List<? extends Object> tokens) {
		StringBuilder bld=new StringBuilder();
		for (Object o:tokens) {
			bld.append(o.toString());
		}
		if (bld.length()==0){
			return null;
		}
		String lowerCase = bld.toString().toLowerCase();
		//System.out.println(lowerCase);
		ArrayList<Object> arrayList = entities.get(lowerCase);
		if (arrayList==null&&lowerCase.length()>3){
			List<Word> correct = sp.getSuggestions(lowerCase, 100);
			if (correct!=null&&!correct.isEmpty()){
				String corr=correct.get(0).getWord().toLowerCase();
				arrayList = entities.get(corr);
				
			}
		}
		return arrayList;
	}
}
