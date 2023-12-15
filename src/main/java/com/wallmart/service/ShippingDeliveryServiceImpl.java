package com.wallmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallmart.dao.ShippingDeliveryRepository;

@Service
public class ShippingDeliveryServiceImpl {

    @Autowired
    ShippingDeliveryRepository shippingDeliveryRepository; 
    
}
