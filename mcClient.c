#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <pthread.h>

int sockfd;

void *receiveMessage(void *arg) {

    char buffer[1024];

    while(recv(sockfd,buffer,sizeof(buffer),0)>0) {
        printf("%s",buffer);
    }

    return NULL;
}

int main() {

    struct sockaddr_in serverAddr;
    char buffer[1024];

    pthread_t recvThread;

    sockfd = socket(AF_INET,SOCK_STREAM,0);

    serverAddr.sin_family = AF_INET;
    serverAddr.sin_port = htons(8080);
    serverAddr.sin_addr.s_addr = inet_addr("127.0.0.1");

    connect(sockfd,(struct sockaddr*)&serverAddr,sizeof(serverAddr));

    pthread_create(&recvThread,NULL,receiveMessage,NULL);

    while(1) {

        fgets(buffer,sizeof(buffer),stdin);
        send(sockfd,buffer,strlen(buffer),0);
    }

    close(sockfd);

    return 0;
}