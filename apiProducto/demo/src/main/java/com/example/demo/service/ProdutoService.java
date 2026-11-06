package com.example.demo.service;

import com.example.demo.modelo.Producto;
import com.example.demo.ProdutoRepository.ProductoRespository;
import com.example.demo.Dto.ProductoDto;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

	private final ProductoRespository productoRespository;

	public ProdutoService(ProductoRespository p) {
		this.productoRespository = p;
	}

	
	public ProductoDto convertToDto(Producto p) {
		ProductoDto dto = new ProductoDto();
		dto.setCodigo(p.getCodigo());
		dto.setNombre(p.getNombre());
		dto.setDescripcion(p.getDescricion());   
		dto.setPrecio(p.getPrecio());
		return dto;
	}

	
	public Producto converEntity(ProductoDto dto) {
		Producto p = new Producto();
		p.setCodigo(dto.getCodigo());
		p.setNombre(dto.getNombre());
		p.setDescricion(dto.getDescripcion());   
		p.setPrecion(dto.getPrecio());             
		return p;
	}

	
	public ProductoDto guardarProducto(ProductoDto dto) {
		Producto p = converEntity(dto);
		Producto guardado = productoRespository.save(p);
		return convertToDto(guardado);
	}

	// lista de los productos
	public List<ProductoDto> lisProducto() {
		List<ProductoDto> lisDto = new ArrayList<>();
		for (Producto p : productoRespository.findAll()) {
			lisDto.add(convertToDto(p));
		}
		return lisDto;
	}

	// buscar producto por id
	public ProductoDto idProducto(long id) {
		Producto p = productoRespository.findById(id).orElse(null);
		if (p == null) {
			return null;
		}
		return convertToDto(p);
	}

	// borrar producto
	public void eliminarProducto(long id) {
		productoRespository.deleteById(id);
	}

	// actualizar
	public ProductoDto atualizarProducto(long id, ProductoDto pDto) {
		Producto p = productoRespository.findById(id).orElse(null);
		if (p == null) {
			return null;
		}
		p.setNombre(pDto.getNombre());
		p.setDescricion(pDto.getDescripcion());  
		p.setPrecion(pDto.getPrecio());            

		Producto actualizado = productoRespository.save(p);
		return convertToDto(actualizado);
	}
}