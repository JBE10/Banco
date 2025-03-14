package negocios;

public class CajaCorriente extends Cuenta{
    private double descubierto;

    public CajaCorriente() {
        super();
        this.descubierto = 0;
    }

    @Override
    public void extraer(double monto) {
        if(this.balance + this.descubierto >= monto){
            this.balance -= monto;
        }
    }

    public CajaCorriente(double balance, int numero, Cliente cliente, double descubierto) {
        super(balance, numero, cliente);
        this.descubierto = descubierto;
    }

    public double getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(double descubierto) {
        this.descubierto = descubierto;
    }
}

