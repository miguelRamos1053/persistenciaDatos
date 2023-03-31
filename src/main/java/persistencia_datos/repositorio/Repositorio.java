package persistencia_datos.repositorio;

import java.util.List;

public interface Repositorio {

    // CUENTA AHORROS
    public void crearAhorro(Object objeto);

    public void actualizarAhorro(Object objeto);

    public Object buscarAhorro(String numeroCuenta);

    public List<?> listarAhorros();

    // CUENTA CORRIENTE
    public void crearCorriente(Object objeto);

    public void actualizarCorriente(Object objeto);

    public List<?> listarCorrientes();

    public void eliminar(String identificador);

    public void actualizar(Object objeto);

}
