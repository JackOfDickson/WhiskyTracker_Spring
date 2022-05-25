package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(){
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/{id}")
    public ResponseEntity getWhisky(@PathVariable Long id){
        return new ResponseEntity(whiskyRepository.findById(id), HttpStatus.OK);
    }

    //example: http://localhost:8080/whiskies/year?whiskyYear=2018
    @GetMapping(value = "/whiskies/year")
    public ResponseEntity<List<Whisky>> getAllWhiskiesByYear(@RequestParam(name = "whiskyYear", required = false) int whiskyYear) {
        return new ResponseEntity<>(whiskyRepository.findByYear(whiskyYear), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/distilAge")
    public ResponseEntity<List<Whisky>> getWhiskiesByDistilleryAndAge(@RequestParam(name= "distilleryId", required = false) Long distilleryId, @RequestParam(name="age", required = false) int age){
    return new ResponseEntity<>(whiskyRepository.findByDistilleryIdAndAge(distilleryId, age), HttpStatus.OK);
    }

}
