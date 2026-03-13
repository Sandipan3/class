#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <pthread.h>

#define MAX_CLIENTS 10

int clients[MAX_CLIENTS];
int clientCount = 0;

void *handleClient(void *arg) {

    int clientSocket = *(int*)arg;
    char buffer[1024];
    int bytes;

    while((bytes = recv(clientSocket, buffer, sizeof(buffer), 0)) > 0) {

        buffer[bytes] = '\0';
        printf("Client: %s", buffer);

        for(int i=0;i<clientCount;i++) {

            if(clients[i] != clientSocket) {
                send(clients[i], buffer, strlen(buffer), 0);
            }
        }
    }

    close(clientSocket);
    return NULL;
}

int main() {

    int serverSocket, clientSocket;
    struct sockaddr_in serverAddr, clientAddr;
    socklen_t addr_size;

    pthread_t tid;

    serverSocket = socket(AF_INET, SOCK_STREAM, 0);

    serverAddr.sin_family = AF_INET;
    serverAddr.sin_port = htons(8080);
    serverAddr.sin_addr.s_addr = INADDR_ANY;

    bind(serverSocket,(struct sockaddr*)&serverAddr,sizeof(serverAddr));

    listen(serverSocket,5);

    printf("Chat Server Started...\n");

    while(1) {

        addr_size = sizeof(clientAddr);

        clientSocket = accept(serverSocket,
                      (struct sockaddr*)&clientAddr,
                      &addr_size);

        clients[clientCount++] = clientSocket;

        pthread_create(&tid,NULL,handleClient,&clientSocket);
    }

    close(serverSocket);
    return 0;
}