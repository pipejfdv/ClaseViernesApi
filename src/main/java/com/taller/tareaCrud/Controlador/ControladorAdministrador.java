package com.taller.tareaCrud.Controlador;

import com.taller.tareaCrud.Entidad.Administrador;
import com.taller.tareaCrud.Entidad.Clientes;
import com.taller.tareaCrud.ProductService.ServiceAdministrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class ControladorAdministrador {
    @Autowired
    private ServiceAdministrador serviceAdministrador;
    //lista de clientes
    @GetMapping("/listaClientes")
    public List<Clientes> listarClientes(){
        return serviceAdministrador.listaClientes();
    }
    //lista de administradores
    @GetMapping("/listaAdmin")
    public List<Administrador> listarAdmin(){
        return serviceAdministrador.getAdministradors();
    }
    //Administrador
    @PutMapping("/{id}")
    public Administrador AdminId(@PathVariable UUID id){
        return serviceAdministrador.getAdministradorById(id).map(Administrador -> Administrador.getIdAdministrador().equals(id) ? Administrador : null).orElse(null);
    }
    //agregar admin
    @PostMapping
    public UUID crearAdministrador(@RequestBody Administrador admin){
        return serviceAdministrador.insertAdministrador(admin.getNombre(),admin.getApellido(),admin.getCargo(),admin.getSalario());
    }
    //actualizar administrador
    @PutMapping("/actualizarAdmin/{id}")
    public boolean actualizarAdmin(@PathVariable UUID id, @RequestBody Administrador administrador) {
        return serviceAdministrador.actualizarAdmin(
                id,
                administrador.getNombre(),
                administrador.getApellido(),
                administrador.getCargo(),
                administrador.getSalario()
        );
    }
    //eliminar admin
    @DeleteMapping("/borrarAdmin/{id}")
    public void borrarAdmin(@PathVariable UUID id) {
        serviceAdministrador.eliminarAdministrador(id);
    }
}
