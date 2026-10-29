#include <stdio.h>
int main(void) {
    FILE *fp = fopen("numbers.txt", "r"); long long sum = 0; int n, found = 0;
    if (!fp) { perror("numbers.txt"); return 1; }
    while (fscanf(fp, "%d", &n) == 1) { sum += n; found = 1; }
    fclose(fp);
    if (!found) puts("No integers found"); else printf("Sum: %lld\n", sum);
    return 0;
}
