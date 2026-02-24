package com.weg.biblioteca.controller;

import com.weg.biblioteca.dto.UsuarioRequisicaoDto;
import com.weg.biblioteca.dto.UsuarioRespostaDto;
import com.weg.biblioteca.model.Usuario;
import com.weg.biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioRespostaDto salvarUsuario (
            @RequestBody UsuarioRequisicaoDto usuarioRequisicaoDto
    ) {
        try {
            return usuarioService.salvarUsuario(usuarioRequisicaoDto);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<Usuario> listaDeUsuarios(){
        try {
            return usuarioService.buscarTodosOsUsuarios();
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Usuario listarUsuarioPorId(
            @PathVariable int id
    ){
        try {
            return usuarioService.buscarUsuarioPorId(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuarioPorId(
            @PathVariable int id,
            @RequestBody Usuario usuario
    ){
        try {
            return usuarioService.atualizarUsuario(usuario, id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarUsuarioPorId(
            @PathVariable int id
    ){
        try {
            usuarioService.deletarUsuario(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
