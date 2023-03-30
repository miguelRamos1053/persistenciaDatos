package persistencia_datos.servicios;

import java.util.List;

import persistencia_datos.entidades.Ahorro;
import persistencia_datos.entidades.Corriente;
import persistencia_datos.repositorio.CuentaDB;
import persistencia_datos.repositorio.Repositorio;

public class ServicioCuenta {

    private Repositorio repositorioCuenta;

    public ServicioCuenta() {
        this.repositorioCuenta = new CuentaDB();
    }

    public void crearAhorro(Ahorro nuevoAhorro) {
        repositorioCuenta.crearAhorro(nuevoAhorro);
    }

    public void crearCorriente(Corriente nuevoCorriente) {
        repositorioCuenta.crearCorriente(nuevoCorriente);
    }

    public List<Ahorro> listarAhorros() {
        return (List<Ahorro>) repositorioCuenta.listarAhorros();
    }
}
