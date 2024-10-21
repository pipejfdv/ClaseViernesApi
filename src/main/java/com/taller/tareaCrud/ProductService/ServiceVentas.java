package com.taller.tareaCrud.ProductService;

import com.taller.tareaCrud.Entidad.Ventas;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceVentas {
    private List<Ventas> listaVentas = new ArrayList<>();;

    //lista de ventas
    public List<Ventas> getVentas() {
        return listaVentas;
    }

    //agregar venta
    public void agregarVenta(Ventas ventas) {
        //agregar cliente a la lista
        listaVentas.add(ventas);
    }
}
