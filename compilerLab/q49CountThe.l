%option noyywrap
%{
#include <stdio.h>
long count=0;
%}
%%
[Tt][Hh][Ee]([ \t\r\n.,!?;:]|$) { count++; ECHO; }
.|\n { ECHO; }
%%
int main(void) { yylex(); printf("\nOccurrences of the: %ld\n", count); return 0; }
