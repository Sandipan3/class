#include <stdio.h>
int main(void) {
    FILE *fp = fopen("numbers.txt", "w");
    if (!fp) { perror("numbers.txt"); return 1; }
    for (int i = 1; i <= 10; i++) fprintf(fp, "%d%c", i, i == 10 ? '\n' : ' ');
    fclose(fp);
    fp = fopen("numbers.txt", "r");
    if (!fp) { perror("numbers.txt"); return 1; }
    int n; while (fscanf(fp, "%d", &n) == 1) printf("%d ", n);
    putchar('\n'); fclose(fp); return 0;
}
