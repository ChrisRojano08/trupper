package com.example.trupper.services;

import java.util.List;
import com.example.trupper.dto.Lista;
import com.example.trupper.entities.ListaCompraDetalle;

public interface ListaCompraDetalleService {
	public String insertarCompras(Lista lista);
	
	public String actualizarCompras(Lista lista);
	
	public List<Lista> obtenerComprasPorIdCliente(Integer id);
	
	public List<ListaCompraDetalle> obtenerComprasPorIdListaCompra(Integer id);
	
	public String eliminarCompras(Integer id);
}
