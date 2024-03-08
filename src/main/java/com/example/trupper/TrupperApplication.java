package com.example.trupper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.trupper.entities.Cliente;
import com.example.trupper.entities.Producto;
import com.example.trupper.repositories.ClienteRepository;
import com.example.trupper.repositories.ProductoRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class TrupperApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrupperApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner startup(ClienteRepository clienteRepository, ProductoRepository productoRepository) {
		return (args) -> {
			Cliente c1 = new Cliente();
			c1.setIdCliente(720010);
			c1.setNombre("Juan");
			c1.setActivo(1);
			clienteRepository.save(c1);
			
			Cliente c2 = new Cliente();
			c2.setIdCliente(710020);
			c2.setNombre("Juan");
			c2.setActivo(1);
			clienteRepository.save(c2);
			
			// Productos
			Producto p1 = new Producto();
			p1.setIdProducto(10200);
			p1.setClave("10200A");
			p1.setActivo(1);
			p1.setDescripcion("");
			productoRepository.save(p1);
			
			Producto p2 = new Producto();
			p2.setIdProducto(25020);
			p2.setClave("25020A");
			p2.setActivo(1);
			p2.setDescripcion("");
			productoRepository.save(p2);
			
			Producto p3 = new Producto();
			p3.setIdProducto(10170);
			p3.setClave("10170A");
			p3.setActivo(1);
			p3.setDescripcion("");
			productoRepository.save(p3);
			
			Producto p4 = new Producto();
			p4.setIdProducto(10280);
			p4.setClave("10280A");
			p4.setActivo(1);
			p4.setDescripcion("");
			productoRepository.save(p4);
			
			Producto p5 = new Producto();
			p5.setIdProducto(30001);
			p5.setClave("30001A");
			p5.setActivo(1);
			p5.setDescripcion("");
			productoRepository.save(p5);
			
			Producto p6 = new Producto();
			p6.setIdProducto(18156);
			p6.setClave("18156A");
			p6.setActivo(1);
			p6.setDescripcion("");
			productoRepository.save(p6);
			
			log.info(clienteRepository.findAll().toString());
			log.info(productoRepository.findAll().toString());
		};
	}
}
