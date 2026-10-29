#include <stdio.h>
#include <ctype.h>
int main(void) {
    FILE *fp = fopen("input.txt", "r"); int ch; long count = 0;
    if (!fp) { perror("input.txt"); return 1; }
    while ((ch = fgetc(fp)) != EOF) {
        ch = tolower((unsigned char)ch);
        if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') count++;
    }
    fclose(fp); printf("Vowels: %ld\n", count); return 0;
}
