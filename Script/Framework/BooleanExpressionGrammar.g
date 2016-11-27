parser grammar BooleanExpressionGrammar;

//This code was modified from: http://meri-stuff.blogspot.com/2011/09/antlr-tutorial-expression-language.html
//Compile it via: java -jar jars\antlr-3.5.2-complete.jar Script\Framework\BooleanExpressionGrammar.g

options
{
  language = Java;
  // generated parser should create abstract syntax tree
  output = AST;  
  tokenVocab = ExpressionToken;
  backtrack=true;
}

//as the generated parser will reside in ATSSG.Script.Framework 
//package, we have to add package declaration on top of it
@parser::header {
package ATSSG.Script.Framework;
}
 
//start rule
expression : andexpression;
andexpression : orexpression AND^ andexpression | orexpression;
orexpression : ineqexpression OR^ ineqexpression | ineqexpression;
ineqexpression: pmexpression EQ^ pmexpression | pmexpression LT^ pmexpression | pmexpression LTE^ pmexpression 
	| pmexpression GT^ pmexpression | pmexpression GTE^ pmexpression | pmexpression NE^ pmexpression | notexpression;
notexpression : NOT^ booleanatom | booleanatom;
booleanatom :  NAME | LPAREN! andexpression RPAREN!;
pmexpression : mdexpression ADD^ pmexpression | mdexpression SUBT^ pmexpression | mdexpression;
mdexpression : numberatom MULT^ mdexpression | numberatom DIV^ mdexpression | numberatom;
numberatom : NAME | LPAREN! mdexpression RPAREN!;
