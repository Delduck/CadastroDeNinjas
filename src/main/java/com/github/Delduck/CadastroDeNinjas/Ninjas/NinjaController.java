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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.criarNinja(ninjaDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjasID(@PathVariable Long id) {
        ninjaService.deletarNinjasID(id);
    }


    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjaID(@PathVariable Long id,
                                 @RequestBody NinjaModel ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }


}
