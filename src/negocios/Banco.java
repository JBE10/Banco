package negocios;

import java.util.ArrayList;

public class Banco {
    private Cliente cliente;
    private ArrayList<Cliente> clientes;

    public Banco() {
        this.clientes = new ArrayList<Cliente>();
    }
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public void eliminarCliente(Cliente cliente){
        clientes.remove(cliente);
    }
    public  Cliente getCliente(int dni){
        Cliente cliente = new Cliente();
        cliente= buscarCliente(dni);
        return cliente;
    }

    private Cliente buscarCliente(int dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                return cliente;
            }
        }
        return null;
    }
}
