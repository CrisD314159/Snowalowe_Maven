package co.edu.uniquindio.snowalowe.snowalowe.model;

import java.util.ArrayList;

public class Red {
    private ArrayList<Vendedor> usuarios;

    /*----------------CONSTRUCTOR--------------------------------------------------*/

    public Red(ArrayList<Vendedor> usuarios) {
        this.usuarios = new ArrayList<>();
    }

    /*----------------METODOS-------------------------------------------------------*/
    public void buscarVendedor(String id ){

    }
    public void buscarVendedorNom(String nombre ){

    }
    public void sugerirVendedor(String id ){

    }


    /*----------------GETTERS & SETTERS-----------------------------------------------*/

    public ArrayList<Vendedor> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Vendedor> usuarios) {
        this.usuarios = usuarios;
    }
}
