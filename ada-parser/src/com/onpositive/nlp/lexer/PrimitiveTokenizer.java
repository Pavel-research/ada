package com.onpositive.nlp.lexer;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveTokenizer {

	static char[] symbols = new char[] { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+',
			'\\', '|', ',', '.', '<', '>', '/', '?', ';', ':', '\'', '"', '[', ']', '{', '}', '—', '«', '»', '„', '“',
			'“', '”', '‘', '’' };

	static String symb = new String(symbols);

	public static List<? extends Object> tokenize(String tokens) {
		ArrayList<String> result = new ArrayList<>();
		int length = tokens.length();
		StringBuilder currentToken = new StringBuilder();
		
		for (int i = 0; i < length; i++) {
			char charAt = tokens.charAt(i);
			if (Character.isWhitespace(charAt)) {
				currentToken = append(currentToken, result);
				continue;
			}
			if (symb.indexOf(charAt) != -1) {
				currentToken = append(currentToken, result);
				result.add("" + charAt);
				continue;
			}
			currentToken.append(charAt);
		}
		if (currentToken.length() > 0) {
			result.add(currentToken.toString());
		}
		ArrayList<Object> m = parseNumbers(result);
		return m;
	}

	private static ArrayList<Object> parseNumbers(ArrayList<String> result) {
		ArrayList<Object> m = new ArrayList<>();
		for (String s : result) {
			try {
				m.add(Integer.parseInt(s));
			} catch (NumberFormatException e) {
				m.add(s);
			}
		}
		return m;
	}

	private static StringBuilder append(StringBuilder currentToken, ArrayList<String> result) {
		if (currentToken.length() == 0) {
			return currentToken;
		}
		result.add(currentToken.toString());
		return new StringBuilder();
	}
}