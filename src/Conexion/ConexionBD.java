package Conexion;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Angie Ballesteros
 */ 
public class ConexionBD {
    private static Connection cn = null;
    private static Driver driver = new org.apache.derby.jdbc.ClientDriver();
    private static String URLBD = "jdbc:derby://localhost:1527/Contac";
    private static String usuario = "Angie";
    private static String contrasena = "gabye6";
        
    public static Connection getConexion() throws SQLException {
        DriverManager.registerDriver(driver);
        cn = DriverManager.getConnection(URLBD, usuario, contrasena);
        return cn;
    }
    
    public static void desconectar(){
      cn = null;
   }

}

class TestConexionBD {
    private static Connection con;
   
    public static void main(String[] args) throws SQLException{
        con = ConexionBD.getConexion();
        if(con != null){
            JOptionPane.showMessageDialog(null, "Conexión Realizada Correctamente");
        }
    }
}
   
