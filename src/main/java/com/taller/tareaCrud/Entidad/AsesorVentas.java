package com.taller.tareaCrud.Entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
public class AsesorVentas {
    private UUID idAsesor;
    private String nombre;
    private String apellido;
    private String cargo;
    private float salario;
}
