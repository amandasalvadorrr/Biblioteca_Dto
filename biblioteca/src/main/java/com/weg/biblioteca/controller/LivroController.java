package com.weg.biblioteca.controller;

import com.weg.biblioteca.dto.LivroRequisicaoDto;
import com.weg.biblioteca.dto.LivroRespostaDto;
import com.weg.biblioteca.model.Livro;
import com.weg.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public LivroRespostaDto salvarLivro (
            @RequestBody LivroRequisicaoDto requisicaoDto
    ) {
        try {
            return livroService.salvarLivro(requisicaoDto);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<Livro> listaDeLivros(){
        try {
            return livroService.buscarTodosOsLivros();
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Livro listarLivroPorId(
            @PathVariable int id
    ){
        try {
            return livroService.buscarLivroPorId(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Livro atualizarLivroPorId(
            @PathVariable int id,
            @RequestBody Livro livro
    ){
        try {
            return livroService.atualizarLivro(livro, id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarLivroPorId(
            @PathVariable int id
    ){
        try {
            livroService.deletarLivro(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
