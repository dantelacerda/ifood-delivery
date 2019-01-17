package com.ifood.bestroute.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ifood.bestroute.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Query("From pedido where restaurantId = ?1 and delivery = ?2")
	public Optional<Pedido> buscaPedidoPorRestaurantIdDelivery(Long idRestaurant, Date data);

	@Query("From pedido where nome like %?1%")
	public List<Pedido> buscaPedidoPorNome(String nome);
}
