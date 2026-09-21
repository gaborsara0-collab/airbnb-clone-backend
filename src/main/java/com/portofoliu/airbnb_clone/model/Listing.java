package com.portofoliu.airbnb_clone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private String hostname;
    private Double price;
    private String neighborhoodGroup;
    private String neighborhood;
    private String roomType;
    private Integer beds;
    private Integer baths;

    private Integer numberOfReviews;
    private Double rating;
    private Integer availability365;


    public Listing()
    {

    }
    public Listing(String name, Double price, String neighborhood)
    {
        this.name=name;
        this.price=price;
        this.neighborhood=neighborhood;

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id)
    {
        this.id=id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice()
    {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNeighborhood()
    {
        return neighborhood;
    }
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getNeighborhoodGroup() {
        return neighborhoodGroup;
    }

    public void setNeighborhoodGroup(String neighborhoodGroup) {
        this.neighborhoodGroup = neighborhoodGroup;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getBaths() {
        return baths;
    }

    public void setBaths(Integer baths) {
        this.baths = baths;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getAvailability365() {
        return availability365;
    }

    public void setAvailability365(Integer availability365) {
        this.availability365 = availability365;
    }
    public String getName() {
        if (this.name == null) return null;
        // Înlocuim secvența greșită generată de UTF-8 citit ca Latin-1
        return this.name.replace("Â·", "·").replace("Ã¢â¬â", "-");
    }
}
