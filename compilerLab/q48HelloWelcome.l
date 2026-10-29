%option noyywrap
%%
hello { printf("welcome"); }
.|\n  { ECHO; }
%%
int main(void) { yylex(); return 0; }
