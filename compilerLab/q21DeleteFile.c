#include <stdio.h>
#include <stdlib.h>
int main(void) {
    char name[260];
    printf("Filename to delete: ");
    if (scanf("%259s", name) != 1) return 1;
    if (remove(name) == 0) puts("File deleted");
    else { perror("remove"); return 1; }
    return 0;
}
