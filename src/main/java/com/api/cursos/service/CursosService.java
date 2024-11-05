package com.api.cursos.service;

import com.api.cursos.dto.CursoDTOActive;
import com.api.cursos.dto.CursoDTOResponse;
import com.api.cursos.enums.Status;
import com.api.cursos.exception.CurseFoundExeception;
import com.api.cursos.exception.CurseNotFoundException;
import com.api.cursos.model.CursoModel;
import com.api.cursos.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<CursoDTOResponse> todosCursos( CursoModel cursoModel){
        
        if(cursoModel.getName().isEmpty() && cursoModel.getCategory().isEmpty()){
            return this.cursosRepository.findAll().stream().map(curso -> CursoDTOResponse.builder()
                    .name(curso.getName())
                    .category(curso.getCategory())
                    .active(curso.getActive())
                    .createdAt(curso.getCreatedAt())
                    .updatedAt(curso.getUpdatedAt())
                    .build())
                    .collect(Collectors.toList());
        }else{
            var curso = this.cursosRepository.findByNameAndCategory(cursoModel.getName(), cursoModel.getCategory()).orElseThrow(() -> {
                throw new CurseNotFoundException();
            });

            return List.of(CursoDTOResponse.builder()
                    .name(curso.getName())
                    .category(curso.getCategory())
                    .active(curso.getActive())
                    .createdAt(curso.getCreatedAt())
                    .updatedAt(curso.getUpdatedAt())
                    .build());
        }   
    }
    
    public CursoDTOResponse alterar(CursoModel cursoModel, UUID id){
        var alterarCurso = this.cursosRepository.findById(id).orElseThrow(() -> {
            throw new CurseNotFoundException();
        });

        if(cursoModel.getName().isEmpty()){
            alterarCurso.setCategory(cursoModel.getCategory());
            cursosRepository.save(alterarCurso);

            return CursoDTOResponse.builder()
            .category(alterarCurso.getCategory()).build();
            
        }
        else{
            alterarCurso.setName(cursoModel.getName());
            cursosRepository.save(alterarCurso);

            return CursoDTOResponse.builder()
            .name(alterarCurso.getName()).build();
        }
    }

    public CursoDTOActive alterarCursoActive(CursoModel cursoModel, UUID id){
        var alterarActive = this.cursosRepository.findById(id).orElseThrow(() -> {
            throw new CurseNotFoundException();
        });

        if(alterarActive.getActive() == Status.ACTIVE){
            alterarActive.setActive(Status.INACTIVE);
            cursosRepository.save(alterarActive);
            return CursoDTOActive.builder()
            .active(alterarActive.getActive()).build();
        }else{
            alterarActive.setActive(Status.ACTIVE);
            cursosRepository.save(alterarActive);
            return CursoDTOActive.builder()
            .active(alterarActive.getActive()).build();
        }
    }

    public void delete(UUID id){

        this.cursosRepository.findById(id).orElseThrow(() -> {
            throw new CurseNotFoundException();
        });

       this.cursosRepository.deleteById(id);
    }
}
