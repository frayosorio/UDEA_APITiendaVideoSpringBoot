package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.modelos.Empresa;
import apitiendavideo.apitiendavideo.modelos.Titulo;

public interface IEmpresaServicio {

    public List<Empresa> listar();

    public Empresa obtener(Long id);

    public List<Empresa> buscar(String nombre);

    public Empresa guardar(Empresa Empresa);

    public boolean eliminar(Long id);

    public List<Titulo> listarTitulos(String nombre);
}
