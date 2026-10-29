%option noyywrap
%%
[A-Za-z_][A-Za-z0-9_]* { printf("Valid identifier: %s\n", yytext); }
[0-9][A-Za-z0-9_]*     { printf("Invalid identifier: %s\n", yytext); }
[ \t\r\n]+ ;
. { printf("Invalid token: %s\n", yytext); }
%%
int main(void) { yylex(); return 0; }
