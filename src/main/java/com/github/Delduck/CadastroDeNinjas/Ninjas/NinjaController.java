package com.github.Delduck.CadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
@RequiredArgsConstructor
public class NinjaController {

    private final NinjaService ninjaService;

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarTodosNinjas() {
        List<NinjaDTO> ninjasDTO = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjasDTO);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninjaDTO = ninjaService.listarNinjasId(id);

        if (ninjaDTO != null) {
            return ResponseEntity.ok(ninjaDTO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID " + id + " não encontrado.");

    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjasID(@PathVariable Long id) {
        if (ninjaService.listarNinjasId(id) != null) {
            ninjaService.deletarNinjasID(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso.");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID " + id + " não encontrado.");
    }


    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaID(@PathVariable Long id,
                                 @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninjaDTO != null) {
            return ResponseEntity.ok(ninjaDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID " + id + " não encontrado");
    }

}
