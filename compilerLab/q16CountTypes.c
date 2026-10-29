#include <stdio.h>
#include <ctype.h>
int main(void) {
    FILE *fp = fopen("input.txt", "r"); int ch; long digits=0, spaces=0, upper=0;
    if (!fp) { perror("input.txt"); return 1; }
    while ((ch=fgetc(fp)) != EOF) {
        if (isdigit((unsigned char)ch)) digits++;
        if (ch == ' ') spaces++;
        if (isupper((unsigned char)ch)) upper++;
    }
    fclose(fp);
    printf("Digits: %ld\nSpaces: %ld\nUppercase letters: %ld\n", digits, spaces, upper);
    return 0;
}
