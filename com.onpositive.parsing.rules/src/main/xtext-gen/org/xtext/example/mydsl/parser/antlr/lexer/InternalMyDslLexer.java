package org.xtext.example.mydsl.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslLexer extends Lexer {
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

    public InternalMyDslLexer() {;} 
    public InternalMyDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalMyDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalMyDslLexer.g"; }

    // $ANTLR start "Functions"
    public final void mFunctions() throws RecognitionException {
        try {
            int _type = Functions;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:14:11: ( 'functions:' )
            // InternalMyDslLexer.g:14:13: 'functions:'
            {
            match("functions:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Functions"

    // $ANTLR start "Classes"
    public final void mClasses() throws RecognitionException {
        try {
            int _type = Classes;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:16:9: ( 'classes:' )
            // InternalMyDslLexer.g:16:11: 'classes:'
            {
            match("classes:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Classes"

    // $ANTLR start "Example"
    public final void mExample() throws RecognitionException {
        try {
            int _type = Example;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:18:9: ( 'example:' )
            // InternalMyDslLexer.g:18:11: 'example:'
            {
            match("example:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Example"

    // $ANTLR start "Layers"
    public final void mLayers() throws RecognitionException {
        try {
            int _type = Layers;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:20:8: ( 'layers:' )
            // InternalMyDslLexer.g:20:10: 'layers:'
            {
            match("layers:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Layers"

    // $ANTLR start "Layer"
    public final void mLayer() throws RecognitionException {
        try {
            int _type = Layer;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:22:7: ( 'layer:' )
            // InternalMyDslLexer.g:22:9: 'layer:'
            {
            match("layer:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Layer"

    // $ANTLR start "Rules"
    public final void mRules() throws RecognitionException {
        try {
            int _type = Rules;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:24:7: ( 'rules:' )
            // InternalMyDslLexer.g:24:9: 'rules:'
            {
            match("rules:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Rules"

    // $ANTLR start "Then"
    public final void mThen() throws RecognitionException {
        try {
            int _type = Then;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:26:6: ( 'then:' )
            // InternalMyDslLexer.g:26:8: 'then:'
            {
            match("then:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Then"

    // $ANTLR start "When"
    public final void mWhen() throws RecognitionException {
        try {
            int _type = When;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:28:6: ( 'when:' )
            // InternalMyDslLexer.g:28:8: 'when:'
            {
            match("when:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "When"

    // $ANTLR start "AsteriskEqualsSign"
    public final void mAsteriskEqualsSign() throws RecognitionException {
        try {
            int _type = AsteriskEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:30:20: ( '*=' )
            // InternalMyDslLexer.g:30:22: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AsteriskEqualsSign"

    // $ANTLR start "PlusSignEqualsSign"
    public final void mPlusSignEqualsSign() throws RecognitionException {
        try {
            int _type = PlusSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:32:20: ( '+=' )
            // InternalMyDslLexer.g:32:22: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSignEqualsSign"

    // $ANTLR start "EqualsSignGreaterThanSign"
    public final void mEqualsSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = EqualsSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:34:27: ( '=>' )
            // InternalMyDslLexer.g:34:29: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSignGreaterThanSign"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:36:17: ( '(' )
            // InternalMyDslLexer.g:36:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:38:18: ( ')' )
            // InternalMyDslLexer.g:38:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "Asterisk"
    public final void mAsterisk() throws RecognitionException {
        try {
            int _type = Asterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:40:10: ( '*' )
            // InternalMyDslLexer.g:40:12: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Asterisk"

    // $ANTLR start "PlusSign"
    public final void mPlusSign() throws RecognitionException {
        try {
            int _type = PlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:42:10: ( '+' )
            // InternalMyDslLexer.g:42:12: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSign"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:44:7: ( ',' )
            // InternalMyDslLexer.g:44:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:46:7: ( ':' )
            // InternalMyDslLexer.g:46:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "EqualsSign"
    public final void mEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:48:12: ( '=' )
            // InternalMyDslLexer.g:48:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSign"

    // $ANTLR start "QuestionMark"
    public final void mQuestionMark() throws RecognitionException {
        try {
            int _type = QuestionMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:50:14: ( '?' )
            // InternalMyDslLexer.g:50:16: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QuestionMark"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:52:19: ( '[' )
            // InternalMyDslLexer.g:52:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:54:20: ( ']' )
            // InternalMyDslLexer.g:54:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "VerticalLine"
    public final void mVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:56:14: ( '|' )
            // InternalMyDslLexer.g:56:16: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLine"

    // $ANTLR start "RULE_BEGIN"
    public final void mRULE_BEGIN() throws RecognitionException {
        try {
            // InternalMyDslLexer.g:60:21: ()
            // InternalMyDslLexer.g:60:23: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BEGIN"

    // $ANTLR start "RULE_END"
    public final void mRULE_END() throws RecognitionException {
        try {
            // InternalMyDslLexer.g:62:19: ()
            // InternalMyDslLexer.g:62:21: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_END"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:64:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalMyDslLexer.g:64:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalMyDslLexer.g:64:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalMyDslLexer.g:64:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalMyDslLexer.g:64:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMyDslLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:66:10: ( ( '0' .. '9' )+ )
            // InternalMyDslLexer.g:66:12: ( '0' .. '9' )+
            {
            // InternalMyDslLexer.g:66:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMyDslLexer.g:66:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:68:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalMyDslLexer.g:68:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalMyDslLexer.g:68:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalMyDslLexer.g:68:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalMyDslLexer.g:68:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalMyDslLexer.g:68:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalMyDslLexer.g:68:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalMyDslLexer.g:68:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalMyDslLexer.g:68:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalMyDslLexer.g:68:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalMyDslLexer.g:68:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:70:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalMyDslLexer.g:70:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalMyDslLexer.g:70:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMyDslLexer.g:70:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:72:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalMyDslLexer.g:72:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalMyDslLexer.g:72:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMyDslLexer.g:72:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalMyDslLexer.g:72:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMyDslLexer.g:72:41: ( '\\r' )? '\\n'
                    {
                    // InternalMyDslLexer.g:72:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalMyDslLexer.g:72:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:74:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalMyDslLexer.g:74:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalMyDslLexer.g:74:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMyDslLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMyDslLexer.g:76:16: ( . )
            // InternalMyDslLexer.g:76:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalMyDslLexer.g:1:8: ( Functions | Classes | Example | Layers | Layer | Rules | Then | When | AsteriskEqualsSign | PlusSignEqualsSign | EqualsSignGreaterThanSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | Colon | EqualsSign | QuestionMark | LeftSquareBracket | RightSquareBracket | VerticalLine | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=29;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalMyDslLexer.g:1:10: Functions
                {
                mFunctions(); 

                }
                break;
            case 2 :
                // InternalMyDslLexer.g:1:20: Classes
                {
                mClasses(); 

                }
                break;
            case 3 :
                // InternalMyDslLexer.g:1:28: Example
                {
                mExample(); 

                }
                break;
            case 4 :
                // InternalMyDslLexer.g:1:36: Layers
                {
                mLayers(); 

                }
                break;
            case 5 :
                // InternalMyDslLexer.g:1:43: Layer
                {
                mLayer(); 

                }
                break;
            case 6 :
                // InternalMyDslLexer.g:1:49: Rules
                {
                mRules(); 

                }
                break;
            case 7 :
                // InternalMyDslLexer.g:1:55: Then
                {
                mThen(); 

                }
                break;
            case 8 :
                // InternalMyDslLexer.g:1:60: When
                {
                mWhen(); 

                }
                break;
            case 9 :
                // InternalMyDslLexer.g:1:65: AsteriskEqualsSign
                {
                mAsteriskEqualsSign(); 

                }
                break;
            case 10 :
                // InternalMyDslLexer.g:1:84: PlusSignEqualsSign
                {
                mPlusSignEqualsSign(); 

                }
                break;
            case 11 :
                // InternalMyDslLexer.g:1:103: EqualsSignGreaterThanSign
                {
                mEqualsSignGreaterThanSign(); 

                }
                break;
            case 12 :
                // InternalMyDslLexer.g:1:129: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 13 :
                // InternalMyDslLexer.g:1:145: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 14 :
                // InternalMyDslLexer.g:1:162: Asterisk
                {
                mAsterisk(); 

                }
                break;
            case 15 :
                // InternalMyDslLexer.g:1:171: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 16 :
                // InternalMyDslLexer.g:1:180: Comma
                {
                mComma(); 

                }
                break;
            case 17 :
                // InternalMyDslLexer.g:1:186: Colon
                {
                mColon(); 

                }
                break;
            case 18 :
                // InternalMyDslLexer.g:1:192: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 19 :
                // InternalMyDslLexer.g:1:203: QuestionMark
                {
                mQuestionMark(); 

                }
                break;
            case 20 :
                // InternalMyDslLexer.g:1:216: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 21 :
                // InternalMyDslLexer.g:1:234: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 22 :
                // InternalMyDslLexer.g:1:253: VerticalLine
                {
                mVerticalLine(); 

                }
                break;
            case 23 :
                // InternalMyDslLexer.g:1:266: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 24 :
                // InternalMyDslLexer.g:1:274: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 25 :
                // InternalMyDslLexer.g:1:283: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 26 :
                // InternalMyDslLexer.g:1:295: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 27 :
                // InternalMyDslLexer.g:1:311: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 28 :
                // InternalMyDslLexer.g:1:327: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 29 :
                // InternalMyDslLexer.g:1:335: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\7\34\1\44\1\46\1\50\10\uffff\1\32\2\uffff\3\32\2\uffff\1\34\1\uffff\6\34\23\uffff\23\34\2\uffff\4\34\2\uffff\3\34\1\uffff\1\34\2\uffff\1\34\1\uffff";
    static final String DFA12_eofS =
        "\132\uffff";
    static final String DFA12_minS =
        "\1\0\1\165\1\154\1\170\1\141\1\165\2\150\2\75\1\76\10\uffff\1\101\2\uffff\2\0\1\52\2\uffff\1\156\1\uffff\2\141\1\171\1\154\2\145\23\uffff\1\143\1\163\1\155\2\145\2\156\1\164\1\163\1\160\1\162\1\163\2\72\1\151\1\145\1\154\2\72\2\uffff\1\157\1\163\1\145\1\72\2\uffff\1\156\2\72\1\uffff\1\163\2\uffff\1\72\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\165\1\154\1\170\1\141\1\165\2\150\2\75\1\76\10\uffff\1\172\2\uffff\2\uffff\1\57\2\uffff\1\156\1\uffff\2\141\1\171\1\154\2\145\23\uffff\1\143\1\163\1\155\2\145\2\156\1\164\1\163\1\160\1\162\1\163\2\72\1\151\1\145\1\154\1\163\1\72\2\uffff\1\157\1\163\1\145\1\72\2\uffff\1\156\2\72\1\uffff\1\163\2\uffff\1\72\1\uffff";
    static final String DFA12_acceptS =
        "\13\uffff\1\14\1\15\1\20\1\21\1\23\1\24\1\25\1\26\1\uffff\1\27\1\30\3\uffff\1\34\1\35\1\uffff\1\27\6\uffff\1\11\1\16\1\12\1\17\1\13\1\22\1\14\1\15\1\20\1\21\1\23\1\24\1\25\1\26\1\30\1\31\1\32\1\33\1\34\23\uffff\1\7\1\10\4\uffff\1\5\1\6\3\uffff\1\4\1\uffff\1\2\1\3\1\uffff\1\1";
    static final String DFA12_specialS =
        "\1\2\25\uffff\1\0\1\1\102\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\32\2\31\2\32\1\31\22\32\1\31\1\32\1\26\4\32\1\27\1\13\1\14\1\10\1\11\1\15\2\32\1\30\12\25\1\16\2\32\1\12\1\32\1\17\1\32\32\24\1\20\1\32\1\21\1\23\1\24\1\32\2\24\1\2\1\24\1\3\1\1\5\24\1\4\5\24\1\5\1\24\1\6\2\24\1\7\3\24\1\32\1\22\uff83\32",
            "\1\33",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\45",
            "\1\47",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "\0\62",
            "\0\62",
            "\1\63\4\uffff\1\64",
            "",
            "",
            "\1\66",
            "",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\117\70\uffff\1\116",
            "\1\120",
            "",
            "",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "",
            "",
            "\1\125",
            "\1\126",
            "\1\127",
            "",
            "\1\130",
            "",
            "",
            "\1\131",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Functions | Classes | Example | Layers | Layer | Rules | Then | When | AsteriskEqualsSign | PlusSignEqualsSign | EqualsSignGreaterThanSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | Colon | EqualsSign | QuestionMark | LeftSquareBracket | RightSquareBracket | VerticalLine | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_22 = input.LA(1);

                        s = -1;
                        if ( ((LA12_22>='\u0000' && LA12_22<='\uFFFF')) ) {s = 50;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_23 = input.LA(1);

                        s = -1;
                        if ( ((LA12_23>='\u0000' && LA12_23<='\uFFFF')) ) {s = 50;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='f') ) {s = 1;}

                        else if ( (LA12_0=='c') ) {s = 2;}

                        else if ( (LA12_0=='e') ) {s = 3;}

                        else if ( (LA12_0=='l') ) {s = 4;}

                        else if ( (LA12_0=='r') ) {s = 5;}

                        else if ( (LA12_0=='t') ) {s = 6;}

                        else if ( (LA12_0=='w') ) {s = 7;}

                        else if ( (LA12_0=='*') ) {s = 8;}

                        else if ( (LA12_0=='+') ) {s = 9;}

                        else if ( (LA12_0=='=') ) {s = 10;}

                        else if ( (LA12_0=='(') ) {s = 11;}

                        else if ( (LA12_0==')') ) {s = 12;}

                        else if ( (LA12_0==',') ) {s = 13;}

                        else if ( (LA12_0==':') ) {s = 14;}

                        else if ( (LA12_0=='?') ) {s = 15;}

                        else if ( (LA12_0=='[') ) {s = 16;}

                        else if ( (LA12_0==']') ) {s = 17;}

                        else if ( (LA12_0=='|') ) {s = 18;}

                        else if ( (LA12_0=='^') ) {s = 19;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='b')||LA12_0=='d'||(LA12_0>='g' && LA12_0<='k')||(LA12_0>='m' && LA12_0<='q')||LA12_0=='s'||(LA12_0>='u' && LA12_0<='v')||(LA12_0>='x' && LA12_0<='z')) ) {s = 20;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 21;}

                        else if ( (LA12_0=='\"') ) {s = 22;}

                        else if ( (LA12_0=='\'') ) {s = 23;}

                        else if ( (LA12_0=='/') ) {s = 24;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 25;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='-' && LA12_0<='.')||(LA12_0>=';' && LA12_0<='<')||LA12_0=='>'||LA12_0=='@'||LA12_0=='\\'||LA12_0=='`'||LA12_0=='{'||(LA12_0>='}' && LA12_0<='\uFFFF')) ) {s = 26;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}