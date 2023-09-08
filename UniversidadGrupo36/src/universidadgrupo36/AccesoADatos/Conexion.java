
package universidadgrupo36.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    
    private static final String URL ="jdbc:mariadb://localhost/";
    private static final String DB= "universidadulpgrupo36";
    private static final String USUARIO= "root";
    private static final String PASSWORD="";
    private static Connection connection;
    
    private Conexion (){}
    
    private static Connection getConnection(){
    
        if (connection == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
                 
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "error al cargar drivers");
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "error al conectarse");
            }
           
        }
        return connection;
    
    }
    
    
}
