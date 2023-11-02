package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.IEmpresaServicio;
import apitiendavideo.apitiendavideo.modelos.Empresa;
import apitiendavideo.apitiendavideo.modelos.Titulo;
import apitiendavideo.apitiendavideo.repositorios.EmpresaRepositorio;
import jakarta.persistence.EntityManager;

@Service
public class EmpresaServicio implements IEmpresaServicio {

    private EmpresaRepositorio repositorio;

    @Autowired
    private EntityManager em;

    public EmpresaServicio(EmpresaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Empresa> listar() {
        return repositorio.findAll();
    }

    @Override
    public Empresa obtener(Long id) {
        var empresa = repositorio.findById(id);
        return empresa.isEmpty() ? null : empresa.get();
    }

    @Override
    public List<Empresa> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return repositorio.save(empresa);
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<Titulo> listarTitulos(String nombre) {
        List<Titulo> titulos = em
                .createNativeQuery("SELECT * FROM fBuscarTitulosPorEmpresa(:nombreEmpresa)", Titulo.class)
                .setParameter("nombreEmpresa", nombre)
                .getResultList();
        return titulos;
    }

}
