%option noyywrap
%%
"<="|">="|"=="|"<"|">" { printf("Relational operator: %s\n", yytext); }
[ \t\r\n]+ ;
. { printf("Other: %s\n", yytext); }
%%
int main(void) { yylex(); return 0; }
