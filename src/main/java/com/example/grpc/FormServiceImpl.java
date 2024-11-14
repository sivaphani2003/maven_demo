package com.example.grpc;

import io.grpc.stub.StreamObserver;

public class FormServiceImpl extends FormServiceGrpc.FormServiceImplBase {

    @Override
    public void submitForm(FormRequest request, StreamObserver<FormResponse> responseObserver) {
        // Handle form submission logic here
        System.out.println("Received Form Submission: " + request.getFirstName() + " " + request.getLastName());

        // Process the form and send a response
        FormResponse response = FormResponse.newBuilder()
                .setMessage("Form submitted successfully!")
                .setSuccess(true)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void retrieveFormData(RetrieveRequest request, StreamObserver<FormResponse> responseObserver) {
        // Handle data retrieval based on name and email
        System.out.println("Retrieving Form Data for: " + request.getName());

        // Retrieve data (just an example)
        FormResponse response = FormResponse.newBuilder()
                .setMessage("Form data retrieved successfully!")
                .setSuccess(true)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
