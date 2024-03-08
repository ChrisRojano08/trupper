package com.example.trupper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trupper.entities.Producto;
import com.example.trupper.services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private ProductoService prodcutoService;
	
	@GetMapping("/obtenerTodos")
	public List<Producto> obtenerTodos(){
		return prodcutoService.obtenerTodos();
	}
	
	@PostMapping("/insertar")
	public Producto insertar(@RequestBody Producto producto) {
		return prodcutoService.insertar(producto);
	}
}
