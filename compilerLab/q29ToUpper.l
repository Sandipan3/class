%option noyywrap
%%
[a-z]+ { for (int i=0; i<yyleng; i++) putchar(yytext[i] - 'a' + 'A'); }
.|\n   { ECHO; }
%%
int main(void) { yylex(); return 0; }
