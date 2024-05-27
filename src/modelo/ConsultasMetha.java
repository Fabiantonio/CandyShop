
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasMetha extends Conexion{
    
    public boolean registrar(Methamphetamine metha) {

        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "INSERT INTO Methamphetamine (codigo, nombre, gramos, pureza, color) VALUES(?,?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, metha.getCodigo());
            ps.setString(2, metha.getNombre());
            ps.setInt(3, metha.getGramos());
            ps.setInt(4, metha.getPureza());
            ps.setString(5, metha.getColor());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.print(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.print(e);
            }

        }

    }
    
    public boolean modificar(Methamphetamine metha) {

        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "UPDATE  methamphetamine SET codigo=?, nombre=?, gramos=?, pureza=?, color=? WHERE Codigo=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, metha.getCodigo());
            ps.setString(2, metha.getNombre());
            ps.setInt(3, metha.getGramos());
            ps.setInt(4, metha.getPureza());
            ps.setString(5, metha.getColor());
            ps.setInt(6, metha.getCodigo());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.print(e);
            return false;
        } finally {

            try {
                con.close();
            } catch (SQLException e) {
                System.err.print(e);
            }

        }

    }
    

    public boolean eliminar(Methamphetamine metha) {

        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "DELETE FROM methamphetamine WHERE Codigo=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, metha.getCodigo());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.print(e);
            return false;
        } finally {

            try {
                con.close();
            } catch (SQLException e) {
                System.err.print(e);
            }

        }

    }
    
    public boolean buscar(Methamphetamine metha) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "SELECT * FROM methamphetamine WHERE Codigo=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, metha.getCodigo());
            rs = ps.executeQuery();

            if (rs.next()) {

                metha.setCodigo(rs.getInt("Codigo"));
                metha.setNombre(rs.getString("Nombre"));
                metha.setGramos(rs.getInt("Gramos"));
                metha.setPureza(rs.getInt("Pureza"));
                metha.setColor(rs.getString("Color"));
                return true;
            }

            return false;

        } catch (SQLException e) {
            System.err.print(e);
            return false;
        } finally {

            try {
                con.close();
            } catch (SQLException e) {
                System.err.print(e);
            }

        }

    }
    
    public int contMetha(){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String sql = "SELECT COUNT(*) FROM methamphetamine;";
        
        try {
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int count=0;
            
            if(rs.next()){
                
                return count = rs.getInt("COUNT(*)");
                
            }
            return 0;
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0; 
    }
    
    public int maxMetha() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String sql = "SELECT MAX(gramos) FROM methamphetamine;";

        try {

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt("MAX(gramos)");
            }
            return 0;

        } catch (SQLException e) {
            System.err.print(e);
            return 0;
        }
    }
    
}
