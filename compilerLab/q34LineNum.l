%option noyywrap
%{
#include <stdio.h>
int lineNo=1;
%}
%%
[^\n]*\n { printf("%d: %s", lineNo++, yytext); }
[^\n]+   { printf("%d: %s\n", lineNo++, yytext); }
%%
int main(void) { yylex(); return 0; }
