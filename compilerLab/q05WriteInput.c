#include <stdio.h>
int main(void) {
    char text[500];
    printf("Enter a line: ");
    if (!fgets(text, sizeof text, stdin)) return 1;
    FILE *fp = fopen("output.txt", "w");
    if (!fp) { perror("output.txt"); return 1; }
    fputs(text, fp);
    fclose(fp);
    puts("Saved to output.txt");
    return 0;
}
