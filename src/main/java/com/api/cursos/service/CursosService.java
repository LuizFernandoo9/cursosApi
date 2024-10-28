package com.api.cursos.service;

import com.api.cursos.dto.CursoDTOResponse;
import com.api.cursos.exception.CurseFoundExeception;
import com.api.cursos.exception.CurseNotFoundException;
import com.api.cursos.model.CursoModel;
import com.api.cursos.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Locale.Category;

@Service
public class CursosService {

    @Autowired
    private CursosRepository cursosRepository;

    public CursoModel create(CursoModel cursoModel){

        this.cursosRepository.findByName(cursoModel.getName()).ifPresent(curso -> {
            throw new CurseFoundExeception();
        });

        var curso = this.cursosRepository.save(cursoModel);

        return curso;
    }

    public CursoDTOResponse todosCursos(String name, String category){
        var todosCursos = this.cursosRepository.findByNameAndCategory(name, category).orElseThrow(() -> {
            throw new CurseNotFoundException();
        });

        var cursosDto = CursoDTOResponse.builder()
        .name(todosCursos.getName())
        .category(todosCursos.getCategory())
        .build();

        return  cursosDto;

    }
}
