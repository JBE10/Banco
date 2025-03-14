package negocios;

public abstract class Tarjeta {
    protected double balance;
    private int numero;
    private Cliente cliente;


    public Tarjeta(double balance, int numero, Cliente cliente) {
        this.balance = balance;
        this.numero = numero;
        this.cliente = cliente;
    }
    public Tarjeta(){
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

    public void setLimite(double v) {
    }

    public double getLimite() {
        return 0;
    }
}
