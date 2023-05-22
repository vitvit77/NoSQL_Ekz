package com.example.labsnewcourse.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("CarCollection")
public class CarMongoDocument {
    @Id
    private String id;
    private String number;
    private CarBrand brand;
    private String model;
    private CarType type;
    private String color;
    private Boolean isAutomaticTransmission;
    private Float engineVolume;
    private Integer year;
    private Float price;
    private String description;
    private String photoUrl;
}
