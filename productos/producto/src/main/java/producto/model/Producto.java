package producto.model;

import java.math.BigDecimal;

public class Producto {
	private long codigo;
	private String nombre;
	private String  Descripcion;
 	private BigDecimal Precio;
 	public Producto() {}
 	
 	public Producto(Long codigo, String nombre, String descripcion, BigDecimal precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.Descripcion = descripcion;
        this.Precio = precio;
    }
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public BigDecimal getPrecio() {
		return Precio;
	}
	public void setPrecio(BigDecimal precio) {
		Precio = precio;
	}
}
