package com.ifood.bestroute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ifood.bestroute.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	@Query("From restaurant where nome like %?1% and id = ?2")
	public List<Restaurant> buscaRestaurantPorNomeId(String nome, Long id);

	@Query("From restaurant where nome like %?1%")
	public List<Restaurant> buscaRestaurantPorNome(String nome);
}
