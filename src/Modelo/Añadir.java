package Modelo;

import java.io.Serializable;

/**
 *
 * @author Angie Ballesteros
 */
public class Añadir implements Serializable {
    private Contacto idContacto;
    private Grupo idGrupo;

    public Contacto getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Contacto idContacto) {
        this.idContacto = idContacto;
    }

    public Grupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupo idGrupo) {
        this.idGrupo = idGrupo;
    }
    
    
}
