package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    Conexion conexion = new Conexion();

    public Usuario login(String usuario, String contraseña) {
        Usuario u = null;
        try {
            Connection con = conexion.getConexion();
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND clave = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setClave(rs.getString("clave"));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error login: " + e.getMessage());
        }
        return u;
    }
}
