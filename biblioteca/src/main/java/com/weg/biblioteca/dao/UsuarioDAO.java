package com.weg.biblioteca.dao;

import com.weg.biblioteca.model.Usuario;
import com.weg.biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioDAO {

    public Usuario salvarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nome, email) VALUES (?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()){
                usuario.setId(rs.getInt(1));
                return usuario;
            }
        }
        throw new RuntimeException("Não foi possível cadastrar um usuário.");
    }

    public List<Usuario> buscarTodosOsUsuarios() throws SQLException {
        List<Usuario> ListaUsuarios = new ArrayList<>();
        String query = "SELECT id, nome, email FROM usuario";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ListaUsuarios.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email")
                ));
            }
            return ListaUsuarios;
        }
    }

    public Usuario buscarUsuarioPorId(int id) throws SQLException {
        String query = "SELECT id, nome, email FROM usuario WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email")
                );
            }
        }
        throw new RuntimeException("Nenhum usuário foi encontrado.");
    }

    public Usuario atualizarUsuario(Usuario usuario) throws SQLException{
        String query = "UPDATE usuario SET nome = ?, email = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setInt(3,usuario.getId());
            stmt.executeUpdate();
        }
        return usuario;
    }

    public void deletarUsuario(int id) throws SQLException{
        String query = "DELETE FROM usuario WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }
}
