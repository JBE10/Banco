package negocios;

public abstract class Cuenta {
    protected double balance;
    private int numero;
    private Cliente cliente;

    public Cuenta(double balance, int numero, Cliente cliente) {
        this.balance = balance;
        this.numero = numero;
        this.cliente = cliente;
    }
    public Cuenta(){
        this.balance=0;
        this.numero=0;
        this.cliente=new Cliente();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void depositar(double monto){
        this.balance+=monto;
    }
    public double verBalance(){
        return this.balance;
    }

    public abstract void extraer(double monto);
}
