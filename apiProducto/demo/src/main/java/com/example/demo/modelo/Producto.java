package com.example.demo.modelo;
import java.math.BigDecimal;

import jakarta.persistence.*;


@Entity
@Table(name="producto")
public class Producto {
	@Id
	private long codigo;
	
	@Column(nullable = false,length = 100)
	private String nombre;
	
	@Column(length = 200)
	private String  descripcion;
	
	@Column(precision = 10 ,scale = 2 )
 	private BigDecimal precio;
	
	
	//set y get codigo
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo=codigo;
	}
	//set y get nombre
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	//set y get Descripción
	public String getDescricion() {
		return descripcion;
	}
	public void setDescricion(String Descricion) {
		this.descripcion=Descricion;
	}
	//set y get Precio
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecion(BigDecimal precio) {
		this.precio=precio;
	}
	
	
	
}
