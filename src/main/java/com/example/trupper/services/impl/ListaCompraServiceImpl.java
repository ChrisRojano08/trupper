package com.example.trupper.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.trupper.entities.ListaCompra;
import com.example.trupper.repositories.ListaCompraRepository;
import com.example.trupper.services.ListaCompraService;

public class ListaCompraServiceImpl implements ListaCompraService {
	@Autowired
	private ListaCompraRepository listaCompraRepository;
	
	@Override
	public List<ListaCompra> obtenerComprasPorIdListaCompra(Integer id) {
		return listaCompraRepository.findAll().stream().filter(compra -> compra.getCustomerId().getIdCliente().equals(id)).collect(Collectors.toList());
	}
	
}
