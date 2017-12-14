package org.xtext.example.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Functions", "Classes", "Example", "Layers", "Layer", "Rules", "Then", "When", "AsteriskEqualsSign", "PlusSignEqualsSign", "EqualsSignGreaterThanSign", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "Colon", "EqualsSign", "QuestionMark", "LeftSquareBracket", "RightSquareBracket", "VerticalLine", "RULE_BEGIN", "RULE_END", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_END=27;
    public static final int RULE_BEGIN=26;
    public static final int EqualsSignGreaterThanSign=14;
    public static final int RULE_STRING=30;
    public static final int RULE_SL_COMMENT=32;
    public static final int Comma=19;
    public static final int EqualsSign=21;
    public static final int LeftParenthesis=15;
    public static final int Example=6;
    public static final int Then=10;
    public static final int AsteriskEqualsSign=12;
    public static final int Colon=20;
    public static final int EOF=-1;
    public static final int Layers=7;
    public static final int Asterisk=17;
    public static final int PlusSignEqualsSign=13;
    public static final int RightSquareBracket=24;
    public static final int Classes=5;
    public static final int RULE_ID=28;
    public static final int RULE_WS=33;
    public static final int RightParenthesis=16;
    public static final int Functions=4;
    public static final int RULE_ANY_OTHER=34;
    public static final int Layer=8;
    public static final int Rules=9;
    public static final int When=11;
    public static final int VerticalLine=25;
    public static final int PlusSign=18;
    public static final int QuestionMark=22;
    public static final int RULE_INT=29;
    public static final int RULE_ML_COMMENT=31;
    public static final int LeftSquareBracket=23;

    // delegates
    // delegators


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyDslParser.g"; }



     	private MyDslGrammarAccess grammarAccess;

        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalMyDslParser.g:57:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalMyDslParser.g:57:46: (iv_ruleModel= ruleModel EOF )
            // InternalMyDslParser.g:58:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMyDslParser.g:64:1: ruleModel returns [EObject current=null] : (otherlv_0= Classes otherlv_1= LeftSquareBracket ( (lv_tokens_2_0= ruleTokenDefinition ) ) (otherlv_3= Comma ( (lv_tokens_4_0= ruleTokenDefinition ) ) )* otherlv_5= RightSquareBracket otherlv_6= Functions otherlv_7= LeftSquareBracket ( (lv_functions_8_0= ruleFunction ) ) (otherlv_9= Comma ( (lv_functions_10_0= ruleFunction ) ) )* otherlv_11= RightSquareBracket otherlv_12= Layers otherlv_13= LeftSquareBracket ( (lv_layers_14_0= ruleLayer ) ) (otherlv_15= Comma ( (lv_layers_16_0= ruleLayer ) ) )* otherlv_17= RightSquareBracket otherlv_18= Rules this_BEGIN_19= RULE_BEGIN ( (lv_rules_20_0= ruleRule ) )+ this_END_21= RULE_END ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token this_BEGIN_19=null;
        Token this_END_21=null;
        EObject lv_tokens_2_0 = null;

        EObject lv_tokens_4_0 = null;

        EObject lv_functions_8_0 = null;

        EObject lv_functions_10_0 = null;

        EObject lv_layers_14_0 = null;

        EObject lv_layers_16_0 = null;

        EObject lv_rules_20_0 = null;



        	enterRule();

        try {
            // InternalMyDslParser.g:70:2: ( (otherlv_0= Classes otherlv_1= LeftSquareBracket ( (lv_tokens_2_0= ruleTokenDefinition ) ) (otherlv_3= Comma ( (lv_tokens_4_0= ruleTokenDefinition ) ) )* otherlv_5= RightSquareBracket otherlv_6= Functions otherlv_7= LeftSquareBracket ( (lv_functions_8_0= ruleFunction ) ) (otherlv_9= Comma ( (lv_functions_10_0= ruleFunction ) ) )* otherlv_11= RightSquareBracket otherlv_12= Layers otherlv_13= LeftSquareBracket ( (lv_layers_14_0= ruleLayer ) ) (otherlv_15= Comma ( (lv_layers_16_0= ruleLayer ) ) )* otherlv_17= RightSquareBracket otherlv_18= Rules this_BEGIN_19= RULE_BEGIN ( (lv_rules_20_0= ruleRule ) )+ this_END_21= RULE_END ) )
            // InternalMyDslParser.g:71:2: (otherlv_0= Classes otherlv_1= LeftSquareBracket ( (lv_tokens_2_0= ruleTokenDefinition ) ) (otherlv_3= Comma ( (lv_tokens_4_0= ruleTokenDefinition ) ) )* otherlv_5= RightSquareBracket otherlv_6= Functions otherlv_7= LeftSquareBracket ( (lv_functions_8_0= ruleFunction ) ) (otherlv_9= Comma ( (lv_functions_10_0= ruleFunction ) ) )* otherlv_11= RightSquareBracket otherlv_12= Layers otherlv_13= LeftSquareBracket ( (lv_layers_14_0= ruleLayer ) ) (otherlv_15= Comma ( (lv_layers_16_0= ruleLayer ) ) )* otherlv_17= RightSquareBracket otherlv_18= Rules this_BEGIN_19= RULE_BEGIN ( (lv_rules_20_0= ruleRule ) )+ this_END_21= RULE_END )
            {
            // InternalMyDslParser.g:71:2: (otherlv_0= Classes otherlv_1= LeftSquareBracket ( (lv_tokens_2_0= ruleTokenDefinition ) ) (otherlv_3= Comma ( (lv_tokens_4_0= ruleTokenDefinition ) ) )* otherlv_5= RightSquareBracket otherlv_6= Functions otherlv_7= LeftSquareBracket ( (lv_functions_8_0= ruleFunction ) ) (otherlv_9= Comma ( (lv_functions_10_0= ruleFunction ) ) )* otherlv_11= RightSquareBracket otherlv_12= Layers otherlv_13= LeftSquareBracket ( (lv_layers_14_0= ruleLayer ) ) (otherlv_15= Comma ( (lv_layers_16_0= ruleLayer ) ) )* otherlv_17= RightSquareBracket otherlv_18= Rules this_BEGIN_19= RULE_BEGIN ( (lv_rules_20_0= ruleRule ) )+ this_END_21= RULE_END )
            // InternalMyDslParser.g:72:3: otherlv_0= Classes otherlv_1= LeftSquareBracket ( (lv_tokens_2_0= ruleTokenDefinition ) ) (otherlv_3= Comma ( (lv_tokens_4_0= ruleTokenDefinition ) ) )* otherlv_5= RightSquareBracket otherlv_6= Functions otherlv_7= LeftSquareBracket ( (lv_functions_8_0= ruleFunction ) ) (otherlv_9= Comma ( (lv_functions_10_0= ruleFunction ) ) )* otherlv_11= RightSquareBracket otherlv_12= Layers otherlv_13= LeftSquareBracket ( (lv_layers_14_0= ruleLayer ) ) (otherlv_15= Comma ( (lv_layers_16_0= ruleLayer ) ) )* otherlv_17= RightSquareBracket otherlv_18= Rules this_BEGIN_19= RULE_BEGIN ( (lv_rules_20_0= ruleRule ) )+ this_END_21= RULE_END
            {
            otherlv_0=(Token)match(input,Classes,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getClassesKeyword_0());
            		
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getModelAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalMyDslParser.g:80:3: ( (lv_tokens_2_0= ruleTokenDefinition ) )
            // InternalMyDslParser.g:81:4: (lv_tokens_2_0= ruleTokenDefinition )
            {
            // InternalMyDslParser.g:81:4: (lv_tokens_2_0= ruleTokenDefinition )
            // InternalMyDslParser.g:82:5: lv_tokens_2_0= ruleTokenDefinition
            {

            					newCompositeNode(grammarAccess.getModelAccess().getTokensTokenDefinitionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_tokens_2_0=ruleTokenDefinition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"tokens",
            						lv_tokens_2_0,
            						"org.xtext.example.mydsl.MyDsl.TokenDefinition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDslParser.g:99:3: (otherlv_3= Comma ( (lv_tokens_4_0= ruleTokenDefinition ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Comma) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyDslParser.g:100:4: otherlv_3= Comma ( (lv_tokens_4_0= ruleTokenDefinition ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_4); 

            	    				newLeafNode(otherlv_3, grammarAccess.getModelAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalMyDslParser.g:104:4: ( (lv_tokens_4_0= ruleTokenDefinition ) )
            	    // InternalMyDslParser.g:105:5: (lv_tokens_4_0= ruleTokenDefinition )
            	    {
            	    // InternalMyDslParser.g:105:5: (lv_tokens_4_0= ruleTokenDefinition )
            	    // InternalMyDslParser.g:106:6: lv_tokens_4_0= ruleTokenDefinition
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getTokensTokenDefinitionParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_tokens_4_0=ruleTokenDefinition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"tokens",
            	    							lv_tokens_4_0,
            	    							"org.xtext.example.mydsl.MyDsl.TokenDefinition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getModelAccess().getRightSquareBracketKeyword_4());
            		
            otherlv_6=(Token)match(input,Functions,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getModelAccess().getFunctionsKeyword_5());
            		
            otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getModelAccess().getLeftSquareBracketKeyword_6());
            		
            // InternalMyDslParser.g:136:3: ( (lv_functions_8_0= ruleFunction ) )
            // InternalMyDslParser.g:137:4: (lv_functions_8_0= ruleFunction )
            {
            // InternalMyDslParser.g:137:4: (lv_functions_8_0= ruleFunction )
            // InternalMyDslParser.g:138:5: lv_functions_8_0= ruleFunction
            {

            					newCompositeNode(grammarAccess.getModelAccess().getFunctionsFunctionParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_5);
            lv_functions_8_0=ruleFunction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"functions",
            						lv_functions_8_0,
            						"org.xtext.example.mydsl.MyDsl.Function");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDslParser.g:155:3: (otherlv_9= Comma ( (lv_functions_10_0= ruleFunction ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Comma) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMyDslParser.g:156:4: otherlv_9= Comma ( (lv_functions_10_0= ruleFunction ) )
            	    {
            	    otherlv_9=(Token)match(input,Comma,FOLLOW_4); 

            	    				newLeafNode(otherlv_9, grammarAccess.getModelAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalMyDslParser.g:160:4: ( (lv_functions_10_0= ruleFunction ) )
            	    // InternalMyDslParser.g:161:5: (lv_functions_10_0= ruleFunction )
            	    {
            	    // InternalMyDslParser.g:161:5: (lv_functions_10_0= ruleFunction )
            	    // InternalMyDslParser.g:162:6: lv_functions_10_0= ruleFunction
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getFunctionsFunctionParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_functions_10_0=ruleFunction();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"functions",
            	    							lv_functions_10_0,
            	    							"org.xtext.example.mydsl.MyDsl.Function");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_11=(Token)match(input,RightSquareBracket,FOLLOW_7); 

            			newLeafNode(otherlv_11, grammarAccess.getModelAccess().getRightSquareBracketKeyword_9());
            		
            otherlv_12=(Token)match(input,Layers,FOLLOW_3); 

            			newLeafNode(otherlv_12, grammarAccess.getModelAccess().getLayersKeyword_10());
            		
            otherlv_13=(Token)match(input,LeftSquareBracket,FOLLOW_4); 

            			newLeafNode(otherlv_13, grammarAccess.getModelAccess().getLeftSquareBracketKeyword_11());
            		
            // InternalMyDslParser.g:192:3: ( (lv_layers_14_0= ruleLayer ) )
            // InternalMyDslParser.g:193:4: (lv_layers_14_0= ruleLayer )
            {
            // InternalMyDslParser.g:193:4: (lv_layers_14_0= ruleLayer )
            // InternalMyDslParser.g:194:5: lv_layers_14_0= ruleLayer
            {

            					newCompositeNode(grammarAccess.getModelAccess().getLayersLayerParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_5);
            lv_layers_14_0=ruleLayer();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"layers",
            						lv_layers_14_0,
            						"org.xtext.example.mydsl.MyDsl.Layer");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDslParser.g:211:3: (otherlv_15= Comma ( (lv_layers_16_0= ruleLayer ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Comma) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMyDslParser.g:212:4: otherlv_15= Comma ( (lv_layers_16_0= ruleLayer ) )
            	    {
            	    otherlv_15=(Token)match(input,Comma,FOLLOW_4); 

            	    				newLeafNode(otherlv_15, grammarAccess.getModelAccess().getCommaKeyword_13_0());
            	    			
            	    // InternalMyDslParser.g:216:4: ( (lv_layers_16_0= ruleLayer ) )
            	    // InternalMyDslParser.g:217:5: (lv_layers_16_0= ruleLayer )
            	    {
            	    // InternalMyDslParser.g:217:5: (lv_layers_16_0= ruleLayer )
            	    // InternalMyDslParser.g:218:6: lv_layers_16_0= ruleLayer
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getLayersLayerParserRuleCall_13_1_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_layers_16_0=ruleLayer();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"layers",
            	    							lv_layers_16_0,
            	    							"org.xtext.example.mydsl.MyDsl.Layer");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_17=(Token)match(input,RightSquareBracket,FOLLOW_8); 

            			newLeafNode(otherlv_17, grammarAccess.getModelAccess().getRightSquareBracketKeyword_14());
            		
            otherlv_18=(Token)match(input,Rules,FOLLOW_9); 

            			newLeafNode(otherlv_18, grammarAccess.getModelAccess().getRulesKeyword_15());
            		
            this_BEGIN_19=(Token)match(input,RULE_BEGIN,FOLLOW_4); 

            			newLeafNode(this_BEGIN_19, grammarAccess.getModelAccess().getBEGINTerminalRuleCall_16());
            		
            // InternalMyDslParser.g:248:3: ( (lv_rules_20_0= ruleRule ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMyDslParser.g:249:4: (lv_rules_20_0= ruleRule )
            	    {
            	    // InternalMyDslParser.g:249:4: (lv_rules_20_0= ruleRule )
            	    // InternalMyDslParser.g:250:5: lv_rules_20_0= ruleRule
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getRulesRuleParserRuleCall_17_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_rules_20_0=ruleRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"rules",
            	    						lv_rules_20_0,
            	    						"org.xtext.example.mydsl.MyDsl.Rule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            this_END_21=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_21, grammarAccess.getModelAccess().getENDTerminalRuleCall_18());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleTransferModel"
    // InternalMyDslParser.g:275:1: entryRuleTransferModel returns [EObject current=null] : iv_ruleTransferModel= ruleTransferModel EOF ;
    public final EObject entryRuleTransferModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransferModel = null;


        try {
            // InternalMyDslParser.g:275:54: (iv_ruleTransferModel= ruleTransferModel EOF )
            // InternalMyDslParser.g:276:2: iv_ruleTransferModel= ruleTransferModel EOF
            {
             newCompositeNode(grammarAccess.getTransferModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransferModel=ruleTransferModel();

            state._fsp--;

             current =iv_ruleTransferModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransferModel"


    // $ANTLR start "ruleTransferModel"
    // InternalMyDslParser.g:282:1: ruleTransferModel returns [EObject current=null] : ( ( (lv_seq_0_0= ruleCall ) ) (otherlv_1= EqualsSignGreaterThanSign ( (lv_seq_2_0= ruleCall ) ) )* ) ;
    public final EObject ruleTransferModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_seq_0_0 = null;

        EObject lv_seq_2_0 = null;



        	enterRule();

        try {
            // InternalMyDslParser.g:288:2: ( ( ( (lv_seq_0_0= ruleCall ) ) (otherlv_1= EqualsSignGreaterThanSign ( (lv_seq_2_0= ruleCall ) ) )* ) )
            // InternalMyDslParser.g:289:2: ( ( (lv_seq_0_0= ruleCall ) ) (otherlv_1= EqualsSignGreaterThanSign ( (lv_seq_2_0= ruleCall ) ) )* )
            {
            // InternalMyDslParser.g:289:2: ( ( (lv_seq_0_0= ruleCall ) ) (otherlv_1= EqualsSignGreaterThanSign ( (lv_seq_2_0= ruleCall ) ) )* )
            // InternalMyDslParser.g:290:3: ( (lv_seq_0_0= ruleCall ) ) (otherlv_1= EqualsSignGreaterThanSign ( (lv_seq_2_0= ruleCall ) ) )*
            {
            // InternalMyDslParser.g:290:3: ( (lv_seq_0_0= ruleCall ) )
            // InternalMyDslParser.g:291:4: (lv_seq_0_0= ruleCall )
            {
            // InternalMyDslParser.g:291:4: (lv_seq_0_0= ruleCall )
            // InternalMyDslParser.g:292:5: lv_seq_0_0= ruleCall
            {

            					newCompositeNode(grammarAccess.getTransferModelAccess().getSeqCallParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_11);
            lv_seq_0_0=ruleCall();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransferModelRule());
            					}
            					add(
            						current,
            						"seq",
            						lv_seq_0_0,
            						"org.xtext.example.mydsl.MyDsl.Call");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDslParser.g:309:3: (otherlv_1= EqualsSignGreaterThanSign ( (lv_seq_2_0= ruleCall ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==EqualsSignGreaterThanSign) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMyDslParser.g:310:4: otherlv_1= EqualsSignGreaterThanSign ( (lv_seq_2_0= ruleCall ) )
            	    {
            	    otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getTransferModelAccess().getEqualsSignGreaterThanSignKeyword_1_0());
            	    			
            	    // InternalMyDslParser.g:314:4: ( (lv_seq_2_0= ruleCall ) )
            	    // InternalMyDslParser.g:315:5: (lv_seq_2_0= ruleCall )
            	    {
            	    // InternalMyDslParser.g:315:5: (lv_seq_2_0= ruleCall )
            	    // InternalMyDslParser.g:316:6: lv_seq_2_0= ruleCall
            	    {

            	    						newCompositeNode(grammarAccess.getTransferModelAccess().getSeqCallParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_seq_2_0=ruleCall();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTransferModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"seq",
            	    							lv_seq_2_0,
            	    							"org.xtext.example.mydsl.MyDsl.Call");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransferModel"


    // $ANTLR start "entryRuleCall"
    // InternalMyDslParser.g:338:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // InternalMyDslParser.g:338:45: (iv_ruleCall= ruleCall EOF )
            // InternalMyDslParser.g:339:2: iv_ruleCall= ruleCall EOF
            {
             newCompositeNode(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCall=ruleCall();

            state._fsp--;

             current =iv_ruleCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCall"


    // $ANTLR start "ruleCall"
    // InternalMyDslParser.g:345:1: ruleCall returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LeftParenthesis ( (lv_args_2_0= ruleArgList ) )? otherlv_3= RightParenthesis ( (lv_op_4_0= QuestionMark ) )? ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_op_4_0=null;
        EObject lv_args_2_0 = null;



        	enterRule();

        try {
            // InternalMyDslParser.g:351:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LeftParenthesis ( (lv_args_2_0= ruleArgList ) )? otherlv_3= RightParenthesis ( (lv_op_4_0= QuestionMark ) )? ) )
            // InternalMyDslParser.g:352:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LeftParenthesis ( (lv_args_2_0= ruleArgList ) )? otherlv_3= RightParenthesis ( (lv_op_4_0= QuestionMark ) )? )
            {
            // InternalMyDslParser.g:352:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= LeftParenthesis ( (lv_args_2_0= ruleArgList ) )? otherlv_3= RightParenthesis ( (lv_op_4_0= QuestionMark ) )? )
            // InternalMyDslParser.g:353:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= LeftParenthesis ( (lv_args_2_0= ruleArgList ) )? otherlv_3= RightParenthesis ( (lv_op_4_0= QuestionMark ) )?
            {
            // InternalMyDslParser.g:353:3: ( (otherlv_0= RULE_ID ) )
            // InternalMyDslParser.g:354:4: (otherlv_0= RULE_ID )
            {
            // InternalMyDslParser.g:354:4: (otherlv_0= RULE_ID )
            // InternalMyDslParser.g:355:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCallRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_0, grammarAccess.getCallAccess().getNameFunctionCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,LeftParenthesis,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMyDslParser.g:370:3: ( (lv_args_2_0= ruleArgList ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_STRING)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMyDslParser.g:371:4: (lv_args_2_0= ruleArgList )
                    {
                    // InternalMyDslParser.g:371:4: (lv_args_2_0= ruleArgList )
                    // InternalMyDslParser.g:372:5: lv_args_2_0= ruleArgList
                    {

                    					newCompositeNode(grammarAccess.getCallAccess().getArgsArgListParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_14);
                    lv_args_2_0=ruleArgList();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getCallRule());
                    					}
                    					set(
                    						current,
                    						"args",
                    						lv_args_2_0,
                    						"org.xtext.example.mydsl.MyDsl.ArgList");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,RightParenthesis,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getCallAccess().getRightParenthesisKeyword_3());
            		
            // InternalMyDslParser.g:393:3: ( (lv_op_4_0= QuestionMark ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==QuestionMark) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMyDslParser.g:394:4: (lv_op_4_0= QuestionMark )
                    {
                    // InternalMyDslParser.g:394:4: (lv_op_4_0= QuestionMark )
                    // InternalMyDslParser.g:395:5: lv_op_4_0= QuestionMark
                    {
                    lv_op_4_0=(Token)match(input,QuestionMark,FOLLOW_2); 

                    					newLeafNode(lv_op_4_0, grammarAccess.getCallAccess().getOpQuestionMarkKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCallRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_4_0, "?");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCall"


    // $ANTLR start "entryRuleArgList"
    // InternalMyDslParser.g:411:1: entryRuleArgList returns [EObject current=null] : iv_ruleArgList= ruleArgList EOF ;
    public final EObject entryRuleArgList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgList = null;


        try {
            // InternalMyDslParser.g:411:48: (iv_ruleArgList= ruleArgList EOF )
            // InternalMyDslParser.g:412:2: iv_ruleArgList= ruleArgList EOF
            {
             newCompositeNode(grammarAccess.getArgListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArgList=ruleArgList();

            state._fsp--;

             current =iv_ruleArgList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArgList"


    // $ANTLR start "ruleArgList"
    // InternalMyDslParser.g:418:1: ruleArgList returns [EObject current=null] : ( ( (lv_a_0_0= rulePrimaryExpression ) ) (otherlv_1= Comma ( (lv_a_2_0= rulePrimaryExpression ) ) )* ) ;
    public final EObject ruleArgList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_a_0_0 = null;

        EObject lv_a_2_0 = null;



        	enterRule();

        try {
            // InternalMyDslParser.g:424:2: ( ( ( (lv_a_0_0= rulePrimaryExpression ) ) (otherlv_1= Comma ( (lv_a_2_0= rulePrimaryExpression ) ) )* ) )
            // InternalMyDslParser.g:425:2: ( ( (lv_a_0_0= rulePrimaryExpression ) ) (otherlv_1= Comma ( (lv_a_2_0= rulePrimaryExpression ) ) )* )
            {
            // InternalMyDslParser.g:425:2: ( ( (lv_a_0_0= rulePrimaryExpression ) ) (otherlv_1= Comma ( (lv_a_2_0= rulePrimaryExpression ) ) )* )
            // InternalMyDslParser.g:426:3: ( (lv_a_0_0= rulePrimaryExpression ) ) (otherlv_1= Comma ( (lv_a_2_0= rulePrimaryExpression ) ) )*
            {
            // InternalMyDslParser.g:426:3: ( (lv_a_0_0= rulePrimaryExpression ) )
            // InternalMyDslParser.g:427:4: (lv_a_0_0= rulePrimaryExpression )
            {
            // InternalMyDslParser.g:427:4: (lv_a_0_0= rulePrimaryExpression )
            // InternalMyDslParser.g:428:5: lv_a_0_0= rulePrimaryExpression
            {

            					newCompositeNode(grammarAccess.getArgListAccess().getAPrimaryExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_16);
            lv_a_0_0=rulePrimaryExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArgListRule());
            					}
            					add(
            						current,
            						"a",
            						lv_a_0_0,
            						"org.xtext.example.mydsl.MyDsl.PrimaryExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDslParser.g:445:3: (otherlv_1= Comma ( (lv_a_2_0= rulePrimaryExpression ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Comma) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMyDslParser.g:446:4: otherlv_1= Comma ( (lv_a_2_0= rulePrimaryExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,Comma,FOLLOW_17); 

            	    				newLeafNode(otherlv_1, grammarAccess.getArgListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMyDslParser.g:450:4: ( (lv_a_2_0= rulePrimaryExpression ) )
            	    // InternalMyDslParser.g:451:5: (lv_a_2_0= rulePrimaryExpression )
            	    {
            	    // InternalMyDslParser.g:451:5: (lv_a_2_0= rulePrimaryExpression )
            	    // InternalMyDslParser.g:452:6: lv_a_2_0= rulePrimaryExpression
            	    {

            	    						newCompositeNode(grammarAccess.getArgListAccess().getAPrimaryExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_a_2_0=rulePrimaryExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getArgListRule());
            	    						}
            	    						add(
            	    							current,
            	    							"a",
            	    							lv_a_2_0,
            	    							"org.xtext.example.mydsl.MyDsl.PrimaryExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArgList"


    // $ANTLR start "entryRuleName"
    // InternalMyDslParser.g:474:1: entryRuleName returns [EObject current=null] : iv_ruleName= ruleName EOF ;
    public final EObject entryRuleName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleName = null;


        try {
            // InternalMyDslParser.g:474:45: (iv_ruleName= ruleName EOF )
            // InternalMyDslParser.g:475:2: iv_ruleName= ruleName EOF
            {
             newCompositeNode(grammarAccess.getNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleName=ruleName();

            state._fsp--;

             current =iv_ruleName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleName"


    // $ANTLR start "ruleName"
    // InternalMyDslParser.g:481:1: ruleName returns [EObject current=null] : ( (lv_v_0_0= RULE_ID ) ) ;
    public final EObject ruleName() throws RecognitionException {
        EObject current = null;

        Token lv_v_0_0=null;


        	enterRule();

        try {
            // InternalMyDslParser.g:487:2: ( ( (lv_v_0_0= RULE_ID ) ) )
            // InternalMyDslParser.g:488:2: ( (lv_v_0_0= RULE_ID ) )
            {
            // InternalMyDslParser.g:488:2: ( (lv_v_0_0= RULE_ID ) )
            // InternalMyDslParser.g:489:3: (lv_v_0_0= RULE_ID )
            {
            // InternalMyDslParser.g:489:3: (lv_v_0_0= RULE_ID )
            // InternalMyDslParser.g:490:4: lv_v_0_0= RULE_ID
            {
            lv_v_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_v_0_0, grammarAccess.getNameAccess().getVIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNameRule());
            				}
            				setWithLastConsumed(
            					current,
            					"v",
            					lv_v_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleName"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalMyDslParser.g:509:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalMyDslParser.g:509:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalMyDslParser.g:510:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalMyDslParser.g:516:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_c_0_0= ruleCall ) ) | ( (lv_c_1_0= ruleName ) ) | ( (lv_c_2_0= ruleIntLiteral ) ) | ( (lv_c_3_0= ruleStringLiteral ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_c_0_0 = null;

        EObject lv_c_1_0 = null;

        EObject lv_c_2_0 = null;

        EObject lv_c_3_0 = null;



        	enterRule();

        try {
            // InternalMyDslParser.g:522:2: ( ( ( (lv_c_0_0= ruleCall ) ) | ( (lv_c_1_0= ruleName ) ) | ( (lv_c_2_0= ruleIntLiteral ) ) | ( (lv_c_3_0= ruleStringLiteral ) ) ) )
            // InternalMyDslParser.g:523:2: ( ( (lv_c_0_0= ruleCall ) ) | ( (lv_c_1_0= ruleName ) ) | ( (lv_c_2_0= ruleIntLiteral ) ) | ( (lv_c_3_0= ruleStringLiteral ) ) )
            {
            // InternalMyDslParser.g:523:2: ( ( (lv_c_0_0= ruleCall ) ) | ( (lv_c_1_0= ruleName ) ) | ( (lv_c_2_0= ruleIntLiteral ) ) | ( (lv_c_3_0= ruleStringLiteral ) ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==LeftParenthesis) ) {
                    alt9=1;
                }
                else if ( (LA9_1==EOF||LA9_1==RightParenthesis||LA9_1==Comma) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt9=3;
                }
                break;
            case RULE_STRING:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalMyDslParser.g:524:3: ( (lv_c_0_0= ruleCall ) )
                    {
                    // InternalMyDslParser.g:524:3: ( (lv_c_0_0= ruleCall ) )
                    // InternalMyDslParser.g:525:4: (lv_c_0_0= ruleCall )
                    {
                    // InternalMyDslParser.g:525:4: (lv_c_0_0= ruleCall )
                    // InternalMyDslParser.g:526:5: lv_c_0_0= ruleCall
                    {

                    					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getCCallParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_c_0_0=ruleCall();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    					}
                    					set(
                    						current,
                    						"c",
                    						lv_c_0_0,
                    						"org.xtext.example.mydsl.MyDsl.Call");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyDslParser.g:544:3: ( (lv_c_1_0= ruleName ) )
                    {
                    // InternalMyDslParser.g:544:3: ( (lv_c_1_0= ruleName ) )
                    // InternalMyDslParser.g:545:4: (lv_c_1_0= ruleName )
                    {
                    // InternalMyDslParser.g:545:4: (lv_c_1_0= ruleName )
                    // InternalMyDslParser.g:546:5: lv_c_1_0= ruleName
                    {

                    					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getCNameParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_c_1_0=ruleName();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    					}
                    					set(
                    						current,
                    						"c",
                    						lv_c_1_0,
                    						"org.xtext.example.mydsl.MyDsl.Name");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyDslParser.g:564:3: ( (lv_c_2_0= ruleIntLiteral ) )
                    {
                    // InternalMyDslParser.g:564:3: ( (lv_c_2_0= ruleIntLiteral ) )
                    // InternalMyDslParser.g:565:4: (lv_c_2_0= ruleIntLiteral )
                    {
                    // InternalMyDslParser.g:565:4: (lv_c_2_0= ruleIntLiteral )
                    // InternalMyDslParser.g:566:5: lv_c_2_0= ruleIntLiteral
                    {

                    					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getCIntLiteralParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_c_2_0=ruleIntLiteral();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    					}
                    					set(
                    						current,
                    						"c",
                    						lv_c_2_0,
                    						"org.xtext.example.mydsl.MyDsl.IntLiteral");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMyDslParser.g:584:3: ( (lv_c_3_0= ruleStringLiteral ) )
                    {
                    // InternalMyDslParser.g:584:3: ( (lv_c_3_0= ruleStringLiteral ) )
                    // InternalMyDslParser.g:585:4: (lv_c_3_0= ruleStringLiteral )
                    {
                    // InternalMyDslParser.g:585:4: (lv_c_3_0= ruleStringLiteral )
                    // InternalMyDslParser.g:586:5: lv_c_3_0= ruleStringLiteral
                    {

                    					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getCStringLiteralParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_c_3_0=ruleStringLiteral();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    					}
                    					set(
                    						current,
                    						"c",
                    						lv_c_3_0,
                    						"org.xtext.example.mydsl.MyDsl.StringLiteral");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleIntLiteral"
    // InternalMyDslParser.g:607:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalMyDslParser.g:607:51: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalMyDslParser.g:608:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntLiteral"


    // $ANTLR start "ruleIntLiteral"
    // InternalMyDslParser.g:614:1: ruleIntLiteral returns [EObject current=null] : ( (lv_v_0_0= RULE_INT ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_v_0_0=null;


        	enterRule();

        try {
            // InternalMyDslParser.g:620:2: ( ( (lv_v_0_0= RULE_INT ) ) )
            // InternalMyDslParser.g:621:2: ( (lv_v_0_0= RULE_INT ) )
            {
            // InternalMyDslParser.g:621:2: ( (lv_v_0_0= RULE_INT ) )
            // InternalMyDslParser.g:622:3: (lv_v_0_0= RULE_INT )
            {
            // InternalMyDslParser.g:622:3: (lv_v_0_0= RULE_INT )
            // InternalMyDslParser.g:623:4: lv_v_0_0= RULE_INT
            {
            lv_v_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_v_0_0, grammarAccess.getIntLiteralAccess().getVINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIntLiteralRule());
            				}
            				setWithLastConsumed(
            					current,
            					"v",
            					lv_v_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalMyDslParser.g:642:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalMyDslParser.g:642:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalMyDslParser.g:643:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalMyDslParser.g:649:1: ruleStringLiteral returns [EObject current=null] : ( (lv_v_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_v_0_0=null;


        	enterRule();

        try {
            // InternalMyDslParser.g:655:2: ( ( (lv_v_0_0= RULE_STRING ) ) )
            // InternalMyDslParser.g:656:2: ( (lv_v_0_0= RULE_STRING ) )
            {
            // InternalMyDslParser.g:656:2: ( (lv_v_0_0= RULE_STRING ) )
            // InternalMyDslParser.g:657:3: (lv_v_0_0= RULE_STRING )
            {
            // InternalMyDslParser.g:657:3: (lv_v_0_0= RULE_STRING )
            // InternalMyDslParser.g:658:4: lv_v_0_0= RULE_STRING
            {
            lv_v_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_v_0_0, grammarAccess.getStringLiteralAccess().getVSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStringLiteralRule());
            				}
            				setWithLastConsumed(
            					current,
            					"v",
            					lv_v_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleSeq"
    // InternalMyDslParser.g:677:1: entryRuleSeq returns [EObject current=null] : iv_ruleSeq= ruleSeq EOF ;
    public final EObject entryRuleSeq() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSeq = null;


        try {
            // InternalMyDslParser.g:677:44: (iv_ruleSeq= ruleSeq EOF )
            // InternalMyDslParser.g:678:2: iv_ruleSeq= ruleSeq EOF
            {
             newCompositeNode(grammarAccess.getSeqRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSeq=ruleSeq();

            state._fsp--;

             current =iv_ruleSeq; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSeq"


    // $ANTLR start "ruleSeq"
    // InternalMyDslParser.g:684:1: ruleSeq returns [EObject current=null] : ( (lv_seq_0_0= ruleOrExp ) )+ ;
    public final EObject ruleSeq() throws RecognitionException {
        EObject current = null;

        EObject lv_seq_0_0 = null;



        	enterRule();

        try {
            // InternalMyDslParser.g:690:2: ( ( (lv_seq_0_0= ruleOrExp ) )+ )
            // InternalMyDslParser.g:691:2: ( (lv_seq_0_0= ruleOrExp ) )+
            {
            // InternalMyDslParser.g:691:2: ( (lv_seq_0_0= ruleOrExp ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==LeftParenthesis||LA10_0==RULE_ID||LA10_0==RULE_STRING) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMyDslParser.g:692:3: (lv_seq_0_0= ruleOrExp )
            	    {
            	    // InternalMyDslParser.g:692:3: (lv_seq_0_0= ruleOrExp )
            	    // InternalMyDslParser.g:693:4: lv_seq_0_0= ruleOrExp
            	    {

            	    				newCompositeNode(grammarAccess.getSeqAccess().getSeqOrExpParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_18);
            	    lv_seq_0_0=ruleOrExp();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getSeqRule());
            	    				}
            	    				add(
            	    					current,
            	    					"seq",
            	    					lv_seq_0_0,
            	    					"org.xtext.example.mydsl.MyDsl.OrExp");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSeq"


    // $ANTLR start "entryRuleGroup"
    // InternalMyDslParser.g:713:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // InternalMyDslParser.g:713:46: (iv_ruleGroup= ruleGroup EOF )
            // InternalMyDslParser.g:714:2: iv_ruleGroup= ruleGroup EOF
            {
             newCompositeNode(grammarAccess.getGroupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGroup=ruleGroup();

            state._fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // InternalMyDslParser.g:720:1: ruleGroup returns [EObject current=null] : (otherlv_0= LeftParenthesis ( (lv_seq_1_0= ruleSeq ) ) otherlv_2= RightParenthesis ( ( (lv_op_3_0= PlusSign ) ) | ( (lv_op_4_0= QuestionMark ) ) | ( (lv_op_5_0= Asterisk ) ) )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_op_3_0=null;
        Token lv_op_4_0=null;
        Token lv_op_5_0=null;
        EObject lv_seq_1_0 = null;



        	enterRule();

        try {
            // InternalMyDslParser.g:726:2: ( (otherlv_0= LeftParenthesis ( (lv_seq_1_0= ruleSeq ) ) otherlv_2= RightParenthesis ( ( (lv_op_3_0= PlusSign ) ) | ( (lv_op_4_0= QuestionMark ) ) | ( (lv_op_5_0= Asterisk ) ) )? ) )
            // InternalMyDslParser.g:727:2: (otherlv_0= LeftParenthesis ( (lv_seq_1_0= ruleSeq ) ) otherlv_2= RightParenthesis ( ( (lv_op_3_0= PlusSign ) ) | ( (lv_op_4_0= QuestionMark ) ) | ( (lv_op_5_0= Asterisk ) ) )? )
            {
            // InternalMyDslParser.g:727:2: (otherlv_0= LeftParenthesis ( (lv_seq_1_0= ruleSeq ) ) otherlv_2= RightParenthesis ( ( (lv_op_3_0= PlusSign ) ) | ( (lv_op_4_0= QuestionMark ) ) | ( (lv_op_5_0= Asterisk ) ) )? )
            // InternalMyDslParser.g:728:3: otherlv_0= LeftParenthesis ( (lv_seq_1_0= ruleSeq ) ) otherlv_2= RightParenthesis ( ( (lv_op_3_0= PlusSign ) ) | ( (lv_op_4_0= QuestionMark ) ) | ( (lv_op_5_0= Asterisk ) ) )?
            {
            otherlv_0=(Token)match(input,LeftParenthesis,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getGroupAccess().getLeftParenthesisKeyword_0());
            		
            // InternalMyDslParser.g:732:3: ( (lv_seq_1_0= ruleSeq ) )
            // InternalMyDslParser.g:733:4: (lv_seq_1_0= ruleSeq )
            {
            // InternalMyDslParser.g:733:4: (lv_seq_1_0= ruleSeq )
            // InternalMyDslParser.g:734:5: lv_seq_1_0= ruleSeq
            {

            					newCompositeNode(grammarAccess.getGroupAccess().getSeqSeqParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_14);
            lv_seq_1_0=ruleSeq();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGroupRule());
            					}
            					set(
            						current,
            						"seq",
            						lv_seq_1_0,
            						"org.xtext.example.mydsl.MyDsl.Seq");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,RightParenthesis,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getGroupAccess().getRightParenthesisKeyword_2());
            		
            // InternalMyDslParser.g:755:3: ( ( (lv_op_3_0= PlusSign ) ) | ( (lv_op_4_0= QuestionMark ) ) | ( (lv_op_5_0= Asterisk ) ) )?
            int alt11=4;
            switch ( input.LA(1) ) {
                case PlusSign:
                    {
                    alt11=1;
                    }
                    break;
                case QuestionMark:
                    {
                    alt11=2;
                    }
                    break;
                case Asterisk:
                    {
                    alt11=3;
                    }
                    break;
            }

            switch (alt11) {
                case 1 :
                    // InternalMyDslParser.g:756:4: ( (lv_op_3_0= PlusSign ) )
                    {
                    // InternalMyDslParser.g:756:4: ( (lv_op_3_0= PlusSign ) )
                    // InternalMyDslParser.g:757:5: (lv_op_3_0= PlusSign )
                    {
                    // InternalMyDslParser.g:757:5: (lv_op_3_0= PlusSign )
                    // InternalMyDslParser.g:758:6: lv_op_3_0= PlusSign
                    {
                    lv_op_3_0=(Token)match(input,PlusSign,FOLLOW_2); 

                    						newLeafNode(lv_op_3_0, grammarAccess.getGroupAccess().getOpPlusSignKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGroupRule());
                    						}
                    						setWithLastConsumed(current, "op", lv_op_3_0, "+");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyDslParser.g:771:4: ( (lv_op_4_0= QuestionMark ) )
                    {
                    // InternalMyDslParser.g:771:4: ( (lv_op_4_0= QuestionMark ) )
                    // InternalMyDslParser.g:772:5: (lv_op_4_0= QuestionMark )
                    {
                    // InternalMyDslParser.g:772:5: (lv_op_4_0= QuestionMark )
                    // InternalMyDslParser.g:773:6: lv_op_4_0= QuestionMark
                    {
                    lv_op_4_0=(Token)match(input,QuestionMark,FOLLOW_2); 

                    						newLeafNode(lv_op_4_0, grammarAccess.getGroupAccess().getOpQuestionMarkKeyword_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGroupRule());
                    						}
                    						setWithLastConsumed(current, "op", lv_op_4_0, "?");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyDslParser.g:786:4: ( (lv_op_5_0= Asterisk ) )
                    {
                    // InternalMyDslParser.g:786:4: ( (lv_op_5_0= Asterisk ) )
                    // InternalMyDslParser.g:787:5: (lv_op_5_0= Asterisk )
                    {
                    // InternalMyDslParser.g:787:5: (lv_op_5_0= Asterisk )
                    // InternalMyDslParser.g:788:6: lv_op_5_0= Asterisk
                    {
                    lv_op_5_0=(Token)match(input,Asterisk,FOLLOW_2); 

                    						newLeafNode(lv_op_5_0, grammarAccess.getGroupAccess().getOpAsteriskKeyword_3_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGroupRule());
                    						}
                    						setWithLastConsumed(current, "op", lv_op_5_0, "*");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleOrExp"
    // InternalMyDslParser.g:805:1: entryRuleOrExp returns [EObject current=null] : iv_ruleOrExp= ruleOrExp EOF ;
    public final EObject entryRuleOrExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExp = null;


        try {
            // InternalMyDslParser.g:805:46: (iv_ruleOrExp= ruleOrExp EOF )
            // InternalMyDslParser.g:806:2: iv_ruleOrExp= ruleOrExp EOF
            {
             newCompositeNode(grammarAccess.getOrExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrExp=ruleOrExp();

            state._fsp--;

             current =iv_ruleOrExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExp"


    // $ANTLR start "ruleOrExp"
    // InternalMyDslParser.g:812:1: ruleOrExp returns [EObject current=null] : ( ( (lv_options_0_0= ruleElement ) ) (otherlv_1= VerticalLine ( (lv_options_2_0= ruleElement ) ) )* ) ;
    public final EObject ruleOrExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_options_0_0 = null;

        EObject lv_options_2_0 = null;



        	enterRule();

        try {
            // InternalMyDslParser.g:818:2: ( ( ( (lv_options_0_0= ruleElement ) ) (otherlv_1= VerticalLine ( (lv_options_2_0= ruleElement ) ) )* ) )
            // InternalMyDslParser.g:819:2: ( ( (lv_options_0_0= ruleElement ) ) (otherlv_1= VerticalLine ( (lv_options_2_0= ruleElement ) ) )* )
            {
            // InternalMyDslParser.g:819:2: ( ( (lv_options_0_0= ruleElement ) ) (otherlv_1= VerticalLine ( (lv_options_2_0= ruleElement ) ) )* )
            // InternalMyDslParser.g:820:3: ( (lv_options_0_0= ruleElement ) ) (otherlv_1= VerticalLine ( (lv_options_2_0= ruleElement ) ) )*
            {
            // InternalMyDslParser.g:820:3: ( (lv_options_0_0= ruleElement ) )
            // InternalMyDslParser.g:821:4: (lv_options_0_0= ruleElement )
            {
            // InternalMyDslParser.g:821:4: (lv_options_0_0= ruleElement )
            // InternalMyDslParser.g:822:5: lv_options_0_0= ruleElement
            {

            					newCompositeNode(grammarAccess.getOrExpAccess().getOptionsElementParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_21);
            lv_options_0_0=ruleElement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrExpRule());
            					}
            					add(
            						current,
            						"options",
            						lv_options_0_0,
            						"org.xtext.example.mydsl.MyDsl.Element");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDslParser.g:839:3: (otherlv_1= VerticalLine ( (lv_options_2_0= ruleElement ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==VerticalLine) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMyDslParser.g:840:4: otherlv_1= VerticalLine ( (lv_options_2_0= ruleElement ) )
            	    {
            	    otherlv_1=(Token)match(input,VerticalLine,FOLLOW_22); 

            	    				newLeafNode(otherlv_1, grammarAccess.getOrExpAccess().getVerticalLineKeyword_1_0());
            	    			
            	    // InternalMyDslParser.g:844:4: ( (lv_options_2_0= ruleElement ) )
            	    // InternalMyDslParser.g:845:5: (lv_options_2_0= ruleElement )
            	    {
            	    // InternalMyDslParser.g:845:5: (lv_options_2_0= ruleElement )
            	    // InternalMyDslParser.g:846:6: lv_options_2_0= ruleElement
            	    {

            	    						newCompositeNode(grammarAccess.getOrExpAccess().getOptionsElementParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    lv_options_2_0=ruleElement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrExpRule());
            	    						}
            	    						add(
            	    							current,
            	    							"options",
            	    							lv_options_2_0,
            	    							"org.xtext.example.mydsl.MyDsl.Element");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExp"


    // $ANTLR start "entryRuleElement"
    // InternalMyDslParser.g:868:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalMyDslParser.g:868:48: (iv_ruleElement= ruleElement EOF )
            // InternalMyDslParser.g:869:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalMyDslParser.g:875:1: ruleElement returns [EObject current=null] : ( ( (lv_val_0_0= ruleAssign ) ) | ( (lv_val_1_0= ruleStringLiteral ) ) | ( (lv_val_2_0= ruleGroup ) ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject lv_val_0_0 = null;

        EObject lv_val_1_0 = null;

        EObject lv_val_2_0 = null;



        	enterRule();

        try {
            // InternalMyDslParser.g:881:2: ( ( ( (lv_val_0_0= ruleAssign ) ) | ( (lv_val_1_0= ruleStringLiteral ) ) | ( (lv_val_2_0= ruleGroup ) ) ) )
            // InternalMyDslParser.g:882:2: ( ( (lv_val_0_0= ruleAssign ) ) | ( (lv_val_1_0= ruleStringLiteral ) ) | ( (lv_val_2_0= ruleGroup ) ) )
            {
            // InternalMyDslParser.g:882:2: ( ( (lv_val_0_0= ruleAssign ) ) | ( (lv_val_1_0= ruleStringLiteral ) ) | ( (lv_val_2_0= ruleGroup ) ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt13=1;
                }
                break;
            case RULE_STRING:
                {
                alt13=2;
                }
                break;
            case LeftParenthesis:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalMyDslParser.g:883:3: ( (lv_val_0_0= ruleAssign ) )
                    {
                    // InternalMyDslParser.g:883:3: ( (lv_val_0_0= ruleAssign ) )
                    // InternalMyDslParser.g:884:4: (lv_val_0_0= ruleAssign )
                    {
                    // InternalMyDslParser.g:884:4: (lv_val_0_0= ruleAssign )
                    // InternalMyDslParser.g:885:5: lv_val_0_0= ruleAssign
                    {

                    					newCompositeNode(grammarAccess.getElementAccess().getValAssignParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_val_0_0=ruleAssign();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getElementRule());
                    					}
                    					set(
                    						current,
                    						"val",
                    						lv_val_0_0,
                    						"org.xtext.example.mydsl.MyDsl.Assign");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyDslParser.g:903:3: ( (lv_val_1_0= ruleStringLiteral ) )
                    {
                    // InternalMyDslParser.g:903:3: ( (lv_val_1_0= ruleStringLiteral ) )
                    // InternalMyDslParser.g:904:4: (lv_val_1_0= ruleStringLiteral )
                    {
                    // InternalMyDslParser.g:904:4: (lv_val_1_0= ruleStringLiteral )
                    // InternalMyDslParser.g:905:5: lv_val_1_0= ruleStringLiteral
                    {

                    					newCompositeNode(grammarAccess.getElementAccess().getValStringLiteralParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_val_1_0=ruleStringLiteral();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getElementRule());
                    					}
                    					set(
                    						current,
                    						"val",
                    						lv_val_1_0,
                    						"org.xtext.example.mydsl.MyDsl.StringLiteral");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyDslParser.g:923:3: ( (lv_val_2_0= ruleGroup ) )
                    {
                    // InternalMyDslParser.g:923:3: ( (lv_val_2_0= ruleGroup ) )
                    // InternalMyDslParser.g:924:4: (lv_val_2_0= ruleGroup )
                    {
                    // InternalMyDslParser.g:924:4: (lv_val_2_0= ruleGroup )
                    // InternalMyDslParser.g:925:5: lv_val_2_0= ruleGroup
                    {

                    					newCompositeNode(grammarAccess.getElementAccess().getValGroupParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_val_2_0=ruleGroup();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getElementRule());
                    					}
                    					set(
                    						current,
                    						"val",
                    						lv_val_2_0,
                    						"org.xtext.example.mydsl.MyDsl.Group");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleAssign"
    // InternalMyDslParser.g:946:1: entryRuleAssign returns [EObject current=null] : iv_ruleAssign= ruleAssign EOF ;
    public final EObject entryRuleAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssign = null;


        try {
            // InternalMyDslParser.g:946:47: (iv_ruleAssign= ruleAssign EOF )
            // InternalMyDslParser.g:947:2: iv_ruleAssign= ruleAssign EOF
            {
             newCompositeNode(grammarAccess.getAssignRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssign=ruleAssign();

            state._fsp--;

             current =iv_ruleAssign; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssign"


    // $ANTLR start "ruleAssign"
    // InternalMyDslParser.g:953:1: ruleAssign returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_op_1_0= EqualsSign ) ) | ( (lv_op_2_0= PlusSignEqualsSign ) ) | ( (lv_op_3_0= AsteriskEqualsSign ) ) ) ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleAssign() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_op_1_0=null;
        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMyDslParser.g:959:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_op_1_0= EqualsSign ) ) | ( (lv_op_2_0= PlusSignEqualsSign ) ) | ( (lv_op_3_0= AsteriskEqualsSign ) ) ) ( (otherlv_4= RULE_ID ) ) ) )
            // InternalMyDslParser.g:960:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_op_1_0= EqualsSign ) ) | ( (lv_op_2_0= PlusSignEqualsSign ) ) | ( (lv_op_3_0= AsteriskEqualsSign ) ) ) ( (otherlv_4= RULE_ID ) ) )
            {
            // InternalMyDslParser.g:960:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_op_1_0= EqualsSign ) ) | ( (lv_op_2_0= PlusSignEqualsSign ) ) | ( (lv_op_3_0= AsteriskEqualsSign ) ) ) ( (otherlv_4= RULE_ID ) ) )
            // InternalMyDslParser.g:961:3: ( (lv_name_0_0= RULE_ID ) ) ( ( (lv_op_1_0= EqualsSign ) ) | ( (lv_op_2_0= PlusSignEqualsSign ) ) | ( (lv_op_3_0= AsteriskEqualsSign ) ) ) ( (otherlv_4= RULE_ID ) )
            {
            // InternalMyDslParser.g:961:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMyDslParser.g:962:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMyDslParser.g:962:4: (lv_name_0_0= RULE_ID )
            // InternalMyDslParser.g:963:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(lv_name_0_0, grammarAccess.getAssignAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMyDslParser.g:979:3: ( ( (lv_op_1_0= EqualsSign ) ) | ( (lv_op_2_0= PlusSignEqualsSign ) ) | ( (lv_op_3_0= AsteriskEqualsSign ) ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case EqualsSign:
                {
                alt14=1;
                }
                break;
            case PlusSignEqualsSign:
                {
                alt14=2;
                }
                break;
            case AsteriskEqualsSign:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalMyDslParser.g:980:4: ( (lv_op_1_0= EqualsSign ) )
                    {
                    // InternalMyDslParser.g:980:4: ( (lv_op_1_0= EqualsSign ) )
                    // InternalMyDslParser.g:981:5: (lv_op_1_0= EqualsSign )
                    {
                    // InternalMyDslParser.g:981:5: (lv_op_1_0= EqualsSign )
                    // InternalMyDslParser.g:982:6: lv_op_1_0= EqualsSign
                    {
                    lv_op_1_0=(Token)match(input,EqualsSign,FOLLOW_4); 

                    						newLeafNode(lv_op_1_0, grammarAccess.getAssignAccess().getOpEqualsSignKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssignRule());
                    						}
                    						setWithLastConsumed(current, "op", lv_op_1_0, "=");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyDslParser.g:995:4: ( (lv_op_2_0= PlusSignEqualsSign ) )
                    {
                    // InternalMyDslParser.g:995:4: ( (lv_op_2_0= PlusSignEqualsSign ) )
                    // InternalMyDslParser.g:996:5: (lv_op_2_0= PlusSignEqualsSign )
                    {
                    // InternalMyDslParser.g:996:5: (lv_op_2_0= PlusSignEqualsSign )
                    // InternalMyDslParser.g:997:6: lv_op_2_0= PlusSignEqualsSign
                    {
                    lv_op_2_0=(Token)match(input,PlusSignEqualsSign,FOLLOW_4); 

                    						newLeafNode(lv_op_2_0, grammarAccess.getAssignAccess().getOpPlusSignEqualsSignKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssignRule());
                    						}
                    						setWithLastConsumed(current, "op", lv_op_2_0, "+=");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyDslParser.g:1010:4: ( (lv_op_3_0= AsteriskEqualsSign ) )
                    {
                    // InternalMyDslParser.g:1010:4: ( (lv_op_3_0= AsteriskEqualsSign ) )
                    // InternalMyDslParser.g:1011:5: (lv_op_3_0= AsteriskEqualsSign )
                    {
                    // InternalMyDslParser.g:1011:5: (lv_op_3_0= AsteriskEqualsSign )
                    // InternalMyDslParser.g:1012:6: lv_op_3_0= AsteriskEqualsSign
                    {
                    lv_op_3_0=(Token)match(input,AsteriskEqualsSign,FOLLOW_4); 

                    						newLeafNode(lv_op_3_0, grammarAccess.getAssignAccess().getOpAsteriskEqualsSignKeyword_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssignRule());
                    						}
                    						setWithLastConsumed(current, "op", lv_op_3_0, "*=");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDslParser.g:1025:3: ( (otherlv_4= RULE_ID ) )
            // InternalMyDslParser.g:1026:4: (otherlv_4= RULE_ID )
            {
            // InternalMyDslParser.g:1026:4: (otherlv_4= RULE_ID )
            // InternalMyDslParser.g:1027:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_4, grammarAccess.getAssignAccess().getValTokenDefinitionCrossReference_2_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssign"


    // $ANTLR start "entryRuleTokenDefinition"
    // InternalMyDslParser.g:1042:1: entryRuleTokenDefinition returns [EObject current=null] : iv_ruleTokenDefinition= ruleTokenDefinition EOF ;
    public final EObject entryRuleTokenDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTokenDefinition = null;


        try {
            // InternalMyDslParser.g:1042:56: (iv_ruleTokenDefinition= ruleTokenDefinition EOF )
            // InternalMyDslParser.g:1043:2: iv_ruleTokenDefinition= ruleTokenDefinition EOF
            {
             newCompositeNode(grammarAccess.getTokenDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTokenDefinition=ruleTokenDefinition();

            state._fsp--;

             current =iv_ruleTokenDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTokenDefinition"


    // $ANTLR start "ruleTokenDefinition"
    // InternalMyDslParser.g:1049:1: ruleTokenDefinition returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleTokenDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalMyDslParser.g:1055:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalMyDslParser.g:1056:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalMyDslParser.g:1056:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalMyDslParser.g:1057:3: (lv_name_0_0= RULE_ID )
            {
            // InternalMyDslParser.g:1057:3: (lv_name_0_0= RULE_ID )
            // InternalMyDslParser.g:1058:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getTokenDefinitionAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getTokenDefinitionRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTokenDefinition"


    // $ANTLR start "entryRuleFunction"
    // InternalMyDslParser.g:1077:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalMyDslParser.g:1077:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalMyDslParser.g:1078:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalMyDslParser.g:1084:1: ruleFunction returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalMyDslParser.g:1090:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalMyDslParser.g:1091:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalMyDslParser.g:1091:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalMyDslParser.g:1092:3: (lv_name_0_0= RULE_ID )
            {
            // InternalMyDslParser.g:1092:3: (lv_name_0_0= RULE_ID )
            // InternalMyDslParser.g:1093:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getFunctionRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleLayer"
    // InternalMyDslParser.g:1112:1: entryRuleLayer returns [EObject current=null] : iv_ruleLayer= ruleLayer EOF ;
    public final EObject entryRuleLayer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayer = null;


        try {
            // InternalMyDslParser.g:1112:46: (iv_ruleLayer= ruleLayer EOF )
            // InternalMyDslParser.g:1113:2: iv_ruleLayer= ruleLayer EOF
            {
             newCompositeNode(grammarAccess.getLayerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLayer=ruleLayer();

            state._fsp--;

             current =iv_ruleLayer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLayer"


    // $ANTLR start "ruleLayer"
    // InternalMyDslParser.g:1119:1: ruleLayer returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleLayer() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalMyDslParser.g:1125:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalMyDslParser.g:1126:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalMyDslParser.g:1126:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalMyDslParser.g:1127:3: (lv_name_0_0= RULE_ID )
            {
            // InternalMyDslParser.g:1127:3: (lv_name_0_0= RULE_ID )
            // InternalMyDslParser.g:1128:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getLayerAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getLayerRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLayer"


    // $ANTLR start "entryRuleRule"
    // InternalMyDslParser.g:1147:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalMyDslParser.g:1147:45: (iv_ruleRule= ruleRule EOF )
            // InternalMyDslParser.g:1148:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalMyDslParser.g:1154:1: ruleRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon this_BEGIN_2= RULE_BEGIN otherlv_3= When ( (lv_condition_4_0= ruleSeq ) ) otherlv_5= Then ( (lv_thenPart_6_0= ruleTransferModel ) ) otherlv_7= Example ( (lv_example_8_0= RULE_STRING ) ) (otherlv_9= Layer ( (otherlv_10= RULE_ID ) ) )? this_END_11= RULE_END ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token this_BEGIN_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_example_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token this_END_11=null;
        EObject lv_condition_4_0 = null;

        EObject lv_thenPart_6_0 = null;



        	enterRule();

        try {
            // InternalMyDslParser.g:1160:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon this_BEGIN_2= RULE_BEGIN otherlv_3= When ( (lv_condition_4_0= ruleSeq ) ) otherlv_5= Then ( (lv_thenPart_6_0= ruleTransferModel ) ) otherlv_7= Example ( (lv_example_8_0= RULE_STRING ) ) (otherlv_9= Layer ( (otherlv_10= RULE_ID ) ) )? this_END_11= RULE_END ) )
            // InternalMyDslParser.g:1161:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon this_BEGIN_2= RULE_BEGIN otherlv_3= When ( (lv_condition_4_0= ruleSeq ) ) otherlv_5= Then ( (lv_thenPart_6_0= ruleTransferModel ) ) otherlv_7= Example ( (lv_example_8_0= RULE_STRING ) ) (otherlv_9= Layer ( (otherlv_10= RULE_ID ) ) )? this_END_11= RULE_END )
            {
            // InternalMyDslParser.g:1161:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon this_BEGIN_2= RULE_BEGIN otherlv_3= When ( (lv_condition_4_0= ruleSeq ) ) otherlv_5= Then ( (lv_thenPart_6_0= ruleTransferModel ) ) otherlv_7= Example ( (lv_example_8_0= RULE_STRING ) ) (otherlv_9= Layer ( (otherlv_10= RULE_ID ) ) )? this_END_11= RULE_END )
            // InternalMyDslParser.g:1162:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon this_BEGIN_2= RULE_BEGIN otherlv_3= When ( (lv_condition_4_0= ruleSeq ) ) otherlv_5= Then ( (lv_thenPart_6_0= ruleTransferModel ) ) otherlv_7= Example ( (lv_example_8_0= RULE_STRING ) ) (otherlv_9= Layer ( (otherlv_10= RULE_ID ) ) )? this_END_11= RULE_END
            {
            // InternalMyDslParser.g:1162:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMyDslParser.g:1163:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMyDslParser.g:1163:4: (lv_name_0_0= RULE_ID )
            // InternalMyDslParser.g:1164:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_name_0_0, grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,Colon,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getRuleAccess().getColonKeyword_1());
            		
            this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_25); 

            			newLeafNode(this_BEGIN_2, grammarAccess.getRuleAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,When,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getRuleAccess().getWhenKeyword_3());
            		
            // InternalMyDslParser.g:1192:3: ( (lv_condition_4_0= ruleSeq ) )
            // InternalMyDslParser.g:1193:4: (lv_condition_4_0= ruleSeq )
            {
            // InternalMyDslParser.g:1193:4: (lv_condition_4_0= ruleSeq )
            // InternalMyDslParser.g:1194:5: lv_condition_4_0= ruleSeq
            {

            					newCompositeNode(grammarAccess.getRuleAccess().getConditionSeqParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_26);
            lv_condition_4_0=ruleSeq();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRuleRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_4_0,
            						"org.xtext.example.mydsl.MyDsl.Seq");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,Then,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getRuleAccess().getThenKeyword_5());
            		
            // InternalMyDslParser.g:1215:3: ( (lv_thenPart_6_0= ruleTransferModel ) )
            // InternalMyDslParser.g:1216:4: (lv_thenPart_6_0= ruleTransferModel )
            {
            // InternalMyDslParser.g:1216:4: (lv_thenPart_6_0= ruleTransferModel )
            // InternalMyDslParser.g:1217:5: lv_thenPart_6_0= ruleTransferModel
            {

            					newCompositeNode(grammarAccess.getRuleAccess().getThenPartTransferModelParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_27);
            lv_thenPart_6_0=ruleTransferModel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRuleRule());
            					}
            					set(
            						current,
            						"thenPart",
            						lv_thenPart_6_0,
            						"org.xtext.example.mydsl.MyDsl.TransferModel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,Example,FOLLOW_28); 

            			newLeafNode(otherlv_7, grammarAccess.getRuleAccess().getExampleKeyword_7());
            		
            // InternalMyDslParser.g:1238:3: ( (lv_example_8_0= RULE_STRING ) )
            // InternalMyDslParser.g:1239:4: (lv_example_8_0= RULE_STRING )
            {
            // InternalMyDslParser.g:1239:4: (lv_example_8_0= RULE_STRING )
            // InternalMyDslParser.g:1240:5: lv_example_8_0= RULE_STRING
            {
            lv_example_8_0=(Token)match(input,RULE_STRING,FOLLOW_29); 

            					newLeafNode(lv_example_8_0, grammarAccess.getRuleAccess().getExampleSTRINGTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"example",
            						lv_example_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalMyDslParser.g:1256:3: (otherlv_9= Layer ( (otherlv_10= RULE_ID ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==Layer) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMyDslParser.g:1257:4: otherlv_9= Layer ( (otherlv_10= RULE_ID ) )
                    {
                    otherlv_9=(Token)match(input,Layer,FOLLOW_4); 

                    				newLeafNode(otherlv_9, grammarAccess.getRuleAccess().getLayerKeyword_9_0());
                    			
                    // InternalMyDslParser.g:1261:4: ( (otherlv_10= RULE_ID ) )
                    // InternalMyDslParser.g:1262:5: (otherlv_10= RULE_ID )
                    {
                    // InternalMyDslParser.g:1262:5: (otherlv_10= RULE_ID )
                    // InternalMyDslParser.g:1263:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRuleRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_30); 

                    						newLeafNode(otherlv_10, grammarAccess.getRuleAccess().getLayerLayerCrossReference_9_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_11=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_11, grammarAccess.getRuleAccess().getENDTerminalRuleCall_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRule"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000001080000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000070010000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000070000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000070008002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000070008000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000460002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000072008000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000203000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000008000100L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000008000000L});

}