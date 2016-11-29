package ATSSG.Script.Framework;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class Expression {
	
	public static Double getDoubleValue(String source, Script environment) {
		source = source.trim();
		CommonTree ast = null;
		try {
			ANTLRStringStream input = new ANTLRStringStream(source);
			TokenStream tokens = new CommonTokenStream( new ExpressionGrammarLexer( input ) );
			ExpressionGrammarParser parser = new ExpressionGrammarParser(tokens);
			ExpressionGrammarParser.numberexpression_return ret;
			ret = parser.numberexpression();
		    ast = (CommonTree) ret.tree;
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		return getDoubleValue(ast, environment);
	}
	
	private static Double getDoubleValue(Tree ast, Script environment) {
		switch (ast.getType()) {
		case ExpressionGrammarLexer.ADD:
			return getDoubleValue(ast.getChild(0), environment) + getDoubleValue(ast.getChild(1), environment);
		case ExpressionGrammarLexer.DIV:
			return getDoubleValue(ast.getChild(0), environment) / getDoubleValue(ast.getChild(1), environment);
		case ExpressionGrammarLexer.MULT:
			return getDoubleValue(ast.getChild(0), environment) * getDoubleValue(ast.getChild(1), environment);
		case ExpressionGrammarLexer.NAME:
			if (environment.getHeap().containsKey(ast.getText())) {
				return (Double) environment.getHeap().get(ast.getText());
			}
			return Double.parseDouble(ast.getText());
		case ExpressionGrammarLexer.NUMBER:
			return Double.parseDouble(ast.getText());
		case ExpressionGrammarLexer.SUBT:
			if (ast.getChildCount() == 2) {
				return getDoubleValue(ast.getChild(0), environment) - getDoubleValue(ast.getChild(1), environment);
			} else {
				return - getDoubleValue(ast.getChild(0), environment);
			}
		default: return null;
		}
	}
	
	public static Boolean getBooleanValue(String source, Script environment) {
		source = source.trim();
		CommonTree ast = null;
		try {
			ANTLRStringStream input = new ANTLRStringStream(source);
			TokenStream tokens = new CommonTokenStream( new ExpressionGrammarLexer( input ) );
			ExpressionGrammarParser parser = new ExpressionGrammarParser(tokens);
			ExpressionGrammarParser.booleanexpression_return ret;
			ret = parser.booleanexpression();
		    ast = (CommonTree) ret.tree;
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		return getBooleanValue(ast, environment);
	}
	
	public static Boolean getBooleanValue(Tree ast, Script environment) {
		switch (ast.getType()) {
		case ExpressionGrammarLexer.AND:
			return getBooleanValue(ast.getChild(0), environment) && getBooleanValue(ast.getChild(1), environment);
		case ExpressionGrammarLexer.EQ:
			return getDoubleValue(ast.getChild(0), environment).equals(getDoubleValue(ast.getChild(1), environment));
		case ExpressionGrammarLexer.GT:
			return getDoubleValue(ast.getChild(0), environment) > getDoubleValue(ast.getChild(1), environment);
		case ExpressionGrammarLexer.GTE:
			return getDoubleValue(ast.getChild(0), environment) >= getDoubleValue(ast.getChild(1), environment);
		case ExpressionGrammarLexer.LT:
			return getDoubleValue(ast.getChild(0), environment) < getDoubleValue(ast.getChild(1), environment);
		case ExpressionGrammarLexer.LTE:
			return getDoubleValue(ast.getChild(0), environment) <= getDoubleValue(ast.getChild(1), environment);
		case ExpressionGrammarLexer.NAME:
			if (environment.getHeap().containsKey(ast.getText())) {
				return (Boolean) environment.getHeap().get(ast.getText());
			}
			return Boolean.parseBoolean(ast.getText());
		case ExpressionGrammarLexer.NE:
			return !getDoubleValue(ast.getChild(0), environment).equals(getDoubleValue(ast.getChild(1), environment));
		case ExpressionGrammarLexer.NOT:
			return !getBooleanValue(ast.getChild(0), environment);
		case ExpressionGrammarLexer.OR:
			return getBooleanValue(ast.getChild(0), environment) || getBooleanValue(ast.getChild(1), environment);
		default: return null;
		}
		
	}

}
