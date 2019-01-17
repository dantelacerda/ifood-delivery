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

import com.ifood.bestroute.model.Cliente;
import com.ifood.bestroute.service.ClienteService;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@PostMapping("/salvarCliente")
	public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {

		System.out.println(cliente.getNome());
		return ResponseEntity.ok(clienteService.saveCliente(cliente));
	}

	@GetMapping(path = "/buscaClientes")
	public ResponseEntity<List<Cliente>> buscaClientes() {

		return ResponseEntity.ok(clienteService.buscarTodosClientes());
	}
	
	@GetMapping(path = "/buscaCliente/{id}")
	public ResponseEntity<Optional<Cliente>> buscaClientePorId(@PathVariable long id) {

		return ResponseEntity.ok(clienteService.buscarClientePorId(id));
	}

	@PutMapping("/atualizaCliente/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Cliente cliente, @PathVariable long id) {

		Optional<Cliente> clienteOptional = clienteService.buscarClientePorId(id);

		if (!clienteOptional.isPresent())
			return ResponseEntity.notFound().build();

		cliente.setClienteId(id);
		clienteService.saveCliente(cliente);

		return ResponseEntity.noContent().build();
	}

}
