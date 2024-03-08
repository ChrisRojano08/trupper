package com.example.trupper.dto;

import java.util.List;

import lombok.Data;

@Data
public class Lista {
	private Integer idListaCompra;
	private Integer idCliente;
	private String nombreLista;
	private List<ProductoDetalle> productos;
}
