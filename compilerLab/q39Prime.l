%option noyywrap
%{
#include <stdio.h>
#include <stdlib.h>
%}
%%
[0-9]+ {
    long n = strtol(yytext, NULL, 10); int prime = n >= 2;
    for (long d=2; prime && d <= n/d; d++) if (n % d == 0) prime = 0;
    printf("%ld is %sprime\n", n, prime ? "" : "not ");
}
[ \t\r\n]+ ;
. ;
%%
int main(void) { yylex(); return 0; }
