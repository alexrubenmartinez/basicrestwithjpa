package com.alexm.apirest.apirest.Controllers;

import com.alexm.apirest.apirest.Entities.Producto;
import com.alexm.apirest.apirest.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }
    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoRepository.findById(id).
                orElseThrow(()->new RuntimeException("No se encontró el producto con el id: "+id));
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id,@RequestBody Producto productoNuevo) {
        Producto producto   = productoRepository.findById(id).orElseThrow(()->new RuntimeException("No se encontró el producto con el id: "+id));

        producto.setNombre(productoNuevo.getNombre());
        producto.setPrecio(productoNuevo.getPrecio());

        return productoRepository.save(productoNuevo);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id) {
        Producto producto   = productoRepository.findById(id).orElseThrow(()->new RuntimeException("No se encontró el producto con el id: "+id));
        productoRepository.delete(producto);
        return "El producto con el ID: "+id+" ha sido eliminado";
    }


}
