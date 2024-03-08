package com.example.trupper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trupper.entities.Cliente;
import com.example.trupper.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService; 
	
	@PostMapping("/agregar")
	public Cliente agregar(@RequestBody Cliente cliente) {
		return clienteService.insertar(cliente);
	}
	
	@GetMapping("/obtenerTodos")
	public List<Cliente> obtenerTodos() {
		return clienteService.obtenerTodos();
	}
}
