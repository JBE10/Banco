package negocios;

import java.util.ArrayList;
import java.util.Scanner;

public class CajaAhorro extends Cuenta {
    private ArrayList<Tarjeta> tarjetas;

    public CajaAhorro() {
        super();
        this.tarjetas = new ArrayList<Tarjeta>();
    }

    public ArrayList<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(ArrayList<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public CajaAhorro(double balance, int numero, Cliente cliente, ArrayList<Tarjeta> tarjetas) {
        super(balance, numero, cliente);
        this.tarjetas = tarjetas;
    }

    @Override
    public void extraer(double monto) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tipo de tarjeta que desea usar 1(Credito), 2 (debito): ");
        int tipo = sc.nextInt();
        if (tipo == 1) {
            System.out.println("Ingrese el numero de la tarjeta: ");
            int numero = sc.nextInt();
            for (Tarjeta tarjeta : tarjetas) {
                if (tarjeta.getNumero() == numero) {
                    double limite = tarjeta.getLimite();
                    double balance = tarjeta.getBalance();

                    if (limite >= monto) {
                        tarjeta.setLimite(limite - monto);
                        tarjeta.setBalance(balance - monto);
                        this.setBalance(this.getBalance() - monto);
                    } else {
                        System.out.println("No tiene saldo suficiente");
                    }
                }
            }
        } else {
            if (this.getBalance() >= monto) {
                this.setBalance(this.getBalance() - monto);
            } else {
                System.out.println("No tiene saldo suficiente");
            }
        }
    }
}





