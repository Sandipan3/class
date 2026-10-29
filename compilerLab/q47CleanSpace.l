%option noyywrap
%%
[ \t]+ { putchar(' '); }
.|\n   { ECHO; }
%%
int main(void) { yylex(); return 0; }
