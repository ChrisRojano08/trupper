package com.example.trupper.dto;

import lombok.Data;

@Data
public class ProductoDetalle {
	private Integer idProducto;
	private Integer cantidad;
	
	public ProductoDetalle(Integer idProducto, Integer cantidad) {
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
}
