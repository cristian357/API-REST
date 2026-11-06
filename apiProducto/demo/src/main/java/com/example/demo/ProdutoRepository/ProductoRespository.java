package com.example.demo.ProdutoRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Producto;

public interface ProductoRespository  extends JpaRepository<Producto,Long>{

}
