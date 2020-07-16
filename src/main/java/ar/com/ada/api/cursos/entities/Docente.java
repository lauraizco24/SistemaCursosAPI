package ar.com.ada.api.cursos.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "docente")
public class Docente extends Persona {
    @Id
    @Column(name = "docente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer estudianteId;
    @ManyToMany
    @JoinTable(name = "docente_x_curso", joinColumns = @JoinColumn(name = "docente_id"), inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursosQueDicta;
    @OneToOne(mappedBy = "docente") // Nombre del atributo en el objeto usuario
    private Usuario usuario;


    //Getters y Setters
    
    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public List<Curso> getCursosQueDicta() {
        return cursosQueDicta;
    }

    public void setCursosQueDicta(List<Curso> cursosQueDicta) {
        this.cursosQueDicta = cursosQueDicta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    
}