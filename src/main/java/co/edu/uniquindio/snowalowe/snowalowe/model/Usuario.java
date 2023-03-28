package co.edu.uniquindio.snowalowe.snowalowe.model;

public class Usuario {

    private String nomre;
    private String apellido;
    private String codigo;
    private String direccion;

    public Usuario(String nomre, String apellido, String codigo, String direccion) {
        this.nomre = nomre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.direccion = direccion;
    }

    public String getNomre() {
        return nomre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDireccion() {
        return direccion;
    }
}
