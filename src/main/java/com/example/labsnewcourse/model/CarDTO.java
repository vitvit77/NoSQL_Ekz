package com.example.labsnewcourse.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {
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
