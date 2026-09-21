package com.portofoliu.airbnb_clone.controller;

import com.portofoliu.airbnb_clone.model.Listing;
import com.portofoliu.airbnb_clone.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
@RequestMapping("/api/listings")
@CrossOrigin(origins = "http://localhost:3000")
public class ListingController {

    @Autowired
    private final ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping
    public List<Listing> getAllListings() {
        return listingService.getAllListings();
    }

    @PostMapping
    public ResponseEntity<Listing> createListing(@RequestBody Listing listing) {
        Listing savedListing = listingService.addListing(listing);
        return ResponseEntity.ok(savedListing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListing(@PathVariable Long id) {
        boolean deleted = listingService.deleteListing(id);

        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Listing> updateListing(@PathVariable Long id, @RequestBody Listing listing) {
        Listing updatedListing = listingService.updateListing(id, listing);
        if (updatedListing != null) {
            return ResponseEntity.ok(updatedListing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
