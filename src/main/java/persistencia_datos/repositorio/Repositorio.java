package persistencia_datos.repositorio;

import java.util.List;

public interface Repositorio {

    // CUENTA AHORROS
    public void crearAhorro(Object objeto);

    // CUENTA CORRIENTE
    public void crearCorriente(Object objeto);

    public Object buscar(String numeroCuenta);

    public void eliminar(String identificador);

    public void actualizar(Object objeto);

    public List<?> listar();
}
