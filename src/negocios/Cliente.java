package negocios;

public class Cliente {
    private int dni;
    private String nombre;
    private String apellido;
    private CajaCorriente cajaCorriente;
    private CajaAhorro cajaAhorro;
    private float balance;

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

    public CajaCorriente getCajaCorriente() {
        return cajaCorriente;
    }

    public void setCajaCorriente(CajaCorriente cajaCorriente) {
        this.cajaCorriente = cajaCorriente;
    }

    public CajaAhorro getCajaAhorro() {
        return cajaAhorro;
    }

    public void setCajaAhorro(CajaAhorro cajaAhorro) {
        this.cajaAhorro = cajaAhorro;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
