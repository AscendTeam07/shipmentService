package com.wallmart.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallmart.entities.Product;
import com.wallmart.exception.ProductNotFoundException;

@DataMongoTest
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@EnableAutoConfiguration
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindByProductId() throws ProductNotFoundException {

        Product product = productRepository.findByProductId(1);
        assertEquals(1, product.getProductId());    
     }
    
}
