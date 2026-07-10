package com.github.Delduck.CadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
@RequiredArgsConstructor
public class NinjaController {

    private final NinjaService ninjaService;

    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel mostrarTodosNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasId(id);
    }

    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
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
