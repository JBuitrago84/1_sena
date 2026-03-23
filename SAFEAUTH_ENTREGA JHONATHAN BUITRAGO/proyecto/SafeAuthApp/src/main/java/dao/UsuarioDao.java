package dao;

import conexion.conexionDB;
import modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    // Insertar usuario
    public void insertar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (usuario, email, contrasena, estado) VALUES (?, ?, ?, ?)";

        try (Connection conn = conexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getContrasena());
            stmt.setInt(4, usuario.getEstado());

            stmt.executeUpdate();
            System.out.println("Usuario insertado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    // CONSULTAR TODOS
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = conexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setEmail(rs.getString("email"));
                u.setContrasena(rs.getString("contrasena"));
                u.setEstado(rs.getInt("estado"));

                lista.add(u);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }

        return lista;
    }

    // Actualizar usuario
    public void actualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET usuario=?, email=?, contrasena=?, estado=? WHERE id=?";

        try (Connection conn = conexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getContrasena());
            stmt.setInt(4, usuario.getEstado());
            stmt.setInt(5, usuario.getId());

            stmt.executeUpdate();
            System.out.println("Usuario actualizado");

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    // Eliminar usuario
    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id=?";

        try (Connection conn = conexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuario eliminado");

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}