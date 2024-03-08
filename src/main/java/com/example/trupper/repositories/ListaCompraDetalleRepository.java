package com.example.trupper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trupper.entities.ListaCompraDetalle;
import com.example.trupper.entities.ListaCompraDetalleKey;

@Repository
public interface ListaCompraDetalleRepository extends JpaRepository<ListaCompraDetalle, ListaCompraDetalleKey> {
	public ListaCompraDetalle obtenerPorIdCompraIdProducto(Integer idProducto, Integer idListaCompra);
}
