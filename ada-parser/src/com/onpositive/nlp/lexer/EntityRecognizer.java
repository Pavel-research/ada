package com.onpositive.nlp.lexer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.atteo.evo.inflector.English;

import com.onpositive.nlp.parser.AllMatchParser;
import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.engine.Word;

public class EntityRecognizer implements IEntityRecognizer {

	protected HashMap<String, ArrayList<Object>> entities = new HashMap<>();

	protected SpellDictionaryHashMap sp;

	String[] year=new String[]{"year"};
	String[]months=new String[]{"January","February","March","April","June","July","August","September","October","November","December"};
	String[]months1=new String[]{"Jan.","Feb.","Mar.","Apr.","Jun.","Jul.","Aug.","Sep.","Oct.","Nov.","Dec."};
	
	String[]weeks=new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Satarday","Sunday"};

	public EntityRecognizer() {
		try {
			sp = new SpellDictionaryHashMap();
			initDates();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	private void initDates() {
		innerEnd("year", new Year("year",0,true,true));
		innerEnd("month", new Month("month",0,true,true));
		innerEnd("week", new Week("week",0,true,true));
		for (int i=0;i<months.length;i++){
			innerEnd(months[i].toLowerCase(), new Month(months[i],i, false, true));
		}
		for (int i=0;i<months1.length;i++){
			innerEnd(months1[i].toLowerCase(), new Month(months1[i],i, false, true));
		}
		for (int i=0;i<weeks.length;i++){
			innerEnd(weeks[i].toLowerCase(), new Week(weeks[i],i, false, true));
		}
	}

	public void addEntity(String entityName, Object value) {
		if (entityName.equals("More texts needed")){
			return;
		}
		if (entityName.indexOf(' ') != -1) {
			String[] split = entityName.split(" ");
			if (split.length > 1) {
				for (String sa: split){
					if (Character.toLowerCase(sa.charAt(0))!=sa.charAt(0)){
						innerEnd(sa.toLowerCase(),value);
					}
				}
			}
		}
		
		entityName = entityName.toLowerCase();		
		entityName = entityName.replace(" ", "");
		entityName = entityName.replace("_", "");
		entityName = entityName.replace("-", "");
		innerEnd(entityName, value);
		innerEnd(English.plural(entityName), value);
		

	}

	public void innerEnd(String entityName, Object value) {
		ArrayList<Object> arrayList = entities.get(entityName);
		if (arrayList == null) {
			arrayList = new ArrayList<>();
			entities.put(entityName, arrayList);
		}
		arrayList.add(value);
		if (entityName.length() < 25) {
			sp.addWord(entityName);
		}
	}
	public static HashSet<String>pref=new HashSet<>();
	
	static{
		pref.add("not");
		pref.add("are");
		pref.add("was");
		//pref.add("were");
		//pref.add("that");
	}
	@Override
	public ArrayList<Object> tryMatch(List<? extends Object> tokens) {
		StringBuilder bld = new StringBuilder();
		if (tokens.size()>1&&pref.contains(tokens.get(0))){
			
			return null;
		}
		boolean startsWithNumb=false;
		if (tokens.size()>0&&(tokens.get(0) instanceof Number)){
			startsWithNumb=true;
		}
		
		for (Object o : tokens) {
			bld.append(o.toString());
		}
		if (bld.length() == 0) {
			return null;
		}
		String lowerCase = bld.toString().toLowerCase();
		// System.out.println(lowerCase);
		
		ArrayList<Object> arrayList = entities.get(lowerCase);
		if (!startsWithNumb&&arrayList == null && ((lowerCase.length() > 3&&tokens.size()==1)||(lowerCase.length() > 6&&tokens.size()>1))&& !AllMatchParser.isDEBUG()) {
			List<Word> correct = sp.getSuggestions(lowerCase, 100);
			if (correct != null && !correct.isEmpty()) {
				String corr = correct.get(0).getWord().toLowerCase();
				arrayList = entities.get(corr);
				if (tokens.size() > 1) {
					String string = arrayList.iterator().next().toString();
					if (string.indexOf(' ') == -1) {
						return null;
					}
				}
			}
		}
		return arrayList;
	}
}
