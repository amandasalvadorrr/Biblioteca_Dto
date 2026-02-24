package com.weg.biblioteca.mapper;

import com.weg.biblioteca.dto.UsuarioRequisicaoDto;
import com.weg.biblioteca.dto.UsuarioRespostaDto;
import com.weg.biblioteca.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario paraEntidade(
            UsuarioRequisicaoDto usuarioRequisicaoDto){
        return new Usuario(
                usuarioRequisicaoDto.nome(),
                usuarioRequisicaoDto.email()
        );
    }

    public UsuarioRespostaDto paraRespostaDto(
            Usuario usuario
    ){
        return new UsuarioRespostaDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}
