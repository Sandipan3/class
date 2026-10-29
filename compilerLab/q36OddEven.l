%option noyywrap
%{
#include <stdio.h>
#include <stdlib.h>
%}
%%
[+-]?[0-9]+ { long n = strtol(yytext, NULL, 10); printf("%ld is %s\n", n, n % 2 ? "odd" : "even"); }
[ \t\r\n]+ ;
. { printf("Ignored: %s\n", yytext); }
%%
int main(void) { yylex(); return 0; }
