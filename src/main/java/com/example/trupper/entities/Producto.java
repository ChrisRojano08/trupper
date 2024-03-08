package com.example.trupper.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Producto {
	@Id
	private Integer idProducto;
	
	private String clave;
	
	private String descripcion;
	
	private Integer activo;
}
