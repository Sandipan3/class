%option noyywrap
%{
#include <stdio.h>
#include <stdlib.h>
%}
%%
[0-9]+ {
    unsigned long n = strtoul(yytext, NULL, 10), x = n;
    char bits[sizeof(unsigned long)*8+1]; int i=0;
    if (x == 0) bits[i++]='0';
    while (x) { bits[i++] = (char)('0' + (x & 1)); x >>= 1; }
    printf("%s in binary: ", yytext);
    while (i) putchar(bits[--i]);
    putchar('\n');
}
[ \t\r\n]+ ;
. ;
%%
int main(void) { yylex(); return 0; }
