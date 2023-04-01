package co.edu.uniquindio.snowalowe.snowalowe.model;

import java.util.ArrayList;

public class Chat {
    private String id;
    private ArrayList<Mensaje> mensajes;
    /*--------------CONSTRUCTOR-------------------------------------*/
    public Chat(String id, ArrayList<Mensaje> mensajes) {
        this.id = id;
        this.mensajes = new ArrayList<>();
    }
    /*----------------METODOS---------------------------------------*/


    /*----------------GETTERS & SETTERS----------------------------------------------*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
}
