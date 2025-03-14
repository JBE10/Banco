package negocios;

public class TarjetaCredito extends Tarjeta {
    private double limite;

    public TarjetaCredito() {
        super();
        this.limite = 0;
    }

    public TarjetaCredito(double balance, int numero, Cliente cliente, double limite) {
        super(balance, numero, cliente);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
