%option noyywrap
%%
[A-Z]+ { for (int i=0; i<yyleng; i++) putchar(yytext[i] - 'A' + 'a'); }
.|\n   { ECHO; }
%%
int main(void) { yylex(); return 0; }
