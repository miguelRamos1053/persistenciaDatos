package persistencia_datos;

import java.util.ArrayList;

import persistencia_datos.entidades.Ahorro;
import persistencia_datos.entidades.Corriente;
import persistencia_datos.repositorio.CuentaDB;
import persistencia_datos.repositorio.Repositorio;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Repositorio repositorio = new CuentaDB();

        Ahorro ahorro1 = new Ahorro(1, "dd", 30000, "nuevooo", 0);
        // Ahorro ahorro2 = new Ahorro(0, "rrr", 20000, "Tigre1", 0);

        Corriente corriente1 = new Corriente(0, "zz", 20000, "Bard C nuevo", 0);

        // repositorio.crearAhorro(ahorro1);
        // repositorio.crearAhorro(ahorro2);

        // repositorio.crearCorriente(corriente1);

        // repositorio.actualizarAhorro(ahorro1);
        repositorio.actualizarCorriente(corriente1);

        ArrayList<Corriente> corrientesBaseDatos = (ArrayList<Corriente>) repositorio.listarCorrientes();

        ArrayList<Ahorro> ahorrosBaseDatos = (ArrayList<Ahorro>) repositorio.listarAhorros();

        for (Corriente corrienteBaseDatos : corrientesBaseDatos) {
            System.out.println(corrienteBaseDatos.getPropietario());
        }

    }
}
