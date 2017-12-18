package com.onpositive.ada.core.model;

import java.io.IOException;

import org.ada.metamodel.TypedStore;

import com.onpositive.model.ITypedStore;
import com.onpositive.nlp.lexer.EntityRecognizer;
import com.onpositive.nlp.lexer.Lexer;

import ada.core.rules.loader.VocabularyRecognizer;

public class CoreEngine {

	protected ITypedStore store;

	public CoreEngine(ITypedStore store) {
		super();
		this.store = store;
		this.recognizer = new VocabularyRecognizer(store.universe());
		store.allInstances().forEach(i -> {
			String name = i.name();
			
			if (name != null) {
				this.recognizer.addEntity(name, i);
			}
		});
		this.lexer = new Lexer(recognizer);
	}

	protected EntityRecognizer recognizer;

	protected Lexer lexer;

	public static CoreEngine getDebugEngine() throws IOException {
		return new CoreEngine(TypedStore.getDebugInstance());
	}
}
