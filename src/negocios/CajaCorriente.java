package negocios;

public class CajaCorriente extends Caja {
    private double descubierto;

    public CajaCorriente(double saldo, int numeroCuenta, double descubierto) {
        super(saldo, numeroCuenta);
        this.descubierto = descubierto;
    }

    public double getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(double descubierto) {
        this.descubierto = descubierto;
    }

    @Override
    public void extraer(double monto) {
        if (monto <= getSaldo() + descubierto) {
            setSaldo(getSaldo() - monto);
        } else {
            System.out.println("No se puede extraer el monto solicitado");
        }
    }
}
