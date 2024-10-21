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
public class Ventas {
    private UUID id;
    private String nombreProducto;
    private int cantidad;
    private float valor;
    private int ccCliente;
}
