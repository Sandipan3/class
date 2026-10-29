%option noyywrap
%%
[+-]?([0-9]+[.][0-9]*|[.][0-9]+) { printf("Float: %s\n", yytext); }
[+-]?[0-9]+                     { printf("Integer: %s\n", yytext); }
[ \t\r\n]+ ;
. { printf("Other: %s\n", yytext); }
%%
int main(void) { yylex(); return 0; }
