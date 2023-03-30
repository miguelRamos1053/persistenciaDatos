package persistencia_datos.gui;

import java.util.List;
import java.util.Scanner;

import persistencia_datos.entidades.Ahorro;
import persistencia_datos.servicios.ServicioCuenta;

public class GUI_Cuenta {

    private boolean correr = true;
    private ServicioCuenta servicioCuenta;

    public GUI_Cuenta() {
        servicioCuenta = new ServicioCuenta();
    }

    public void iniciar() {
        System.out.println("Bienvenido al Banco Mundial");

        while (correr) {
            System.out.println("1. Crear cuenta de ahorro");
            System.out.println("2. Crear cuenta Corriente");
            System.out.println("3. Listar Cuentas");
            System.out.println("6. Salir");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            seleccion(opcion);
        }

    }

    private void seleccion(int seleccion) {
        switch (seleccion) {
            case 1:
                crearAhorro();
                break;
            case 2:
                // listarPersonas();
                break;
            case 3:
                listarCuentas();
                break;
            case 4:
                // eliminarPersona();
                break;
            case 6:
                salir();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    private void crearAhorro() {
        System.out.println("Crear cuenta corriente");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Propietario: ");
        String propietario = scanner.nextLine();

        System.out.println("Numero de Cuenta: ");
        String numeroCuenta = scanner.nextLine();

        System.out.println("Saldo: ");
        Float saldo = scanner.nextFloat();

        scanner.nextLine();
        System.out.println("Depositos: ");
        int depositos = scanner.nextInt();

        System.out.println("Retiros: ");
        int retiros = scanner.nextInt();

        Ahorro ahorro = new Ahorro(depositos, numeroCuenta, saldo, propietario, retiros);
        servicioCuenta.crearAhorro(ahorro);

    }

    private void listarCuentas() {
        System.out.println("Listando Cuentas");
        List<Ahorro> personasEnBaseDatos = servicioCuenta.listarAhorros();

        for (Ahorro personaEnBaseDatos : personasEnBaseDatos) {
            System.out.println(personaEnBaseDatos.getPropietario());
        }
    }

    private void salir() {
        System.out.println("Salir");
        correr = false;
    }

}
