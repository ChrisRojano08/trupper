package com.example.trupper.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class ListaCompraDetalleKey implements Serializable {
	private ListaCompra listaCompra;
	private Producto producto;
}
