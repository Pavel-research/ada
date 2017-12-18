package com.onpositive.ada.core.model;

import java.io.IOException;
import java.util.List;

import com.onpositive.nlp.lexer.EntityRecognizer;
import com.onpositive.nlp.lexer.Lexer;

import junit.framework.TestCase;

public class SimpleTest extends TestCase{

	public  void test0() {
		try {
			EntityRecognizer recognizer = CoreEngine.getDebugEngine().recognizer;
			long l0=System.currentTimeMillis();
			for (int i=0;i<1;i++){
				doLex(recognizer);
			}
			long l1=System.currentTimeMillis();
			System.out.println(l1-l0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		PieChart ps=GCharts.newPieChart(Slice.newSlice(40,"J"),Slice.newSlice(50, "Aaaaaaaaaaa"));
//		ps.setThreeD(true);
//		ps.setSize(500, 200);
//		ps.setTitle("Diagram");
//		System.out.println(ps.toURLString());
//		List<DateGroup> parse = new PrettyTimeParser().parseSyntax("I eat at August");
//		parse.forEach(v->{
//		System.out.println(v.getDates());
//		});
////		try {
////			Vocabulary vocabulary = new Vocabulary(SimpleTest.class.getResource("/definition.yaml"));
////			VocabularyRecognizer vocabularyRecognizer = new VocabularyRecognizer(vocabulary);
////			Store debugStore = StoreManager.getDebugStore();
////			debugStore.entities().forEach(e->{
////				Object property = e.property("name");
////				if (property instanceof String&&property.toString().length()>0){
////					vocabularyRecognizer.addEntity(property.toString(), e);
////				}
////			});
////			long l0=System.currentTimeMillis();
////			for (int i=0;i<1;i++){
////			doLex(vocabularyRecognizer);
////			}
////			long l1=System.currentTimeMillis();
////			System.out.println(l1-l0);
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////		Injector injector = new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
////		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
////		Resource resource = resourceSet.getResource(URI.createFileURI("/Users/kor/git/nlp-thoughts/nlp_thoughts/test.rules"), true);
////		EList<EObject> contents = resource.getContents();
////		Model m=(Model) contents.get(0);
////		AllMatchParser<Object> load = new ModelLoader().load(m);
////		Collection<List<Object>> parse = load.parse(Arrays.asList(
////				new SingleSelector("Gleb", null),
////				"or",
////				new SingleSelector("Denis", null)
//////				"and",
//////				new SingleSelector("Mike", null),
//////				"or",
//////				new SingleSelector("Pavel", null)
////				));
////		for (List<Object>p:parse){
////			System.out.println(p);
////		}		
	}

	private void doLex(EntityRecognizer vocabularyRecognizer) {	
		List<List<Object>> lex = new Lexer(vocabularyRecognizer).lex("Issues created by Gleb Borisov or Denis");
		assertEquals(lex.toString(), "[[P:issues, P:created, by, E:Gleb Borisov, or, O:Denis]]");
		lex = new Lexer(vocabularyRecognizer).lex("Issues created by Gleb Borisov or  Denis O Connor");
		assertEquals(lex.toString(),"[[P:issues, P:created, by, E:Gleb Borisov, or, E:Dennis O'Connor]]");
		lex = new Lexer(vocabularyRecognizer).lex("Issues created by Gleb Borisov or  Denisenko");
		assertEquals(lex.toString(), "[[P:issues, P:created, by, E:Gleb Borisov, or, E:Denis Denisenko]]");
		List<List<Object>> lex1 = new Lexer(vocabularyRecognizer).lex("Issues created by Pavel Petrochenko");
		assertEquals(lex1.toString(), "[[P:issues, P:created, by, E:Pavel Petrochenko]]");
		List<List<Object>> lex2 = new Lexer(vocabularyRecognizer).lex("Issues created by Pavel Petrochenko in vocabularies");
		assertEquals(lex2.toString(), "[[P:issues, P:created, by, E:Pavel Petrochenko, in, O:vocabularies]]");
		lex2 = new Lexer(vocabularyRecognizer).lex("Issues created by Pavel Petrohenko in vocabularies");
		assertEquals(lex2.toString(), "[[P:issues, P:created, by, E:Pavel Petrochenko, in, O:vocabularies]]");
		lex2 = new Lexer(vocabularyRecognizer).lex("Issues created by Pawel Petrochenko in vocabularies");
		assertEquals(lex2.toString(), "[[P:issues, P:created, by, E:Pavel Petrochenko, in, O:vocabularies]]");
		lex2 = new Lexer(vocabularyRecognizer).lex("bugs in vocabularies");
		assertEquals(lex2.toString(), "[[O:bugs, in, O:vocabularies]]");		
		lex2 = new Lexer(vocabularyRecognizer).lex("bugs in raml-for-jaxrs");
		assertEquals(lex2.toString(), "[[O:bugs, in, O:ramlforjaxrs]]");
	}
	
}
