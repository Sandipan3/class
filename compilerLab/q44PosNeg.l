%option noyywrap
%{
#include <stdio.h>
long positive=0, negative=0, zero=0;
%}
%%
[+-]?[0-9]+ {
    long n=0; sscanf(yytext, "%ld", &n);
    if (n>0) positive++; else if (n<0) negative++; else zero++;
}
[ \t\r\n]+ ;
. ;
%%
int main(void) { yylex(); printf("Positive: %ld\nNegative: %ld\nZero: %ld\n", positive, negative, zero); return 0; }
