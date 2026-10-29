%option noyywrap
%{
#include <stdio.h>
long words=0;
%}
%%
[A-Za-z0-9_]+ { words++; }
[^A-Za-z0-9_]+ ;
%%
int main(void) { yylex(); printf("Words: %ld\n", words); return 0; }
