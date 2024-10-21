package com.taller.tareaCrud.ProductService;

import com.taller.tareaCrud.Entidad.AsesorVentas;
import com.taller.tareaCrud.Entidad.Clientes;
import com.taller.tareaCrud.Entidad.Producto;
import com.taller.tareaCrud.Entidad.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceAsesorVentas {
    //-----------------METODOS SEGUN NEGOCIO----------------------
    @Autowired
    private ServiceVentas serviceVentas;
    @Autowired
    private ServiceClientes serviceClientes;
    @Autowired
    private ServiceProducto serviceProducto;
    //permite registrar la venta desde el perfil "Asesor"
    public UUID registrarVenta(String nombreProducto, int cantidad, float valor, int cliente){
        Ventas nuevaVenta = new Ventas (UUID.randomUUID(), nombreProducto, cantidad, valor, cliente);
        serviceVentas.agregarVenta(nuevaVenta);
        //actualizar producto en el inventario
        for(Producto producto : serviceProducto.getProductos()){
            if(producto.getNombreProducto().equals(nombreProducto)){
                int nuevaCantidad = producto.getCantidad() - cantidad;
                if(nuevaCantidad < 0){
                    throw new IllegalArgumentException("No hay productos 0");
                }
                producto.setCantidad(nuevaCantidad);

            }
        }
        return nuevaVenta.getId();
    }
    //Registrar un cliente desde el perfil "Asesor"
    public UUID agregarCliente(int ccCliente, String nombre, String apellido, String telefono){
        Clientes nuevoCliente = new Clientes(UUID.randomUUID(), ccCliente, nombre, apellido, telefono);
        serviceClientes.agregarCliente(nuevoCliente);
        return nuevoCliente.getIdCliente();
    }
    //metodo para ver inventario
    public List<Producto> listaProdustosAsesor(){
        return serviceProducto.getProductos();
    }


    //------------------METODOS CRUD DE ASESOR VENTAS--------------
//    private List<AsesorVentas> asesorVentas;
//
//    public ServiceAsesorVentas() {
//        asesorVentas = new ArrayList();
//        asesorVentas.add(new AsesorVentas(UUID.randomUUID(), "Luisa","Echeverri","asesor",1300));
//    }

//    public List<AsesorVentas> getAsesorVentas() {
//        return asesorVentas;
//    }

//    public Optional<AsesorVentas> getAsesorVentasById(UUID id) {
//        return asesorVentas.stream().filter( asesorVentas -> asesorVentas.getIdAsesor().equals(id)).findFirst();
//    }
//
//    public UUID crearAsesorVentas(String nombre, String apellido, String cargo, float salario) {
//        AsesorVentas nuevoAsesor = new AsesorVentas(UUID.randomUUID(), nombre, apellido, cargo, salario);
//        asesorVentas.add(nuevoAsesor);
//        return nuevoAsesor.getIdAsesor();
//    }
//
//    public boolean actualizarAsesorVentas(UUID id, String nombre, String apellido, String cargo, float salario) {
//        for(AsesorVentas asesorVentas : asesorVentas) {
//            if (asesorVentas.getIdAsesor().equals(id)) {
//                asesorVentas.setNombre(nombre);
//                asesorVentas.setApellido(apellido);
//                asesorVentas.setCargo(cargo);
//                asesorVentas.setSalario(salario);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void eliminarAsesorVentas(UUID id) {
//        asesorVentas.removeIf(asesorVentas -> asesorVentas.getIdAsesor().equals(id));
//    }
}
