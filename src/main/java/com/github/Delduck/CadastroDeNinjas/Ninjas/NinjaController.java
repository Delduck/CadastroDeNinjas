package com.github.Delduck.CadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
@RequiredArgsConstructor
public class NinjaController {

    private final NinjaService ninjaService;

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
    public List<NinjaModel> mostrarTodosNinjas() {
        return ninjaService.listarNinjas();
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
