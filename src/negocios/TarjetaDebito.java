package negocios;

public class TarjetaDebito extends Tarjeta {
    public TarjetaDebito() {
        super();
    }

    public TarjetaDebito(double balance, int numero, Cliente cliente) {
        super(balance, numero, cliente);
    }
    public void extraer(double monto){
        if(this.balance>=monto){
            this.balance-=monto;
        }
    }


}
