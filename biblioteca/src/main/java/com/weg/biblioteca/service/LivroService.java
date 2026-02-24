package com.weg.biblioteca.service;

import com.weg.biblioteca.dao.LivroDAO;
import com.weg.biblioteca.dto.LivroRequisicaoDto;
import com.weg.biblioteca.dto.LivroRespostaDto;
import com.weg.biblioteca.mapper.LivroMapper;
import com.weg.biblioteca.model.Livro;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LivroService {

    private final LivroDAO livroDAO;
    private final LivroMapper livroMapper;

    public LivroService(
            LivroDAO livroDAO,
            LivroMapper livroMapper){
        this.livroDAO = livroDAO;
        this.livroMapper = livroMapper;
    }

    public LivroRespostaDto salvarLivro (
            LivroRequisicaoDto requisicaoDto) throws SQLException{

        Livro livro = livroMapper.paraEntidade(requisicaoDto);

        Livro livroSalvo = livroDAO.salvarLivro(livro);
        LivroRespostaDto livroRespostaDto = livroMapper.paraRespostaDto(livroSalvo);

        return livroRespostaDto;
    }

    public List<Livro> buscarTodosOsLivros() throws SQLException{
        return livroDAO.buscarTodosOsLivros();
    }

    public Livro buscarLivroPorId(int id) throws SQLException{
        return livroDAO.buscarLivroPorId(id);
    }

    public Livro atualizarLivro(Livro livro, int id) throws SQLException{
        livro.setId(id);
        livroDAO.atualizarLivro(livro);
        return livro;
    }

    public void deletarLivro(int id) throws SQLException{
        livroDAO.deletarLivro(id);
    }
}
