package com.example.trupper.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trupper.entities.Cliente;
import com.example.trupper.repositories.ClienteRepository;
import com.example.trupper.services.ClienteService;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	@Transactional
	public Cliente insertar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public List<Cliente> obtenerTodos() {
		return clienteRepository.findAll();
	}

}
