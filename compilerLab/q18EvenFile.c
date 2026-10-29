#include <stdio.h>
int main(void) {
    FILE *fp = fopen("even.txt", "w");
    if (!fp) { perror("even.txt"); return 1; }
    for (int i=2; i<=20; i+=2) fprintf(fp, "%d\n", i);
    fclose(fp); puts("Even numbers saved to even.txt"); return 0;
}
