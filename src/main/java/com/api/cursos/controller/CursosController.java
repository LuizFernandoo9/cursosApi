package com.api.cursos.controller;

import com.api.cursos.dto.CursoDTOActive;
import com.api.cursos.dto.CursoDTOResponse;
import com.api.cursos.model.CursoModel;
import com.api.cursos.service.CursosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/cursos")
@Tag(name = "Cursos", description = "Informações de Cursos")
public class CursosController {

    @Autowired
    private CursosService cursosService;

    @PostMapping("/")
    @Operation(summary = "Criação de um novo curso", description = "Responsavel por fazer a criação de novos cursos")
    public ResponseEntity<Object> NovoCurso(@Valid @RequestBody CursoModel cursoModel){
        try {
            var curso = cursosService.create(cursoModel);
            return ResponseEntity.status(HttpStatus.OK).body(curso);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/")
    @Operation(summary = "Cursos disponíveis para usuarios", description = "Tem a função de mostra o curso ou todos os cursos disponíveis")
    public ResponseEntity<Object> buscarCurso(@Valid @RequestBody CursoModel cursoModel ){
        try{
            var cursos = this.cursosService.todosCursos(cursoModel);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(cursos);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
       
    @PutMapping("/{id}") 
    @Operation(summary = "Alterar curso com base no id", description = "Faz a alteração do curso com base no id, sendo possível alterar ou o name ou o category, por vez ")
    public ResponseEntity<Object> alterarCurso(@Valid @RequestBody CursoModel cursoModel, @PathVariable UUID id){
        try{
            var alterar = this.cursosService.alterar(cursoModel, id);
            return ResponseEntity.status(HttpStatus.OK).body(alterar);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    @Operation(summary = "Responsável pro alterar o active", description = "É o endpoint onde será possível alterar o estado dos cursos, somente nele será possível realizar isso")
    public ResponseEntity<Object> alteracaoActive(@Valid @RequestBody CursoDTOResponse cursoDTOResponse, @PathVariable UUID id){
        try{
            var alteracao = this.cursosService.alterarCursoActive(cursoDTOResponse, id);
            return ResponseEntity.status(HttpStatus.OK).body(alteracao);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar o curso", description = "Deleta o curso com base no id fornecido")
    public ResponseEntity<Object> deletarCurso(@PathVariable UUID id){

        try{
            this.cursosService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso!");
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

}
