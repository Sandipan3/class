#include <stdio.h>
#include <string.h>

void xorOperation(char *a, char *b, int len) {
    for(int i = 1; i < len; i++) {
       a[i] =  a[i] == b[i] ? '0': '1';
    }
}

void crc(char *data, char *key) {

    int dataLen = strlen(data);
    int keyLen = strlen(key);

    char temp[50];
    strcpy(temp, data);

    for(int i = 0; i <= dataLen - keyLen; i++) {

        if(temp[i] == '1')
            xorOperation(temp + i, key, keyLen);
    }

    printf("CRC Remainder: ");

    for(int i = dataLen - keyLen + 1; i < dataLen; i++)
        printf("%c", temp[i]);

    printf("\n");
}

int main() {

    char data[50], key[50];

    printf("Enter Data: ");
    scanf("%s", data);

    printf("Enter Generator Key: ");
    scanf("%s", key);

    int keyLen = strlen(key);

    for(int i = 0; i < keyLen - 1; i++)
        strcat(data, "0");

    crc(data, key);

    return 0;
}