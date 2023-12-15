package com.wallmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallmart.dao.DistanceRepository;
import com.wallmart.entities.Distance;
import com.wallmart.exception.DistanceNotFoundException;

@Service
public class DistanceServiceImpl implements DistanceService{

    @Autowired
    DistanceRepository distanceRepository;

    @Override
    public Distance addDistance(Distance distance) {
        
        return distanceRepository.save(distance);
    }

    @Override
    public List<Distance> getAllDistances() {
        
        return distanceRepository.findAll();
    }

    @Override
    public Distance getDistance(String zipCode) throws DistanceNotFoundException {
        
        return distanceRepository.findByZipcode(zipCode);
    }

    @Override
    public Distance updateDistance(String zipCode, Distance distance) throws DistanceNotFoundException {
        Distance currentDistance = distanceRepository.findByZipcode(zipCode);
        if (currentDistance != null) {
            currentDistance.setShippingCost(distance.getShippingCost());
            currentDistance.setDeliveryDuration(distance.getDeliveryDuration());
            currentDistance.setTypeOfShipping(distance.getTypeOfShipping());
            return distanceRepository.save(currentDistance);
        } else{
            throw new DistanceNotFoundException("Zipcode not Found - " + zipCode);
        }
    }
    
}
