%option noyywrap
%%
^[ \t]*#[ \t]*(include|define)([ \t]|$)[^\n]* { printf("Preprocessor directive: %s\n", yytext); }
^[ \t]*#[^\n]* { printf("Other directive: %s\n", yytext); }
.|\n { /* Ignore non-directive text */ }
%%
int main(void) { yylex(); return 0; }
