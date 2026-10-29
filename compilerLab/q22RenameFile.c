#include <stdio.h>
int main(void) {
    char oldName[260], newName[260];
    printf("Old filename: "); if (scanf("%259s", oldName) != 1) return 1;
    printf("New filename: "); if (scanf("%259s", newName) != 1) return 1;
    if (rename(oldName, newName) == 0) puts("File renamed");
    else { perror("rename"); return 1; }
    return 0;
}
