/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionBD;
import Modelo.Grupo;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GrupoDAO {

    private Connection dbConnection;
    private PreparedStatement preparedStmt;
    private ResultSet resultSet;

    public GrupoDAO() {
        dbConnection = null;
        preparedStmt = null;
        resultSet = null;
    }

    public int create(Grupo grupo) {
        int resultado = 0;
        try {
            dbConnection = ConexionBD.getConexion();
            System.out.println("asdasd");
            String insertSQL = "INSERT INTO grupo (nombre,id)" + " VALUES(?,  ?)";

            preparedStmt = dbConnection.prepareStatement(insertSQL);
            System.out.println("asdasd");
            preparedStmt.setString(1, grupo.getNombre());
            System.out.println("asdasd");
            preparedStmt.setInt(2, grupo.getid());
            System.out.println("asdasd");
            resultado = preparedStmt.executeUpdate();
            System.out.println("asdasd");
            dbConnection.close();
            preparedStmt.close();
            JOptionPane.showMessageDialog(null, "Se ha Creado un Nuevo Grupo Exitosamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas con la Creación del Grupo");
        }
        return resultado;
    }

    public Grupo read(int id) {
        Grupo grupoRead = new Grupo();
        try {
            dbConnection = ConexionBD.getConexion();
            String selectSQL = "SELECT * FROM grupo WHERE id = ?";
            preparedStmt = dbConnection.prepareStatement(selectSQL);
            preparedStmt.setInt(1, id);
            resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                grupoRead.setNombre(resultSet.getString("nombre"));
            }
            dbConnection.close();
            preparedStmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showInputDialog("Problemas en la Consulta");
        }

        return grupoRead;
    }

    public int update(Grupo grupo) {
        int resultado = 0;
        try {
            dbConnection = ConexionBD.getConexion();
            String updateSQL = "UPDATE grupo SET  nombre = ? " + "  WHERE id =  ?";
            preparedStmt = dbConnection.prepareStatement(updateSQL);
            preparedStmt.setString(1, grupo.getNombre());
            preparedStmt.setInt(2, grupo.getid());
            resultado = preparedStmt.executeUpdate();
            dbConnection.close();
            preparedStmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showInputDialog("Problemas con la Actualizacion del Grupo ");
        }
        return resultado;
    }

    public int delete(int id) {
        int resultado = 0;
        try {
            dbConnection = ConexionBD.getConexion();
            String deleteSQL = "DELETE FROM grupo WHERE id = ?";
            preparedStmt = dbConnection.prepareStatement(deleteSQL);
            preparedStmt.setInt(1, id);
            resultado = preparedStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas con el Borrado de un grupo Comuniquese con el Administrador");
        }

        return resultado;
    }
    /*
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
     */
}
