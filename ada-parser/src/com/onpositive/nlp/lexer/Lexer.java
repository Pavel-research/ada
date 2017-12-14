package com.onpositive.nlp.lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

	private static final int MAX_LEN = 10;
	protected IEntityRecognizer recognizer;

	public Lexer(IEntityRecognizer recognizer) {
		super();
		this.recognizer = recognizer;
	}

	public List<List<Object>> lex(String str) {
		List<? extends Object> tokenize = PrimitiveTokenizer.tokenize(str);
		return doRecognition(tokenize);
	}

	@SuppressWarnings("unchecked")
	private List<List<Object>> doRecognition(List<? extends Object> tokenize) {		
		ArrayList<List<Object>> results = new ArrayList<>();	
		if (tokenize.isEmpty()) {
			results.add((List<Object>) tokenize);
			return results;
		}
		l2: for (int i = 0; i < tokenize.size(); i++) {
			for (int j = MAX_LEN; j >= 0; j--) {
				List<? extends Object> tokens = subTokens(tokenize,i,j);
				
				ArrayList<Object> obj=recognizer.tryMatch(tokens);
				if (obj!=null&&!obj.isEmpty()) {
					for (Object o:obj) {						
						List<? extends Object> subList = tokenize.subList(Math.min(i+j, tokenize.size()),tokenize.size());
						//System.out.println(subList);
						List<List<Object>> doRecognition = doRecognition(subList);
						for (List<Object>rec:doRecognition) {
							ArrayList<Object>result=new ArrayList<>();
							result.addAll(tokenize.subList(0, i));
							result.add(o);
							result.addAll(rec);
							results.add(result);
						}
					}
					break l2;
				}
			}
		}
		if (results.isEmpty()) {
			results.add((List<Object>) tokenize);
		}
		return results;
	}

	private static List<? extends Object> subTokens(List<? extends Object> tokenize, int i, int j) {
		if (j+i>tokenize.size()) {
			j=tokenize.size()-i;
		}
		return  tokenize.subList(i, j+i);
	}

}
