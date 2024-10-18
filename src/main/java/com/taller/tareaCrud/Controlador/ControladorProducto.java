package com.taller.tareaCrud.Controlador;

import com.taller.tareaCrud.Entidad.Producto;
import com.taller.tareaCrud.ProductService.ServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/apiCRUD/v1/toyStory")
public class ControladorProducto {
    @Autowired
    private ServiceProducto serviceProducto;

    //servicio de lista de productos
    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return serviceProducto.getProductos();
    }
    //traer un solo elemento
    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable UUID id) {
        return serviceProducto.getProducto(id)
                .map(producto -> producto.getId().equals(id) ? producto : null)
                .orElse(null);
    }
    //crear un elemento
    @PostMapping
    public ResponseEntity<String> createProducto(@RequestBody Producto producto) {
        UUID productoID = serviceProducto.CrearProducto(producto);
        return ResponseEntity.created(URI.create("/apiCRUD/v1/toyStory/" + productoID)).body("Juguete creado");
    }
    //actualizar elemento
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProducto(@PathVariable UUID id, @RequestBody Producto producto) {
        Optional<Producto> actualizar = serviceProducto.actualizarProducto(id, producto);
        return ResponseEntity.ok().body("actualizado");
    }
    //eleminar elemento
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable UUID id) {
        serviceProducto.eliminarProducto(id);
    }
}
