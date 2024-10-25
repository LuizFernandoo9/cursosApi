package com.api.cursos.service;

import com.api.cursos.dto.CursoDTOResponse;
import com.api.cursos.exception.CurseFoundExeception;
import com.api.cursos.model.CursoModel;
import com.api.cursos.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    public CursoDTOResponse get(String name){
        var todoSCursos = this.cursosRepository.findByName(name).orElseThrow(() -> {
            throw new UserNotFoun
        });

    }
}
