package co.edu.uniquindio.snowalowe.snowalowe.model;

public class Muro {

    private String mensaje;
    private String comentario;
    private int meGusta;

    public Muro(String mensaje, String comentario, int meGusta) {
        this.mensaje = mensaje;
        this.comentario = comentario;
        this.meGusta = meGusta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getComentario() {
        return comentario;
    }

    public int getMeGusta() {
        return meGusta;
    }
}
