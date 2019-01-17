package com.ifood.bestroute.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifood.bestroute.model.Pedido;
import com.ifood.bestroute.service.PedidoService;

@RestController
@RequestMapping(path = "/pedido")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;

	@PostMapping("/salvarPedido")
	public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {

		return ResponseEntity.ok(pedidoService.savePedido(pedido));
	}

	@GetMapping(path = "/buscaPedidos")
	public ResponseEntity<List<Pedido>> buscaPedidos() {

		return ResponseEntity.ok(pedidoService.buscarTodosPedidos());
	}

	@GetMapping(path = "/buscaPedido/{id}")
	public ResponseEntity<Optional<Pedido>> buscaClientePorId(@PathVariable long id) {

		return ResponseEntity.ok(pedidoService.buscarPedidoPorId(id));
	}

	@GetMapping(path = "/buscaPedidoPorRestaurant")
	public ResponseEntity<Optional<Pedido>> buscaClientePorRestaurant(@RequestParam long restaurantId,
			@RequestParam(required = false) String delivery) {


		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		try {
			System.out.println(dateFormat.parse(delivery));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
//		return ResponseEntity.ok(pedidoService.buscaPedidoPorRestaurantIdDelivery(restaurantId, inputDate));
	}

	@PutMapping("/atualizaPedido/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Pedido pedido, @PathVariable long id) {

		Optional<Pedido> pedidoOptional = pedidoService.buscarPedidoPorId(id);

		if (!pedidoOptional.isPresent())
			return ResponseEntity.notFound().build();

		pedido.setPedidoId(id);
		pedidoService.savePedido(pedido);

		return ResponseEntity.noContent().build();
	}

}
