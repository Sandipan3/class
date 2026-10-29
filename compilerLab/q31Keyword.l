%option noyywrap
%%
int|float|char  { printf("Keyword: %s\n", yytext); }
[A-Za-z_][A-Za-z0-9_]* { printf("Identifier: %s\n", yytext); }
[ \t\r\n]+ ;
. { printf("Other: %s\n", yytext); }
%%
int main(void) { yylex(); return 0; }
