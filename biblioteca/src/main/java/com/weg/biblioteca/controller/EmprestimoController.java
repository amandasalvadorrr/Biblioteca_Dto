package com.weg.biblioteca.controller;

import com.weg.biblioteca.dto.EmprestimoRequisicaoDto;
import com.weg.biblioteca.dto.EmprestimoRespostaDto;
import com.weg.biblioteca.model.Emprestimo;
import com.weg.biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    public EmprestimoRespostaDto salvarEmprestimo(
            @RequestBody EmprestimoRequisicaoDto emprestimoRequisicaoDto
    ) {
        try {
            return emprestimoService.salvarEmprestimo(emprestimoRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<Emprestimo> listaDeEmprestimos() {
        try {
            return emprestimoService.buscarTodosOsEmprestimos();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Emprestimo listarEmprestimoPorId(
            @PathVariable int id
    ) {
        try {
            return emprestimoService.buscarEmprestimoPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Emprestimo atualizarEmprestimoPorId(
            @PathVariable int id,
            @RequestBody Emprestimo emprestimo
    ) {
        try {
            return emprestimoService.atualizarEmprestimo(emprestimo, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarEmprestimoPorId(
            @PathVariable int id
    ) {
        try {
            emprestimoService.deletarEmprestimo(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}