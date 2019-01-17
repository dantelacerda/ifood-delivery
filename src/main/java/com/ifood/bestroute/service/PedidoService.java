package com.ifood.bestroute.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifood.bestroute.model.Pedido;
import com.ifood.bestroute.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> buscarTodosPedidos() {
		return pedidoRepository.findAll();
	}

	public Optional<Pedido> buscarPedidoPorId(Long id) {
		return pedidoRepository.findById(id);
	}

	public Optional<Pedido> buscaPedidoPorRestaurantIdDelivery(Long idRestaurant, Date inputDate) {
		return pedidoRepository.buscaPedidoPorRestaurantIdDelivery(idRestaurant, inputDate);
	}

	public void deletePedido(Long id) {
		pedidoRepository.deleteById(id);
	}

	public Pedido savePedido(Pedido pedido) {
		return pedidoRepository.saveAndFlush(pedido);
	}

}
