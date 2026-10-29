#include <stdio.h>
int main(void) {
    FILE *fp = fopen("input.txt", "r");
    if (fp) { puts("File opened"); fclose(fp); }
    else puts("Cannot open file");
    return 0;
}
