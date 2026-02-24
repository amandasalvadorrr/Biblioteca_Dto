package com.weg.biblioteca.service;

import com.weg.biblioteca.dao.EmprestimoDAO;
import com.weg.biblioteca.dto.EmprestimoRequisicaoDto;
import com.weg.biblioteca.dto.EmprestimoRespostaDto;
import com.weg.biblioteca.mapper.EmprestimoMapper;
import com.weg.biblioteca.model.Emprestimo;
import com.weg.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoDAO emprestimoDAO;
    private final EmprestimoMapper emprestimoMapper;

    public EmprestimoService(EmprestimoDAO emprestimoDAO, EmprestimoMapper emprestimoMapper) {
        this.emprestimoDAO = emprestimoDAO;
        this.emprestimoMapper = emprestimoMapper;
    }

    public EmprestimoRespostaDto salvarEmprestimo (EmprestimoRequisicaoDto requisicaoDto) throws SQLException {

        Emprestimo emprestimo = emprestimoMapper.paraEntidade(requisicaoDto);

        Emprestimo emprestimoSalvo = emprestimoDAO.salvarEmprestimo(emprestimo);
        EmprestimoRespostaDto emprestimoRespostaDto = emprestimoMapper.paraRespostaDto(emprestimoSalvo);

        return emprestimoRespostaDto;
    }

    public List<Emprestimo> buscarTodosOsEmprestimos() throws SQLException{
        return emprestimoDAO.buscarTodosOsEmprestimos();
    }

    public Emprestimo buscarEmprestimoPorId(int id) throws SQLException{
        return emprestimoDAO.buscarEmprestimoPorId(id);
    }

    public Emprestimo atualizarEmprestimo(Emprestimo emprestimo, int id) throws SQLException{
        emprestimo.setId(id);
        emprestimoDAO.atualizarEmprestimo(emprestimo);
        return emprestimo;
    }

    public void deletarEmprestimo(int id) throws SQLException{
        emprestimoDAO.deletarEmprestimo(id);
    }
}
