package com.weg.biblioteca.dto;

import java.util.Date;

public record EmprestimoRequisicaoDto(
        int livro_id,
        int usuario_id,
        Date data_emprestimo,
        Date data_devolucao
) {
}
