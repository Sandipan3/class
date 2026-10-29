#include <stdio.h>
int main(void) {
    FILE *fp = fopen("input.txt", "rb");
    if (!fp) { perror("input.txt"); return 1; }
    if (fseek(fp, 0, SEEK_END) != 0) { fclose(fp); return 1; }
    long size = ftell(fp);
    for (long pos = size; pos > 0; ) {
        if (fseek(fp, --pos, SEEK_SET) != 0) break;
        int ch = fgetc(fp); if (ch != EOF) putchar(ch);
    }
    fclose(fp); return 0;
}
