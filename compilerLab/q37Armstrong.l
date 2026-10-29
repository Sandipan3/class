%option noyywrap
%{
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
%}
%%
[0-9]+ {
    long n = strtol(yytext, NULL, 10), t = n, sum = 0;
    int digits = yyleng;
    do { int d = (int)(t % 10); sum += (long)round(pow(d, digits)); t /= 10; } while (t > 0);
    printf("%ld is %san Armstrong number\n", n, sum == n ? "" : "not ");
}
[ \t\r\n]+ ;
. ;
%%
int main(void) { yylex(); return 0; }
