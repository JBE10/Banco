import negocios.*;
import java.util.Scanner;

public class Main {
    static Banco banco = new Banco();
    public static void main(String[] args) {

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
            scanner.nextLine();

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
        Cliente cliente = new Cliente();

        System.out.print("Ingrese DNI: ");
        cliente.setDni(scanner.nextInt());
        scanner.nextLine(); // Consume newline

        System.out.print("Ingrese Nombre: ");
        cliente.setNombre(scanner.nextLine());

        System.out.print("Ingrese Apellido: ");
        cliente.setApellido(scanner.nextLine());

        // Crear caja de ahorro
        System.out.print("Saldo inicial caja de ahorro: ");
        double saldoAhorro = scanner.nextDouble();
        System.out.print("Número de cuenta caja de ahorro: ");
        int numeroCuentaAhorro = scanner.nextInt();

        CajaAhorro cajaAhorro = new CajaAhorro(saldoAhorro, numeroCuentaAhorro);
        cliente.setCajaAhorro(cajaAhorro);

        // Crear caja corriente
        System.out.print("Saldo inicial caja corriente: ");
        double saldoCorriente = scanner.nextDouble();
        System.out.print("Número de cuenta caja corriente: ");
        int numeroCuentaCorriente = scanner.nextInt();
        System.out.print("Descubierto permitido: ");
        double descubierto = scanner.nextDouble();
        CajaCorriente cajaCorriente = new CajaCorriente(descubierto, numeroCuentaCorriente, saldoCorriente);
        cliente.setCajaCorriente(cajaCorriente);


        System.out.print("Saldo inicial de tarjeta de débito: ");
        double saldoDebito = scanner.nextDouble();
        System.out.print("Número de tarjeta de débito: ");
        int numeroDebito = scanner.nextInt();
        TarjetaDebito tarjetaDebito = new TarjetaDebito(saldoDebito, numeroDebito);
        cliente.getCajaAhorro().setTarjetaDebito(tarjetaDebito);


        System.out.print("Límite de tarjeta de crédito: ");
        double limiteCredito = scanner.nextDouble();
        System.out.print("Saldo inicial de tarjeta de crédito: ");
        double saldoCredito = scanner.nextDouble();
        System.out.print("Número de tarjeta de crédito: ");
        int numeroCredito = scanner.nextInt();
        TarjetaCredito tarjetaCredito = new TarjetaCredito(limiteCredito, saldoCredito, numeroCredito);
        cliente.getCajaAhorro().setTarjetaCredito(tarjetaCredito);


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
            System.out.println("1. Depositar en Caja de Ahorro");
            System.out.println("2. Depositar en Caja Corriente");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            System.out.print("Ingrese monto a depositar: ");
            double monto = scanner.nextDouble();

            if (opcion == 1 && cliente.getCajaAhorro() != null) {
                cliente.getCajaAhorro().setSaldo(cliente.getCajaAhorro().getSaldo() + monto);
                System.out.println("Depósito realizado exitosamente en Caja de Ahorro!");
            } else if (opcion == 2 && cliente.getCajaCorriente() != null) {
                cliente.getCajaCorriente().depositarDinero(monto);
                System.out.println("Depósito realizado exitosamente en Caja Corriente!");
            } else {
                System.out.println("Opción inválida o cuenta no disponible.");
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
            System.out.println("1. Extraer de Caja de Ahorro");
            System.out.println("2. Extraer de Caja Corriente");
            System.out.println("3. Extraer con Tarjeta de Débito");
            System.out.println("4. Extraer con Tarjeta de Crédito");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            System.out.print("Ingrese monto a extraer: ");
            double monto = scanner.nextDouble();

            switch (opcion) {
                case 1:
                    if (cliente.getCajaAhorro() != null) {
                        if (monto <= cliente.getCajaAhorro().getSaldo()) {
                            cliente.getCajaAhorro().setSaldo(cliente.getCajaAhorro().getSaldo() - monto);
                            System.out.println("Extracción realizada exitosamente de Caja de Ahorro!");
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }
                    } else {
                        System.out.println("Caja de Ahorro no disponible.");
                    }
                    break;

                case 2:
                    if (cliente.getCajaCorriente() != null) {
                        cliente.getCajaCorriente().extraerDinero(monto);
                        System.out.println("Extracción procesada de Caja Corriente.");
                    } else {
                        System.out.println("Caja Corriente no disponible.");
                    }
                    break;

                case 3:
                    if (cliente.getCajaAhorro() != null && cliente.getCajaAhorro().getTarjetaDebito() != null) {
                        cliente.getCajaAhorro().getTarjetaDebito().extraer(monto);
                        System.out.println("Extracción con Tarjeta de Débito procesada.");
                    } else {
                        System.out.println("Tarjeta de Débito no disponible.");
                    }
                    break;

                case 4:
                    if (cliente.getCajaAhorro() != null && cliente.getCajaAhorro().getTarjetaCredito() != null) {
                        cliente.getCajaAhorro().getTarjetaCredito().extraer(monto);
                        System.out.println("Extracción con Tarjeta de Crédito procesada.");
                    } else {
                        System.out.println("Tarjeta de Crédito no disponible.");
                    }
                    break;

                default:
                    System.out.println("Opción inválida.");
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

            if (cliente.getCajaAhorro() != null) {
                System.out.println("\nCAJA DE AHORRO");
                System.out.println("Número de cuenta: " + cliente.getCajaAhorro().getNumeroCuenta());
                System.out.println("Saldo: $" + cliente.getCajaAhorro().getSaldo());

                if (cliente.getCajaAhorro().getTarjetaDebito() != null) {
                    System.out.println("\nTARJETA DE DÉBITO");
                    System.out.println("Número: " + cliente.getCajaAhorro().getTarjetaDebito().getNumeroTarjeta());
                    System.out.println("Saldo: $" + cliente.getCajaAhorro().getTarjetaDebito().getSaldo());
                }

                if (cliente.getCajaAhorro().getTarjetaCredito() != null) {
                    System.out.println("\nTARJETA DE CRÉDITO");
                    System.out.println("Número: " + cliente.getCajaAhorro().getTarjetaCredito().getNumeroTarjeta());
                    System.out.println("Saldo: $" + cliente.getCajaAhorro().getTarjetaCredito().getSaldo());
                    System.out.println("Límite: $" + cliente.getCajaAhorro().getTarjetaCredito().getLimite());
                }
            }

            if (cliente.getCajaCorriente() != null) {
                System.out.println("\nCAJA CORRIENTE");
                System.out.println("Número de cuenta: " + cliente.getCajaCorriente().getNumeroCuenta());
                System.out.println("Saldo: $" + cliente.getCajaCorriente().getSaldo());
                System.out.println("Descubierto permitido: $" + cliente.getCajaCorriente().getDescubierto());
                System.out.println("Balance total: $" + cliente.getCajaCorriente().verBalance());
            }

        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
}