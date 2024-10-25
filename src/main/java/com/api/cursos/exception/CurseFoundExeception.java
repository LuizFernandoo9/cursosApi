package com.api.cursos.exception;

public class CurseFoundExeception extends RuntimeException {
    public CurseFoundExeception() {
        super("Curso já existente na nossa plataforma!");
    }
}
