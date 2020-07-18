package ar.com.ada.api.cursos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.cursos.entities.Categoria;
import ar.com.ada.api.cursos.repos.CategoriaRepository;


@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepo;   

    void crearCategoria(Categoria categoria){ 
        categoriaRepo.save(categoria);
    }

	public Categoria crearCategoria(String nombre, String descripcion) {
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);
        categoriaRepo.save(categoria);
        return categoria;
    }
    
    public Categoria buscarPorId(Integer id){
        Optional<Categoria> opCategoria = categoriaRepo.findById(id);
        if(opCategoria.isPresent()){
            return opCategoria;
        }
        return null;

    }
}