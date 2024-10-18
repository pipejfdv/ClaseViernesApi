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
        return productos;//retorna todos lo elementos de la clase
    }
    //retornar un solo elemento
    public Optional<Producto> getProducto(UUID id) {
        //realiza una consulta lambda para buscar un elemento de acuerdo a su ID
        return productos.stream().filter(producto -> producto.getId().equals(id)).findFirst();
    }
    //crear elemento - se adiciona en la lista
    public UUID CrearProducto(Producto producto) {
        //genera un ID tipo UUID de manera aleatoia
        producto.setId(UUID.randomUUID());
        //agrega el elemento a la lista
        productos.add(producto);
        //retorna el id
        return producto.getId();
    }
    //actualizar elemento
    public Optional<Producto> actualizarProducto(UUID id, Producto productoActualizado) {
        //consulta si exite un elemento tipo producto y que tenga el id que se esta consultando
        Optional<Producto> existe = productos.stream().filter(producto -> producto.getId().equals(id)).findFirst();
        //si existe ejecutar la insersión
        existe.ifPresent(producto -> {
            producto.setNombreProducto(productoActualizado.getNombreProducto());
            producto.setCategoriaProducto(productoActualizado.getCategoriaProducto());
            producto.setPrecioProducto(productoActualizado.getPrecioProducto());
            producto.setCantidad(productoActualizado.getCantidad());
        });
        return existe;
    }
    //borrar el registro
    public void eliminarProducto(UUID id) {
        //consulta por ID y se le elimina
        productos.removeIf(producto -> producto.getId().equals(id));
    }
}
