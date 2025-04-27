package com.restuarent.restuarentservice.service;

import com.restuarent.restuarentservice.dto.RestaurantDto;
import com.restuarent.restuarentservice.entity.Restaurant;
import com.restuarent.restuarentservice.mapper.RestaurantMapper;
import com.restuarent.restuarentservice.repository.RestaurantRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

  @Autowired private RestaurantRepository restaurantRepository;

  public List<RestaurantDto> getAllRestaurant() {
    List<Restaurant> restaurants = restaurantRepository.findAll();
    // map it to list of DTOs
    return restaurants.stream()
        .map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO)
        .toList();
  }

  public ResponseEntity<RestaurantDto> getOneRestaurant(Integer id) {
    Optional<Restaurant> restaurant = restaurantRepository.findById(id);
    if (restaurant.isPresent()) {
      return new ResponseEntity<>(
          RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()),
              org.springframework.http.HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
    Restaurant restaurantSave =
        restaurantRepository.save(
            RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDto));
    return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurantSave);
  }
}
