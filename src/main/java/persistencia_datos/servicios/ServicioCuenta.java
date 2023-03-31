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

    public void actualizarAhorro(Ahorro ahorroEditado) {
        repositorioCuenta.actualizarAhorro(ahorroEditado);
    }

    public List<Ahorro> listarAhorros() {
        return (List<Ahorro>) repositorioCuenta.listarAhorros();
    }

    public Ahorro buscarAhorro(String numeroCuenta) throws Exception {
        Object ahorro = repositorioCuenta.buscarAhorro(numeroCuenta);
        if (ahorro == null) {
            throw new Exception("No se encontro la cuenta de ahorro");
        }
        return (Ahorro) ahorro;
    }

    public void retirarAhorro(String numeroCuenta, float valor) {
        Ahorro ahorro = null;
        float retiroTotal = 0;

        // -- Exception para comprobar si existe o no la cuenta
        try {
            ahorro = buscarAhorro(numeroCuenta);

            if (ahorro.getRetiros() > 3) {
                float cobroRetiroAhorro = cobroRetiroAhorro(valor);
                retiroTotal = valor + cobroRetiroAhorro;

                // ahorro.setRetiros(ahorro.getRetiros() + 1);
            } else {
                retiroTotal = valor;
            }

            if (ahorro.getSaldo() - retiroTotal < 0) {
                System.out.println("Fondos insuficientes");
            } else {
                ahorro.setSaldo(ahorro.getSaldo() - retiroTotal);

                repositorioCuenta.actualizarAhorro(ahorro);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public float cobroRetiroAhorro(float valor) {
        float cobro = valor / 100;
        return cobro;
    }

}
