package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ContactoDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conexion = new Conexion(); // Asegúrate que esta clase maneje tu conexión MySQL

    // Listar contactos
    public List<Contacto> listar() {
        List<Contacto> lista = new ArrayList<>();
        String sql = "SELECT * FROM contactos";
        try {
            con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Contacto c = new Contacto();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                lista.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar contactos: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return lista;
    }

    // Insertar nuevo contacto
    public boolean insertar(Contacto c) {
        String sql = "INSERT INTO contactos (nombre, telefono, email) VALUES (?, ?, ?)";
        try {
            con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: " + e.getMessage());
            return false;
        } finally {
            cerrarRecursos();
        }
    }

    // Actualizar contacto existente
    public boolean actualizar(Contacto c) {
        String sql = "UPDATE contactos SET nombre=?, telefono=?, email=? WHERE id=?";
        try {
            con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getEmail());
            ps.setInt(4, c.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
            return false;
        } finally {
            cerrarRecursos();
        }
    }

    // Eliminar contacto
    public boolean eliminar(int id) {
        String sql = "DELETE FROM contactos WHERE id=?";
        try {
            con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
            return false;
        } finally {
            cerrarRecursos();
        }
    }

    // Método para cerrar recursos y evitar fugas
    private void cerrarRecursos() {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (ps != null) {
                ps.close();
                ps = null;
            }
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
