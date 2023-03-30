package persistencia_datos;

import java.util.ArrayList;

import persistencia_datos.entidades.Ahorro;
import persistencia_datos.entidades.Corriente;
import persistencia_datos.gui.GUI_Cuenta;
import persistencia_datos.repositorio.CuentaDB;
import persistencia_datos.repositorio.Repositorio;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Repositorio repositorio = new CuentaDB();

        // ----- CUENTA AHORRO ----------------------------------------------------

        // Ahorro ahorro1 = new Ahorro(1, "dd", 30000, "nuevooo", 0);
        // Ahorro ahorro2 = new Ahorro(0, "rrr", 20000, "Tigre1", 0);

        // ----Crear ahorro ----
        // repositorio.crearAhorro(ahorro1);
        // repositorio.crearAhorro(ahorro2);

        // ---- Actualizar ahorro -----
        // repositorio.actualizarAhorro(ahorro1);

        // ---Listar Ahorro ---
        // ArrayList<Ahorro> ahorrosBaseDatos = (ArrayList<Ahorro>)
        // repositorio.listarAhorros();

        // for (Ahorro ahorroBaseDatos : ahorrosBaseDatos) {
        // System.out.println(ahorroBaseDatos.getPropietario());
        // }

        // ----- CUENTA CORRIENTE ----------------------------------------------------

        // Corriente corriente1 = new Corriente(0, "zz", 20000, "Bard C nuevo", 0);

        // ----Crear corriente ----
        // repositorio.crearCorriente(corriente1);

        // ---- Actualizar corriente -----
        // repositorio.actualizarCorriente(corriente1);

        // ---Listar corriente ---
        // ArrayList<Corriente> corrientesBaseDatos = (ArrayList<Corriente>)
        // repositorio.listarCorrientes();

        // for (Corriente corrienteBaseDatos : corrientesBaseDatos) {
        // System.out.println(corrienteBaseDatos.getPropietario());
        // }

        GUI_Cuenta gui = new GUI_Cuenta();
        gui.iniciar();

    }
}
