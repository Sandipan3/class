#include <stdio.h>
int main(void) {
    FILE *fp = fopen("input.txt", "r"); int ch, any = 0, last = '\n'; long lines = 0;
    if (!fp) { perror("input.txt"); return 1; }
    while ((ch = fgetc(fp)) != EOF) { any = 1; if (ch == '\n') lines++; last = ch; }
    if (any && last != '\n') lines++;
    fclose(fp); printf("Lines: %ld\n", lines); return 0;
}
