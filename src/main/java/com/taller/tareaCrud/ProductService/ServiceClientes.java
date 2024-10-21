package com.taller.tareaCrud.ProductService;

import com.taller.tareaCrud.Entidad.Clientes;
import com.taller.tareaCrud.Entidad.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceClientes {
    @Autowired
    private ServiceVentas servicesVentas;
    private List<Clientes> listaClientes = new ArrayList<>();

    //lista de clientes para admin
    public List<Clientes> getListaClientes() {
        try {

        }
        catch (Exception e) {

        }
        return listaClientes;
    }
    //agregar clientes
    public void agregarCliente(Clientes cliente) {
        //agregar cliente a la lista
        listaClientes.add(cliente);
    }

    //actualizar datos de cliente
    public boolean actualizarCliente(int ccCliente, String nombre, String apellido, String telefono) {
        for (Clientes cliente : listaClientes) {
            if (cliente.getCcCliente() == ccCliente) {
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setTelefono(telefono);
                return true;
            }
        }
        return false;
    }
    //el cliente puede borrar sus datos
    public boolean eliminarCliente(int ccCliente) {
        for (Clientes cliente : listaClientes) {
            if (cliente.getCcCliente() == ccCliente) {
                listaClientes.remove(cliente);
                return true;
            }
        }
        return false;
    }
    //el cliente puede ver sus compras
    public List<Ventas> listaCompras(int ccCliente) {
        //se crea lista temporal para que almacene los datos del cliente en especifico
        List<Ventas> comprasCliente = new ArrayList<>();
        for (Ventas compra : servicesVentas.getVentas()) {
            //busca por ccCliente - documento
            if (compra.getCcCliente() == ccCliente) {
                comprasCliente.add(compra);
            }
        }
        return comprasCliente;
    }
}
