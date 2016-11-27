// $ANTLR 3.5.2 Script\\Framework\\ExpressionGrammar.g 2016-11-27 09:20:44

package ATSSG.Script.Framework;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class ExpressionGrammarParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "AND", "DIV", "EQ", "GT", 
		"GTE", "LPAREN", "LT", "LTE", "MULT", "NAME", "NE", "NOT", "NUMBER", "OR", 
		"RPAREN", "SUBT", "WS"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ExpressionGrammarParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExpressionGrammarParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return ExpressionGrammarParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Script\\Framework\\ExpressionGrammar.g"; }


	public static class booleanexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "booleanexpression"
	// Script\\Framework\\ExpressionGrammar.g:45:1: booleanexpression : andexpression ;
	public final ExpressionGrammarParser.booleanexpression_return booleanexpression() throws RecognitionException {
		ExpressionGrammarParser.booleanexpression_return retval = new ExpressionGrammarParser.booleanexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope andexpression1 =null;


		try {
			// Script\\Framework\\ExpressionGrammar.g:45:19: ( andexpression )
			// Script\\Framework\\ExpressionGrammar.g:45:21: andexpression
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_andexpression_in_booleanexpression265);
			andexpression1=andexpression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, andexpression1.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "booleanexpression"


	public static class numberexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "numberexpression"
	// Script\\Framework\\ExpressionGrammar.g:46:1: numberexpression : pmexpression ;
	public final ExpressionGrammarParser.numberexpression_return numberexpression() throws RecognitionException {
		ExpressionGrammarParser.numberexpression_return retval = new ExpressionGrammarParser.numberexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope pmexpression2 =null;


		try {
			// Script\\Framework\\ExpressionGrammar.g:46:18: ( pmexpression )
			// Script\\Framework\\ExpressionGrammar.g:46:20: pmexpression
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_pmexpression_in_numberexpression272);
			pmexpression2=pmexpression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression2.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "numberexpression"


	public static class andexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "andexpression"
	// Script\\Framework\\ExpressionGrammar.g:47:1: andexpression : orexpression ( AND ^ orexpression )* ;
	public final ExpressionGrammarParser.andexpression_return andexpression() throws RecognitionException {
		ExpressionGrammarParser.andexpression_return retval = new ExpressionGrammarParser.andexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AND4=null;
		ParserRuleReturnScope orexpression3 =null;
		ParserRuleReturnScope orexpression5 =null;

		Object AND4_tree=null;

		try {
			// Script\\Framework\\ExpressionGrammar.g:47:15: ( orexpression ( AND ^ orexpression )* )
			// Script\\Framework\\ExpressionGrammar.g:47:17: orexpression ( AND ^ orexpression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_orexpression_in_andexpression279);
			orexpression3=orexpression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, orexpression3.getTree());

			// Script\\Framework\\ExpressionGrammar.g:47:30: ( AND ^ orexpression )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==AND) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Script\\Framework\\ExpressionGrammar.g:47:31: AND ^ orexpression
					{
					AND4=(Token)match(input,AND,FOLLOW_AND_in_andexpression282); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND4_tree = (Object)adaptor.create(AND4);
					root_0 = (Object)adaptor.becomeRoot(AND4_tree, root_0);
					}

					pushFollow(FOLLOW_orexpression_in_andexpression285);
					orexpression5=orexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, orexpression5.getTree());

					}
					break;

				default :
					break loop1;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "andexpression"


	public static class orexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "orexpression"
	// Script\\Framework\\ExpressionGrammar.g:48:1: orexpression : ineqexpression ( OR ^ ineqexpression )* ;
	public final ExpressionGrammarParser.orexpression_return orexpression() throws RecognitionException {
		ExpressionGrammarParser.orexpression_return retval = new ExpressionGrammarParser.orexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OR7=null;
		ParserRuleReturnScope ineqexpression6 =null;
		ParserRuleReturnScope ineqexpression8 =null;

		Object OR7_tree=null;

		try {
			// Script\\Framework\\ExpressionGrammar.g:48:14: ( ineqexpression ( OR ^ ineqexpression )* )
			// Script\\Framework\\ExpressionGrammar.g:48:16: ineqexpression ( OR ^ ineqexpression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_ineqexpression_in_orexpression294);
			ineqexpression6=ineqexpression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, ineqexpression6.getTree());

			// Script\\Framework\\ExpressionGrammar.g:48:31: ( OR ^ ineqexpression )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==OR) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Script\\Framework\\ExpressionGrammar.g:48:32: OR ^ ineqexpression
					{
					OR7=(Token)match(input,OR,FOLLOW_OR_in_orexpression297); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OR7_tree = (Object)adaptor.create(OR7);
					root_0 = (Object)adaptor.becomeRoot(OR7_tree, root_0);
					}

					pushFollow(FOLLOW_ineqexpression_in_orexpression300);
					ineqexpression8=ineqexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ineqexpression8.getTree());

					}
					break;

				default :
					break loop2;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "orexpression"


	public static class ineqexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ineqexpression"
	// Script\\Framework\\ExpressionGrammar.g:49:1: ineqexpression : ( pmexpression compareop ^ pmexpression | notexpression );
	public final ExpressionGrammarParser.ineqexpression_return ineqexpression() throws RecognitionException {
		ExpressionGrammarParser.ineqexpression_return retval = new ExpressionGrammarParser.ineqexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope pmexpression9 =null;
		ParserRuleReturnScope compareop10 =null;
		ParserRuleReturnScope pmexpression11 =null;
		ParserRuleReturnScope notexpression12 =null;


		try {
			// Script\\Framework\\ExpressionGrammar.g:49:15: ( pmexpression compareop ^ pmexpression | notexpression )
			int alt3=2;
			switch ( input.LA(1) ) {
			case NUMBER:
			case SUBT:
				{
				alt3=1;
				}
				break;
			case NAME:
				{
				int LA3_2 = input.LA(2);
				if ( (synpred3_ExpressionGrammar()) ) {
					alt3=1;
				}
				else if ( (true) ) {
					alt3=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA3_4 = input.LA(2);
				if ( (synpred3_ExpressionGrammar()) ) {
					alt3=1;
				}
				else if ( (true) ) {
					alt3=2;
				}

				}
				break;
			case NOT:
				{
				alt3=2;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// Script\\Framework\\ExpressionGrammar.g:49:17: pmexpression compareop ^ pmexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pmexpression_in_ineqexpression308);
					pmexpression9=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression9.getTree());

					pushFollow(FOLLOW_compareop_in_ineqexpression310);
					compareop10=compareop();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(compareop10.getTree(), root_0);
					pushFollow(FOLLOW_pmexpression_in_ineqexpression313);
					pmexpression11=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression11.getTree());

					}
					break;
				case 2 :
					// Script\\Framework\\ExpressionGrammar.g:49:56: notexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_notexpression_in_ineqexpression317);
					notexpression12=notexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, notexpression12.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ineqexpression"


	public static class notexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "notexpression"
	// Script\\Framework\\ExpressionGrammar.g:50:1: notexpression : ( NOT ^ booleanatom | booleanatom );
	public final ExpressionGrammarParser.notexpression_return notexpression() throws RecognitionException {
		ExpressionGrammarParser.notexpression_return retval = new ExpressionGrammarParser.notexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NOT13=null;
		ParserRuleReturnScope booleanatom14 =null;
		ParserRuleReturnScope booleanatom15 =null;

		Object NOT13_tree=null;

		try {
			// Script\\Framework\\ExpressionGrammar.g:50:15: ( NOT ^ booleanatom | booleanatom )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==NOT) ) {
				alt4=1;
			}
			else if ( (LA4_0==LPAREN||LA4_0==NAME) ) {
				alt4=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// Script\\Framework\\ExpressionGrammar.g:50:17: NOT ^ booleanatom
					{
					root_0 = (Object)adaptor.nil();


					NOT13=(Token)match(input,NOT,FOLLOW_NOT_in_notexpression324); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOT13_tree = (Object)adaptor.create(NOT13);
					root_0 = (Object)adaptor.becomeRoot(NOT13_tree, root_0);
					}

					pushFollow(FOLLOW_booleanatom_in_notexpression327);
					booleanatom14=booleanatom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, booleanatom14.getTree());

					}
					break;
				case 2 :
					// Script\\Framework\\ExpressionGrammar.g:50:36: booleanatom
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_booleanatom_in_notexpression331);
					booleanatom15=booleanatom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, booleanatom15.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "notexpression"


	public static class booleanatom_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "booleanatom"
	// Script\\Framework\\ExpressionGrammar.g:51:1: booleanatom : ( NAME | LPAREN ! andexpression RPAREN !);
	public final ExpressionGrammarParser.booleanatom_return booleanatom() throws RecognitionException {
		ExpressionGrammarParser.booleanatom_return retval = new ExpressionGrammarParser.booleanatom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME16=null;
		Token LPAREN17=null;
		Token RPAREN19=null;
		ParserRuleReturnScope andexpression18 =null;

		Object NAME16_tree=null;
		Object LPAREN17_tree=null;
		Object RPAREN19_tree=null;

		try {
			// Script\\Framework\\ExpressionGrammar.g:51:13: ( NAME | LPAREN ! andexpression RPAREN !)
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==NAME) ) {
				alt5=1;
			}
			else if ( (LA5_0==LPAREN) ) {
				alt5=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// Script\\Framework\\ExpressionGrammar.g:51:16: NAME
					{
					root_0 = (Object)adaptor.nil();


					NAME16=(Token)match(input,NAME,FOLLOW_NAME_in_booleanatom339); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME16_tree = (Object)adaptor.create(NAME16);
					adaptor.addChild(root_0, NAME16_tree);
					}

					}
					break;
				case 2 :
					// Script\\Framework\\ExpressionGrammar.g:51:23: LPAREN ! andexpression RPAREN !
					{
					root_0 = (Object)adaptor.nil();


					LPAREN17=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_booleanatom343); if (state.failed) return retval;
					pushFollow(FOLLOW_andexpression_in_booleanatom346);
					andexpression18=andexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, andexpression18.getTree());

					RPAREN19=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_booleanatom348); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "booleanatom"


	public static class pmexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "pmexpression"
	// Script\\Framework\\ExpressionGrammar.g:52:1: pmexpression : mdexpression ( addsubtractop ^ mdexpression )* ;
	public final ExpressionGrammarParser.pmexpression_return pmexpression() throws RecognitionException {
		ExpressionGrammarParser.pmexpression_return retval = new ExpressionGrammarParser.pmexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope mdexpression20 =null;
		ParserRuleReturnScope addsubtractop21 =null;
		ParserRuleReturnScope mdexpression22 =null;


		try {
			// Script\\Framework\\ExpressionGrammar.g:52:14: ( mdexpression ( addsubtractop ^ mdexpression )* )
			// Script\\Framework\\ExpressionGrammar.g:52:16: mdexpression ( addsubtractop ^ mdexpression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_mdexpression_in_pmexpression356);
			mdexpression20=mdexpression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, mdexpression20.getTree());

			// Script\\Framework\\ExpressionGrammar.g:52:29: ( addsubtractop ^ mdexpression )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==ADD||LA6_0==SUBT) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// Script\\Framework\\ExpressionGrammar.g:52:30: addsubtractop ^ mdexpression
					{
					pushFollow(FOLLOW_addsubtractop_in_pmexpression359);
					addsubtractop21=addsubtractop();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(addsubtractop21.getTree(), root_0);
					pushFollow(FOLLOW_mdexpression_in_pmexpression362);
					mdexpression22=mdexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mdexpression22.getTree());

					}
					break;

				default :
					break loop6;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "pmexpression"


	public static class mdexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mdexpression"
	// Script\\Framework\\ExpressionGrammar.g:53:1: mdexpression : negative ( multdivop ^ negative )* ;
	public final ExpressionGrammarParser.mdexpression_return mdexpression() throws RecognitionException {
		ExpressionGrammarParser.mdexpression_return retval = new ExpressionGrammarParser.mdexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope negative23 =null;
		ParserRuleReturnScope multdivop24 =null;
		ParserRuleReturnScope negative25 =null;


		try {
			// Script\\Framework\\ExpressionGrammar.g:53:14: ( negative ( multdivop ^ negative )* )
			// Script\\Framework\\ExpressionGrammar.g:53:16: negative ( multdivop ^ negative )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_negative_in_mdexpression371);
			negative23=negative();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, negative23.getTree());

			// Script\\Framework\\ExpressionGrammar.g:53:25: ( multdivop ^ negative )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==DIV||LA7_0==MULT) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// Script\\Framework\\ExpressionGrammar.g:53:26: multdivop ^ negative
					{
					pushFollow(FOLLOW_multdivop_in_mdexpression374);
					multdivop24=multdivop();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(multdivop24.getTree(), root_0);
					pushFollow(FOLLOW_negative_in_mdexpression377);
					negative25=negative();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, negative25.getTree());

					}
					break;

				default :
					break loop7;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "mdexpression"


	public static class negative_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "negative"
	// Script\\Framework\\ExpressionGrammar.g:54:1: negative : ( SUBT ^ numberatom | numberatom );
	public final ExpressionGrammarParser.negative_return negative() throws RecognitionException {
		ExpressionGrammarParser.negative_return retval = new ExpressionGrammarParser.negative_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SUBT26=null;
		ParserRuleReturnScope numberatom27 =null;
		ParserRuleReturnScope numberatom28 =null;

		Object SUBT26_tree=null;

		try {
			// Script\\Framework\\ExpressionGrammar.g:54:10: ( SUBT ^ numberatom | numberatom )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==SUBT) ) {
				alt8=1;
			}
			else if ( (LA8_0==LPAREN||LA8_0==NAME||LA8_0==NUMBER) ) {
				alt8=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// Script\\Framework\\ExpressionGrammar.g:54:12: SUBT ^ numberatom
					{
					root_0 = (Object)adaptor.nil();


					SUBT26=(Token)match(input,SUBT,FOLLOW_SUBT_in_negative386); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SUBT26_tree = (Object)adaptor.create(SUBT26);
					root_0 = (Object)adaptor.becomeRoot(SUBT26_tree, root_0);
					}

					pushFollow(FOLLOW_numberatom_in_negative389);
					numberatom27=numberatom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numberatom27.getTree());

					}
					break;
				case 2 :
					// Script\\Framework\\ExpressionGrammar.g:54:31: numberatom
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_numberatom_in_negative393);
					numberatom28=numberatom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numberatom28.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "negative"


	public static class numberatom_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "numberatom"
	// Script\\Framework\\ExpressionGrammar.g:55:1: numberatom : ( NAME | NUMBER | LPAREN ! pmexpression RPAREN !);
	public final ExpressionGrammarParser.numberatom_return numberatom() throws RecognitionException {
		ExpressionGrammarParser.numberatom_return retval = new ExpressionGrammarParser.numberatom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME29=null;
		Token NUMBER30=null;
		Token LPAREN31=null;
		Token RPAREN33=null;
		ParserRuleReturnScope pmexpression32 =null;

		Object NAME29_tree=null;
		Object NUMBER30_tree=null;
		Object LPAREN31_tree=null;
		Object RPAREN33_tree=null;

		try {
			// Script\\Framework\\ExpressionGrammar.g:55:12: ( NAME | NUMBER | LPAREN ! pmexpression RPAREN !)
			int alt9=3;
			switch ( input.LA(1) ) {
			case NAME:
				{
				alt9=1;
				}
				break;
			case NUMBER:
				{
				alt9=2;
				}
				break;
			case LPAREN:
				{
				alt9=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// Script\\Framework\\ExpressionGrammar.g:55:14: NAME
					{
					root_0 = (Object)adaptor.nil();


					NAME29=(Token)match(input,NAME,FOLLOW_NAME_in_numberatom400); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME29_tree = (Object)adaptor.create(NAME29);
					adaptor.addChild(root_0, NAME29_tree);
					}

					}
					break;
				case 2 :
					// Script\\Framework\\ExpressionGrammar.g:55:21: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER30=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberatom404); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER30_tree = (Object)adaptor.create(NUMBER30);
					adaptor.addChild(root_0, NUMBER30_tree);
					}

					}
					break;
				case 3 :
					// Script\\Framework\\ExpressionGrammar.g:55:30: LPAREN ! pmexpression RPAREN !
					{
					root_0 = (Object)adaptor.nil();


					LPAREN31=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_numberatom408); if (state.failed) return retval;
					pushFollow(FOLLOW_pmexpression_in_numberatom411);
					pmexpression32=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression32.getTree());

					RPAREN33=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_numberatom413); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "numberatom"


	public static class addsubtractop_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "addsubtractop"
	// Script\\Framework\\ExpressionGrammar.g:58:1: addsubtractop : ( ADD | SUBT );
	public final ExpressionGrammarParser.addsubtractop_return addsubtractop() throws RecognitionException {
		ExpressionGrammarParser.addsubtractop_return retval = new ExpressionGrammarParser.addsubtractop_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set34=null;

		Object set34_tree=null;

		try {
			// Script\\Framework\\ExpressionGrammar.g:58:14: ( ADD | SUBT )
			// Script\\Framework\\ExpressionGrammar.g:
			{
			root_0 = (Object)adaptor.nil();


			set34=input.LT(1);
			if ( input.LA(1)==ADD||input.LA(1)==SUBT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set34));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "addsubtractop"


	public static class multdivop_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "multdivop"
	// Script\\Framework\\ExpressionGrammar.g:59:1: multdivop : ( MULT | DIV );
	public final ExpressionGrammarParser.multdivop_return multdivop() throws RecognitionException {
		ExpressionGrammarParser.multdivop_return retval = new ExpressionGrammarParser.multdivop_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set35=null;

		Object set35_tree=null;

		try {
			// Script\\Framework\\ExpressionGrammar.g:59:10: ( MULT | DIV )
			// Script\\Framework\\ExpressionGrammar.g:
			{
			root_0 = (Object)adaptor.nil();


			set35=input.LT(1);
			if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set35));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "multdivop"


	public static class compareop_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "compareop"
	// Script\\Framework\\ExpressionGrammar.g:60:1: compareop : ( EQ | LT | LTE | GT | GTE | NE );
	public final ExpressionGrammarParser.compareop_return compareop() throws RecognitionException {
		ExpressionGrammarParser.compareop_return retval = new ExpressionGrammarParser.compareop_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set36=null;

		Object set36_tree=null;

		try {
			// Script\\Framework\\ExpressionGrammar.g:60:11: ( EQ | LT | LTE | GT | GTE | NE )
			// Script\\Framework\\ExpressionGrammar.g:
			{
			root_0 = (Object)adaptor.nil();


			set36=input.LT(1);
			if ( (input.LA(1) >= EQ && input.LA(1) <= GTE)||(input.LA(1) >= LT && input.LA(1) <= LTE)||input.LA(1)==NE ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set36));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "compareop"

	// $ANTLR start synpred3_ExpressionGrammar
	public final void synpred3_ExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\ExpressionGrammar.g:49:17: ( pmexpression compareop pmexpression )
		// Script\\Framework\\ExpressionGrammar.g:49:17: pmexpression compareop pmexpression
		{
		pushFollow(FOLLOW_pmexpression_in_synpred3_ExpressionGrammar308);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_compareop_in_synpred3_ExpressionGrammar310);
		compareop();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_pmexpression_in_synpred3_ExpressionGrammar313);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred3_ExpressionGrammar

	// Delegated rules

	public final boolean synpred3_ExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_ExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_andexpression_in_booleanexpression265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_numberexpression272 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orexpression_in_andexpression279 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_AND_in_andexpression282 = new BitSet(new long[]{0x0000000000134400L});
	public static final BitSet FOLLOW_orexpression_in_andexpression285 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_ineqexpression_in_orexpression294 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_OR_in_orexpression297 = new BitSet(new long[]{0x0000000000134400L});
	public static final BitSet FOLLOW_ineqexpression_in_orexpression300 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression308 = new BitSet(new long[]{0x0000000000009B80L});
	public static final BitSet FOLLOW_compareop_in_ineqexpression310 = new BitSet(new long[]{0x0000000000124400L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression313 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notexpression_in_ineqexpression317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_notexpression324 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_booleanatom_in_notexpression327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_booleanatom_in_notexpression331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_booleanatom339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_booleanatom343 = new BitSet(new long[]{0x0000000000134400L});
	public static final BitSet FOLLOW_andexpression_in_booleanatom346 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_RPAREN_in_booleanatom348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mdexpression_in_pmexpression356 = new BitSet(new long[]{0x0000000000100012L});
	public static final BitSet FOLLOW_addsubtractop_in_pmexpression359 = new BitSet(new long[]{0x0000000000124400L});
	public static final BitSet FOLLOW_mdexpression_in_pmexpression362 = new BitSet(new long[]{0x0000000000100012L});
	public static final BitSet FOLLOW_negative_in_mdexpression371 = new BitSet(new long[]{0x0000000000002042L});
	public static final BitSet FOLLOW_multdivop_in_mdexpression374 = new BitSet(new long[]{0x0000000000124400L});
	public static final BitSet FOLLOW_negative_in_mdexpression377 = new BitSet(new long[]{0x0000000000002042L});
	public static final BitSet FOLLOW_SUBT_in_negative386 = new BitSet(new long[]{0x0000000000024400L});
	public static final BitSet FOLLOW_numberatom_in_negative389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberatom_in_negative393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_numberatom400 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_numberatom404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_numberatom408 = new BitSet(new long[]{0x0000000000124400L});
	public static final BitSet FOLLOW_pmexpression_in_numberatom411 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_RPAREN_in_numberatom413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_synpred3_ExpressionGrammar308 = new BitSet(new long[]{0x0000000000009B80L});
	public static final BitSet FOLLOW_compareop_in_synpred3_ExpressionGrammar310 = new BitSet(new long[]{0x0000000000124400L});
	public static final BitSet FOLLOW_pmexpression_in_synpred3_ExpressionGrammar313 = new BitSet(new long[]{0x0000000000000002L});
}
