package com.booking.recruitment.hotel.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.booking.recruitment.hotel.dto.HotelDto;
import com.booking.recruitment.hotel.model.City;
import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.service.CityService;
import com.booking.recruitment.hotel.service.HotelService;
import com.booking.recruitment.hotel.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class DefaultSearchService implements SearchService {
    public final double R = 6372.8;
    private final HotelService hotelService;
    private final CityService cityService;

    @Autowired
    DefaultSearchService(HotelService hotelService, CityService cityService) {
        this.hotelService = hotelService;
        this.cityService = cityService;
    }


    @Override
    public List<HotelDto> findNearestHotelForCity(Integer cityId) {
        City city = cityService.getCityById(Long.valueOf(cityId));
        return hotelService.getAllHotels().stream()
                .map(Hotel::toDto)
                .peek(hotel -> hotel.setDistance(distanceInKm(city.getCityCentreLatitude(), city.getCityCentreLongitude(),
                        hotel.getCity().getCityCentreLatitude(), hotel.getCity().getCityCentreLongitude())))
                .sorted(Comparator.comparingDouble(HotelDto::getDistance))
                .limit(3)
                .collect(Collectors.toList());
    }


    public double distanceInKm(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }

}
