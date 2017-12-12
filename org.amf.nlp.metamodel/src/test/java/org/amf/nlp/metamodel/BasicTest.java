package org.amf.nlp.metamodel;

import java.io.IOException;

import org.ada.metamodel.Universe;
import org.ada.metamodel.VocabularyLoader;
import org.raml.store.Store;
import org.raml.store.StoreManager;
import org.raml.vocabularies.Vocabulary;

import junit.framework.TestCase;

public class BasicTest extends TestCase {

	
	public void test0(){
		try {
			Universe loadFrom = new VocabularyLoader().loadFrom(new Vocabulary(BasicTest.class.getResource("/definition.yaml")));
			assertEquals(loadFrom.classes().size(), 9);
		} catch (IOException e) {
			assertTrue(false);
		}
	}
	
	public void test1(){
		Store st=StoreManager.getDebugStore();
		System.out.println(st);
	}
}
