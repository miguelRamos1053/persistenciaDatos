package persistencia_datos;

import java.util.ArrayList;

import persistencia_datos.entidades.Ahorro;
import persistencia_datos.repositorio.CuentaDB;
import persistencia_datos.repositorio.Repositorio;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Repositorio repositorio = new CuentaDB();

        Ahorro ahorro1 = new Ahorro(1, "111", 30000, "Messi", 0);
        Ahorro ahorro2 = new Ahorro(0, "222", 20000, "Tigre", 0);

        repositorio.crearAhorro(ahorro1);
        repositorio.crearAhorro(ahorro2);

        ArrayList<Ahorro> ahorrosBaseDatos = (ArrayList<Ahorro>) repositorio.listar();

        for (Ahorro ahorroBaseDatos : ahorrosBaseDatos) {
            System.out.println(ahorroBaseDatos.getPropietario());
        }

    }
}
