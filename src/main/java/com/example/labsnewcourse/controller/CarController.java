package com.example.labsnewcourse.controller;

import com.example.labsnewcourse.model.*;
import com.example.labsnewcourse.service.CarDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service")
public class CarController {
    @Autowired
    private CarDBService carDBService;

    @PostMapping("/car")
    public CarMongoDocument createDocument(@RequestBody CarDTO carDTO) {
        return carDBService.create(carDTO);
    }

    @PutMapping("/car")
    public CarMongoDocument updateDocument(@RequestBody CarDTO carDTO, @RequestParam String documentId) {
        return carDBService.update(documentId, carDTO);
    }

    @GetMapping("/car")
    public CarMongoDocument findDocument(@RequestParam String documentId) {
        return carDBService.find(documentId);
    }

    @DeleteMapping("/car")
    public SuccessDTOResponse deleteDocument(@RequestParam String documentId) {
        carDBService.delete(documentId);
        SuccessDTOResponse successDTOResponse = new SuccessDTOResponse();
        successDTOResponse.setResult(true);
        return successDTOResponse;
    }
}
