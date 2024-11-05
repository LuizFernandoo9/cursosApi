package com.api.cursos.dto;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.api.cursos.enums.Status;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTOResponse {

    @NotBlank(message = "O campo 'name' é obrigatório e não pode estar vazio.")
    private String name;
    @NotBlank(message = "O campo 'name' é obrigatório e não pode estar vazio.")
    private String category;
    private Status active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

