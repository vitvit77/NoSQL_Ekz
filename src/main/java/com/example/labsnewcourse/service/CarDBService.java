package com.example.labsnewcourse.service;

import com.example.labsnewcourse.model.CarDTO;
import com.example.labsnewcourse.model.CarMongoDocument;
import com.example.labsnewcourse.repository.MongoDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarDBService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoDocumentRepository mongoDocumentRepository;

    /**
     *
     * @param carDTO
     * @return
     */
    public CarMongoDocument create(CarDTO carDTO) {
        CarMongoDocument carMongoDocument = new CarMongoDocument();
        carMongoDocument.setNumber(carDTO.getNumber());
        carMongoDocument.setBrand(carDTO.getBrand());
        carMongoDocument.setModel(carDTO.getModel());
        carMongoDocument.setType(carDTO.getType());
        carMongoDocument.setColor(carDTO.getColor());
        carMongoDocument.setEngineVolume(carDTO.getEngineVolume());
        carMongoDocument.setIsAutomaticTransmission(carDTO.getIsAutomaticTransmission());
        carMongoDocument.setYear(carDTO.getYear());
        carMongoDocument.setPrice(carDTO.getPrice());
        carMongoDocument.setDescription(carDTO.getDescription());
        carMongoDocument.setPhotoUrl(carDTO.getPhotoUrl());
        mongoDocumentRepository.save(carMongoDocument);
        return carMongoDocument;
    }

    public CarMongoDocument update(String documentId, CarDTO carDTO) {
        Optional<CarMongoDocument> optionalCarMongoDocument = Optional.ofNullable(this.find(documentId));
        if (optionalCarMongoDocument.isPresent()) {
            CarMongoDocument carMongoDocument = optionalCarMongoDocument.get();
            carMongoDocument.setNumber(carDTO.getNumber());
            carMongoDocument.setBrand(carDTO.getBrand());
            carMongoDocument.setModel(carDTO.getModel());
            carMongoDocument.setType(carDTO.getType());
            carMongoDocument.setColor(carDTO.getColor());
            carMongoDocument.setEngineVolume(carDTO.getEngineVolume());
            carMongoDocument.setIsAutomaticTransmission(carDTO.getIsAutomaticTransmission());
            carMongoDocument.setYear(carDTO.getYear());
            carMongoDocument.setPrice(carDTO.getPrice());
            carMongoDocument.setDescription(carDTO.getDescription());
            carMongoDocument.setPhotoUrl(carDTO.getPhotoUrl());
            return mongoTemplate.save(carMongoDocument);
        }
        return null;
    }

    public CarMongoDocument find(String documentId) {
        Optional<CarMongoDocument> optionalCarMongoDocument =  mongoDocumentRepository.findById(documentId);
        if (optionalCarMongoDocument.isPresent()) {
            CarMongoDocument carMongoDocument = optionalCarMongoDocument.get();
            return carMongoDocument;
        }
        return null;
    }

    public void delete(String documentId) {
        mongoDocumentRepository.deleteById(documentId);
    }
}
