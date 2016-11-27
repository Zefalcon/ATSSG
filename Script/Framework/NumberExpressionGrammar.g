parser grammar NumberExpressionGrammar;

//This code was modified from: http://meri-stuff.blogspot.com/2011/09/antlr-tutorial-expression-language.html
//Compile it via: java -jar jars\antlr-3.5.2-complete.jar Script\Framework\NumberExpressionGrammar.g

options
{
  // antlr will generate java lexer and parser
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

// ***************** parser rules:
 
//
//start rule
expression : pmexpression;
pmexpression : mdexpression ADD^ pmexpression | mdexpression SUBT^ pmexpression | mdexpression;
mdexpression : numberatom MULT^ mdexpression | numberatom DIV^ mdexpression | numberatom;
numberatom : NAME | LPAREN! pmexpression RPAREN!;

