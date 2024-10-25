package com.api.cursos.controller;

import com.api.cursos.model.CursoModel;
import com.api.cursos.service.CursosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    @Autowired
    private CursosService cursosService;

    @PostMapping("/")
    public ResponseEntity<Object> NovoCurso(@Valid @RequestBody CursoModel cursoModel){
        try {
            var curso = cursosService.create(cursoModel);
            return ResponseEntity.status(HttpStatus.OK).body(curso);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Object>> buscarCurso(@Valid @RequestBody CursoModel cursoModel){
        try {
            //var buscarCursos = cursosService.get(cursoModel);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(buscarCursos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
