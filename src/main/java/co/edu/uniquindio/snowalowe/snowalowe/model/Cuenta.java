package co.edu.uniquindio.snowalowe.snowalowe.model;

public class Cuenta {

    private String user;
    private String contraseña;

    public Cuenta(String user, String contraseña) {
        this.user = user;
        this.contraseña = contraseña;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
