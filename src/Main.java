
import negocios.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== SISTEMA BANCARIO =====");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Extraer dinero");
            System.out.println("5. Ver balance");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case 1:
                    agregarCliente(banco, scanner);
                    break;
                case 2:
                    eliminarCliente(banco, scanner);
                    break;
                case 3:
                    depositarDinero(banco, scanner);
                    break;
                case 4:
                    extraerDinero(banco, scanner);
                    break;
                case 5:
                    verBalance(banco, scanner);
                    break;
                case 6:
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema bancario!");
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        }
        scanner.close();
    }

    private static void agregarCliente(Banco banco, Scanner scanner) {
        System.out.print("Ingrese DNI: ");
        int dni = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese Apellido: ");
        String apellido = scanner.nextLine();

        Cliente cliente = new Cliente(dni, nombre, apellido);

        // Crear caja de ahorro
        System.out.print("Saldo inicial caja de ahorro: ");
        double saldoAhorro = scanner.nextDouble();
        System.out.print("Número de cuenta caja de ahorro: ");
        int numeroCuentaAhorro = scanner.nextInt();

        CajaAhorro cajaAhorro = new CajaAhorro(saldoAhorro, numeroCuentaAhorro, cliente, null);
        cliente.getTarjetas().add(cajaAhorro);

        // Crear caja corriente
        System.out.print("Saldo inicial caja corriente: ");
        double saldoCorriente = scanner.nextDouble();
        System.out.print("Número de cuenta caja corriente: ");
        int numeroCuentaCorriente = scanner.nextInt();
        System.out.print("Descubierto permitido: ");
        double descubierto = scanner.nextDouble();

        CajaCorriente cajaCorriente = new CajaCorriente(saldoCorriente, numeroCuentaCorriente, cliente, descubierto);
        cliente.getTarjetas().add(cajaCorriente);

        // Tarjeta de débito
        System.out.print("¿Crear tarjeta de débito? (1: Sí / 0: No): ");
        if (scanner.nextInt() == 1) {
            System.out.print("Saldo inicial: ");
            double saldoDebito = scanner.nextDouble();
            System.out.print("Número de tarjeta: ");
            int numeroDebito = scanner.nextInt();

            TarjetaDebito tarjetaDebito = new TarjetaDebito(saldoDebito, numeroDebito, cliente);
            cajaAhorro.getTarjetas().add(tarjetaDebito);
        }

        // Tarjeta de crédito
        System.out.print("¿Crear tarjeta de crédito? (1: Sí / 0: No): ");
        if (scanner.nextInt() == 1) {
            System.out.print("Saldo inicial: ");
            double saldoCredito = scanner.nextDouble();
            System.out.print("Número de tarjeta: ");
            int numeroCredito = scanner.nextInt();
            System.out.print("Límite de crédito: ");
            double limiteCredito = scanner.nextDouble();

            TarjetaCredito tarjetaCredito = new TarjetaCredito(saldoCredito, numeroCredito, cliente, limiteCredito);
            cajaAhorro.getTarjetas().add(tarjetaCredito);
        }

        banco.agregarCliente(cliente);
        System.out.println("Cliente agregado exitosamente!");
    }

    private static void eliminarCliente(Banco banco, Scanner scanner) {
        System.out.print("Ingrese DNI del cliente a eliminar: ");
        int dni = scanner.nextInt();
        Cliente cliente = banco.getCliente(dni);

        if (cliente != null) {
            banco.eliminarCliente(cliente);
            System.out.println("Cliente eliminado exitosamente!");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void depositarDinero(Banco banco, Scanner scanner) {
        System.out.print("Ingrese DNI del cliente: ");
        int dni = scanner.nextInt();
        Cliente cliente = banco.getCliente(dni);

        if (cliente != null) {
            System.out.println("Cuentas disponibles:");
            mostrarCuentas(cliente);

            System.out.print("Seleccione número de cuenta: ");
            int numeroCuenta = scanner.nextInt();

            Cuenta cuentaSeleccionada = buscarCuentaPorNumero(cliente, numeroCuenta);

            if (cuentaSeleccionada != null) {
                System.out.print("Ingrese monto a depositar: ");
                double monto = scanner.nextDouble();

                cuentaSeleccionada.depositar(monto);
                System.out.println("Depósito realizado exitosamente!");
            } else {
                System.out.println("Cuenta no encontrada.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void extraerDinero(Banco banco, Scanner scanner) {
        System.out.print("Ingrese DNI del cliente: ");
        int dni = scanner.nextInt();
        Cliente cliente = banco.getCliente(dni);

        if (cliente != null) {
            System.out.println("Cuentas disponibles:");
            mostrarCuentas(cliente);

            System.out.print("Seleccione número de cuenta: ");
            int numeroCuenta = scanner.nextInt();

            Cuenta cuentaSeleccionada = buscarCuentaPorNumero(cliente, numeroCuenta);

            if (cuentaSeleccionada != null) {
                System.out.print("Ingrese monto a extraer: ");
                double monto = scanner.nextDouble();

                cuentaSeleccionada.extraer(monto);
                System.out.println("Operación procesada.");
            } else {
                System.out.println("Cuenta no encontrada.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void verBalance(Banco banco, Scanner scanner) {
        System.out.print("Ingrese DNI del cliente: ");
        int dni = scanner.nextInt();
        Cliente cliente = banco.getCliente(dni);

        if (cliente != null) {
            System.out.println("\n===== BALANCE DEL CLIENTE =====");
            System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
            System.out.println("DNI: " + cliente.getDni());

            for (Cuenta cuenta : cliente.getTarjetas()) {
                if (cuenta instanceof CajaAhorro) {
                    CajaAhorro cajaAhorro = (CajaAhorro) cuenta;
                    System.out.println("\nCAJA DE AHORRO");
                    System.out.println("Número de cuenta: " + cajaAhorro.getNumero());
                    System.out.println("Saldo: $" + cajaAhorro.getBalance());

                    // Mostrar tarjetas asociadas
                    if (cajaAhorro.getTarjetas() != null && !cajaAhorro.getTarjetas().isEmpty()) {
                        for (Tarjeta tarjeta : cajaAhorro.getTarjetas()) {
                            if (tarjeta instanceof TarjetaDebito) {
                                System.out.println("\nTARJETA DE DÉBITO");
                                System.out.println("Número: " + tarjeta.getNumero());
                                System.out.println("Saldo: $" + tarjeta.getBalance());
                            } else if (tarjeta instanceof TarjetaCredito) {
                                TarjetaCredito tarjetaCredito = (TarjetaCredito) tarjeta;
                                System.out.println("\nTARJETA DE CRÉDITO");
                                System.out.println("Número: " + tarjetaCredito.getNumero());
                                System.out.println("Saldo: $" + tarjetaCredito.getBalance());
                                System.out.println("Límite: $" + tarjetaCredito.getLimite());
                            }
                        }
                    }
                } else if (cuenta instanceof CajaCorriente) {
                    CajaCorriente cajaCorriente = (CajaCorriente) cuenta;
                    System.out.println("\nCAJA CORRIENTE");
                    System.out.println("Número de cuenta: " + cajaCorriente.getNumero());
                    System.out.println("Saldo: $" + cajaCorriente.getBalance());
                    System.out.println("Descubierto permitido: $" + cajaCorriente.getDescubierto());
                }
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    // Métodos de utilidad
    private static void mostrarCuentas(Cliente cliente) {
        for (Cuenta cuenta : cliente.getTarjetas()) {
            String tipoCuenta = (cuenta instanceof CajaAhorro) ? "Caja de Ahorro" : "Caja Corriente";
            System.out.println(cuenta.getNumero() + " - " + tipoCuenta + " - Saldo: $" + cuenta.getBalance());
        }
    }

    private static Cuenta buscarCuentaPorNumero(Cliente cliente, int numeroCuenta) {
        for (Cuenta cuenta : cliente.getTarjetas()) {
            if (cuenta.getNumero() == numeroCuenta) {
                return cuenta;
            }
        }
        return null;
    }
}