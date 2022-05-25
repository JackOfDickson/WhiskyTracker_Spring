package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(){
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/{id}")
    public ResponseEntity getDistillery(@PathVariable Long id){
        return new ResponseEntity(distilleryRepository.findById(id), HttpStatus.OK);
    }

    //example: http://localhost:8080/distilleries/region?region=Highland
    @GetMapping(value = "/distilleries/region")
    public ResponseEntity<List<Distillery>> getAllDistilleriesByRegion(@RequestParam(name="region", required = false) String region){
        return new ResponseEntity<>(distilleryRepository.findByRegionIgnoreCase(region), HttpStatus.OK);
    }


}
