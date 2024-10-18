package com.taller.tareaCrud.Entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Producto {
    private UUID id;
    private String nombreProducto;
    private String categoriaProducto;
    private double precioProducto;
    private int cantidad;
}
