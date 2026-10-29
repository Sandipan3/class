%option noyywrap
%x COMMENT
%%
"//"[^\n]*   ;
\n           { ECHO; }
.            { ECHO; }
%%
int main(void) { yylex(); return 0; }
