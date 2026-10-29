#include <stdio.h>
int main(void) {
    FILE *fp = fopen("input.txt", "r");
    char line[256];
    if (!fp) { perror("input.txt"); return 1; }
    while (fgets(line, sizeof line, fp)) fputs(line, stdout);
    fclose(fp);
    return 0;
}
