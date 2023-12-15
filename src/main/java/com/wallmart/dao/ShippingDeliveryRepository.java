package com.wallmart.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wallmart.entities.ShippingDelivery;

@Repository
public interface ShippingDeliveryRepository extends MongoRepository<ShippingDelivery,Integer> {
    
    Optional<ShippingDelivery> findByShippingID(Integer shippingID);
    Optional<ShippingDelivery> deleteByShippingID(Integer shippingID);

    
}
