package ar.com.ada.api.cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.cursos.entities.Curso;
import ar.com.ada.api.cursos.repos.CursoRepository;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepo;
    @Autowired
    CategoriaService categoriaService;

    // 21/07 21:39 el profe dijo que tenemos que cambiar algo en el resultado
    public boolean crearCurso(Curso curso) {
        if (cursoRepo.existsByNombre(curso.getNombre()))
            return false;
        else 
        grabarCurso(curso);
        return true;
    }

    public void grabarCurso(Curso curso){

        cursoRepo.save(curso);
    }

    public Curso crearCurso(String nombre, Integer categoriaId, Integer duracionHoras, String descripcion) {
        Curso curso = new Curso();
        curso.setNombre(nombre);
        curso.agregarCategoria(categoriaService.buscarPorId(categoriaId));
        curso.setDuracionHoras(duracionHoras);
        curso.setDescripcion(descripcion);
        // llamo al metodo creado en la linea 19
        boolean cursoCreado = crearCurso(curso);
        if (cursoCreado)
            return curso;
        else
            return null;
    }

    public List<Curso> listaCurso() {
        return cursoRepo.findAll();
    }

	

}