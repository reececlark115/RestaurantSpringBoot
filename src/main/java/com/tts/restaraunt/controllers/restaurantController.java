package com.tts.restaraunt.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.restaraunt.models.Restaurant;
import com.tts.restaraunt.repository.RestaurantRepository;

@Controller
public class restaurantController {

	@Autowired
	RestaurantRepository restaurantRepository;
	
	private static List<Restaurant> restaurants = new ArrayList<>();
	
		@GetMapping(value="/")
public String index(Restaurant restaurant, Model model) {
			restaurants = (List<Restaurant>) restaurantRepository.findAll();
				model.addAttribute("restaurants", restaurants);
			return "restaurant/index";
			}
		@GetMapping(value="/new")
public String newPage(Restaurant restaurant) {
				return "restaurant/new";
		}
		@PostMapping(value="/new")
		public String addNew(Restaurant restaurant, Model model) {
		restaurantRepository.save(restaurant);
			
		model.addAttribute("owner", restaurant.getOwner());
		model.addAttribute("name", restaurant.getName());
		model.addAttribute("phoneNumber", restaurant.getPhoneNumber());
		model.addAttribute("address", restaurant.getAddress());
		return "restaurant/result";
		}	
		}
		