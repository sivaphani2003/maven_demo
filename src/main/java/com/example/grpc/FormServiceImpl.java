package com.example.grpc;

import io.grpc.stub.StreamObserver;
import com.example.grpc.FormServiceGrpc.FormServiceImplBase;

public class FormServiceImpl extends FormServiceImplBase {
    private final MongoDBConnection mongoDBConnection = new MongoDBConnection();

    @Override
    public void uploadForm(FormRequest request, StreamObserver<FormResponse> responseObserver) {
        Form form = request.getFormData();

        // Here, you would save the form data to MongoDB
        mongoDBConnection.saveFormData(form);

        FormResponse response = FormResponse.newBuilder()
                .setMessage("Form data uploaded successfully")
                .setSuccess(true)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void retrieveForm(RetrieveRequest request, StreamObserver<FormData> responseObserver) {
        String name = request.getName();
        String email = request.getEmail();

        // Retrieve form data from MongoDB based on name and email
        FormData formData = mongoDBConnection.retrieveFormData(name, email);

        responseObserver.onNext(formData);
        responseObserver.onCompleted();
    }
}
