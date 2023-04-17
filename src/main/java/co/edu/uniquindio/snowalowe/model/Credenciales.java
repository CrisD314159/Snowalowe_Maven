package co.edu.uniquindio.snowalowe.model;

import java.io.Serializable;

public class Credenciales implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String nombre;
    private String contrasena;
    /*--------------CONSTRUCTOR-------------------------------------*/

    public Credenciales(String id, String nombre, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
    /*----------------METODOS---------------------------------------*/


    /*----------------GETTERS & SETTERS-------------------------------------------*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
