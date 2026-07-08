package com.github.Delduck.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar todos os NINJAS
    @GetMapping("/listar")
    public String mostrarTodosNinjas() {
        return "Mostrar Ninja";
    }

    // Mostrar Ninja por ID
    @GetMapping("/{idNinja}")
    public String mostrarTodosNinjasPorId(@PathVariable String idNinja) {
        return "Mostrar Ninja por id";
    }

    // Alterar dados Ninja
    @PutMapping("/{alterarID}")
    public String alterarNinjaID(@PathVariable String alterarID) {
        return "Alterar ninja por id";
    }

    // Deletar Ninja por ID
    @DeleteMapping("/{deletarID}")
    public String deletarNinjaID(@PathVariable String deletarID) {
        return "Ninja deletado por id";
    }
}
