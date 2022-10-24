package com.booking.recruitment.hotel.service;

import java.util.List;

import com.booking.recruitment.hotel.dto.HotelDto;

public interface SearchService {

  List<HotelDto> findNearestHotelForCity(Integer cityId);
}
