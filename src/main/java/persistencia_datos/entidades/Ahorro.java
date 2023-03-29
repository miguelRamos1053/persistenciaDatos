package persistencia_datos.entidades;

public class Ahorro extends Cuenta {
    int depositos;

    public Ahorro(int depositos, String numeroCuenta, float saldo, String propietario, int retiros) {
        super(numeroCuenta, saldo, propietario, retiros);
        this.depositos = depositos;
    }

    public int getDepositos() {
        return depositos;
    }

    public void setDepositos(int depositos) {
        this.depositos = depositos;
    }

}
