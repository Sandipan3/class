#include <stdio.h>
#include <string.h>
#include <arpa/inet.h>
#include <unistd.h>

int main() {

    int sockfd;
    char buffer[1024];

    struct sockaddr_in serverAddr, clientAddr;

    socklen_t len = sizeof(clientAddr);

    sockfd = socket(AF_INET, SOCK_DGRAM, 0);

    serverAddr.sin_family = AF_INET;
    serverAddr.sin_port = htons(8080);
    serverAddr.sin_addr.s_addr = INADDR_ANY;

    bind(sockfd, (struct sockaddr*)&serverAddr, sizeof(serverAddr));

    recvfrom(sockfd, buffer, sizeof(buffer), 0,
             (struct sockaddr*)&clientAddr, &len);

    printf("Message from Client: %s\n", buffer);

    close(sockfd);

    return 0;
}