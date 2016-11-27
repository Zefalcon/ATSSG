// $ANTLR 3.5.2 Script\\Framework\\NumberExpressionGrammar.g 2016-11-26 23:05:14

package ATSSG.Script.Framework;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class NumberExpressionGrammar extends Parser {
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


	public NumberExpressionGrammar(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public NumberExpressionGrammar(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return NumberExpressionGrammar.tokenNames; }
	@Override public String getGrammarFileName() { return "Script\\Framework\\NumberExpressionGrammar.g"; }


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// Script\\Framework\\NumberExpressionGrammar.g:26:1: expression : pmexpression ;
	public final NumberExpressionGrammar.expression_return expression() throws RecognitionException {
		NumberExpressionGrammar.expression_return retval = new NumberExpressionGrammar.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope pmexpression1 =null;


		try {
			// Script\\Framework\\NumberExpressionGrammar.g:26:12: ( pmexpression )
			// Script\\Framework\\NumberExpressionGrammar.g:26:14: pmexpression
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_pmexpression_in_expression76);
			pmexpression1=pmexpression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression1.getTree());

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


	public static class pmexpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "pmexpression"
	// Script\\Framework\\NumberExpressionGrammar.g:27:1: pmexpression : ( mdexpression ADD ^ pmexpression | mdexpression SUBT ^ pmexpression | mdexpression );
	public final NumberExpressionGrammar.pmexpression_return pmexpression() throws RecognitionException {
		NumberExpressionGrammar.pmexpression_return retval = new NumberExpressionGrammar.pmexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ADD3=null;
		Token SUBT6=null;
		ParserRuleReturnScope mdexpression2 =null;
		ParserRuleReturnScope pmexpression4 =null;
		ParserRuleReturnScope mdexpression5 =null;
		ParserRuleReturnScope pmexpression7 =null;
		ParserRuleReturnScope mdexpression8 =null;

		Object ADD3_tree=null;
		Object SUBT6_tree=null;

		try {
			// Script\\Framework\\NumberExpressionGrammar.g:27:14: ( mdexpression ADD ^ pmexpression | mdexpression SUBT ^ pmexpression | mdexpression )
			int alt1=3;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==NAME) ) {
				int LA1_1 = input.LA(2);
				if ( (synpred1_NumberExpressionGrammar()) ) {
					alt1=1;
				}
				else if ( (synpred2_NumberExpressionGrammar()) ) {
					alt1=2;
				}
				else if ( (true) ) {
					alt1=3;
				}

			}
			else if ( (LA1_0==LPAREN) ) {
				int LA1_2 = input.LA(2);
				if ( (synpred1_NumberExpressionGrammar()) ) {
					alt1=1;
				}
				else if ( (synpred2_NumberExpressionGrammar()) ) {
					alt1=2;
				}
				else if ( (true) ) {
					alt1=3;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// Script\\Framework\\NumberExpressionGrammar.g:27:16: mdexpression ADD ^ pmexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_mdexpression_in_pmexpression83);
					mdexpression2=mdexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mdexpression2.getTree());

					ADD3=(Token)match(input,ADD,FOLLOW_ADD_in_pmexpression85); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ADD3_tree = (Object)adaptor.create(ADD3);
					root_0 = (Object)adaptor.becomeRoot(ADD3_tree, root_0);
					}

					pushFollow(FOLLOW_pmexpression_in_pmexpression88);
					pmexpression4=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression4.getTree());

					}
					break;
				case 2 :
					// Script\\Framework\\NumberExpressionGrammar.g:27:49: mdexpression SUBT ^ pmexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_mdexpression_in_pmexpression92);
					mdexpression5=mdexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mdexpression5.getTree());

					SUBT6=(Token)match(input,SUBT,FOLLOW_SUBT_in_pmexpression94); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SUBT6_tree = (Object)adaptor.create(SUBT6);
					root_0 = (Object)adaptor.becomeRoot(SUBT6_tree, root_0);
					}

					pushFollow(FOLLOW_pmexpression_in_pmexpression97);
					pmexpression7=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression7.getTree());

					}
					break;
				case 3 :
					// Script\\Framework\\NumberExpressionGrammar.g:27:83: mdexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_mdexpression_in_pmexpression101);
					mdexpression8=mdexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mdexpression8.getTree());

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
	// Script\\Framework\\NumberExpressionGrammar.g:28:1: mdexpression : ( numberatom MULT ^ mdexpression | numberatom DIV ^ mdexpression | numberatom );
	public final NumberExpressionGrammar.mdexpression_return mdexpression() throws RecognitionException {
		NumberExpressionGrammar.mdexpression_return retval = new NumberExpressionGrammar.mdexpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MULT10=null;
		Token DIV13=null;
		ParserRuleReturnScope numberatom9 =null;
		ParserRuleReturnScope mdexpression11 =null;
		ParserRuleReturnScope numberatom12 =null;
		ParserRuleReturnScope mdexpression14 =null;
		ParserRuleReturnScope numberatom15 =null;

		Object MULT10_tree=null;
		Object DIV13_tree=null;

		try {
			// Script\\Framework\\NumberExpressionGrammar.g:28:14: ( numberatom MULT ^ mdexpression | numberatom DIV ^ mdexpression | numberatom )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==NAME) ) {
				int LA2_1 = input.LA(2);
				if ( (synpred3_NumberExpressionGrammar()) ) {
					alt2=1;
				}
				else if ( (synpred4_NumberExpressionGrammar()) ) {
					alt2=2;
				}
				else if ( (true) ) {
					alt2=3;
				}

			}
			else if ( (LA2_0==LPAREN) ) {
				int LA2_2 = input.LA(2);
				if ( (synpred3_NumberExpressionGrammar()) ) {
					alt2=1;
				}
				else if ( (synpred4_NumberExpressionGrammar()) ) {
					alt2=2;
				}
				else if ( (true) ) {
					alt2=3;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// Script\\Framework\\NumberExpressionGrammar.g:28:16: numberatom MULT ^ mdexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_numberatom_in_mdexpression108);
					numberatom9=numberatom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numberatom9.getTree());

					MULT10=(Token)match(input,MULT,FOLLOW_MULT_in_mdexpression110); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MULT10_tree = (Object)adaptor.create(MULT10);
					root_0 = (Object)adaptor.becomeRoot(MULT10_tree, root_0);
					}

					pushFollow(FOLLOW_mdexpression_in_mdexpression113);
					mdexpression11=mdexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mdexpression11.getTree());

					}
					break;
				case 2 :
					// Script\\Framework\\NumberExpressionGrammar.g:28:48: numberatom DIV ^ mdexpression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_numberatom_in_mdexpression117);
					numberatom12=numberatom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numberatom12.getTree());

					DIV13=(Token)match(input,DIV,FOLLOW_DIV_in_mdexpression119); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DIV13_tree = (Object)adaptor.create(DIV13);
					root_0 = (Object)adaptor.becomeRoot(DIV13_tree, root_0);
					}

					pushFollow(FOLLOW_mdexpression_in_mdexpression122);
					mdexpression14=mdexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mdexpression14.getTree());

					}
					break;
				case 3 :
					// Script\\Framework\\NumberExpressionGrammar.g:28:79: numberatom
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_numberatom_in_mdexpression126);
					numberatom15=numberatom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numberatom15.getTree());

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
	// Script\\Framework\\NumberExpressionGrammar.g:29:1: numberatom : ( NAME | LPAREN ! pmexpression RPAREN !);
	public final NumberExpressionGrammar.numberatom_return numberatom() throws RecognitionException {
		NumberExpressionGrammar.numberatom_return retval = new NumberExpressionGrammar.numberatom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME16=null;
		Token LPAREN17=null;
		Token RPAREN19=null;
		ParserRuleReturnScope pmexpression18 =null;

		Object NAME16_tree=null;
		Object LPAREN17_tree=null;
		Object RPAREN19_tree=null;

		try {
			// Script\\Framework\\NumberExpressionGrammar.g:29:12: ( NAME | LPAREN ! pmexpression RPAREN !)
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==NAME) ) {
				alt3=1;
			}
			else if ( (LA3_0==LPAREN) ) {
				alt3=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// Script\\Framework\\NumberExpressionGrammar.g:29:14: NAME
					{
					root_0 = (Object)adaptor.nil();


					NAME16=(Token)match(input,NAME,FOLLOW_NAME_in_numberatom133); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME16_tree = (Object)adaptor.create(NAME16);
					adaptor.addChild(root_0, NAME16_tree);
					}

					}
					break;
				case 2 :
					// Script\\Framework\\NumberExpressionGrammar.g:29:21: LPAREN ! pmexpression RPAREN !
					{
					root_0 = (Object)adaptor.nil();


					LPAREN17=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_numberatom137); if (state.failed) return retval;
					pushFollow(FOLLOW_pmexpression_in_numberatom140);
					pmexpression18=pmexpression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pmexpression18.getTree());

					RPAREN19=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_numberatom142); if (state.failed) return retval;
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

	// $ANTLR start synpred1_NumberExpressionGrammar
	public final void synpred1_NumberExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\NumberExpressionGrammar.g:27:16: ( mdexpression ADD pmexpression )
		// Script\\Framework\\NumberExpressionGrammar.g:27:16: mdexpression ADD pmexpression
		{
		pushFollow(FOLLOW_mdexpression_in_synpred1_NumberExpressionGrammar83);
		mdexpression();
		state._fsp--;
		if (state.failed) return;

		match(input,ADD,FOLLOW_ADD_in_synpred1_NumberExpressionGrammar85); if (state.failed) return;

		pushFollow(FOLLOW_pmexpression_in_synpred1_NumberExpressionGrammar88);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_NumberExpressionGrammar

	// $ANTLR start synpred2_NumberExpressionGrammar
	public final void synpred2_NumberExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\NumberExpressionGrammar.g:27:49: ( mdexpression SUBT pmexpression )
		// Script\\Framework\\NumberExpressionGrammar.g:27:49: mdexpression SUBT pmexpression
		{
		pushFollow(FOLLOW_mdexpression_in_synpred2_NumberExpressionGrammar92);
		mdexpression();
		state._fsp--;
		if (state.failed) return;

		match(input,SUBT,FOLLOW_SUBT_in_synpred2_NumberExpressionGrammar94); if (state.failed) return;

		pushFollow(FOLLOW_pmexpression_in_synpred2_NumberExpressionGrammar97);
		pmexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_NumberExpressionGrammar

	// $ANTLR start synpred3_NumberExpressionGrammar
	public final void synpred3_NumberExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\NumberExpressionGrammar.g:28:16: ( numberatom MULT mdexpression )
		// Script\\Framework\\NumberExpressionGrammar.g:28:16: numberatom MULT mdexpression
		{
		pushFollow(FOLLOW_numberatom_in_synpred3_NumberExpressionGrammar108);
		numberatom();
		state._fsp--;
		if (state.failed) return;

		match(input,MULT,FOLLOW_MULT_in_synpred3_NumberExpressionGrammar110); if (state.failed) return;

		pushFollow(FOLLOW_mdexpression_in_synpred3_NumberExpressionGrammar113);
		mdexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred3_NumberExpressionGrammar

	// $ANTLR start synpred4_NumberExpressionGrammar
	public final void synpred4_NumberExpressionGrammar_fragment() throws RecognitionException {
		// Script\\Framework\\NumberExpressionGrammar.g:28:48: ( numberatom DIV mdexpression )
		// Script\\Framework\\NumberExpressionGrammar.g:28:48: numberatom DIV mdexpression
		{
		pushFollow(FOLLOW_numberatom_in_synpred4_NumberExpressionGrammar117);
		numberatom();
		state._fsp--;
		if (state.failed) return;

		match(input,DIV,FOLLOW_DIV_in_synpred4_NumberExpressionGrammar119); if (state.failed) return;

		pushFollow(FOLLOW_mdexpression_in_synpred4_NumberExpressionGrammar122);
		mdexpression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred4_NumberExpressionGrammar

	// Delegated rules

	public final boolean synpred2_NumberExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_NumberExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred3_NumberExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_NumberExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_NumberExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_NumberExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_NumberExpressionGrammar() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_NumberExpressionGrammar_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_pmexpression_in_expression76 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mdexpression_in_pmexpression83 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ADD_in_pmexpression85 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_pmexpression88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mdexpression_in_pmexpression92 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBT_in_pmexpression94 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_pmexpression97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mdexpression_in_pmexpression101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberatom_in_mdexpression108 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_MULT_in_mdexpression110 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_mdexpression_in_mdexpression113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberatom_in_mdexpression117 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_DIV_in_mdexpression119 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_mdexpression_in_mdexpression122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberatom_in_mdexpression126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_numberatom133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_numberatom137 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_numberatom140 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_RPAREN_in_numberatom142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mdexpression_in_synpred1_NumberExpressionGrammar83 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ADD_in_synpred1_NumberExpressionGrammar85 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_synpred1_NumberExpressionGrammar88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mdexpression_in_synpred2_NumberExpressionGrammar92 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBT_in_synpred2_NumberExpressionGrammar94 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_pmexpression_in_synpred2_NumberExpressionGrammar97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberatom_in_synpred3_NumberExpressionGrammar108 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_MULT_in_synpred3_NumberExpressionGrammar110 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_mdexpression_in_synpred3_NumberExpressionGrammar113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numberatom_in_synpred4_NumberExpressionGrammar117 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_DIV_in_synpred4_NumberExpressionGrammar119 = new BitSet(new long[]{0x0000000000004400L});
	public static final BitSet FOLLOW_mdexpression_in_synpred4_NumberExpressionGrammar122 = new BitSet(new long[]{0x0000000000000002L});
}
