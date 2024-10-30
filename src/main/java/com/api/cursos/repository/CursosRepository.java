package com.api.cursos.repository;

import com.api.cursos.model.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CursosRepository extends JpaRepository<CursoModel, UUID> {

    @Override
    Optional<CursoModel> findById(UUID uuid);

    Optional<CursoModel> findByNameAndCategory(String name, String category);

    Optional<CursoModel> findByNameOrCategory(String name, String category);

    Optional<CursoModel> findByName(String name);
}
