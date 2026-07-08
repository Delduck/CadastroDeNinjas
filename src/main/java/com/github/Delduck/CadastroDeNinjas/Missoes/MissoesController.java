package com.github.Delduck.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissao() {
        return "Missões listadas com sucesso";
    }

    @PostMapping("/criar")
    public String criarMIssoes() {
        return "Missão criada com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missao deletada com sucesso";
    }

}
