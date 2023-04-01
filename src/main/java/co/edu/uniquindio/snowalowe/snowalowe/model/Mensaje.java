package co.edu.uniquindio.snowalowe.snowalowe.model;

import java.time.format.DateTimeFormatter;

public class Mensaje {
    private String id;
    private String idAutor;
    private String descripcion;
    private DateTimeFormatter date;
    /*--------------CONSTRUCTOR-----------------------------------------------------------*/
    public Mensaje(String id, String idAutor, String descripcion, DateTimeFormatter date) {
        this.id = id;
        this.idAutor = idAutor;
        this.descripcion = descripcion;
        this.date = date;
    }
    /*----------------METODOS-------------------------------------------------------------*/

    public String getId() {
        return id;
    }

    public String getIdAutor() {
        return idAutor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public DateTimeFormatter getDate() {
        return date;
    }
}
