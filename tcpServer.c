#include <stdio.h>
#include <string.h>
#include <arpa/inet.h>
#include <unistd.h>

int main() {

    int sockfd, newSocket;
    char buffer[1024];

    struct sockaddr_in serverAddr, clientAddr;
    socklen_t addr_size;

    sockfd = socket(AF_INET, SOCK_STREAM, 0);

    serverAddr.sin_family = AF_INET;
    serverAddr.sin_port = htons(8080);
    serverAddr.sin_addr.s_addr = INADDR_ANY;

    bind(sockfd, (struct sockaddr*)&serverAddr, sizeof(serverAddr));

    listen(sockfd, 5);

    addr_size = sizeof(clientAddr);
    newSocket = accept(sockfd, (struct sockaddr*)&clientAddr, &addr_size);

    recv(newSocket, buffer, sizeof(buffer), 0);

    printf("Message from client: %s\n", buffer);

    close(newSocket);
    close(sockfd);

    return 0;
}