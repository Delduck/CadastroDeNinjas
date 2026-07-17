package com.github.Delduck.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface NinjaControllerOpenApi {

    @Operation(summary = "Lista os ninjas")
    public ResponseEntity<List<NinjaDTO>> listarTodosNinjas();

    @Operation(summary = "Busca um ninja por ID", description = "Rota lista um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id);

    @Operation(summary = "Cadastra um ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criaçao do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO);

    @Operation(summary = "Exclui um ninja por ID", responses = {
            @ApiResponse(responseCode = "200", description = "Ninja excluído"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> deletarNinjasID(@PathVariable Long id);

    @Operation(summary = "Atualiza um ninja por ID", description = "Rota altera um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> alterarNinjaID(
            @Parameter(description = "ID de um ninja", example = "1", required = true) @PathVariable Long id,

            @Parameter(description = "Representação de um ninja com os novos dados", required = true)
            @RequestBody NinjaDTO ninjaAtualizado);
}
