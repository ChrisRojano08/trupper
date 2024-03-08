package com.example.trupper.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trupper.dto.Lista;
import com.example.trupper.dto.ProductoDetalle;
import com.example.trupper.entities.Cliente;
import com.example.trupper.entities.ListaCompra;
import com.example.trupper.entities.ListaCompraDetalle;
import com.example.trupper.entities.Producto;
import com.example.trupper.repositories.ClienteRepository;
import com.example.trupper.repositories.ListaCompraDetalleRepository;
import com.example.trupper.repositories.ListaCompraRepository;
import com.example.trupper.repositories.ProductoRepository;
import com.example.trupper.services.ListaCompraDetalleService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ListaCompraDetalleServiceImpl implements ListaCompraDetalleService {

	@Autowired
	private ListaCompraRepository listaCompraRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private ListaCompraDetalleRepository listaCompraDetalleRepository;

	@Override
	@Transactional
	public String insertarCompras(Lista lista) {
		ListaCompra listaCompra = new ListaCompra();
		Cliente cliente = clienteRepository.findById(lista.getIdCliente()).orElse(null);

		if (cliente != null) {
			listaCompra.setNombre(lista.getNombreLista());
			listaCompra.setFechaRegistro(new Date());
			listaCompra.setFechaUltimaActualizacion(new Date());
			listaCompra.setCustomerId(cliente);
			listaCompra.setActivo(1);

			final ListaCompra listaCompraSaved = listaCompraRepository.save(listaCompra);

			lista.getProductos().stream().forEach(prod -> {
				ListaCompraDetalle listaDetalle = new ListaCompraDetalle();
				listaDetalle.setCantidad(prod.getCantidad());

				Producto producto = productoRepository.findById(prod.getIdProducto()).orElse(null);

				if (producto == null) {
					log.error("No existe un cliente con id: " + prod.getIdProducto());
				}

				listaDetalle.setProducto(producto);
				listaDetalle.setCantidad(prod.getCantidad());
				listaDetalle.setListaCompra(listaCompraSaved);

				listaCompraDetalleRepository.save(listaDetalle);
			});
		} else {
			return "No existe un cliente con id: " + lista.getIdCliente();
		}

		return "Compra insertada con exito";
	}
	
	@Override
	@Transactional
	public String actualizarCompras(Lista lista) {
		ListaCompra listaCompra = listaCompraRepository.findById(lista.getIdListaCompra()).orElse(null);
		
		if(listaCompra != null) {
			
			for(ProductoDetalle prod: lista.getProductos()){
				ListaCompraDetalle listaDetalleCompra = listaCompraDetalleRepository.obtenerPorIdCompraIdProducto(
						listaCompra.getIdListaCompra(), prod.getIdProducto());
				
				if(listaDetalleCompra == null){
					listaDetalleCompra = new ListaCompraDetalle();
					
					listaDetalleCompra.setProducto(productoRepository.findById(prod.getIdProducto()).orElse(null));
					listaDetalleCompra.setListaCompra(listaCompra);
				}
				
				listaDetalleCompra.setCantidad(prod.getCantidad());
				listaCompraDetalleRepository.save(listaDetalleCompra);
			}
			
		}else {
			return "No existe una compra con el id: "+lista.getIdListaCompra();
		}
		
		return "Compra actualizada correctamente.";
	}

	@Override
	@Transactional
	public List<Lista> obtenerComprasPorIdCliente(Integer id) {
		List<Lista> compras = new ArrayList<>();
		
		List<ListaCompra> listaCompras = listaCompraRepository.findAll()
				.stream()
				.filter(compra -> compra.getCustomerId().getIdCliente().equals(id))
				.collect(Collectors.toList());
		
		for (ListaCompra lista : listaCompras) {
			Lista listaN = new Lista();
			listaN.setNombreLista(lista.getNombre());
			listaN.setIdCliente(lista.getCustomerId().getIdCliente());
			listaN.setIdListaCompra(lista.getIdListaCompra());
			
			List<ProductoDetalle> prods = new ArrayList<>();
			List<ListaCompraDetalle> comprasListaDetalle = obtenerComprasPorIdListaCompra(lista.getIdListaCompra());
			for(ListaCompraDetalle listaDetalle : comprasListaDetalle) {
				prods.add(new ProductoDetalle(listaDetalle.getProducto().getIdProducto(), listaDetalle.getCantidad()) );
			}
			listaN.setProductos(prods);
			
			compras.add(listaN);
		}
		
		return compras;
	}
	
	@Override
	@Transactional
	public String eliminarCompras(Integer id) {
		ListaCompra listaCompra = listaCompraRepository.findById(id).orElse(null);
		
		if(listaCompra != null) {
			List<ListaCompraDetalle> listaCompraDetalle = obtenerComprasPorIdListaCompra(id);
			
			for(ListaCompraDetalle listaBorrar : listaCompraDetalle) {
				listaCompraDetalleRepository.delete(listaBorrar);
				listaCompraDetalleRepository.flush();
			}
			
			listaCompraRepository.delete(listaCompra);
		}else {
			return "No existe una compra con el id: "+id;
		}
		
		return "Compras borradas exitosamente";
	}

	@Override
	@Transactional
	public List<ListaCompraDetalle> obtenerComprasPorIdListaCompra(Integer id) {
		return listaCompraDetalleRepository.findAll()
				.stream()
				.filter( lista -> lista.getListaCompra().getIdListaCompra().equals(id))
				.collect(Collectors.toList());
	}
}








