package persistencia_datos.entidades;

public class Corriente extends Cuenta {
    int transferenciasAhorro;

    public Corriente(int transferenciasAhorro, String numeroCuenta, float saldo, String propietario, int retiros) {
        super(numeroCuenta, saldo, propietario, retiros);
        this.transferenciasAhorro = transferenciasAhorro;
    }

    public int getTransferenciasAhorro() {
        return transferenciasAhorro;
    }

    public void setTransferenciasAhorro(int transferenciasAhorro) {
        this.transferenciasAhorro = transferenciasAhorro;
    }

}
