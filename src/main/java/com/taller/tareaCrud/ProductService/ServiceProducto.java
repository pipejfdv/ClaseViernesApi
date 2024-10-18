package com.taller.tareaCrud.ProductService;

import com.taller.tareaCrud.Entidad.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceProducto {
    //declarar lista
    private List<Producto> productos;

    //agregar contenido a la lista
    public ServiceProducto() {
        productos = new ArrayList<>();
        productos.add(new Producto(UUID.randomUUID(), "Buzz Lightyear", "Espacio", 26.80, 3));
        productos.add(new Producto(UUID.randomUUID(), "Woody", "Vaquero", 24.50, 5));
        productos.add(new Producto(UUID.randomUUID(), "Jessie", "Vaquera", 22.30, 4));
        productos.add(new Producto(UUID.randomUUID(), "Rex", "Dinosaurio", 18.75, 2));
        productos.add(new Producto(UUID.randomUUID(), "Hamm", "Cerdito", 15.60, 3));
        productos.add(new Producto(UUID.randomUUID(), "Mr. Potato Head", "Papa", 20.00, 4));
        productos.add(new Producto(UUID.randomUUID(), "Slinky Dog", "Perro", 19.90, 3));
        productos.add(new Producto(UUID.randomUUID(), "Bo Peep", "Pastora", 21.40, 4));
        productos.add(new Producto(UUID.randomUUID(), "Forky", "Tenedor", 12.00, 1));

    }

    //servicio para traer todos los datos
    public List<Producto> getProductos() {
        return productos;
    }
    //retornar un solo elemento
    public Optional<Producto> getProducto(UUID id) {
        return productos.stream().filter(producto -> producto.getId().equals(id)).findFirst();
    }
    //crear elemento - se adiciona en la lista
    public UUID CrearProducto(Producto producto) {
        producto.setId(UUID.randomUUID());
        productos.add(producto);
        return producto.getId();
    }
    //actualizar elemento
    public Optional<Producto> actualizarProducto(UUID id, Producto productoActualizado) {
        Optional<Producto> existe = productos.stream().filter(producto -> producto.getId().equals(id)).findFirst();
        existe.ifPresent(producto -> {
            producto.setNombreProducto(productoActualizado.getNombreProducto());
            producto.setCategoriaProducto(productoActualizado.getCategoriaProducto());
            producto.setPrecioProducto(productoActualizado.getPrecioProducto());
            producto.setCantidad(productoActualizado.getCantidad());
        });
        return existe;
    }

    public void eliminarProducto(UUID id) {
        productos.removeIf(producto -> producto.getId().equals(id));
    }
}
