#include <stdio.h>
int main(void) {
    FILE *src = fopen("input.txt", "rb");
    if (!src) { perror("input.txt"); return 1; }
    FILE *dst = fopen("copy.txt", "wb");
    if (!dst) { perror("copy.txt"); fclose(src); return 1; }
    int ch;
    while ((ch = fgetc(src)) != EOF) fputc(ch, dst);
    fclose(src); fclose(dst);
    puts("Copied input.txt to copy.txt");
    return 0;
}
