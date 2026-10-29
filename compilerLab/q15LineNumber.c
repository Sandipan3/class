#include <stdio.h>
int main(void) {
    FILE *fp = fopen("input.txt", "r"); char line[512]; int n = 1;
    if (!fp) { perror("input.txt"); return 1; }
    while (fgets(line, sizeof line, fp)) printf("%d: %s", n++, line);
    fclose(fp); return 0;
}
