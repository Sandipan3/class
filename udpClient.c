#include <stdio.h>
#include <string.h>
#include <arpa/inet.h>
#include <unistd.h>

int main() {

    int sockfd;
    char buffer[1024];

    struct sockaddr_in serverAddr;

    sockfd = socket(AF_INET, SOCK_DGRAM, 0);

    serverAddr.sin_family = AF_INET;
    serverAddr.sin_port = htons(8080);
    serverAddr.sin_addr.s_addr = inet_addr("127.0.0.1");

    printf("Enter message: ");
    fgets(buffer, sizeof(buffer), stdin);

    sendto(sockfd, buffer, strlen(buffer), 0,
           (struct sockaddr*)&serverAddr, sizeof(serverAddr));

    close(sockfd);

    return 0;
}