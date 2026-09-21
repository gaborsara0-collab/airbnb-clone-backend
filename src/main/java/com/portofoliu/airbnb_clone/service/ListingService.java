package com.portofoliu.airbnb_clone.service;
import com.portofoliu.airbnb_clone.model.Listing;
import com.portofoliu.airbnb_clone.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListingService {

    @Autowired
    private final ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository)
    {
        this.listingRepository=listingRepository;
    }

    //metoda pentru a extrage toate apartamentele
    public List<Listing> getAllListings()
    {
        return listingRepository.findAll();
    }

    //metoda pentru adaugare apartament
    public Listing addListing(Listing listing)
    {
        return listingRepository.save(listing);
    }

    public boolean deleteListing(Long id) {
        if (listingRepository.existsById(id)) {
            listingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //metoda pentru editare
    public Listing updateListing(Long id,Listing updateData)
    {
        return listingRepository.findById(id).map(listing -> {
            listing.setName(updateData.getName());
            listing.setNeighborhood(updateData.getNeighborhood());
            listing.setPrice(updateData.getPrice());
            return listingRepository.save(listing);
        }).orElse(null);
    }
}
