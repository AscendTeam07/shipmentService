package com.wallmart.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wallmart.entities.Distance;

@Repository
public interface DistanceRepository extends MongoRepository<Distance, ObjectId>{
    Distance findByZipcode(String zipcode);
}
