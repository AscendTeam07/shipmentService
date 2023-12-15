package com.wallmart.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wallmart.dao.ShippingDeliveryRepository;
import com.wallmart.entities.ShippingDelivery;

@RestController
public class ShippingDeliveryController {

    @Autowired
    private ShippingDeliveryRepository shippingDeliveryRepository;

    @GetMapping("/shipping")
    public ResponseEntity<Iterable<ShippingDelivery>> getShippingDeliveryinfo() {
        Iterable<ShippingDelivery> shipments = shippingDeliveryRepository.findAll();
        return new ResponseEntity<>(shipments, HttpStatus.OK);

    }

    @GetMapping("/shipment/{shipId}")
    public ResponseEntity<?> getShipment(@PathVariable(value = "shipId") Integer shipId) {

        Optional<ShippingDelivery> shipment = shippingDeliveryRepository.findByShippingID(shipId);
        if (shipment.isPresent()) {
            return new ResponseEntity<>(shipment, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>("shipment not Found", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/createShipment")
    ResponseEntity<?> createShipment(@RequestBody ShippingDelivery shippingDelivery) {
        try {
            ShippingDelivery shipment = shippingDeliveryRepository.save(shippingDelivery);
            return new ResponseEntity<>(shipment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/updateShipment/{id}")
    public ResponseEntity<?> updateShipment(@PathVariable("id") Integer id,
            @RequestBody ShippingDelivery shippingDelivery) {
        Optional<ShippingDelivery> shipment = shippingDeliveryRepository.findByShippingID(id);

        if (shipment.isPresent()) {
            ShippingDelivery shipmentData = shipment.get();
            shipmentData.setCartId(shippingDelivery.getCartId());
            shipmentData.setDeliveryDuration(shippingDelivery.getDeliveryDuration());
            shipmentData.setDestinationOfShipping(shippingDelivery.getDestinationOfShipping());
            shipmentData.setShippingCost(shippingDelivery.getShippingCost());
            shipmentData.setTypeOfShipping(shippingDelivery.getTypeOfShipping());

            return new ResponseEntity<>(shippingDeliveryRepository.save(shipmentData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delShipment/{id}")
    public ResponseEntity<HttpStatus> deleteShipment(@PathVariable("id") Integer id) {
        try {
            shippingDeliveryRepository.deleteByShippingID(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
