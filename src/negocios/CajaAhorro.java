package negocios;

public class CajaAhorro extends  Caja{
    private double interes;

    public CajaAhorro(double saldo, int numeroCuenta, double interes) {
        super(saldo, numeroCuenta);
        this.interes = interes;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public void calcularInteres(){
        setSaldo(getSaldo() + getSaldo() * interes);
    }
}
