package negocios;

public class TarjetaCredito {
    private double limite;
    private double saldo;
    private int numeroTarjeta;

    public TarjetaCredito(double limite, double saldo, int numeroTarjeta) {
        this.limite = limite;
        this.saldo = saldo;
        this.numeroTarjeta = numeroTarjeta;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
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
        if (monto <= saldo + limite) {
            saldo -= monto;
        } else {
            System.out.println("No se puede extraer el monto solicitado");
        }
    }
}
