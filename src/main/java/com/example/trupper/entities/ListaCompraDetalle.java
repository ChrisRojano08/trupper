package com.example.trupper.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Entity
@IdClass(ListaCompraDetalleKey.class)
@Data
@NamedQuery(name = "ListaCompraDetalle.obtenerPorIdCompraIdProducto",
	query = "SELECT lcd FROM ListaCompraDetalle lcd WHERE lcd.producto.idProducto=:idProducto AND lcd.listaCompra.idListaCompra=:idListaCompra")
public class ListaCompraDetalle {
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idListaCompra", referencedColumnName = "idListaCompra")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ListaCompra listaCompra;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCodigoProducto", referencedColumnName = "idProducto")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Producto producto;
	
	private Integer cantidad;
}
