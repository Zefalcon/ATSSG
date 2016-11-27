grammar ExpressionGrammar;

//This code was modified from: http://meri-stuff.blogspot.com/2011/09/antlr-tutorial-expression-language.html
//Compile it via: java -jar jars\antlr-3.5.2-complete.jar Script\Framework\ExpressionGrammar.g

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

@lexer::header {
package ATSSG.Script.Framework;
}

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

NAME : ('a'..'z' | 'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9' | '_' | '$')*; 
NUMBER : ('0' .. '9')+ ('.' ('0' .. '9')+)?;
WS : ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; };
 
//start rule
booleanexpression : andexpression;
numberexpression : pmexpression;
andexpression : orexpression AND^ andexpression | orexpression;
orexpression : ineqexpression OR^ ineqexpression | ineqexpression;
ineqexpression: pmexpression EQ^ pmexpression | pmexpression LT^ pmexpression | pmexpression LTE^ pmexpression 
	| pmexpression GT^ pmexpression | pmexpression GTE^ pmexpression | pmexpression NE^ pmexpression | notexpression;
notexpression : NOT^ booleanatom | booleanatom;
booleanatom :  NAME | LPAREN! andexpression RPAREN!;
pmexpression : mdexpression ADD^ pmexpression | mdexpression SUBT^ pmexpression | mdexpression;
mdexpression : negative MULT^ mdexpression | negative DIV^ mdexpression | negative;
negative : SUBT^ numberatom | numberatom;
numberatom : NAME | NUMBER | LPAREN! pmexpression RPAREN!;
