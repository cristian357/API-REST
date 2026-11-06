package com.example.demo.controller;

import com.example.demo.Dto.ProductoDto;
import com.example.demo.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProdutoService productoService;

    public ProductoController(ProdutoService productoService) {
        this.productoService = productoService;
    }

    // CREATE - Guardar producto
    @PostMapping
    public ResponseEntity<ProductoDto> guardarProducto(@RequestBody ProductoDto productoDto) {
        ProductoDto guardado = productoService.guardarProducto(productoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    // READ ALL - Listar todos los productos
    @GetMapping
    public ResponseEntity<List<ProductoDto>> listarProductos() {
        List<ProductoDto> lista = productoService.lisProducto();
        return ResponseEntity.ok(lista);
    }

    // READ ONE - Buscar producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> buscarProductoPorId(@PathVariable long id) {
        ProductoDto producto = productoService.idProducto(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    // UPDATE - Actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> actualizarProducto(@PathVariable long id, @RequestBody ProductoDto productoDto) {
        ProductoDto actualizado = productoService.atualizarProducto(id, productoDto);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    // DELETE - Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable long id) {
        // Verificamos si existe antes de eliminar
        if (productoService.idProducto(id) == null) {
            return ResponseEntity.notFound().build();
        }
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}