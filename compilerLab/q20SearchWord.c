#include <stdio.h>
#include <string.h>
int main(void) {
    char target[100], word[100]; int found = 0;
    printf("Word to search: ");
    if (scanf("%99s", target) != 1) return 1;
    FILE *fp = fopen("input.txt", "r");
    if (!fp) { perror("input.txt"); return 1; }
    while (fscanf(fp, "%99s", word) == 1) if (strcmp(target, word) == 0) { found=1; break; }
    fclose(fp); puts(found ? "Word found" : "Word not found"); return 0;
}
