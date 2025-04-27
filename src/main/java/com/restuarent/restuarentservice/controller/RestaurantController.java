package com.restuarent.restuarentservice.controller;

import com.restuarent.restuarentservice.dto.RestaurantDto;
import com.restuarent.restuarentservice.entity.Restaurant;
import com.restuarent.restuarentservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

  @Autowired private RestaurantService service;

  @GetMapping("/fetch-all")
  public ResponseEntity<List<RestaurantDto>> fetchAllRestaurant() {
    return ResponseEntity.ok(service.getAllRestaurant());
  }

  @GetMapping("/fetchById/{id}")
  public ResponseEntity<RestaurantDto> getOneRestaurant(@PathVariable Integer id) {
    return service.getOneRestaurant(id);
  }

  @PostMapping("/save-restaurant")
  public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto) {
    RestaurantDto restaurantDto1 = service.addRestaurant(restaurantDto);
    return new ResponseEntity<>(restaurantDto1, HttpStatus.CREATED);
  }
}
