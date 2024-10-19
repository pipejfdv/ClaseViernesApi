package com.taller.tareaCrud.ProductService;

import com.taller.tareaCrud.Entidad.AsesorVentas;
import com.taller.tareaCrud.Entidad.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceAsesorVentas {
    private List<AsesorVentas> asesorVentas;

    public ServiceAsesorVentas() {
        asesorVentas = new ArrayList();
        asesorVentas.add(new AsesorVentas(UUID.randomUUID(), "Luisa","Echeverri","asesor",1300));
    }

    public List<AsesorVentas> getAsesorVentas() {
        return asesorVentas;
    }

    public Optional<AsesorVentas> getAsesorVentasById(UUID id) {
        return asesorVentas.stream().filter( asesorVentas -> asesorVentas.getIdAsesor().equals(id)).findFirst();
    }

    public UUID crearAsesorVentas(String nombre, String apellido, String cargo, float salario) {
        AsesorVentas nuevoAsesor = new AsesorVentas(UUID.randomUUID(), nombre, apellido, cargo, salario);
        asesorVentas.add(nuevoAsesor);
        return nuevoAsesor.getIdAsesor();
    }

    public boolean actualizarAsesorVentas(UUID id, String nombre, String apellido, String cargo, float salario) {
        for(AsesorVentas asesorVentas : asesorVentas) {
            if (asesorVentas.getIdAsesor().equals(id)) {
                asesorVentas.setNombre(nombre);
                asesorVentas.setApellido(apellido);
                asesorVentas.setCargo(cargo);
                asesorVentas.setSalario(salario);
                return true;
            }
        }
        return false;
    }

    public void eliminarAsesorVentas(UUID id) {
        asesorVentas.removeIf(asesorVentas -> asesorVentas.getIdAsesor().equals(id));
    }
}
