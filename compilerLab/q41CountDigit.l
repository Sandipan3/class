%option noyywrap
%{
#include <stdio.h>
long digits=0;
%}
%%
[0-9]+ { digits += yyleng; }
.|\n   ;
%%
int main(void) { yylex(); printf("Digits: %ld\n", digits); return 0; }
