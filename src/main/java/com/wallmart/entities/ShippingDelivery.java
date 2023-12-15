package com.wallmart.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "shippingDelivery")
public class ShippingDelivery {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shippingID;
    private String cartId;
    private String typeOfShipping;
    private String destinationOfShipping;
    private Double shippingCost;
    private int deliveryDuration;    
}
