package com.example.grpc;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection {
    private final MongoCollection<Document> collection;

    public MongoDBConnection() {
        var client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = client.getDatabase("grpcdb");
        collection = database.getCollection("form_data");
    }

    public void saveFormData(Form form) {
        Document doc = new Document("firstName", form.getFirstName())
                .append("lastName", form.getLastName())
                .append("phoneNumber", form.getPhoneNumber())
                .append("email", form.getEmail())
                .append("fields", form.getFieldsList());

        collection.insertOne(doc);
    }

    public FormData retrieveFormData(String name, String email) {
        Document doc = collection.find(new Document("firstName", name).append("email", email)).first();

        if (doc != null) {
            return FormData.newBuilder()
                    .setFirstName(doc.getString("firstName"))
                    .setLastName(doc.getString("lastName"))
                    .setPhoneNumber(doc.getString("phoneNumber"))
                    .setEmail(doc.getString("email"))
                    .addAllFields(doc.getList("fields", String.class))
                    .build();
        } else {
            return null;
        }
    }
}
