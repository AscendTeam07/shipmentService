package com.wallmart.dao;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wallmart.entities.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
	Product findByProductId(int productId);
   
}
