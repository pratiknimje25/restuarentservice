package com.restuarent.restuarentservice.mapper;

import com.restuarent.restuarentservice.dto.RestaurantDto;
import com.restuarent.restuarentservice.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

  RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

  Restaurant mapRestaurantDTOToRestaurant(RestaurantDto dto);

  RestaurantDto mapRestaurantToRestaurantDTO(Restaurant restaurant);
}
