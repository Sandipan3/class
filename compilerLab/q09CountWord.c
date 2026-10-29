#include <stdio.h>
#include <ctype.h>
int main(void) {
    FILE *fp = fopen("input.txt", "r"); int ch, inside = 0; long words = 0;
    if (!fp) { perror("input.txt"); return 1; }
    while ((ch = fgetc(fp)) != EOF) {
        if (isspace((unsigned char)ch)) inside = 0;
        else if (!inside) { inside = 1; words++; }
    }
    fclose(fp); printf("Words: %ld\n", words); return 0;
}
