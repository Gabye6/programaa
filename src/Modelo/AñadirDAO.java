/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionBD;
import Modelo.Contacto;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AñadirDAO {

    private Connection dbConnection;
    private PreparedStatement preparedStmt;
    private ResultSet resultSet;

    public AñadirDAO() {
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

}
