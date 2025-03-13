package negocios;

public class CajaCorriente {
    private double descubierto;
    private  int numeroCuenta;
    private double saldo;

    public CajaCorriente(double descubierto, int numeroCuenta, double saldo) {
        this.descubierto = descubierto;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
    public CajaCorriente(){
        this.descubierto = 0;
        this.numeroCuenta = 0;
        this.saldo = 0;
    }

    public double getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(double descubierto) {
        this.descubierto = descubierto;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void extraerDinero(double monto) {
        if (monto <= saldo + descubierto) {
            saldo -= monto;
        } else {
            System.out.println("No se puede extraer el monto solicitado");
        }
    }
    public void depositarDinero(double monto) {
        saldo += monto;
    }
    public double verBalance() {
        return saldo;
    }
}

