package com.example.trupper.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cliente {
	@Id
	private Integer idCliente;
	
	private String nombre;
	
	private Integer activo;
}
