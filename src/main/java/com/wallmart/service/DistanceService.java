package com.wallmart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wallmart.entities.Distance;
import com.wallmart.exception.DistanceNotFoundException;

@Service
public interface DistanceService {

    Distance addDistance(Distance distance);

    Distance updateDistance(String zipCode, Distance distance) throws DistanceNotFoundException;

    Distance getDistance(String zipCode) throws DistanceNotFoundException;

    List<Distance> getAllDistances();

}
