package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    Conexion conexion = new Conexion();

    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        try {
            Connection con = conexion.getConexion();
            String sql = "SELECT * FROM usuarios";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setClave(rs.getString("clave"));
                u.setDocumento(rs.getString("documento"));
                u.setNombreCompleto(rs.getString("nombre_completo"));
                lista.add(u);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error listarUsuarios: " + e.getMessage());
        }
        return lista;
    }

    public boolean insertarUsuario(Usuario u) {
        try {
            Connection con = conexion.getConexion();
            String sql = "INSERT INTO usuarios (usuario, clave, documento, nombre_completo) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getClave());
            ps.setString(3, u.getDocumento());
            ps.setString(4, u.getNombreCompleto());

            ps.executeUpdate();

            ps.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error insertarUsuario: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarUsuario(Usuario u) {
        try {
            Connection con = conexion.getConexion();
            String sql = "UPDATE usuarios SET usuario = ?, clave = ?, documento = ?, nombre_completo = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getClave());
            ps.setString(3, u.getDocumento());
            ps.setString(4, u.getNombreCompleto());
            ps.setInt(5, u.getId());

            ps.executeUpdate();

            ps.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error actualizarUsuario: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarUsuario(int id) {
        try {
            Connection con = conexion.getConexion();
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error eliminarUsuario: " + e.getMessage());
            return false;
        }
    }

    public Usuario buscarPorDocumento(String documento) {
        Usuario u = null;
        try {
            Connection con = conexion.getConexion();
            String sql = "SELECT * FROM usuarios WHERE documento = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setClave(rs.getString("clave"));
                u.setDocumento(rs.getString("documento"));
                u.setNombreCompleto(rs.getString("nombre_completo"));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error buscarPorDocumento: " + e.getMessage());
        }
        return u;
    }

    public Usuario login(String usuario, String clave) {
        Usuario u = null;
        try {
            Connection con = conexion.getConexion();
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND clave = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setClave(rs.getString("clave"));
                u.setDocumento(rs.getString("documento"));
                u.setNombreCompleto(rs.getString("nombre_completo"));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error en login: " + e.getMessage());
        }
        return u;
    }
}
