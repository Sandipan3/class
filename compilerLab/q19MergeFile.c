#include <stdio.h>
static int appendFile(FILE *out, const char *name) {
    FILE *in = fopen(name, "r");
    if (!in) { perror(name); return 0; }
    int ch; while ((ch=fgetc(in)) != EOF) fputc(ch, out);
    fclose(in); return 1;
}
int main(void) {
    FILE *out = fopen("merged.txt", "w");
    if (!out) { perror("merged.txt"); return 1; }
    int ok1 = appendFile(out, "input.txt");
    int ok2 = appendFile(out, "input2.txt");
    fclose(out);
    if (ok1 && ok2) puts("Merged into merged.txt"); else puts("Merge incomplete");
    return (ok1 && ok2) ? 0 : 1;
}
