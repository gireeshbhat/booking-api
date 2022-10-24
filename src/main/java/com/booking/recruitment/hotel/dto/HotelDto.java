package com.booking.recruitment.hotel.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.booking.recruitment.hotel.model.City;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.repository.cdi.CdiRepositoryExtensionSupport;

public class HotelDto implements Serializable {

    private Long id;
    private String name;
    private Double rating;
    private City city;
    private String address;
    private double latitude;
    private double longitude;

    private double distance;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public HotelDto(Long id, String name, Double rating, City city, String address, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.city = city;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelDto)) return false;
        HotelDto hotelDto = (HotelDto) o;
        return Double.compare(hotelDto.latitude, latitude) == 0 && Double.compare(hotelDto.longitude, longitude) == 0 && Objects.equals(id, hotelDto.id) && Objects.equals(name, hotelDto.name) && Objects.equals(rating, hotelDto.rating) && Objects.equals(city, hotelDto.city) && Objects.equals(address, hotelDto.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rating, city, address, latitude, longitude);
    }


}
