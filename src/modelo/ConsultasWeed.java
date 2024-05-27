package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasWeed extends Conexion {

    public boolean registrar(Weed weed) {

        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "INSERT INTO Weed (codigo, nombre, gramos, raza, genero) VALUES(?,?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, weed.getCodigo());
            ps.setString(2, weed.getNombre());
            ps.setInt(3, weed.getGramos());
            ps.setString(4, weed.getRaza());
            ps.setString(5, weed.getGenero());
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

    public boolean modificar(Weed weed) {

        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "UPDATE  Weed SET codigo=?, nombre=?, gramos=?, raza=?, genero=? WHERE Codigo=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, weed.getCodigo());
            ps.setString(2, weed.getNombre());
            ps.setInt(3, weed.getGramos());
            ps.setString(4, weed.getRaza());
            ps.setString(5, weed.getGenero());
            ps.setInt(6, weed.getCodigo());
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

    public boolean eliminar(Weed weed) {

        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "DELETE FROM Weed WHERE Codigo=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, weed.getCodigo());
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

    public boolean buscar(Weed weed) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "SELECT * FROM Weed WHERE Codigo=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, weed.getCodigo());
            rs = ps.executeQuery();

            if (rs.next()) {

                weed.setCodigo(rs.getInt("Codigo"));
                weed.setNombre(rs.getString("Nombre"));
                weed.setGramos(rs.getInt("Gramos"));
                weed.setRaza(rs.getString("Raza"));
                weed.setGenero(rs.getString("Genero"));
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
    
    public int contWeed() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String sql = "SELECT COUNT(*) FROM weed;";

        try {

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int count=0;
            
            if(rs.next()){
                return count = rs.getInt("COUNT(*)");
            }
            return 0;

        } catch (SQLException e) {
            System.err.print(e);
            return 0;
        }
    }
    
    
    public int maxWeed() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String sql = "SELECT MAX(gramos) FROM weed;";

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
