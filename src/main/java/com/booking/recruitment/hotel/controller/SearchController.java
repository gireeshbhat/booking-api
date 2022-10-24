package com.booking.recruitment.hotel.controller;

import java.util.List;

import com.booking.recruitment.hotel.dto.HotelDto;
import com.booking.recruitment.hotel.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
  private final SearchService searchService;

  @Autowired
  public SearchController(SearchService searchService) {
    this.searchService = searchService;
  }

  @GetMapping("/{cityId}")
  public List<HotelDto> getNearestCity(@PathVariable Integer cityId, @RequestParam String sortBy) {
    // Ignoring sortBy for now just because it doesn't have anh other values that distance
    return searchService.findNearestHotelForCity(cityId);
  }

}
