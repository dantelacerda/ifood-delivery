package com.ifood.bestroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifood.bestroute.model.Cliente;
import com.ifood.bestroute.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> buscarTodosClientes() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> buscarClientePorId(Long id) {
		return clienteRepository.findById(id);
	}

	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}

	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.saveAndFlush(cliente);
	}


}
