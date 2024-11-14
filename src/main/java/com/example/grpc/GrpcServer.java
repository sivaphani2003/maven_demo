package com.example.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

    private static final int PORT = 9090;  // gRPC server port

    public static void main(String[] args) throws Exception {
        // Initialize the gRPC server
        Server server = ServerBuilder.forPort(PORT)
                .addService(new FormServiceImpl())  // Add the FormServiceImpl to the server
                .build();

        // Start the server
        System.out.println("Starting gRPC server on port " + PORT);
        server.start();

        // Keep the server running
        server.awaitTermination();
    }
}
