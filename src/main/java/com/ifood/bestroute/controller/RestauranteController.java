package com.ifood.bestroute.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifood.bestroute.model.Restaurant;
import com.ifood.bestroute.service.RestaurantService;

@RestController
@RequestMapping(path = "/restaurant")
public class RestauranteController {

	@Autowired
	RestaurantService restaurantService;

	@PostMapping("/salvarRestaurant")
	public ResponseEntity<Restaurant> salvarRestaurant(@RequestBody Restaurant restaurant) {

		System.out.println(restaurant.getNome());
		return ResponseEntity.ok(restaurantService.saveRestaurant(restaurant));
	}

	@GetMapping(path = "/buscaRestaurants")
	public ResponseEntity<List<Restaurant>> buscaRestaurants() {

		return ResponseEntity.ok(restaurantService.buscarTodosRestaurants());
	}

	@GetMapping(path = "/buscaRestaurant/{id}")
	public ResponseEntity<Optional<Restaurant>> buscaClientePorId(@PathVariable long id) {

		return ResponseEntity.ok(restaurantService.buscarRestaurantPorId(id));
	}

	@PutMapping("/atualizaRestaurant/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Restaurant restaurant, @PathVariable long id) {

		Optional<Restaurant> restaurantOptional = restaurantService.buscarRestaurantPorId(id);

		if (!restaurantOptional.isPresent())
			return ResponseEntity.notFound().build();

		restaurant.setRestaurantId(id);
		;
		restaurantService.saveRestaurant(restaurant);

		return ResponseEntity.noContent().build();
	}

}
