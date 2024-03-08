package com.example.trupper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trupper.dto.Lista;
import com.example.trupper.services.ListaCompraDetalleService;

@RestController
@RequestMapping("/compras")
public class ListaCompraDetalleController {
	@Autowired
	private ListaCompraDetalleService listaCompraDetalleService;
	
	@PostMapping("/insertar")
	public String insertar(@RequestBody Lista lista) {
		return listaCompraDetalleService.insertarCompras(lista);
	}
	
	@PutMapping("/actualizar")
	public String actualizar(@RequestBody Lista lista) {
		return listaCompraDetalleService.actualizarCompras(lista);
	}
	
	@GetMapping("/obtenerTodas/{id}")
	public List<Lista> obtenerTodas(@PathVariable Integer id) {
		return listaCompraDetalleService.obtenerComprasPorIdCliente(id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Integer id) {
		return listaCompraDetalleService.eliminarCompras(id);
	}
}
