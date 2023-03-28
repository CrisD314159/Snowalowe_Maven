package co.edu.uniquindio.snowalowe.snowalowe.model;

public class Producto {

    private String nombre;
    private String codigo;
    private String imagen;
    private double precio;

    public Producto(String nombre, String codigo, String imagen, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.imagen = imagen;
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
