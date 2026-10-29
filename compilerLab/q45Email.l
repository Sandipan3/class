%option noyywrap
%{
#include <stdio.h>
%}
%%
[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,} { printf("Valid email: %s\n", yytext); }
[^ \t\r\n]+ { printf("Invalid email/token: %s\n", yytext); }
[ \t\r\n]+ ;
%%
int main(void) { yylex(); return 0; }
