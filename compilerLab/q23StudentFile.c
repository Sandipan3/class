#include <stdio.h>
int main(void) {
    char name[100]; float marks;
    printf("Student name (no spaces): "); if (scanf("%99s", name) != 1) return 1;
    printf("Marks: "); if (scanf("%f", &marks) != 1) return 1;
    FILE *fp = fopen("student.txt", "w");
    if (!fp) { perror("student.txt"); return 1; }
    fprintf(fp, "%s %.2f\n", name, marks); fclose(fp);
    fp = fopen("student.txt", "r");
    if (!fp) { perror("student.txt"); return 1; }
    fscanf(fp, "%99s %f", name, &marks);
    printf("Name: %s\nMarks: %.2f\n", name, marks);
    fclose(fp); return 0;
}
