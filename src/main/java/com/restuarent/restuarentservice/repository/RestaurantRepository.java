package com.restuarent.restuarentservice.repository;

import com.restuarent.restuarentservice.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {}
