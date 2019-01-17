package com.ifood.bestroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifood.bestroute.model.Restaurant;
import com.ifood.bestroute.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	public List<Restaurant> buscarTodosRestaurants() {
		return restaurantRepository.findAll();
	}

	public Optional<Restaurant> buscarRestaurantPorId(Long id) {
		return restaurantRepository.findById(id);
	}

	public void deleteRestaurant(Long id) {
		restaurantRepository.deleteById(id);
	}

	public Restaurant saveRestaurant(Restaurant restaurant) {
		return restaurantRepository.saveAndFlush(restaurant);
	}

}
