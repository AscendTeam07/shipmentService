package com.wallmart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wallmart.entities.Product;

@Service
public interface ProductService {
	
	Product addProduct(Product product);
    Product updateProduct(int productId, Product product);
    Product getProduct(int productId);
    List<Product> getAllProducts();

}
