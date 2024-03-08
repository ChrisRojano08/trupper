package com.example.trupper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trupper.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
