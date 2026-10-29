#include <stdio.h>
int main(void) {
    FILE *fp = fopen("numbers.txt", "r"); int n, largest, found = 0;
    if (!fp) { perror("numbers.txt"); return 1; }
    while (fscanf(fp, "%d", &n) == 1) {
        if (!found || n > largest) largest = n;
        found = 1;
    }
    fclose(fp);
    if (found) printf("Largest: %d\n", largest); else puts("No integers found");
    return 0;
}
