%option noyywrap
%{
#include <stdio.h>
#include <string.h>
%}
%%
[0-9]+ {
    int ok=1;
    for (int i=0, j=yyleng-1; i<j; i++,j--) if (yytext[i] != yytext[j]) { ok=0; break; }
    printf("%s is %sa palindrome\n", yytext, ok ? "" : "not ");
}
[ \t\r\n]+ ;
. ;
%%
int main(void) { yylex(); return 0; }
