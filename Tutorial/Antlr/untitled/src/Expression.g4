grammar Expression;

// Rules starting with an uppercase letter comprise the lexical (token) rules
INT: [0-9]+; // match integers
NEWLINE:'\r'? '\n' ; // return newlines to parser (is end-statement signal)
WS : [ \t]+ -> skip; // toss out whitespace

MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';

// Rules starting with a lowercase letter comprise the parser rules
expr: expr op=(MUL | DIV) expr   # MulDiv
    | expr op=(ADD | SUB) expr   # AddSub
    | INT                        # int
    | '(' expr ')'               # parens
    ;