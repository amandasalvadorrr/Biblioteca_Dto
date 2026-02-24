package com.weg.biblioteca.mapper;

import com.weg.biblioteca.dto.EmprestimoRequisicaoDto;
import com.weg.biblioteca.dto.EmprestimoRespostaDto;
import com.weg.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoMapper {
    public Emprestimo paraEntidade(
            EmprestimoRequisicaoDto emprestimoRequisicaoDto){
        return new Emprestimo(
                emprestimoRequisicaoDto.livro_id(),
                emprestimoRequisicaoDto.usuario_id(),
                emprestimoRequisicaoDto.data_emprestimo(),
                emprestimoRequisicaoDto.data_devolucao()
        );
    }

    public EmprestimoRespostaDto paraRespostaDto(
            Emprestimo emprestimo
    ){
        return new EmprestimoRespostaDto(
                emprestimo.getId(),
                emprestimo.getLivro_id(),
                emprestimo.getUsuario_id(),
                emprestimo.getData_emprestimo(),
                emprestimo.getData_devolucao()
        );
    }
}
