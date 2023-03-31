package persistencia_datos.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persistencia_datos.entidades.Ahorro;
import persistencia_datos.entidades.Corriente;
import persistencia_datos.entidades.Cuenta;

public class CuentaDB implements Repositorio {

    private String cadenaConexion;

    public CuentaDB() {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            cadenaConexion = "jdbc:sqlite:banco.db";
            crearTabla();
        } catch (SQLException e) {
            System.err.println("Error de conexión con la base de datos: " + e);
        }

    }

    private void crearTabla() {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {

            String sql = "CREATE TABLE IF NOT EXISTS cuenta (\n"
                    + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + " numeroCuenta  TEXT NOT NULL UNIQUE,\n"
                    + " tipo TEXT NOT NULL,\n"
                    + " saldo REAL NOT NULL,\n"
                    + " propietario TEXT NOT NULL,\n"
                    + " retiros INTEGER NOT NULL,\n"
                    + " depositos INTEGER,\n"
                    + " transferenciasAhorro INTEGER\n"
                    + ");";

            Statement sentencia = conexion.createStatement();
            sentencia.execute(sql);

        } catch (SQLException e) {
            System.out.println("Error de conexión: ya se " + e.getMessage());
        }
    }

    @Override
    public void crearAhorro(Object objeto) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            Ahorro ahorro = (Ahorro) objeto;
            String tipo = "Ahorro";
            String sentenciaSql = "INSERT INTO cuenta (numeroCuenta, tipo, saldo, propietario, retiros,depositos,transferenciasAhorro) "
                    + " VALUES('" + ahorro.getNumeroCuenta() + "','" + tipo + "','"
                    + ahorro.getSaldo() + "', '" + ahorro.getPropietario()
                    + "', '" + ahorro.getRetiros() + "','" + ahorro.getDepositos() + "',0);";
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sentenciaSql);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public void crearCorriente(Object objeto) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            Corriente corriente = (Corriente) objeto;
            String tipo = "Corriente";
            String sentenciaSql = "INSERT INTO cuenta (numeroCuenta, tipo, saldo, propietario, retiros,depositos,transferenciasAhorro) "
                    + " VALUES('" + corriente.getNumeroCuenta() + "','" + tipo + "','"
                    + corriente.getSaldo() + "', '" + corriente.getPropietario()
                    + "', '" + corriente.getRetiros() + "'," + "0 , '" + corriente.getTransferenciasAhorro() + "');";
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sentenciaSql);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public void actualizarAhorro(Object objeto) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            Ahorro ahorro = (Ahorro) objeto;

            String senteciaSql = "UPDATE cuenta SET saldo=?, propietario=?, retiros=?, depositos=? WHERE numeroCuenta = ?;";

            PreparedStatement sentencia = conexion.prepareStatement(senteciaSql);

            sentencia.setString(1, Float.toString(ahorro.getSaldo()));
            sentencia.setString(2, ahorro.getPropietario());
            sentencia.setString(3, Integer.toString(ahorro.getRetiros()));
            sentencia.setString(4, Integer.toString(ahorro.getDepositos()));
            sentencia.setString(5, ahorro.getNumeroCuenta());

            sentencia.execute();

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public void actualizarCorriente(Object objeto) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            Corriente corriente = (Corriente) objeto;

            String senteciaSql = "UPDATE cuenta SET saldo=?, propietario=?, retiros=?, transferenciasAhorro=? WHERE numeroCuenta = ?;";

            PreparedStatement sentencia = conexion.prepareStatement(senteciaSql);

            sentencia.setString(1, Float.toString(corriente.getSaldo()));
            sentencia.setString(2, corriente.getPropietario());
            sentencia.setString(3, Integer.toString(corriente.getRetiros()));
            sentencia.setString(4, Integer.toString(corriente.getTransferenciasAhorro()));
            sentencia.setString(5, corriente.getNumeroCuenta());

            sentencia.execute();

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public Object buscarAhorro(String numCuenta) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {

            String sentenciaSQL = "SELECT * FROM cuenta WHERE tipo='Ahorro' AND numeroCuenta = ?";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, numCuenta);
            ResultSet resultadoConsulta = sentencia.executeQuery();
            if (resultadoConsulta != null && resultadoConsulta.next()) {
                Ahorro ahorro = null;
                String numeroCuenta = resultadoConsulta.getString("numeroCuenta");
                float saldo = resultadoConsulta.getFloat("saldo");
                String propietario = resultadoConsulta.getString("propietario");
                int retiros = resultadoConsulta.getInt("retiros");
                int depositos = resultadoConsulta.getInt("depositos");
                ahorro = new Ahorro(depositos, numeroCuenta, saldo, propietario, retiros);
                return ahorro;
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

    @Override
    public void eliminar(String identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public void actualizar(Object objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public List<?> listarAhorros() {
        List<Ahorro> ahorros = new ArrayList<Ahorro>();

        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "SELECT * FROM cuenta WHERE tipo = 'Ahorro'";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
            ResultSet resultadoConsulta = sentencia.executeQuery();

            if (resultadoConsulta != null) {
                while (resultadoConsulta.next()) {
                    Ahorro ahorro = null;

                    int depositos = resultadoConsulta.getInt("depositos");
                    String numeroCuenta = resultadoConsulta.getString("numeroCuenta");
                    Float saldo = resultadoConsulta.getFloat("saldo");
                    String propietario = resultadoConsulta.getString("propietario");
                    int retiros = resultadoConsulta.getInt("retiros");

                    ahorro = new Ahorro(depositos, numeroCuenta, saldo, propietario, retiros);
                    ahorros.add(ahorro);
                }
                return ahorros;
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

    @Override
    public List<?> listarCorrientes() {
        List<Corriente> corrientes = new ArrayList<Corriente>();

        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "SELECT * FROM cuenta WHERE tipo = 'Corriente'";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
            ResultSet resultadoConsulta = sentencia.executeQuery();

            if (resultadoConsulta != null) {
                while (resultadoConsulta.next()) {
                    Corriente corriente = null;

                    int transferenciasAhorro = resultadoConsulta.getInt("transferenciasAhorro");
                    String numeroCuenta = resultadoConsulta.getString("numeroCuenta");
                    Float saldo = resultadoConsulta.getFloat("saldo");
                    String propietario = resultadoConsulta.getString("propietario");
                    int retiros = resultadoConsulta.getInt("retiros");

                    corriente = new Corriente(transferenciasAhorro, numeroCuenta, saldo, propietario, retiros);
                    corrientes.add(corriente);
                }
                return corrientes;
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

}
