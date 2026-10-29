#include <stdio.h>
int main(void) {
    FILE *fp = fopen("output.txt", "w");
    if (!fp) { perror("output.txt"); return 1; }
    fprintf(fp, "Hello Compiler Lab\n");
    fclose(fp);
    puts("Text written to output.txt");
    return 0;
}
