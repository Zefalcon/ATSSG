lexer grammar ExpressionToken;

//This code was modified from: http://meri-stuff.blogspot.com/2011/09/antlr-tutorial-expression-language.html
//Compile it via: java -jar jars\antlr-3.5.2-complete.jar Script\Framework\ExpressionToken.g

options
{
  language = Java;
}

//as the generated lexer will reside in ATSSG.Script.Framework 
//package, we have to add package declaration on top of it
@lexer::header {
package ATSSG.Script.Framework;
}
// ***************** lexer rules:
//the grammar must contain at least one lexer rule
LPAREN : '(' ;
RPAREN : ')' ;
AND : '&&';
OR : '||';
NOT : '!';
MULT: '*';
DIV: '/';
ADD: '+';
SUBT: '-';
EQ: '==';
LT: '<';
LTE: '<=';
GT: '>';
GTE: '>=';
NE: '!=';

NAME : ('a'..'z' | '0'..'9' | '_' | '$')+; 
WS : ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; };