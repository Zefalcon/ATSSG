// $ANTLR 3.5.2 Script\\Framework\\BooleanExpressionGrammar.g 2016-11-26 23:41:25

package ATSSG.Script.Framework;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class BooleanExpressionGrammar extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "AND", "DIV", "EQ", "GT", 
		"GTE", "LPAREN", "LT", "LTE", "MULT", "NAME", "NE", "NOT", "OR", "RPAREN", 
		"SUBT", "WS"
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
	public static final int OR=17;
	public static final int RPAREN=18;
	public static final int SUBT=19;
	public static final int WS=20;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public BooleanExpressionGrammar(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public BooleanExpressionGrammar(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return BooleanExpressionGrammar.tokenNames; }
	@Override public String getGrammarFileName() { return "Script\\Framework\\BooleanExpressionGrammar.g"; }


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// Script\\Framework\\BooleanExpressionGrammar.g:22:1: expression : andexpression ;
	public final BooleanExpressionGrammar.expression_return expression() throws RecognitionException {
		BooleanExpressionGrammar.expression_return retval = new BooleanExpressionGrammar.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope andexpression1 =null;


		try {
			// Script\\Framework\\BooleanExpressionGrammar.g:22:12: ( andexpression )
			// Script\\Framework\\BooleanExpressionGrammar.g:22:14: andexpression
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_andexpression_in_expression72);
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
	// $ANTLR end "expression"


	public static class andexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "andexpression"
	// Script\\Framework\\BooleanExpressionGrammar.g:23:1: andexpression : ( orexpression AND ^ andexpression | orexpression );
	public final BooleanExpressionGrammar.andexpression_return andexpression() throws RecognitionException {
		BooleanExpressionGrammar.andexpression_return retval = new BooleanExpressionGrammar.andexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AND3=null;
		ParserRuleReturnScope orexpression2 =null;
		ParserRuleReturnScope andexpression4 =null;
		ParserRuleReturnScope orexpression5 =null;

		Object AND3_tree=null;

		try {
			// Script\\Framework\\BooleanExpressionGrammar.g:23:15: ( orexpression AND ^ andexpression | orexpression )
			int alt1=2;
			switch ( input.LA(1) ) {
			case NAME:
				{
				int LA1_1 = input.LA(2);
				if ( (synpred1_BooleanExpressionGrammar()) ) {
					alt1=1;
				}
				else if ( (true) ) {
					alt1=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA1_2 = input.LA(2);
				if ( (synpred1_BooleanExpressionGrammar()) ) {
					alt1=1;
				}
				else if ( (true) ) {
					alt1=2;
				}

				}
				break;
			case NOT:
				{
				int LA1_3 = input.LA(2);
				if ( (synpred1_BooleanExpressionGrammar()) ) {
					alt1=1;
				}
				else if ( (true) ) {
					alt1=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// Script\\Framework\\BooleanExpressionGrammar.g:23:17: orexpression AND ^ andexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_orexpression_in_andexpression79);
					orexpression2=orexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, orexpression2.getTree());

					AND3=(Token)match(input,AND,FOLLOW_AND_in_andexpression81); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND3_tree = (Object)adaptor.create(AND3);
					root_0 = (Object)adaptor.becomeRoot(AND3_tree, root_0);
					}

					pushFollow(FOLLOW_andexpression_in_andexpression84);
					andexpression4=andexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, andexpression4.getTree());

					}
					break;
				case 2 :
					// Script\\Framework\\BooleanExpressionGrammar.g:23:51: orexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_orexpression_in_andexpression88);
					orexpression5=orexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, orexpression5.getTree());

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
	// $ANTLR end "andexpression"


	public static class orexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "orexpression"
	// Script\\Framework\\BooleanExpressionGrammar.g:24:1: orexpression : ( ineqexpression OR ^ ineqexpression | ineqexpression );
	public final BooleanExpressionGrammar.orexpression_return orexpression() throws RecognitionException {
		BooleanExpressionGrammar.orexpression_return retval = new BooleanExpressionGrammar.orexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OR7=null;
		ParserRuleReturnScope ineqexpression6 =null;
		ParserRuleReturnScope ineqexpression8 =null;
		ParserRuleReturnScope ineqexpression9 =null;

		Object OR7_tree=null;

		try {
			// Script\\Framework\\BooleanExpressionGrammar.g:24:14: ( ineqexpression OR ^ ineqexpression | ineqexpression )
			int alt2=2;
			switch ( input.LA(1) ) {
			case NAME:
				{
				int LA2_1 = input.LA(2);
				if ( (synpred2_BooleanExpressionGrammar()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA2_2 = input.LA(2);
				if ( (synpred2_BooleanExpressionGrammar()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

				}
				break;
			case NOT:
				{
				int LA2_3 = input.LA(2);
				if ( (synpred2_BooleanExpressionGrammar()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// Script\\Framework\\BooleanExpressionGrammar.g:24:16: ineqexpression OR ^ ineqexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_ineqexpression_in_orexpression95);
					ineqexpression6=ineqexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ineqexpression6.getTree());

					OR7=(Token)match(input,OR,FOLLOW_OR_in_orexpression97); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OR7_tree = (Object)adaptor.create(OR7);
					root_0 = (Object)adaptor.becomeRoot(OR7_tree, root_0);
					}

					pushFollow(FOLLOW_ineqexpression_in_orexpression100);
					ineqexpression8=ineqexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ineqexpression8.getTree());

					}
					break;
				case 2 :
					// Script\\Framework\\BooleanExpressionGrammar.g:24:52: ineqexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_ineqexpression_in_orexpression104);
					ineqexpression9=ineqexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ineqexpression9.getTree());

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
	// $ANTLR end "orexpression"


	public static class ineqexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ineqexpression"
	// Script\\Framework\\BooleanExpressionGrammar.g:25:1: ineqexpression : ( pmexpression EQ ^ pmexpression | pmexpression LT ^ pmexpression | pmexpression LTE ^ pmexpression | pmexpression GT ^ pmexpression | pmexpression GTE ^ pmexpression | pmexpression NE ^ pmexpression | notexpression );
	public final BooleanExpressionGrammar.ineqexpression_return ineqexpression() throws RecognitionException {
		BooleanExpressionGrammar.ineqexpression_return retval = new BooleanExpressionGrammar.ineqexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EQ11=null;
		Token LT14=null;
		Token LTE17=null;
		Token GT20=null;
		Token GTE23=null;
		Token NE26=null;
		ParserRuleReturnScope pmexpression10 =null;
		ParserRuleReturnScope pmexpression12 =null;
		ParserRuleReturnScope pmexpression13 =null;
		ParserRuleReturnScope pmexpression15 =null;
		ParserRuleReturnScope pmexpression16 =null;
		ParserRuleReturnScope pmexpression18 =null;
		ParserRuleReturnScope pmexpression19 =null;
		ParserRuleReturnScope pmexpression21 =null;
		ParserRuleReturnScope pmexpression22 =null;
		ParserRuleReturnScope pmexpression24 =null;
		ParserRuleReturnScope pmexpression25 =null;
		ParserRuleReturnScope pmexpression27 =null;
		ParserRuleReturnScope notexpression28 =null;

		Object EQ11_tree=null;
		Object LT14_tree=null;
		Object LTE17_tree=null;
		Object GT20_tree=null;
		Object GTE23_tree=null;
		Object NE26_tree=null;

		try {
			// Script\\Framework\\BooleanExpressionGrammar.g:25:15: ( pmexpression EQ ^ pmexpression | pmexpression LT ^ pmexpression | pmexpression LTE ^ pmexpression | pmexpression GT ^ pmexpression | pmexpression GTE ^ pmexpression | pmexpression NE ^ pmexpression | notexpression )
			int alt3=7;
			switch ( input.LA(1) ) {
			case NAME:
				{
				int LA3_1 = input.LA(2);
				if ( (synpred3_BooleanExpressionGrammar()) ) {
					alt3=1;
				}
				else if ( (synpred4_BooleanExpressionGrammar()) ) {
					alt3=2;
				}
				else if ( (synpred5_BooleanExpressionGrammar()) ) {
					alt3=3;
				}
				else if ( (synpred6_BooleanExpressionGrammar()) ) {
					alt3=4;
				}
				else if ( (synpred7_BooleanExpressionGrammar()) ) {
					alt3=5;
				}
				else if ( (synpred8_BooleanExpressionGrammar()) ) {
					alt3=6;
				}
				else if ( (true) ) {
					alt3=7;
				}

				}
				break;
			case LPAREN:
				{
				int LA3_2 = input.LA(2);
				if ( (synpred3_BooleanExpressionGrammar()) ) {
					alt3=1;
				}
				else if ( (synpred4_BooleanExpressionGrammar()) ) {
					alt3=2;
				}
				else if ( (synpred5_BooleanExpressionGrammar()) ) {
					alt3=3;
				}
				else if ( (synpred6_BooleanExpressionGrammar()) ) {
					alt3=4;
				}
				else if ( (synpred7_BooleanExpressionGrammar()) ) {
					alt3=5;
				}
				else if ( (synpred8_BooleanExpressionGrammar()) ) {
					alt3=6;
				}
				else if ( (true) ) {
					alt3=7;
				}

				}
				break;
			case NOT:
				{
				alt3=7;
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
					// Script\\Framework\\BooleanExpressionGrammar.g:25:17: pmexpression EQ ^ pmexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pmexpression_in_ineqexpression110);
					pmexpression10=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression10.getTree());

					EQ11=(Token)match(input,EQ,FOLLOW_EQ_in_ineqexpression112); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EQ11_tree = (Object)adaptor.create(EQ11);
					root_0 = (Object)adaptor.becomeRoot(EQ11_tree, root_0);
					}

					pushFollow(FOLLOW_pmexpression_in_ineqexpression115);
					pmexpression12=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression12.getTree());

					}
					break;
				case 2 :
					// Script\\Framework\\BooleanExpressionGrammar.g:25:49: pmexpression LT ^ pmexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pmexpression_in_ineqexpression119);
					pmexpression13=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression13.getTree());

					LT14=(Token)match(input,LT,FOLLOW_LT_in_ineqexpression121); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LT14_tree = (Object)adaptor.create(LT14);
					root_0 = (Object)adaptor.becomeRoot(LT14_tree, root_0);
					}

					pushFollow(FOLLOW_pmexpression_in_ineqexpression124);
					pmexpression15=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression15.getTree());

					}
					break;
				case 3 :
					// Script\\Framework\\BooleanExpressionGrammar.g:25:81: pmexpression LTE ^ pmexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pmexpression_in_ineqexpression128);
					pmexpression16=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression16.getTree());

					LTE17=(Token)match(input,LTE,FOLLOW_LTE_in_ineqexpression130); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LTE17_tree = (Object)adaptor.create(LTE17);
					root_0 = (Object)adaptor.becomeRoot(LTE17_tree, root_0);
					}

					pushFollow(FOLLOW_pmexpression_in_ineqexpression133);
					pmexpression18=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression18.getTree());

					}
					break;
				case 4 :
					// Script\\Framework\\BooleanExpressionGrammar.g:26:4: pmexpression GT ^ pmexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pmexpression_in_ineqexpression139);
					pmexpression19=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression19.getTree());

					GT20=(Token)match(input,GT,FOLLOW_GT_in_ineqexpression141); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GT20_tree = (Object)adaptor.create(GT20);
					root_0 = (Object)adaptor.becomeRoot(GT20_tree, root_0);
					}

					pushFollow(FOLLOW_pmexpression_in_ineqexpression144);
					pmexpression21=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression21.getTree());

					}
					break;
				case 5 :
					// Script\\Framework\\BooleanExpressionGrammar.g:26:36: pmexpression GTE ^ pmexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pmexpression_in_ineqexpression148);
					pmexpression22=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression22.getTree());

					GTE23=(Token)match(input,GTE,FOLLOW_GTE_in_ineqexpression150); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GTE23_tree = (Object)adaptor.create(GTE23);
					root_0 = (Object)adaptor.becomeRoot(GTE23_tree, root_0);
					}

					pushFollow(FOLLOW_pmexpression_in_ineqexpression153);
					pmexpression24=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression24.getTree());

					}
					break;
				case 6 :
					// Script\\Framework\\BooleanExpressionGrammar.g:26:69: pmexpression NE ^ pmexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pmexpression_in_ineqexpression157);
					pmexpression25=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression25.getTree());

					NE26=(Token)match(input,NE,FOLLOW_NE_in_ineqexpression159); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NE26_tree = (Object)adaptor.create(NE26);
					root_0 = (Object)adaptor.becomeRoot(NE26_tree, root_0);
					}

					pushFollow(FOLLOW_pmexpression_in_ineqexpression162);
					pmexpression27=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression27.getTree());

					}
					break;
				case 7 :
					// Script\\Framework\\BooleanExpressionGrammar.g:26:101: notexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_notexpression_in_ineqexpression166);
					notexpression28=notexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, notexpression28.getTree());

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
	// Script\\Framework\\BooleanExpressionGrammar.g:27:1: notexpression : ( NOT ^ booleanatom | booleanatom );
	public final BooleanExpressionGrammar.notexpression_return notexpression() throws RecognitionException {
		BooleanExpressionGrammar.notexpression_return retval = new BooleanExpressionGrammar.notexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NOT29=null;
		ParserRuleReturnScope booleanatom30 =null;
		ParserRuleReturnScope booleanatom31 =null;

		Object NOT29_tree=null;

		try {
			// Script\\Framework\\BooleanExpressionGrammar.g:27:15: ( NOT ^ booleanatom | booleanatom )
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
					// Script\\Framework\\BooleanExpressionGrammar.g:27:17: NOT ^ booleanatom
					{
					root_0 = (Object)adaptor.nil();


					NOT29=(Token)match(input,NOT,FOLLOW_NOT_in_notexpression173); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOT29_tree = (Object)adaptor.create(NOT29);
					root_0 = (Object)adaptor.becomeRoot(NOT29_tree, root_0);
					}

					pushFollow(FOLLOW_booleanatom_in_notexpression176);
					booleanatom30=booleanatom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, booleanatom30.getTree());

					}
					break;
				case 2 :
					// Script\\Framework\\BooleanExpressionGrammar.g:27:36: booleanatom
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_booleanatom_in_notexpression180);
					booleanatom31=booleanatom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, booleanatom31.getTree());

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
	// Script\\Framework\\BooleanExpressionGrammar.g:28:1: booleanatom : ( NAME | LPAREN ! andexpression RPAREN !);
	public final BooleanExpressionGrammar.booleanatom_return booleanatom() throws RecognitionException {
		BooleanExpressionGrammar.booleanatom_return retval = new BooleanExpressionGrammar.booleanatom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME32=null;
		Token LPAREN33=null;
		Token RPAREN35=null;
		ParserRuleReturnScope andexpression34 =null;

		Object NAME32_tree=null;
		Object LPAREN33_tree=null;
		Object RPAREN35_tree=null;

		try {
			// Script\\Framework\\BooleanExpressionGrammar.g:28:13: ( NAME | LPAREN ! andexpression RPAREN !)
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
					// Script\\Framework\\BooleanExpressionGrammar.g:28:16: NAME
					{
					root_0 = (Object)adaptor.nil();


					NAME32=(Token)match(input,NAME,FOLLOW_NAME_in_booleanatom188); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME32_tree = (Object)adaptor.create(NAME32);
					adaptor.addChild(root_0, NAME32_tree);
					}

					}
					break;
				case 2 :
					// Script\\Framework\\BooleanExpressionGrammar.g:28:23: LPAREN ! andexpression RPAREN !
					{
					root_0 = (Object)adaptor.nil();


					LPAREN33=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_booleanatom192); if (state.failed) return retval;
					pushFollow(FOLLOW_andexpression_in_booleanatom195);
					andexpression34=andexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, andexpression34.getTree());

					RPAREN35=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_booleanatom197); if (state.failed) return retval;
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
	// Script\\Framework\\BooleanExpressionGrammar.g:29:1: pmexpression : ( mdexpression ADD ^ pmexpression | mdexpression SUBT ^ pmexpression | mdexpression );
	public final BooleanExpressionGrammar.pmexpression_return pmexpression() throws RecognitionException {
		BooleanExpressionGrammar.pmexpression_return retval = new BooleanExpressionGrammar.pmexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ADD37=null;
		Token SUBT40=null;
		ParserRuleReturnScope mdexpression36 =null;
		ParserRuleReturnScope pmexpression38 =null;
		ParserRuleReturnScope mdexpression39 =null;
		ParserRuleReturnScope pmexpression41 =null;
		ParserRuleReturnScope mdexpression42 =null;

		Object ADD37_tree=null;
		Object SUBT40_tree=null;

		try {
			// Script\\Framework\\BooleanExpressionGrammar.g:29:14: ( mdexpression ADD ^ pmexpression | mdexpression SUBT ^ pmexpression | mdexpression )
			int alt6=3;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==NAME) ) {
				int LA6_1 = input.LA(2);
				if ( (synpred11_BooleanExpressionGrammar()) ) {
					alt6=1;
				}
				else if ( (synpred12_BooleanExpressionGrammar()) ) {
					alt6=2;
				}
				else if ( (true) ) {
					alt6=3;
				}

			}
			else if ( (LA6_0==LPAREN) ) {
				int LA6_2 = input.LA(2);
				if ( (synpred11_BooleanExpressionGrammar()) ) {
					alt6=1;
				}
				else if ( (synpred12_BooleanExpressionGrammar()) ) {
					alt6=2;
				}
				else if ( (true) ) {
					alt6=3;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// Script\\Framework\\BooleanExpressionGrammar.g:29:16: mdexpression ADD ^ pmexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_mdexpression_in_pmexpression205);
					mdexpression36=mdexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mdexpression36.getTree());

					ADD37=(Token)match(input,ADD,FOLLOW_ADD_in_pmexpression207); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ADD37_tree = (Object)adaptor.create(ADD37);
					root_0 = (Object)adaptor.becomeRoot(ADD37_tree, root_0);
					}

					pushFollow(FOLLOW_pmexpression_in_pmexpression210);
					pmexpression38=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression38.getTree());

					}
					break;
				case 2 :
					// Script\\Framework\\BooleanExpressionGrammar.g:29:49: mdexpression SUBT ^ pmexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_mdexpression_in_pmexpression214);
					mdexpression39=mdexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mdexpression39.getTree());

					SUBT40=(Token)match(input,SUBT,FOLLOW_SUBT_in_pmexpression216); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SUBT40_tree = (Object)adaptor.create(SUBT40);
					root_0 = (Object)adaptor.becomeRoot(SUBT40_tree, root_0);
					}

					pushFollow(FOLLOW_pmexpression_in_pmexpression219);
					pmexpression41=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression41.getTree());

					}
					break;
				case 3 :
					// Script\\Framework\\BooleanExpressionGrammar.g:29:83: mdexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_mdexpression_in_pmexpression223);
					mdexpression42=mdexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mdexpression42.getTree());

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
	// $ANTLR end "pmexpression"


	public static class mdexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mdexpression"
	// Script\\Framework\\BooleanExpressionGrammar.g:30:1: mdexpression : ( numberatom MULT ^ mdexpression | numberatom DIV ^ mdexpression | numberatom );
	public final BooleanExpressionGrammar.mdexpression_return mdexpression() throws RecognitionException {
		BooleanExpressionGrammar.mdexpression_return retval = new BooleanExpressionGrammar.mdexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MULT44=null;
		Token DIV47=null;
		ParserRuleReturnScope numberatom43 =null;
		ParserRuleReturnScope mdexpression45 =null;
		ParserRuleReturnScope numberatom46 =null;
		ParserRuleReturnScope mdexpression48 =null;
		ParserRuleReturnScope numberatom49 =null;

		Object MULT44_tree=null;
		Object DIV47_tree=null;

		try {
			// Script\\Framework\\BooleanExpressionGrammar.g:30:14: ( numberatom MULT ^ mdexpression | numberatom DIV ^ mdexpression | numberatom )
			int alt7=3;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==NAME) ) {
				int LA7_1 = input.LA(2);
				if ( (synpred13_BooleanExpressionGrammar()) ) {
					alt7=1;
				}
				else if ( (synpred14_BooleanExpressionGrammar()) ) {
					alt7=2;
				}
				else if ( (true) ) {
					alt7=3;
				}

			}
			else if ( (LA7_0==LPAREN) ) {
				int LA7_2 = input.LA(2);
				if ( (synpred13_BooleanExpressionGrammar()) ) {
					alt7=1;
				}
				else if ( (synpred14_BooleanExpressionGrammar()) ) {
					alt7=2;
				}
				else if ( (true) ) {
					alt7=3;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// Script\\Framework\\BooleanExpressionGrammar.g:30:16: numberatom MULT ^ mdexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_numberatom_in_mdexpression230);
					numberatom43=numberatom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numberatom43.getTree());

					MULT44=(Token)match(input,MULT,FOLLOW_MULT_in_mdexpression232); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MULT44_tree = (Object)adaptor.create(MULT44);
					root_0 = (Object)adaptor.becomeRoot(MULT44_tree, root_0);
					}

					pushFollow(FOLLOW_mdexpression_in_mdexpression235);
					mdexpression45=mdexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mdexpression45.getTree());

					}
					break;
				case 2 :
					// Script\\Framework\\BooleanExpressionGrammar.g:30:48: numberatom DIV ^ mdexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_numberatom_in_mdexpression239);
					numberatom46=numberatom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numberatom46.getTree());

					DIV47=(Token)match(input,DIV,FOLLOW_DIV_in_mdexpression241); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DIV47_tree = (Object)adaptor.create(DIV47);
					root_0 = (Object)adaptor.becomeRoot(DIV47_tree, root_0);
					}

					pushFollow(FOLLOW_mdexpression_in_mdexpression244);
					mdexpression48=mdexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mdexpression48.getTree());

					}
					break;
				case 3 :
					// Script\\Framework\\BooleanExpressionGrammar.g:30:79: numberatom
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_numberatom_in_mdexpression248);
					numberatom49=numberatom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numberatom49.getTree());

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
	// $ANTLR end "mdexpression"


	public static class numberatom_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "numberatom"
	// Script\\Framework\\BooleanExpressionGrammar.g:31:1: numberatom : ( NAME | LPAREN ! mdexpression RPAREN !);
	public final BooleanExpressionGrammar.numberatom_return numberatom() throws RecognitionException {
		BooleanExpressionGrammar.numberatom_return retval = new BooleanExpressionGrammar.numberatom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME50=null;
		Token LPAREN51=null;
		Token RPAREN53=null;
		ParserRuleReturnScope mdexpression52 =null;

		Object NAME50_tree=null;
		Object LPAREN51_tree=null;
		Object RPAREN53_tree=null;

		try {
			// Script\\Framework\\BooleanExpressionGrammar.g:31:12: ( NAME | LPAREN ! mdexpression RPAREN !)
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==NAME) ) {
				alt8=1;
			}
			else if ( (LA8_0==LPAREN) ) {
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
					// Script\\Framework\\BooleanExpressionGrammar.g:31:14: NAME
					{
					root_0 = (Object)adaptor.nil();


					NAME50=(Token)match(input,NAME,FOLLOW_NAME_in_numberatom255); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME50_tree = (Object)adaptor.create(NAME50);
					adaptor.addChild(root_0, NAME50_tree);
					}

					}
					break;
				case 2 :
					// Script\\Framework\\BooleanExpressionGrammar.g:31:21: LPAREN ! mdexpression RPAREN !
					{
					root_0 = (Object)adaptor.nil();


					LPAREN51=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_numberatom259); if (state.failed) return retval;
					pushFollow(FOLLOW_mdexpression_in_numberatom262);
					mdexpression52=mdexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mdexpression52.getTree());

					RPAREN53=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_numberatom264); if (state.failed) return retval;
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

	// $ANTLR start synpred1_BooleanExpressionGrammar
	public final void synpred1_BooleanExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\BooleanExpressionGrammar.g:23:17: ( orexpression AND andexpression )
		// Script\\Framework\\BooleanExpressionGrammar.g:23:17: orexpression AND andexpression
		{
		pushFollow(FOLLOW_orexpression_in_synpred1_BooleanExpressionGrammar79);
		orexpression();
		state._fsp--;
		if (state.failed) return;

		match(input,AND,FOLLOW_AND_in_synpred1_BooleanExpressionGrammar81); if (state.failed) return;

		pushFollow(FOLLOW_andexpression_in_synpred1_BooleanExpressionGrammar84);
		andexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_BooleanExpressionGrammar

	// $ANTLR start synpred2_BooleanExpressionGrammar
	public final void synpred2_BooleanExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\BooleanExpressionGrammar.g:24:16: ( ineqexpression OR ineqexpression )
		// Script\\Framework\\BooleanExpressionGrammar.g:24:16: ineqexpression OR ineqexpression
		{
		pushFollow(FOLLOW_ineqexpression_in_synpred2_BooleanExpressionGrammar95);
		ineqexpression();
		state._fsp--;
		if (state.failed) return;

		match(input,OR,FOLLOW_OR_in_synpred2_BooleanExpressionGrammar97); if (state.failed) return;

		pushFollow(FOLLOW_ineqexpression_in_synpred2_BooleanExpressionGrammar100);
		ineqexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_BooleanExpressionGrammar

	// $ANTLR start synpred3_BooleanExpressionGrammar
	public final void synpred3_BooleanExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\BooleanExpressionGrammar.g:25:17: ( pmexpression EQ pmexpression )
		// Script\\Framework\\BooleanExpressionGrammar.g:25:17: pmexpression EQ pmexpression
		{
		pushFollow(FOLLOW_pmexpression_in_synpred3_BooleanExpressionGrammar110);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		match(input,EQ,FOLLOW_EQ_in_synpred3_BooleanExpressionGrammar112); if (state.failed) return;

		pushFollow(FOLLOW_pmexpression_in_synpred3_BooleanExpressionGrammar115);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred3_BooleanExpressionGrammar

	// $ANTLR start synpred4_BooleanExpressionGrammar
	public final void synpred4_BooleanExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\BooleanExpressionGrammar.g:25:49: ( pmexpression LT pmexpression )
		// Script\\Framework\\BooleanExpressionGrammar.g:25:49: pmexpression LT pmexpression
		{
		pushFollow(FOLLOW_pmexpression_in_synpred4_BooleanExpressionGrammar119);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		match(input,LT,FOLLOW_LT_in_synpred4_BooleanExpressionGrammar121); if (state.failed) return;

		pushFollow(FOLLOW_pmexpression_in_synpred4_BooleanExpressionGrammar124);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred4_BooleanExpressionGrammar

	// $ANTLR start synpred5_BooleanExpressionGrammar
	public final void synpred5_BooleanExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\BooleanExpressionGrammar.g:25:81: ( pmexpression LTE pmexpression )
		// Script\\Framework\\BooleanExpressionGrammar.g:25:81: pmexpression LTE pmexpression
		{
		pushFollow(FOLLOW_pmexpression_in_synpred5_BooleanExpressionGrammar128);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		match(input,LTE,FOLLOW_LTE_in_synpred5_BooleanExpressionGrammar130); if (state.failed) return;

		pushFollow(FOLLOW_pmexpression_in_synpred5_BooleanExpressionGrammar133);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred5_BooleanExpressionGrammar

	// $ANTLR start synpred6_BooleanExpressionGrammar
	public final void synpred6_BooleanExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\BooleanExpressionGrammar.g:26:4: ( pmexpression GT pmexpression )
		// Script\\Framework\\BooleanExpressionGrammar.g:26:4: pmexpression GT pmexpression
		{
		pushFollow(FOLLOW_pmexpression_in_synpred6_BooleanExpressionGrammar139);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		match(input,GT,FOLLOW_GT_in_synpred6_BooleanExpressionGrammar141); if (state.failed) return;

		pushFollow(FOLLOW_pmexpression_in_synpred6_BooleanExpressionGrammar144);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred6_BooleanExpressionGrammar

	// $ANTLR start synpred7_BooleanExpressionGrammar
	public final void synpred7_BooleanExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\BooleanExpressionGrammar.g:26:36: ( pmexpression GTE pmexpression )
		// Script\\Framework\\BooleanExpressionGrammar.g:26:36: pmexpression GTE pmexpression
		{
		pushFollow(FOLLOW_pmexpression_in_synpred7_BooleanExpressionGrammar148);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		match(input,GTE,FOLLOW_GTE_in_synpred7_BooleanExpressionGrammar150); if (state.failed) return;

		pushFollow(FOLLOW_pmexpression_in_synpred7_BooleanExpressionGrammar153);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred7_BooleanExpressionGrammar

	// $ANTLR start synpred8_BooleanExpressionGrammar
	public final void synpred8_BooleanExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\BooleanExpressionGrammar.g:26:69: ( pmexpression NE pmexpression )
		// Script\\Framework\\BooleanExpressionGrammar.g:26:69: pmexpression NE pmexpression
		{
		pushFollow(FOLLOW_pmexpression_in_synpred8_BooleanExpressionGrammar157);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		match(input,NE,FOLLOW_NE_in_synpred8_BooleanExpressionGrammar159); if (state.failed) return;

		pushFollow(FOLLOW_pmexpression_in_synpred8_BooleanExpressionGrammar162);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred8_BooleanExpressionGrammar

	// $ANTLR start synpred11_BooleanExpressionGrammar
	public final void synpred11_BooleanExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\BooleanExpressionGrammar.g:29:16: ( mdexpression ADD pmexpression )
		// Script\\Framework\\BooleanExpressionGrammar.g:29:16: mdexpression ADD pmexpression
		{
		pushFollow(FOLLOW_mdexpression_in_synpred11_BooleanExpressionGrammar205);
		mdexpression();
		state._fsp--;
		if (state.failed) return;

		match(input,ADD,FOLLOW_ADD_in_synpred11_BooleanExpressionGrammar207); if (state.failed) return;

		pushFollow(FOLLOW_pmexpression_in_synpred11_BooleanExpressionGrammar210);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred11_BooleanExpressionGrammar

	// $ANTLR start synpred12_BooleanExpressionGrammar
	public final void synpred12_BooleanExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\BooleanExpressionGrammar.g:29:49: ( mdexpression SUBT pmexpression )
		// Script\\Framework\\BooleanExpressionGrammar.g:29:49: mdexpression SUBT pmexpression
		{
		pushFollow(FOLLOW_mdexpression_in_synpred12_BooleanExpressionGrammar214);
		mdexpression();
		state._fsp--;
		if (state.failed) return;

		match(input,SUBT,FOLLOW_SUBT_in_synpred12_BooleanExpressionGrammar216); if (state.failed) return;

		pushFollow(FOLLOW_pmexpression_in_synpred12_BooleanExpressionGrammar219);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred12_BooleanExpressionGrammar

	// $ANTLR start synpred13_BooleanExpressionGrammar
	public final void synpred13_BooleanExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\BooleanExpressionGrammar.g:30:16: ( numberatom MULT mdexpression )
		// Script\\Framework\\BooleanExpressionGrammar.g:30:16: numberatom MULT mdexpression
		{
		pushFollow(FOLLOW_numberatom_in_synpred13_BooleanExpressionGrammar230);
		numberatom();
		state._fsp--;
		if (state.failed) return;

		match(input,MULT,FOLLOW_MULT_in_synpred13_BooleanExpressionGrammar232); if (state.failed) return;

		pushFollow(FOLLOW_mdexpression_in_synpred13_BooleanExpressionGrammar235);
		mdexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred13_BooleanExpressionGrammar

	// $ANTLR start synpred14_BooleanExpressionGrammar
	public final void synpred14_BooleanExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\BooleanExpressionGrammar.g:30:48: ( numberatom DIV mdexpression )
		// Script\\Framework\\BooleanExpressionGrammar.g:30:48: numberatom DIV mdexpression
		{
		pushFollow(FOLLOW_numberatom_in_synpred14_BooleanExpressionGrammar239);
		numberatom();
		state._fsp--;
		if (state.failed) return;

		match(input,DIV,FOLLOW_DIV_in_synpred14_BooleanExpressionGrammar241); if (state.failed) return;

		pushFollow(FOLLOW_mdexpression_in_synpred14_BooleanExpressionGrammar244);
		mdexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred14_BooleanExpressionGrammar

	// Delegated rules

	public final boolean synpred11_BooleanExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred11_BooleanExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred14_BooleanExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred14_BooleanExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_BooleanExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_BooleanExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred3_BooleanExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_BooleanExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred5_BooleanExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_BooleanExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred7_BooleanExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred7_BooleanExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred12_BooleanExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred12_BooleanExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred13_BooleanExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred13_BooleanExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_BooleanExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_BooleanExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred8_BooleanExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred8_BooleanExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_BooleanExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_BooleanExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred6_BooleanExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred6_BooleanExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_andexpression_in_expression72 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orexpression_in_andexpression79 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_AND_in_andexpression81 = new BitSet(new long[]{0x0000000000014400L});
	public static final BitSet FOLLOW_andexpression_in_andexpression84 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orexpression_in_andexpression88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ineqexpression_in_orexpression95 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_OR_in_orexpression97 = new BitSet(new long[]{0x0000000000014400L});
	public static final BitSet FOLLOW_ineqexpression_in_orexpression100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ineqexpression_in_orexpression104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression110 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_EQ_in_ineqexpression112 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression119 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_LT_in_ineqexpression121 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression128 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_LTE_in_ineqexpression130 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression139 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_GT_in_ineqexpression141 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression148 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_GTE_in_ineqexpression150 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression157 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_NE_in_ineqexpression159 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_ineqexpression162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_notexpression_in_ineqexpression166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_notexpression173 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_booleanatom_in_notexpression176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_booleanatom_in_notexpression180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_booleanatom188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_booleanatom192 = new BitSet(new long[]{0x0000000000014400L});
	public static final BitSet FOLLOW_andexpression_in_booleanatom195 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_RPAREN_in_booleanatom197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mdexpression_in_pmexpression205 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ADD_in_pmexpression207 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_pmexpression210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mdexpression_in_pmexpression214 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBT_in_pmexpression216 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_pmexpression219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mdexpression_in_pmexpression223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberatom_in_mdexpression230 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_MULT_in_mdexpression232 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_mdexpression_in_mdexpression235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberatom_in_mdexpression239 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_DIV_in_mdexpression241 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_mdexpression_in_mdexpression244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberatom_in_mdexpression248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_numberatom255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_numberatom259 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_mdexpression_in_numberatom262 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_RPAREN_in_numberatom264 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orexpression_in_synpred1_BooleanExpressionGrammar79 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_AND_in_synpred1_BooleanExpressionGrammar81 = new BitSet(new long[]{0x0000000000014400L});
	public static final BitSet FOLLOW_andexpression_in_synpred1_BooleanExpressionGrammar84 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ineqexpression_in_synpred2_BooleanExpressionGrammar95 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_OR_in_synpred2_BooleanExpressionGrammar97 = new BitSet(new long[]{0x0000000000014400L});
	public static final BitSet FOLLOW_ineqexpression_in_synpred2_BooleanExpressionGrammar100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_synpred3_BooleanExpressionGrammar110 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_EQ_in_synpred3_BooleanExpressionGrammar112 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_synpred3_BooleanExpressionGrammar115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_synpred4_BooleanExpressionGrammar119 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_LT_in_synpred4_BooleanExpressionGrammar121 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_synpred4_BooleanExpressionGrammar124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_synpred5_BooleanExpressionGrammar128 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_LTE_in_synpred5_BooleanExpressionGrammar130 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_synpred5_BooleanExpressionGrammar133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_synpred6_BooleanExpressionGrammar139 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_GT_in_synpred6_BooleanExpressionGrammar141 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_synpred6_BooleanExpressionGrammar144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_synpred7_BooleanExpressionGrammar148 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_GTE_in_synpred7_BooleanExpressionGrammar150 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_synpred7_BooleanExpressionGrammar153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pmexpression_in_synpred8_BooleanExpressionGrammar157 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_NE_in_synpred8_BooleanExpressionGrammar159 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_synpred8_BooleanExpressionGrammar162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mdexpression_in_synpred11_BooleanExpressionGrammar205 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ADD_in_synpred11_BooleanExpressionGrammar207 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_synpred11_BooleanExpressionGrammar210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mdexpression_in_synpred12_BooleanExpressionGrammar214 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBT_in_synpred12_BooleanExpressionGrammar216 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_synpred12_BooleanExpressionGrammar219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberatom_in_synpred13_BooleanExpressionGrammar230 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_MULT_in_synpred13_BooleanExpressionGrammar232 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_mdexpression_in_synpred13_BooleanExpressionGrammar235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberatom_in_synpred14_BooleanExpressionGrammar239 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_DIV_in_synpred14_BooleanExpressionGrammar241 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_mdexpression_in_synpred14_BooleanExpressionGrammar244 = new BitSet(new long[]{0x0000000000000002L});
}
