package com.taller.tareaCrud.Controlador;

import com.taller.tareaCrud.Entidad.AsesorVentas;
import com.taller.tareaCrud.ProductService.ServiceAsesorVentas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/asesores")
public class ControladorAsesorVentas {
    @Autowired
    private ServiceAsesorVentas serviceAsesorVentas;
    //lista asesores
    @GetMapping("/listaAsesores")
    public List<AsesorVentas> listaAsesorVentas(){
        return serviceAsesorVentas.getAsesorVentas();
    }
    //buscar asesor
    @PutMapping("/{id}")
    public AsesorVentas getAsesorVentas(@PathVariable UUID id){
        return serviceAsesorVentas.getAsesorVentasById(id).map(asesorVentas -> asesorVentas.getIdAsesor().equals(id) ? asesorVentas : null).orElse(null);
    }

    @PostMapping("crearAsesor")
    public UUID crearAsesor(@RequestBody AsesorVentas asesorVentas) {
        return serviceAsesorVentas.crearAsesorVentas(asesorVentas.getNombre(), asesorVentas.getApellido(), asesorVentas.getCargo(), asesorVentas.getSalario());
    }
    //actualizar asesor
    @PutMapping("/actualizarAsesor/{id}")
    public boolean actualizarAsesor(@PathVariable UUID id, @RequestBody AsesorVentas asesorVentas) {
        return serviceAsesorVentas.actualizarAsesorVentas(
                id,
                asesorVentas.getNombre(),
                asesorVentas.getApellido(),
                asesorVentas.getCargo(),
                asesorVentas.getSalario()
        );
    }
    @DeleteMapping("/borrarAsesor/{id}")
    public void borrarAsesor(@PathVariable UUID id) {
        serviceAsesorVentas.eliminarAsesorVentas(id);
    }
}
