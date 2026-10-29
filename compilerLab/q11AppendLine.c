#include <stdio.h>
int main(void) {
    char line[500];
    printf("Enter line to append: ");
    if (!fgets(line, sizeof line, stdin)) return 1;
    FILE *fp = fopen("input.txt", "a");
    if (!fp) { perror("input.txt"); return 1; }
    fputs(line, fp); fclose(fp); puts("Appended to input.txt"); return 0;
}
