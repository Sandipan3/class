%option noyywrap
%{
#include <stdio.h>
%}
%%
[0-9]+       { printf("Valid integer: %s\n", yytext); }
[^ \t\r\n]+  { printf("Not digits only: %s\n", yytext); }
[ \t\r\n]+   ;
%%
int main(void) { puts("Enter input, then end with Ctrl+D (Linux) or Ctrl+Z then Enter (Windows):"); yylex(); return 0; }
