#include <stdio.h>

int main() {

    int n, sum = 0, data[50];

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter data:\n");

    for(int i=0;i<n;i++)
    {
        scanf("%d",&data[i]);
        sum += data[i];
    }

    int checksum = ~sum;

    printf("Checksum: %d\n", checksum);

    int receiverSum = sum + checksum;

    if(receiverSum == -1)
        printf("No Error Detected\n");
    else
        printf("Error Detected\n");

    return 0;
}