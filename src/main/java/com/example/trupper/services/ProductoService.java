package com.example.trupper.services;

import java.util.List;

import com.example.trupper.entities.Producto;

public interface ProductoService {
	public List<Producto> obtenerTodos();
	
	public Producto insertar(Producto producto);
}
