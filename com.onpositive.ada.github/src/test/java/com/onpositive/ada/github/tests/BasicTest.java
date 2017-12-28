package com.onpositive.ada.github.tests;

import com.onpositive.ada.core.model.CoreEngine;
import com.onpositive.ada.core.model.ParsedQuery;
import com.onpositive.ada.github.Github;
import com.onpositive.nlp.parser.AllMatchParser;

import junit.framework.TestCase;

public class BasicTest extends TestCase {

	public void test0() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("Issues created by Gleb");
		assertEquals(parse.toString(), "[[C:Issue=>FILTER(P:Issue.user,(in,E:Gleb Borisov))]]");
	}

	public void test1() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("5 issues");
		assertEquals(parse.toString(), "[[D[5,C:Issue]]]");
	}

	public void test2() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("more then 5 issues");
		assertEquals(parse.toString(), "[[(>,D[5,C:Issue])]]");
	}

	public void test3() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with more then 5 issues");
		assertEquals(parse.toString(), "[[C:Repository=>WITH((>,D[5,C:Issue]))]]");
	}

	public void test4() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with issues");
		assertEquals(parse.toString(), "[[C:Repository=>WITH((in,C:Issue))]]");
	}

	public void test5() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with issues with more then 5 comments");
		assertEquals(parse.toString(), "[[C:Repository=>WITH((in,C:Issue=>WITH((>,D[5,C:Comment]))))]]");
	}

	public void test6() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with more issues then raml-for-jaxrs");
		assertEquals(parse.toString(), "[[C:Repository=>WITH((>,O:ramlforjaxrs=>map(P:Repository.issues)))]]");
	}

	public void test61() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users who created more issues then assigned to Gleb");
		assertEquals(parse.toString(),
				"[[C:User=>FILTER(!C:Issue.user,relative(COMP(more),C:Issue,FILTER(P:Issue.assignee,(in,E:Gleb Borisov)))]]");
	}

	public void test63() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users who created more issues then Denis Denisenko");
		assertEquals(parse.toString(),
				"[[C:User=>FILTER(!C:Issue.user,relative(COMP(more),C:Issue,E:Denis Denisenko=>map(!C:Issue.user))]]");
	}

	public void test64() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with more watchers then raml-for-jaxrs");
		assertEquals(parse.toString(), "[[C:Repository=>WITH((>,O:ramlforjaxrs=>map(P:Repository.watchers)))]]");
	}

	public void test65() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with most forks");
		assertEquals(parse.toString(), "[[C:Repository=>WITH((in,PC(COMP(most),P:Repository.forks)))]]");
	}

	public void test66() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with largest number of forks");
		assertEquals(parse.toString(), "[[C:Repository=>WITH((in,PC(COMP(largest),P:Repository.forks)))]]");
	}

	public void test67() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("labels of issues assigned to Pavel Petrochenko");
		assertEquals(parse.toString(),
				"[[C:Issue=>FILTER(P:Issue.assignee,(in,E:Pavel Petrochenko))=>map(P:Issue.labels)]]");
	}

	public void test68() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("labels of issues assigned to Pavel Petrochenko with more then 3 issues");
		assertEquals(parse.toString(),
				"[[C:Issue=>FILTER(P:Issue.assignee,(in,E:Pavel Petrochenko))=>map(P:Issue.labels)=>WITH((>,D[3,C:Issue]))]]");
	}
	public void test69() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("count issues in raml-js-parser-2");
		assertEquals(parse.toString(),
				"[[C:Issue=>IN((in,O:ramljsparser2))=>COUNT]]");
	}
	
	public void test699() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("labels of issues with more then 10 comments");
		assertEquals(parse.toString(),
				"[[C:Issue=>WITH((>,D[10,C:Comment]))=>map(P:Issue.labels)]]");
	}
	public void test6991() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		AllMatchParser.setDEBUG(true);
		ParsedQuery parse = engine.parse("issues created by users who created more then 5 issues");
		AllMatchParser.setDEBUG(false);
		assertEquals(parse.toString(),
				"[[C:Issue=>FILTER(P:Issue.user,(in,C:User=>FILTER(!C:Issue.user,(>,D[5,C:Issue]))))]]");
	}
	
	public void test6992() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		//ParsedQuery parse = engine.parse("users created more issues then denis created in raml-js-parser-2");
		ParsedQuery parse = engine.parse("issues created in raml-js-parser-2");
		
		assertEquals(parse.toString(),
				"[[C:Issue=>map(P:Issue.user)=>IN((in,O:ramljsparser2))]]");
	}
	public void test6993() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("denis created in raml-js-parser-2");
		//ParsedQuery parse = engine.parse("issues created in raml-js-parser-2");
		
		assertEquals(parse.toString(),
				"[[O:denis=>map(!C:Issue.user)=>IN((in,O:ramljsparser2))]]");
	}
	public void test6994() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		//AllMatchParser.setDEBUG(true);
		ParsedQuery parse = engine.parse("users created more issues then denis");
		//ParsedQuery parse = engine.parse("issues created in raml-js-parser-2");
		//AllMatchParser.setDEBUG(false);
		assertEquals(parse.toString(),
				"[[C:User=>FILTER(!C:Issue.user,relative(COMP(more),C:Issue,O:denis=>map(!C:Issue.user))]]");
	}
	
	public void test6995() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		//AllMatchParser.setDEBUG(true);
		ParsedQuery parse = engine.parse("users created more issues then denis created in raml-js-parser-2");
		//ParsedQuery parse = engine.parse("issues created in raml-js-parser-2");
		//AllMatchParser.setDEBUG(false);
		assertEquals(parse.toString(),
				"[[C:User=>FILTER(!C:Issue.user,relative(COMP(more),C:Issue,O:denis=>map(!C:Issue.user)=>IN((in,O:ramljsparser2)))]]");
	}

	public void test62() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		// ParsedQuery parse = engine.parse("users who created not more issues
		// then assigned to Gleb and more issues then created by Gleb");
		// AllMatchParser.setDEBUG(true);
		ParsedQuery parse = engine
				.parse("users who created not more issues then assigned to Gleb and more issues then created by Gleb");
		// AllMatchParser.setDEBUG(false);
		assertEquals(parse.toString(),
				"[[C:User=>FILTER(!C:Issue.user,and([relative(COMP(not more),C:Issue,FILTER(P:Issue.assignee,(in,E:Gleb Borisov)), relative(COMP(more),C:Issue,FILTER(P:Issue.user,(in,E:Gleb Borisov))]))]]");
	}

	public void test622() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		// ParsedQuery parse = engine.parse("users who created not more issues
		// then assigned to Gleb and more issues then created by Gleb");
		// AllMatchParser.setDEBUG(true);
		ParsedQuery parse = engine
				.parse("users who created not more issues then assigned to Gleb or more issues then created by Gleb");
		// AllMatchParser.setDEBUG(false);
		assertEquals(parse.toString(),
				"[[C:User=>FILTER(!C:Issue.user,or([relative(COMP(not more),C:Issue,FILTER(P:Issue.assignee,(in,E:Gleb Borisov)), relative(COMP(more),C:Issue,FILTER(P:Issue.user,(in,E:Gleb Borisov))]))]]");
	}

	public void test631() {
		// users created more issues then denis
		CoreEngine engine = Github.getEngine();
		// ParsedQuery parse = engine.parse("users who created not more issues
		// then assigned to Gleb and more issues then created by Gleb");
		ParsedQuery parse = engine.parse("users with issues created by gleb and closed by Denis Denisenko");
		assertEquals(parse.toString(),
				"[[C:User=>WITH((in,C:Issue=>FILTER(P:Issue.user,(in,E:Gleb Borisov))=>FILTER(P:Issue.closed_by,(in,E:Denis Denisenko))))]]");
	}

	//
	public void test31() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with 5 issues");
		assertEquals(parse.toString(), "[[C:Repository=>WITH((==,D[5,C:Issue]))]]");
	}

	public void test7() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("Issues created by Gleb, assigned to Denis Denisenko");
		assertEquals(parse.toString(),
				"[[C:Issue=>FILTER(P:Issue.user,(in,E:Gleb Borisov))=>FILTER(P:Issue.assignee,(in,E:Denis Denisenko))]]");
	}

	//
	public void test8() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("Issues created by Gleb and assigned to Denis Denisenko");
		assertEquals(parse.toString(),
				"[[C:Issue=>FILTER(P:Issue.user,(in,E:Gleb Borisov))=>FILTER(P:Issue.assignee,(in,E:Denis Denisenko))]]");
	}

	//
	public void test9() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("Issues created by Gleb or Denis Denisenko");
		assertEquals(parse.toString(), "[[C:Issue=>FILTER(P:Issue.user,(in,[E:Gleb Borisov, E:Denis Denisenko]))]]");
	}

	//
	public void test10() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("Repositories with issues created by Gleb Borisov");
		assertEquals(parse.toString(),
				"[[C:Repository=>WITH((in,C:Issue=>FILTER(P:Issue.user,(in,E:Gleb Borisov))))]]");
	}

	//
	public void test41() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("Repositories in mulesoft-labs");
		assertEquals(parse.toString(), "[[C:Repository=>IN((in,E:Mulesoft Labs))]]");
	}

	//
	public void test11() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues assigned to gleb");
		assertEquals(parse.toString(), "[[C:Issue=>FILTER(P:Issue.assignee,(in,E:Gleb Borisov))]]");
	}

	//
	public void test12() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("Issues created by Gleb or Denis Denisenko and assigned to Pavel Petrochenko");
		assertEquals(parse.toString(),
				"[[C:Issue=>FILTER(P:Issue.user,(in,[E:Gleb Borisov, E:Denis Denisenko]))=>FILTER(P:Issue.assignee,(in,E:Pavel Petrochenko))]]");
	}

	public void test71() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues created by gleb and assigned to Denis Denisenko in raml-js-parser-2");
		assertEquals(parse.toString(),
				"[[C:Issue=>FILTER(P:Issue.user,(in,E:Gleb Borisov))=>FILTER(P:Issue.assignee,(in,E:Denis Denisenko))=>IN((in,O:ramljsparser2))]]");
	}

	public void test81() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues created by gleb or Denis Denisenko in raml-js-parser-2");
		assertEquals(parse.toString(),
				"[[C:Issue=>FILTER(P:Issue.user,(in,[E:Gleb Borisov, E:Denis Denisenko]))=>IN((in,O:ramljsparser2))]]");
	}

	//
	public void test91() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues created by gleb and not assigned to Denis Denisenko");
		assertEquals(parse.toString(),
				"[[C:Issue=>FILTER(P:Issue.user,(in,E:Gleb Borisov))=>FILTER(P:Issue.assignee,(not_in,E:Denis Denisenko))]]");
	}

	public void test13() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues that were created by gleb");
		assertEquals(parse.toString(), "[[C:Issue=>FILTER(P:Issue.user,(in,E:Gleb Borisov))]]");
	}

	public void test11s() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues that was created by gleb");
		assertEquals(parse.toString(), "[[C:Issue=>FILTER(P:Issue.user,(in,E:Gleb Borisov))]]");
	}

	public void test12s() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues that was not created by gleb");
		assertEquals(parse.toString(), "[[C:Issue=>FILTER(P:Issue.user,(not_in,E:Gleb Borisov))]]");
	}

	public void test12ss() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories without issues");
		assertEquals(parse.toString(), "[[C:Repository=>WITH((not_in,C:Issue))]]");
	}

	//
	public void test13s() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues not in raml-js-parser-2");
		assertEquals(parse.toString(), "[[C:Issue=>IN((not_in,O:ramljsparser2))]]");
	}

	public void test14s() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues not in raml-js-parser-2 that was created by Gleb");
		assertEquals(parse.toString(),
				"[[C:Issue=>IN((not_in,O:ramljsparser2))=>FILTER(P:Issue.user,(in,E:Gleb Borisov))]]");
	}

	//
	public void test15() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with more then 5 issues");
		assertEquals(parse.toString(), "[[C:Repository=>WITH((>,D[5,C:Issue]))]]");
	}

	//
	public void test16() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users who created more then 5 issues");
		assertEquals(parse.toString(), "[[C:User=>FILTER(!C:Issue.user,(>,D[5,C:Issue]))]]");
	}

	public void test17() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users who created issues");
		assertEquals(parse.toString(), "[[C:User=>FILTER(!C:Issue.user,(in,C:Issue))]]");
	}

	public void test18() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues with bug label ");
		assertEquals(parse.toString(), "[[C:Issue=>WITH((in,O:bug))]]");
	}

	public void test19() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues with label bug");
		assertEquals(parse.toString(), "[[C:Issue=>WITH((in,O:bug))]]");
	}
	

	public void test20() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues in raml-for-jaxrs created by Gleb with label bug ");
		assertEquals(parse.toString(),
				"[[C:Issue=>IN((in,O:ramlforjaxrs))=>FILTER(P:Issue.user,(in,E:Gleb Borisov))=>WITH((in,O:bug))]]");
	}
	
	public void test22() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues closed by Antonio and closed at last month");
		assertEquals(parse.toString(),
				"[[C:Issue=>FILTER(P:Issue.closed_by,(in,O:Antonio))=>FILTER(P:Issue.closed_at,(in,month:true:true:0:-1))]]");
	}
	public void test221() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("issues closed by Antonio in last month");
		assertEquals(parse.toString(),
				"[[C:Issue=>FILTER(P:Issue.closed_by,(in,O:Antonio))=>FILTER(P:Issue.closed_at,(in,month:true:true:0:-1))]]");
	}
	
//	public void test223() {
//		CoreEngine engine = Github.getEngine();
//		ParsedQuery parse = engine.parse("issues closed by Antonio later then in last month");
//		assertEquals(parse.toString(),
//				"[[C:Issue=>FILTER(P:Issue.closed_by,(in,O:Antonio))=>FILTER(P:Issue.closed_at,(in,month:true:true:0:-1))]]");
//	}
//	
	
	public void test23() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("milestones in raml-js-parser-2");
		assertEquals(parse.toString(),
				"[[C:Milestone=>IN((in,O:ramljsparser2))]]");
	}
	public void test24() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("raml-js-parser-2 milestones");
		assertEquals(parse.toString(),
				"[[O:ramljsparser2=>map(PathProp:([P:Repository.issues, P:Issue.milestone]))]]");
	}
	
	public void test25() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users in mulesoft labs");
		assertEquals(parse.toString(),
				"[[C:User=>IN((in,E:Mulesoft Labs))]]");
	}
	
	public void test251() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users who created issues in mulesoft labs");
		assertEquals(parse.toString(),
				"[[C:User=>FILTER(!C:Issue.user,(in,C:Issue=>IN((in,E:Mulesoft Labs))))]]");
	}
	
	public void test253() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users with issues in mulesoft labs assigned to them");
		assertEquals(parse.toString(),
				"[[C:User=>WITH((in,C:Issue=>IN((in,E:Mulesoft Labs))))=>FILTER(!C:Issue.assignee,(in,them(C:User*)))]]");
	}
	
	public void test254() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users with issues assigned to them in mulesoft labs");
		assertEquals(parse.toString(),
				"[[C:User=>WITH((in,C:Issue))=>FILTER(!C:Issue.assignee,(in,them(C:User*)))=>IN((in,E:Mulesoft Labs))]]");
	}
	
	public void test256() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users who have issues in mulesoft labs assigned to them");
		assertEquals(parse.toString(),
				"[[C:User=>WITH((in,C:Issue=>IN((in,E:Mulesoft Labs))))=>FILTER(!C:Issue.assignee,(in,them(C:User*)))]]");
	}
	
	public void test257() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories with more then 5 stars");
		assertEquals(parse.toString(),
				"[[C:Repository=>FILTER(P:Repository.stargazers_count,(>,5))]]");
	}
	public void test258() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("repositories who have more then 5 stars");
		assertEquals(parse.toString(),
				"[[C:Repository=>FILTER(P:Repository.stargazers_count,(>,5))]]");
	}
	
	public void test252() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse("users with issues in mulesoft-labs");
		assertEquals(parse.toString(),
				"[[C:User=>WITH((in,C:Issue=>IN((in,E:Mulesoft Labs))))]]");
	}

	public void test21() {
		CoreEngine engine = Github.getEngine();
		ParsedQuery parse = engine.parse(
				"issues in raml-for-jaxrs created by Gleb Borisov with label bug and assigned to Denis Denisenko");
		assertEquals(parse.toString(),
				"[[C:Issue=>IN((in,O:ramlforjaxrs))=>FILTER(P:Issue.user,(in,E:Gleb Borisov))=>WITH((in,O:bug))=>FILTER(P:Issue.assignee,(in,E:Denis Denisenko))]]");
	}

}