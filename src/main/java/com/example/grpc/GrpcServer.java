package com.example.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Create gRPC server and bind it to port 8080
        Server server = ServerBuilder.forPort(8080)
                .addService(new FormServiceImpl())  // Register the service implementation
                .build();

        // Start the server
        System.out.println("Server started...");
        server.start();
        server.awaitTermination();
    }
}
