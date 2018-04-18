package Modelo;

/**
 *
 * @author Angie Ballesteros
 */
import Conexion.ConexionBD;
import Modelo.Contacto;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ContactoDAO {

    private Connection dbConnection;
    private PreparedStatement preparedStmt;
    private ResultSet resultSet;

    public ContactoDAO() {
        dbConnection = null;
        preparedStmt = null;
        resultSet = null;
    }

    public int create(Contacto contacto) {
        int resultado = 0;
        try {
            dbConnection = ConexionBD.getConexion();
            String insertSQL = "INSERT INTO contacto(nombre,telefono,id)" + " VALUES(?,  ?,  ?)";

            preparedStmt = dbConnection.prepareStatement(insertSQL);
            preparedStmt.setString(1, contacto.getNombre());
            preparedStmt.setString(2, contacto.getTelefono());
            preparedStmt.setInt(3, contacto.getId());
            resultado = preparedStmt.executeUpdate();
            dbConnection.close();
            preparedStmt.close();
            JOptionPane.showMessageDialog(null, "Se ha Creado un NuevoContacto Exitosamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas con la Creación del Contacto Comuniquese con el Adminstrador");
        }
        return resultado;
    }

    public Contacto read(int id) {
        Contacto contactoRead = new Contacto();
        try {
            dbConnection = ConexionBD.getConexion();
            String selectSQL = "SELECT * FROM contacto WHERE id = ?";
            preparedStmt = dbConnection.prepareStatement(selectSQL);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                contactoRead.setNombre(resultSet.getString("nombre"));
                contactoRead.setTelefono(resultSet.getString("telefono"));
            }
            dbConnection.close();
            preparedStmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showInputDialog("Problemas en la Consulta Comuniquese con el Administrador");
        }

        return contactoRead;
    }

    public int update(Contacto contacto) {
        int resultado = 0;
        try {
            dbConnection = ConexionBD.getConexion();
            String updateSQL = "UPDATE contacto SET  Telefono = ? nombre =  ? " + "  WHERE id =  ?";
            preparedStmt = dbConnection.prepareStatement(updateSQL);
            preparedStmt.setString(1, contacto.getNombre());
            preparedStmt.setString(2, contacto.getTelefono());
            preparedStmt.setInt(3, contacto.getId());
            resultado = preparedStmt.executeUpdate();
            dbConnection.close();
            preparedStmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showInputDialog("Problemas con la Actualizacion de un Contacto Comuniquese con el Administrador");
        }
        return resultado;
    }

    public int delete(int id) {
        int resultado = 0;
        try {
            dbConnection = ConexionBD.getConexion();
            String deleteSQL = "DELETE FROM contacto WHERE id = ?";
            preparedStmt = dbConnection.prepareStatement(deleteSQL);
            preparedStmt.setInt(1, id);
            resultado = preparedStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showInputDialog("Problemas con el Borrado de un Contacto Comuniquese con el Administrador");
        }

        return resultado;
    }

    public List<Contacto> readAll() {
        List<Contacto> listContacto = null;
        try {
            dbConnection = ConexionBD.getConexion();

            String selectSQL = "SELECT * FROM contacto";

            preparedStmt = dbConnection.prepareStatement(selectSQL);

            resultSet = preparedStmt.executeQuery();

            Contacto contactoAll;

            while (resultSet.next()) {
                contactoAll = new Contacto();
                contactoAll.setNombre(resultSet.getString("nombre"));
                contactoAll.setTelefono(resultSet.getString("telefono"));
                listContacto.add(contactoAll);
            }
            dbConnection.close();
            preparedStmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showInputDialog("Problemas en la Consulta Comuniquese con el Administrador");
        }
        return listContacto;
    }

}
