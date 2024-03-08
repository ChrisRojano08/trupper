package com.example.trupper.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trupper.entities.Producto;
import com.example.trupper.repositories.ProductoRepository;
import com.example.trupper.services.ProductoService;

import jakarta.transaction.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	@Transactional
	public List<Producto> obtenerTodos() {
		return productoRepository.findAll();
	}

	@Override
	@Transactional
	public Producto insertar(Producto producto) {
		return productoRepository.save(producto);
	}
	
	
}
