%option noyywrap
%{
#include <stdio.h>
int vowels=0, consonants=0;
%}
%%
[AaEeIiOoUu] { vowels++; }
[A-Za-z]     { consonants++; }
.|\n         ;
%%
int main(void) { yylex(); printf("Vowels: %d\nConsonants: %d\n", vowels, consonants); return 0; }
