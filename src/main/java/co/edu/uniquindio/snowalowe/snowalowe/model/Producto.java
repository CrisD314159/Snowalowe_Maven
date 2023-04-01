package co.edu.uniquindio.snowalowe.snowalowe.model;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Producto {

    private ArrayList<Mensaje> comentarios;
    private ArrayList<Interaccion> interacciones;
    private String id;
    private String nombre;
    private String codigo;
    private String imagen;
    private EstadoProducto estado;
    private double precio;
    private DateTimeFormatter date;
    /*--------------CONSTRUCTOR------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public Producto(ArrayList<Mensaje> comentarios, ArrayList<Interaccion> interacciones, String id, String nombre, String codigo, String imagen, EstadoProducto estado, double precio, DateTimeFormatter date) {
        this.comentarios = new ArrayList<>();
        this.interacciones = new ArrayList<>();
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.imagen = imagen;
        this.estado = estado;
        this.precio = precio;
        this.date = date;
    }
    /*----------------METODOS--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/



    /*----------------GETTERS & SETTERS------------------------------------------------------------------------*/

    public ArrayList<Mensaje> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Mensaje> comentarios) {
        this.comentarios = comentarios;
    }

    public ArrayList<Interaccion> getInteracciones() {
        return interacciones;
    }

    public void setInteracciones(ArrayList<Interaccion> interacciones) {
        this.interacciones = interacciones;
    }

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public DateTimeFormatter getDate() {
        return date;
    }

    public void setDate(DateTimeFormatter date) {
        this.date = date;
    }
}
