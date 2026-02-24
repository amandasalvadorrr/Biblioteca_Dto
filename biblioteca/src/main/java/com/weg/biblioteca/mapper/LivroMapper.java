package com.weg.biblioteca.mapper;

import com.weg.biblioteca.dto.LivroRequisicaoDto;
import com.weg.biblioteca.dto.LivroRespostaDto;
import com.weg.biblioteca.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {
    public Livro paraEntidade(
            LivroRequisicaoDto livroRequisicaoDto){
        return new Livro(
                livroRequisicaoDto.titulo(),
                livroRequisicaoDto.autor(),
                livroRequisicaoDto.ano_publicacao()
        );
    }

    public LivroRespostaDto paraRespostaDto(
            Livro livro
    ){
        return new LivroRespostaDto(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAno_publicacao()
        );
    }
}
