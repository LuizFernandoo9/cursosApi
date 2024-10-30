package com.api.cursos.dto;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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

    private String name;
    private String category;
    private String active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

