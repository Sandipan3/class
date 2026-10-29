#include <stdio.h>
#include <ctype.h>
int main(void) {
    FILE *fp = fopen("input.txt", "r"); int ch;
    if (!fp) { perror("input.txt"); return 1; }
    while ((ch = fgetc(fp)) != EOF) putchar(toupper((unsigned char)ch));
    fclose(fp); return 0;
}
