package com.example.trupper.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ListaCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idListaCompra;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "idCliente")
	private Cliente customerId;
	
	private String nombre;
	
	private Date fechaRegistro;
	
	private Date fechaUltimaActualizacion;
	
	private Integer activo;
}
