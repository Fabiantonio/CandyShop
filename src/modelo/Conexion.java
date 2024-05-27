
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    
    private final String BASE = "drugstorebd";
    private final String URL = "jdbc:mysql://localhost:3306/" + BASE;
    private final String USERNAME = "root";
    private final String PASSWORD = null;
    private Connection con = null;
    
    public Connection getConnection() {

          Connection con = null;

          try {

              Class.forName("com.mysql.jdbc.Driver");
              con = (Connection) DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
              JOptionPane.showMessageDialog(null, "Conexión exitosa");

          } catch (SQLException e) {
              System.err.print(e);
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
          return con;
      }
    
}
