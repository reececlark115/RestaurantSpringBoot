package com.tts.restaraunt.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.restaraunt.models.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{

}
