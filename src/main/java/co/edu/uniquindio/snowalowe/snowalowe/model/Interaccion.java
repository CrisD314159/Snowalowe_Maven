package co.edu.uniquindio.snowalowe.snowalowe.model;

public class Interaccion {

    private String id;
    private String idAutor;
    private Tipo tipo;
    /*--------------CONSTRUCTOR-------------------------------------*/
    public Interaccion(String id, String idAutor, Tipo tipo) {
        this.id = id;
        this.idAutor = idAutor;
        this.tipo = tipo;
    }
    /*----------------METODOS---------------------------------------*/

    /*----------------GETTERS & SETTERS-----------------------------*/

    public String getId() {
        return id;
    }

    public String getIdAutor() {
        return idAutor;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
