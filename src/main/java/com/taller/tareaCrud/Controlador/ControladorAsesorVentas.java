package com.taller.tareaCrud.Controlador;

import com.taller.tareaCrud.Entidad.AsesorVentas;
import com.taller.tareaCrud.Entidad.Clientes;
import com.taller.tareaCrud.Entidad.Producto;
import com.taller.tareaCrud.Entidad.Ventas;
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
    //controlador de registro venta desde asesor
    @PostMapping("/RegistrarVenta")
    public ResponseEntity<?> registroVentaAsesor(@RequestBody Ventas venta) {
        try {
            UUID ventaId = serviceAsesorVentas.registrarVenta(
                    venta.getNombreProducto(),venta.getCantidad(),venta.getValor(),venta.getCcCliente()
            );
            return ResponseEntity.ok(ventaId);
        }
        catch (IllegalArgumentException e){
            //---------VALIDAR ESTA EXCEPCIÓN------------
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //registro cliente desde asesor
    @PostMapping("/RegistrarVenta/cliente")
    public UUID registroCliente(@RequestBody Clientes cliente) {
        return serviceAsesorVentas.agregarCliente(cliente.getCcCliente(),cliente.getNombre(),cliente.getApellido(),cliente.getTelefono());
    }
    //ver productos desde el asesor
    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return serviceAsesorVentas.listaProdustosAsesor();
    }
    //lista asesores
//    @GetMapping("/listaAsesores")
//    public List<AsesorVentas> listaAsesorVentas(){
//        return serviceAsesorVentas.getAsesorVentas();
//    }
//    //buscar asesor
//    @PutMapping("/{id}")
//    public AsesorVentas getAsesorVentas(@PathVariable UUID id){
//        return serviceAsesorVentas.getAsesorVentasById(id).map(asesorVentas -> asesorVentas.getIdAsesor().equals(id) ? asesorVentas : null).orElse(null);
//    }
//
//    @PostMapping("crearAsesor")
//    public UUID crearAsesor(@RequestBody AsesorVentas asesorVentas) {
//        return serviceAsesorVentas.crearAsesorVentas(asesorVentas.getNombre(), asesorVentas.getApellido(), asesorVentas.getCargo(), asesorVentas.getSalario());
//    }
//    //actualizar asesor
//    @PutMapping("/actualizarAsesor/{id}")
//    public boolean actualizarAsesor(@PathVariable UUID id, @RequestBody AsesorVentas asesorVentas) {
//        return serviceAsesorVentas.actualizarAsesorVentas(
//                id,
//                asesorVentas.getNombre(),
//                asesorVentas.getApellido(),
//                asesorVentas.getCargo(),
//                asesorVentas.getSalario()
//        );
//    }
//    @DeleteMapping("/borrarAsesor/{id}")
//    public void borrarAsesor(@PathVariable UUID id) {
//        serviceAsesorVentas.eliminarAsesorVentas(id);
//    }


}
