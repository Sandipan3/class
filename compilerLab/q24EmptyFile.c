#include <stdio.h>
int main(void) {
    FILE *fp = fopen("input.txt", "rb");
    if (!fp) { perror("input.txt"); return 1; }
    fseek(fp, 0, SEEK_END);
    long size = ftell(fp);
    if (size == 0) puts("File is empty");
    else if (size > 0) puts("File is not empty");
    else puts("Could not determine file size");
    fclose(fp); return size < 0;
}
