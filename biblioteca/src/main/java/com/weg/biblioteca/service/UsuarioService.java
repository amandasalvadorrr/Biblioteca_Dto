package com.weg.biblioteca.service;

import com.weg.biblioteca.dao.LivroDAO;
import com.weg.biblioteca.dao.UsuarioDAO;
import com.weg.biblioteca.dto.UsuarioRequisicaoDto;
import com.weg.biblioteca.dto.UsuarioRespostaDto;
import com.weg.biblioteca.mapper.UsuarioMapper;
import com.weg.biblioteca.model.Livro;
import com.weg.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioDAO usuarioDAO;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioDAO usuarioDAO, UsuarioMapper usuarioMapper) {
        this.usuarioDAO = usuarioDAO;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioRespostaDto salvarUsuario (UsuarioRequisicaoDto requisicaoDto) throws SQLException {

        Usuario usuario = usuarioMapper.paraEntidade(requisicaoDto);

        Usuario usuarioSalvo = usuarioDAO.salvarUsuario(usuario);
        UsuarioRespostaDto usuarioRespostaDto = usuarioMapper.paraRespostaDto(usuarioSalvo);

        return usuarioRespostaDto;
    }

    public List<Usuario> buscarTodosOsUsuarios() throws SQLException{
        return usuarioDAO.buscarTodosOsUsuarios();
    }

    public Usuario buscarUsuarioPorId(int id) throws SQLException{
        return usuarioDAO.buscarUsuarioPorId(id);
    }

    public Usuario atualizarUsuario(Usuario usuario, int id) throws SQLException{
        usuario.setId(id);
        usuarioDAO.atualizarUsuario(usuario);
        return usuario;
    }

    public void deletarUsuario(int id) throws SQLException{
        usuarioDAO.deletarUsuario(id);
    }
}
