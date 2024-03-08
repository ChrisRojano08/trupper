package com.example.trupper.services;

import java.util.List;

import com.example.trupper.entities.Cliente;

public interface ClienteService {
	public Cliente insertar(Cliente cliente);
	public List<Cliente> obtenerTodos();
}
