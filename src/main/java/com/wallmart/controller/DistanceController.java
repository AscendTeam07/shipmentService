package com.wallmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wallmart.entities.Distance;
import com.wallmart.exception.DistanceNotFoundException;
import com.wallmart.service.DistanceService;

@RestController
public class DistanceController {

    @Autowired
    DistanceService distanceService;

    @PostMapping("/createdistance")
    @CrossOrigin("*")
    public ResponseEntity<Distance> addDistance(@RequestBody Distance distance) {
        Distance addedDistance = distanceService.addDistance(distance);
        return new ResponseEntity<>(addedDistance, HttpStatus.CREATED);
    }

    @PutMapping("/upddistance/{zipcode}")
    @CrossOrigin("*")
    public ResponseEntity<?> updateDistance(@PathVariable("zipcode") String zipcode, @RequestBody Distance distance) {
        try {
            Distance curDistance = distanceService.updateDistance(zipcode, distance);
            return new ResponseEntity<>(curDistance, HttpStatus.OK);
        } catch (DistanceNotFoundException dnfe) {
            dnfe.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getdistance/{zipcode}")
    @CrossOrigin("*")
    public ResponseEntity<Distance> findDistance(@PathVariable("zipcode") String zipcode) {
        try {
            Distance curDistance = distanceService.getDistance(zipcode);
            return new ResponseEntity<Distance>(curDistance, HttpStatus.FOUND);
        } catch (DistanceNotFoundException dnfe) {
            dnfe.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/distances")
    @CrossOrigin("*")
    public ResponseEntity<List<Distance>> getAllDistances() {
        List<Distance> distances = distanceService.getAllDistances();
        return new ResponseEntity<>(distances, HttpStatus.OK);
    }

}