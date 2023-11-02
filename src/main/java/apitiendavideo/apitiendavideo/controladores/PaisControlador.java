package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.interfaces.IPaisServicio;
import apitiendavideo.apitiendavideo.modelos.Pais;

@RestController
@RequestMapping("/paises")
public class PaisControlador {

    private IPaisServicio servicio;

    public PaisControlador(IPaisServicio servicio) {
        this.servicio = servicio;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Pais> listar() {
        return servicio.listar();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Pais obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Pais> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Pais crear(@RequestBody Pais pais) {
        pais.setId(0);
        return servicio.guardar(pais);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Pais actualizar(@RequestBody Pais pais) {
        if (servicio.obtener(pais.getId()) != null) {
            return servicio.guardar(pais);
        } else {
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }


}
