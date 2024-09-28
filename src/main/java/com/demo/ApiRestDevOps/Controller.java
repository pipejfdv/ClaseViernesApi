package com.demo.ApiRestDevOps;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apiPaises")
public class Controller {
    //lista de los paises
    private List <String> paises = new ArrayList<String>();
    //agregar elementos a la lista
    public Controller(){
        paises.add("Colombia");
        paises.add("Brasil");
        paises.add("Argentina");
        paises.add("Chile");
        paises.add("Perú");
        paises.add("Bolivia");
    }
    //retornar elemento en especifico
    @GetMapping("/{op}")
    public String elemento(@PathVariable int op){
        if(op >= 0 && op < paises.size()){
            return paises.get(op);
        }
        else {
            return "Elemento no encontrado";
        }
    }
    //retornar elementos
    @GetMapping("/paises")
    public List<String> getPaises() {
        return paises;
    }
    //incertar el valor en la lista
    @PostMapping
    public String agregarPais(@RequestBody String nuevoPais){
        paises.add(nuevoPais);
        return "Pais agregado a la lista";
    }
    //actualizar elemento
    @PutMapping("/{op}")
    public String modificar(@PathVariable int op, @RequestBody String nuevoPais){
        if(op >= 0 && op < paises.size()){
            paises.set(op, nuevoPais);
            return "Actualizción de país";
        }
        else {
            return "Pais no encontrado";
        }
    }
    //eliminar elemento
    @DeleteMapping("/{op}")
    public String eliminar(@PathVariable int op){
        if(op >= 0 && op < paises.size()){
            paises.remove(op);
            return "Pais eliminado";
        }
        else {
            return "Pais no encontrado";
        }
    }
}