package com.example.labsnewcourse.repository;

import com.example.labsnewcourse.model.CarMongoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDocumentRepository extends MongoRepository<CarMongoDocument, String> {
}
