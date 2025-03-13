package negocios;

public class TarjetaDebito {
    private double saldo;
    private int numeroTarjeta;

    public TarjetaDebito(double saldo, int numeroTarjeta) {
        this.saldo = saldo;
        this.numeroTarjeta = numeroTarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void extraer(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
        } else {
            System.out.println("No se puede extraer el monto solicitado");
        }
    }
}
