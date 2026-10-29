#include <stdio.h>
int main(void) {
    FILE *fp = fopen("input.txt", "r"); int ch; long count = 0;
    if (!fp) { perror("input.txt"); return 1; }
    while ((ch = fgetc(fp)) != EOF) count++;
    fclose(fp); printf("Characters: %ld\n", count); return 0;
}
