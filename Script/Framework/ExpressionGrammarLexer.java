// $ANTLR 3.5.2 Script\\Framework\\ExpressionGrammar.g 2016-11-27 09:20:44

package ATSSG.Script.Framework;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExpressionGrammarLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ADD=4;
	public static final int AND=5;
	public static final int DIV=6;
	public static final int EQ=7;
	public static final int GT=8;
	public static final int GTE=9;
	public static final int LPAREN=10;
	public static final int LT=11;
	public static final int LTE=12;
	public static final int MULT=13;
	public static final int NAME=14;
	public static final int NE=15;
	public static final int NOT=16;
	public static final int NUMBER=17;
	public static final int OR=18;
	public static final int RPAREN=19;
	public static final int SUBT=20;
	public static final int WS=21;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ExpressionGrammarLexer() {} 
	public ExpressionGrammarLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExpressionGrammarLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "Script\\Framework\\ExpressionGrammar.g"; }

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:24:8: ( '(' )
			// Script\\Framework\\ExpressionGrammar.g:24:10: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:25:8: ( ')' )
			// Script\\Framework\\ExpressionGrammar.g:25:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:26:5: ( '&&' )
			// Script\\Framework\\ExpressionGrammar.g:26:7: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:27:4: ( '||' )
			// Script\\Framework\\ExpressionGrammar.g:27:6: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:28:5: ( '!' )
			// Script\\Framework\\ExpressionGrammar.g:28:7: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "MULT"
	public final void mMULT() throws RecognitionException {
		try {
			int _type = MULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:29:5: ( '*' )
			// Script\\Framework\\ExpressionGrammar.g:29:7: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULT"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:30:4: ( '/' )
			// Script\\Framework\\ExpressionGrammar.g:30:6: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "ADD"
	public final void mADD() throws RecognitionException {
		try {
			int _type = ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:31:4: ( '+' )
			// Script\\Framework\\ExpressionGrammar.g:31:6: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD"

	// $ANTLR start "SUBT"
	public final void mSUBT() throws RecognitionException {
		try {
			int _type = SUBT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:32:5: ( '-' )
			// Script\\Framework\\ExpressionGrammar.g:32:7: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUBT"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:33:3: ( '==' )
			// Script\\Framework\\ExpressionGrammar.g:33:5: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "LT"
	public final void mLT() throws RecognitionException {
		try {
			int _type = LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:34:3: ( '<' )
			// Script\\Framework\\ExpressionGrammar.g:34:5: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LT"

	// $ANTLR start "LTE"
	public final void mLTE() throws RecognitionException {
		try {
			int _type = LTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:35:4: ( '<=' )
			// Script\\Framework\\ExpressionGrammar.g:35:6: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LTE"

	// $ANTLR start "GT"
	public final void mGT() throws RecognitionException {
		try {
			int _type = GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:36:3: ( '>' )
			// Script\\Framework\\ExpressionGrammar.g:36:5: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GT"

	// $ANTLR start "GTE"
	public final void mGTE() throws RecognitionException {
		try {
			int _type = GTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:37:4: ( '>=' )
			// Script\\Framework\\ExpressionGrammar.g:37:6: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GTE"

	// $ANTLR start "NE"
	public final void mNE() throws RecognitionException {
		try {
			int _type = NE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:38:3: ( '!=' )
			// Script\\Framework\\ExpressionGrammar.g:38:5: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NE"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:40:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )* )
			// Script\\Framework\\ExpressionGrammar.g:40:8: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// Script\\Framework\\ExpressionGrammar.g:40:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='$'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Script\\Framework\\ExpressionGrammar.g:
					{
					if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:41:8: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
			// Script\\Framework\\ExpressionGrammar.g:41:10: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
			{
			// Script\\Framework\\ExpressionGrammar.g:41:10: ( '0' .. '9' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Script\\Framework\\ExpressionGrammar.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			// Script\\Framework\\ExpressionGrammar.g:41:24: ( '.' ( '0' .. '9' )+ )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='.') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// Script\\Framework\\ExpressionGrammar.g:41:25: '.' ( '0' .. '9' )+
					{
					match('.'); 
					// Script\\Framework\\ExpressionGrammar.g:41:29: ( '0' .. '9' )+
					int cnt3=0;
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// Script\\Framework\\ExpressionGrammar.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt3 >= 1 ) break loop3;
							EarlyExitException eee = new EarlyExitException(3, input);
							throw eee;
						}
						cnt3++;
					}

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Script\\Framework\\ExpressionGrammar.g:42:4: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// Script\\Framework\\ExpressionGrammar.g:42:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// Script\\Framework\\ExpressionGrammar.g:42:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||LA5_0=='\r'||LA5_0==' ') ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// Script\\Framework\\ExpressionGrammar.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// Script\\Framework\\ExpressionGrammar.g:1:8: ( LPAREN | RPAREN | AND | OR | NOT | MULT | DIV | ADD | SUBT | EQ | LT | LTE | GT | GTE | NE | NAME | NUMBER | WS )
		int alt6=18;
		switch ( input.LA(1) ) {
		case '(':
			{
			alt6=1;
			}
			break;
		case ')':
			{
			alt6=2;
			}
			break;
		case '&':
			{
			alt6=3;
			}
			break;
		case '|':
			{
			alt6=4;
			}
			break;
		case '!':
			{
			int LA6_5 = input.LA(2);
			if ( (LA6_5=='=') ) {
				alt6=15;
			}

			else {
				alt6=5;
			}

			}
			break;
		case '*':
			{
			alt6=6;
			}
			break;
		case '/':
			{
			alt6=7;
			}
			break;
		case '+':
			{
			alt6=8;
			}
			break;
		case '-':
			{
			alt6=9;
			}
			break;
		case '=':
			{
			alt6=10;
			}
			break;
		case '<':
			{
			int LA6_11 = input.LA(2);
			if ( (LA6_11=='=') ) {
				alt6=12;
			}

			else {
				alt6=11;
			}

			}
			break;
		case '>':
			{
			int LA6_12 = input.LA(2);
			if ( (LA6_12=='=') ) {
				alt6=14;
			}

			else {
				alt6=13;
			}

			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt6=16;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt6=17;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt6=18;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 6, 0, input);
			throw nvae;
		}
		switch (alt6) {
			case 1 :
				// Script\\Framework\\ExpressionGrammar.g:1:10: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 2 :
				// Script\\Framework\\ExpressionGrammar.g:1:17: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 3 :
				// Script\\Framework\\ExpressionGrammar.g:1:24: AND
				{
				mAND(); 

				}
				break;
			case 4 :
				// Script\\Framework\\ExpressionGrammar.g:1:28: OR
				{
				mOR(); 

				}
				break;
			case 5 :
				// Script\\Framework\\ExpressionGrammar.g:1:31: NOT
				{
				mNOT(); 

				}
				break;
			case 6 :
				// Script\\Framework\\ExpressionGrammar.g:1:35: MULT
				{
				mMULT(); 

				}
				break;
			case 7 :
				// Script\\Framework\\ExpressionGrammar.g:1:40: DIV
				{
				mDIV(); 

				}
				break;
			case 8 :
				// Script\\Framework\\ExpressionGrammar.g:1:44: ADD
				{
				mADD(); 

				}
				break;
			case 9 :
				// Script\\Framework\\ExpressionGrammar.g:1:48: SUBT
				{
				mSUBT(); 

				}
				break;
			case 10 :
				// Script\\Framework\\ExpressionGrammar.g:1:53: EQ
				{
				mEQ(); 

				}
				break;
			case 11 :
				// Script\\Framework\\ExpressionGrammar.g:1:56: LT
				{
				mLT(); 

				}
				break;
			case 12 :
				// Script\\Framework\\ExpressionGrammar.g:1:59: LTE
				{
				mLTE(); 

				}
				break;
			case 13 :
				// Script\\Framework\\ExpressionGrammar.g:1:63: GT
				{
				mGT(); 

				}
				break;
			case 14 :
				// Script\\Framework\\ExpressionGrammar.g:1:66: GTE
				{
				mGTE(); 

				}
				break;
			case 15 :
				// Script\\Framework\\ExpressionGrammar.g:1:70: NE
				{
				mNE(); 

				}
				break;
			case 16 :
				// Script\\Framework\\ExpressionGrammar.g:1:73: NAME
				{
				mNAME(); 

				}
				break;
			case 17 :
				// Script\\Framework\\ExpressionGrammar.g:1:78: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 18 :
				// Script\\Framework\\ExpressionGrammar.g:1:85: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
