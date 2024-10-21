package com.taller.tareaCrud.Controlador;

import com.taller.tareaCrud.Entidad.Clientes;
import com.taller.tareaCrud.ProductService.ServiceAdministrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ControladorAdministrador {
    @Autowired
    private ServiceAdministrador serviceAdministrador;

    @GetMapping("/listaClientes")
    public List<Clientes> listarClientes(){
        return serviceAdministrador.listaClientes();
    }
}
