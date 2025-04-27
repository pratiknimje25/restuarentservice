package com.restuarent.restuarentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

  private Integer id;
  private String name;
  private String city;
  private String address;
  private String restaurantDescription;
}
