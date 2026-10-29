%option noyywrap
%{
#include <stdio.h>
long lines=0, words=0, chars=0;
int inWord=0, any=0, lastNewline=1;
%}
%%
[ \t\r\f\v]+ { chars += yyleng; inWord=0; any=1; lastNewline=0; }
\n            { chars++; lines++; inWord=0; any=1; lastNewline=1; }
[^ \t\r\n\f\v]+ { chars += yyleng; if (!inWord) words++; inWord=1; any=1; lastNewline=0; }
%%
int main(void) {
    yylex();
    if (any && !lastNewline) lines++;
    printf("Lines: %ld\nWords: %ld\nCharacters: %ld\n", lines, words, chars);
    return 0;
}
