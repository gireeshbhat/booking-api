package com.booking.recruitment.hotel.model.mapper;

import com.booking.recruitment.hotel.dto.HotelDto;
import com.booking.recruitment.hotel.model.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    HotelDto toHotelDto(Hotel hotel);
}
