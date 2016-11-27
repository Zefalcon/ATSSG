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
			TokenStream tokens = new CommonTokenStream( new ExpressionToken( input ) );
			NumberExpressionGrammar parser = new NumberExpressionGrammar(tokens);
			NumberExpressionGrammar.expression_return ret;
			ret = parser.expression();
		    ast = (CommonTree) ret.tree;
		    print(ast, 0);
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		return getDoubleValue(ast, environment);
	}
	
	private static Double getDoubleValue(Tree ast, Script environment) {
		switch (ast.getType()) {
		case ExpressionToken.ADD:
			return getDoubleValue(ast.getChild(0), environment) + getDoubleValue(ast.getChild(1), environment);
		case ExpressionToken.DIV:
			return getDoubleValue(ast.getChild(0), environment) / getDoubleValue(ast.getChild(1), environment);
		case ExpressionToken.MULT:
			return getDoubleValue(ast.getChild(0), environment) * getDoubleValue(ast.getChild(1), environment);
		case ExpressionToken.NAME:
			if (environment.getHeap().containsKey(ast.getText())) {
				return (Double) environment.getHeap().get(ast.getText());
			}
			return Double.parseDouble(ast.getText());
		case ExpressionToken.SUBT:
			return getDoubleValue(ast.getChild(0), environment) - getDoubleValue(ast.getChild(1), environment);
		default: return null;
		}
	}
	
	private static void print(CommonTree tree, int level) {
		//indent level
		for (int i = 0; i < level; i++)
			System.out.print("--");

		//print node description: type code followed by token text
		System.out.println(" " + tree.getType() + " " + tree.getText());
		
		//print all children
		if (tree.getChildren() != null)
			for (Object ie : tree.getChildren()) {
				print((CommonTree) ie, level + 1);
			}
	}
	
	public static Boolean getBooleanValue(String source, Script environment) {
		source = source.trim();
		CommonTree ast = null;
		try {
			ANTLRStringStream input = new ANTLRStringStream(source);
			TokenStream tokens = new CommonTokenStream( new ExpressionToken( input ) );
			BooleanExpressionGrammar parser = new BooleanExpressionGrammar(tokens);
			BooleanExpressionGrammar.expression_return ret;
			ret = parser.expression();
		    ast = (CommonTree) ret.tree;
		    print(ast, 0);
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		return getBooleanValue(ast, environment);
	}
	
	public static Boolean getBooleanValue(Tree ast, Script environment) {
		switch (ast.getType()) {
		case ExpressionToken.AND:
			boolean result = true;
			for (int i=0; i<ast.getChildCount(); i++) {
				result =  result && getBooleanValue(ast.getChild(i), environment);
			}
			return result;
		case ExpressionToken.EQ:
			return getDoubleValue(ast.getChild(0), environment).equals(getDoubleValue(ast.getChild(1), environment));
		case ExpressionToken.GT:
			return getDoubleValue(ast.getChild(0), environment) > getDoubleValue(ast.getChild(1), environment);
		case ExpressionToken.GTE:
			return getDoubleValue(ast.getChild(0), environment) >= getDoubleValue(ast.getChild(1), environment);
		case ExpressionToken.LT:
			return getDoubleValue(ast.getChild(0), environment) < getDoubleValue(ast.getChild(1), environment);
		case ExpressionToken.LTE:
			return getDoubleValue(ast.getChild(0), environment) <= getDoubleValue(ast.getChild(1), environment);
		case ExpressionToken.NAME:
			if (environment.getHeap().containsKey(ast.getText())) {
				return (Boolean) environment.getHeap().get(ast.getText());
			}
			return Boolean.parseBoolean(ast.getText());
		case ExpressionToken.NE:
			return getDoubleValue(ast.getChild(0), environment) != getDoubleValue(ast.getChild(1), environment);
		case ExpressionToken.OR:
			boolean result2 = false;
			for (int i=0; i<ast.getChildCount(); i++) {
				result2 = result2 || getBooleanValue(ast.getChild(i), environment);
			}
			return result2;
		default: return null;
		}
		
	}

}
