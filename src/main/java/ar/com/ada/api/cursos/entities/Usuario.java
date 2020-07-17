package ar.com.ada.api.cursos.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuarioId;
    private String usuername;
    private String password;
    private String email;
    @Column(name = "fecha_login")
    private Date fechaLogin;
    @Column(name = "tipo_usuario_id")
    private TipoUsuarioEnum tipoUsuarioId;
    @OneToOne
    @JoinColumn(name = "estudiante_id", referencedColumnName = "estudiante_id")
    private Estudiante estudiante;
    @OneToOne
    @JoinColumn(name = "docente_id", referencedColumnName = "docente_id")
    private Docente docente;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Inscripcion> inscripciones;

    //------------------Empieza enum----------------------------
  
    public enum TipoUsuarioEnum {
        DOCENTE(1), ESTUDIANTE(2), STAFF(3);

        private final int value;

        // NOTE: Enum constructor tiene que estar en privado
        private TipoUsuarioEnum(int value) {
            this.value = value;

        }

        public int getValue() {
            return value;
        }

        public static TipoUsuarioEnum parse(int id) {
            TipoUsuarioEnum status = null; // Default
            for (TipoUsuarioEnum item : TipoUsuarioEnum.values()) {
                if (item.getValue() == id) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }
//------------------Termina enum----------------------------

public Integer getUsuarioId() {
    return usuarioId;
}

public void setUsuarioId(Integer usuarioId) {
    this.usuarioId = usuarioId;
}

public String getUsuername() {
    return usuername;
}

public void setUsuername(String usuername) {
    this.usuername = usuername;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public Date getFechaLogin() {
    return fechaLogin;
}

public void setFechaLogin(Date fechaLogin) {
    this.fechaLogin = fechaLogin;
}

public TipoUsuarioEnum getTipoUsuarioId() {
    return tipoUsuarioId;
}

public void setTipoUsuarioId(TipoUsuarioEnum tipoUsuarioId) {
    this.tipoUsuarioId = tipoUsuarioId;
}

public Estudiante getEstudiante() {
    return estudiante;
}

public void setEstudiante(Estudiante estudiante) {
    this.estudiante = estudiante;
}

public Docente getDocente() {
    return docente;
}

public void setDocente(Docente docente) {
    this.docente = docente;
}

public List<Inscripcion> getInscripciones() {
    return inscripciones;
}

public void setInscripciones(List<Inscripcion> inscripciones) {
    this.inscripciones = inscripciones;
}


  





}