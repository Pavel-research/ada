package com.onpositive.ada.github.tests;

import com.onpositive.ada.core.model.CoreEngine;
import com.onpositive.ada.core.model.ParsedQuery;
import com.onpositive.ada.core.model.QueryResult;
import com.onpositive.ada.github.Github;

import junit.framework.TestCase;

public class ExecutionTest extends TestCase {

	public void test0() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("Issues created by Gleb");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 251);
		assertEquals(execute.propertyValues("user").toString(), "[E:Gleb Borisov]");
	}

	public void test01() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("open issues created by Gleb");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 19);
		assertEquals(execute.propertyValues("user").toString(), "[E:Gleb Borisov]");
	}

	public void test011() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("open issues that was not created by Gleb");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 1617);
		assertTrue(!execute.propertyValues("user").toString().contains("Gleb Borisov"));
	}

	public void test02() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with open issues created by Gleb");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 1);
		assertEquals(execute.results().toString(), "[E:api-workbench]");
	}

	public void test04() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with issues");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 260);
	}

	public void test05() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with more then 5 stars");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 52);
	}

	public void test06() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with less then 5 stars");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 1007);
	}

	public void test08() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with 5 stars");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 3);
	}

	public void test081() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with 5 issues");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 8);
	}

	public void test0811() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with less then 5 issues");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 948);
		parse = engine.parse("repositories that have more then 5 issues");
		execute = parse.execute();
		assertEquals(execute.total(), 106);
		parse = engine.parse("repositories that have less then 1 issue");
		execute = parse.execute();
		assertEquals(execute.total(), 802);
		parse = engine.parse("repositories that have more then 5 open issues");
		execute = parse.execute();
		assertEquals(execute.total(), 42);
	}

	public void test07() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 1062);
	}

	public void test071() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with issues with more then 51 comments");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 1);
	}

	public void test072() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("labels of issues assigned to Pavel Petrochenko");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 11);
	}

	public void test0712() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories without issues");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 802);
	}

	public void test07112() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("Issues created by Gleb and closed by Denis Denisenko");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 21);
	}

	public void test071121() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issue with largest number of comments");
		QueryResult execute = parse.execute();
		assertEquals(execute.results().toString(), "[E:https://api.github.com/repos/mulesoft-labs/raml-for-jax-rs/issues/150]");
	}
	
	public void test07112121() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repository with issue with largest number of comments");
		QueryResult execute = parse.execute();
		assertEquals(execute.results().toString(), "[E:raml-for-jax-rs]");
	}

	public void test0711212() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("open issue with largest number of comments");
		QueryResult execute = parse.execute();
		System.out.println(execute.results());
		assertEquals(execute.results().toString(), "[E:https://api.github.com/repos/mulesoft-labs/raml-client-generator/issues/8]");
	}
	public void test03() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues in mulesoft-labs");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 6138);
		int t1 = engine.parse("open issues in mulesoft-labs").execute().total();
		assertEquals(t1, 1470);
	}
	
	public void test031() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories in mulesoft-labs");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 792);
		int t1 = engine.parse("open issues in mulesoft-labs").execute().total();
		assertEquals(t1, 1470);
	}

	public void test252() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users with issues in mulesoft-labs");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 671);
	}
	
	public void test2512() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("Repositories with issues created by Gleb Borisov");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 10);
	}
	
	public void test32() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("milestones in raml-js-parser-2");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 10);
	}
	
	public void test33() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("Gleb issues");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 407);
		parse = engine.parse("open Gleb issues");
		execute = parse.execute();
		assertEquals(execute.total(), 22);
		parse = engine.parse("Gleb issues assigned to Gleb");
		execute = parse.execute();
		assertEquals(execute.total(), 49);
	}
	
	public void test331() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues created by Gleb Borisov");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 251);
		parse = engine.parse("issues created by Denis Denisenko");
		execute = parse.execute();
		assertEquals(execute.total(), 583);
		parse = engine.parse("issues created by Gleb Borisov or Denis Denisenko");
		execute = parse.execute();
		assertEquals(execute.total(), 583+251);
	}
	public void test321() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with most forks");
		QueryResult execute = parse.execute();
		parse = engine.parse("repositories with largest number of forks");
		QueryResult execute1 = parse.execute();
		assertEquals(execute.total(), 1);
		assertEquals(execute.toString(), execute1.toString());
	}
	
	public void test322() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users who created more issues then assigned to Gleb");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 26);
	}
	
	public void test3223() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users who created more issues then Gleb");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 7);
	}
	
	public void test32231() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users who created more issues then Denis created in raml-js-parser-2");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 10);
	}
//	public void test32231() {
//		CoreEngine engine = Github.getEngine();
//		ParsedQuery parse = engine.parse("user with largest number of issues");
//		QueryResult execute = parse.execute();
//		assertEquals(execute.total(), 7);
//	}
	
	public void test3221() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with more issues then raml-for-jaxrs");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 2);
	}
	
	public void test32211() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("Issues created by Gleb or Denis Denisenko and assigned to Pavel Petrochenko");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 3);
	}
	public void test321211() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("denis created in raml-js-parser-2");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 140);
	}
	
	public void test3() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("number of issues in raml-js-parser-2");
		QueryResult execute = parse.execute();
		assertEquals(execute.results().toString(), "[804.0]");
	}
	
	public void test11() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users who created issues");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 837);
	}
	
	public void test12() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues not in raml-js-parser-2");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 6942);
		parse = engine.parse("issues not in raml-js-parser-2 that was created by Gleb");
		execute = parse.execute();
		assertEquals(execute.total(), 210);
	}
	
	public void test13() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues created by Gleb and not assigned to Denis Denisenko");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 251);
		parse = engine.parse("issues created by Gleb and assigned to Denis Denisenko");
		execute = parse.execute();
		assertEquals(execute.total(), 0);
		parse = engine.parse("issues assigned to Denis Denisenko");
		execute = parse.execute();
		assertEquals(execute.total(), 61);
		parse = engine.parse("users who created issues assigned to Denis Denisenko");
		execute = parse.execute();
		assertEquals(execute.total(), 20);
	}
	
	public void test121() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues created by users who created more then 100 issues");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 3896);
	}
	
	public void test1211() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("labels of issues with more then 20 comments");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 8);
	}
	public void test12111() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users who created more then 50 issues");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 25);
	}
	
	public void test122111() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues with label bug");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 1328);
	}
	
	public void test1122111() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("mulesoft labs repositories");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 792);
		parse = engine.parse("mulesoft labs repository owners");
		execute = parse.execute();
		assertEquals(execute.total(), 1);
		
		parse = engine.parse("users who created issues in mulesoft labs");
		execute = parse.execute();
		assertEquals(execute.total(), 651);
//		parse = engine.parse("users in mulesoft labs");
//		execute = parse.execute();
//		assertEquals(execute.total(), 1);
	}
	
	public void test11122111() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users who created not more issues then assigned to Gleb and not more issues then created by Gleb");
		QueryResult execute = parse.execute();
		assertEquals(execute.total(), 875);
		parse = engine.parse("users who created not more issues then assigned to Gleb and more issues then created by Gleb");
		execute = parse.execute();
		assertEquals(execute.total(), 0);
		parse = engine.parse("users with issues created by gleb and closed by Denis Denisenko");
		execute = parse.execute();
		assertEquals(execute.total(), 2);
	}
	public void teste1() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repository with largest number of comments");
		QueryResult execute = parse.execute();
		assertEquals(execute.results().toString(),"[E:raml-for-jax-rs]");
	}

	
	
	
	 public void test64() {
		 // users created more issues then denis
		 CoreEngine engine = Github.getEngine();
		 ParsedQuery parse = engine.parse("repositories with more watchers then raml-for-jaxrs");
		 QueryResult execute = parse.execute();
			assertEquals(execute.total(),61);		
	 }
	

	
	//
	// public void test22() {
	// CoreEngine engine = Github.getEngine();
	// ParsedQuery parse = engine.parse("issues closed by Antonio and closed at
	// last month");
	// assertEquals(parse.toString(),
	// "[[C:Issue=>FILTER(P:Issue.closed_by,(in,O:Antonio))=>FILTER(P:Issue.closed_at,(in,month:true:true:0:-1))]]");
	// }
	// public void test221() {
	// CoreEngine engine = Github.getEngine();
	// ParsedQuery parse = engine.parse("issues closed by Antonio in last
	// month");
	// assertEquals(parse.toString(),
	// "[[C:Issue=>FILTER(P:Issue.closed_by,(in,O:Antonio))=>FILTER(P:Issue.closed_at,(in,month:true:true:0:-1))]]");
	// }
	//
	//// public void test223() {
	//// CoreEngine engine = Github.getEngine();
	//// ParsedQuery parse = engine.parse("issues closed by Antonio later then
	// in last month");
	//// assertEquals(parse.toString(),
	//// "[[C:Issue=>FILTER(P:Issue.closed_by,(in,O:Antonio))=>FILTER(P:Issue.closed_at,(in,month:true:true:0:-1))]]");
	//// }
	////
	//	
	
	//
	// public void test253() {
	// CoreEngine engine = Github.getEngine();
	// ParsedQuery parse = engine.parse("users with issues in mulesoft labs
	// assigned to them");
	// assertEquals(parse.toString(),
	// "[[C:User=>WITH((in,C:Issue=>IN((in,E:Mulesoft
	// Labs))))=>FILTER(!C:Issue.assignee,(in,them(C:User*)))]]");
	// }
	//
	// public void test254() {
	// CoreEngine engine = Github.getEngine();
	// ParsedQuery parse = engine.parse("users with issues assigned to them in
	// mulesoft labs");
	// assertEquals(parse.toString(),
	// "[[C:User=>WITH((in,C:Issue))=>FILTER(!C:Issue.assignee,(in,them(C:User*)))=>IN((in,E:Mulesoft
	// Labs))]]");
	// }
	//
	// public void test256() {
	// CoreEngine engine = Github.getEngine();
	// ParsedQuery parse = engine.parse("users who have issues in mulesoft labs
	// assigned to them");
	// assertEquals(parse.toString(),
	// "[[C:User=>WITH((in,C:Issue=>IN((in,E:Mulesoft
	// Labs))))=>FILTER(!C:Issue.assignee,(in,them(C:User*)))]]");
	// }
	//



}