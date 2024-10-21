package com.taller.tareaCrud.Controlador;

import com.taller.tareaCrud.Entidad.Clientes;
import com.taller.tareaCrud.Entidad.Ventas;
import com.taller.tareaCrud.ProductService.ServiceClientes;
import com.taller.tareaCrud.ProductService.ServiceVentas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ControladorCliente {
    @Autowired
    private ServiceClientes serviceClientes;
    //lista de compras
    @GetMapping("/compras/{ccCliente}")
    public List<Ventas> listaCompras(@PathVariable int ccCliente){
        return serviceClientes.listaCompras(ccCliente);
    }
    //actualizar datos de cliente
    @PutMapping("/actualizar/{cedula}")
    public boolean actualizarCliente(@PathVariable int cedula, @RequestBody Clientes cliente){
        return serviceClientes.actualizarCliente(
                cliente.getCcCliente(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono()
        );
    }
}
