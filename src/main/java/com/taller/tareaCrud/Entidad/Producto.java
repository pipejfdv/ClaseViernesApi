package com.taller.tareaCrud.Entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
//libreria para permite ahorrar código para crear los métodos de get y set
@Data
//permite crear el constructor de la tabla con todos los parametros
@AllArgsConstructor
@Getter
@Setter
public class Producto {
    private UUID id;//Id del producto
    private String nombreProducto;//nombre del producto
    private String categoriaProducto;//categoria del producto
    private double precioProducto;//precio del producto
    private int cantidad;//cantidad del producto
}
