package negocios;

import java.util.ArrayList;

public class Cliente {
    private int dni;
    private String nombre;
    private String apellido;
    private ArrayList<Cuenta> tarjetas;


    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tarjetas = new ArrayList<Cuenta>();
    }
    public Cliente(){
        this.tarjetas = new ArrayList<Cuenta>();
        this.apellido="";
        this.nombre="";
        this.dni=0;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Cuenta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(ArrayList<Cuenta> tarjetas) {
        this.tarjetas = tarjetas;
    }
}
