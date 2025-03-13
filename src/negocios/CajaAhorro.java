package negocios;

public class CajaAhorro{

    private double saldo;
    private int numeroCuenta;
    private TarjetaCredito tarjetaCredito;
    private TarjetaDebito tarjetaDebito;

    public TarjetaDebito getTarjetaDebito() {
        return tarjetaDebito;
    }


    public void setTarjetaDebito(TarjetaDebito tarjetaDebito) {
        this.tarjetaDebito = tarjetaDebito;
    }

    public CajaAhorro(double saldo, int numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;

    }
    public CajaAhorro() {
        this.saldo = 0;
        this.numeroCuenta = 0;


    }
    public TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {

        this.numeroCuenta = numeroCuenta;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

}
