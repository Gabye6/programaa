package Modelo;

import java.io.Serializable;

/**
 *
 * @author Angie Ballesteros
 */
public class Grupo implements Serializable {
  
    private int id;
    private String nombre;

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  
}
