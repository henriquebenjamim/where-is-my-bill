package com.bbr.whereismybill.exception;

import java.util.UUID;

public class RecordNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(Long id) {
        super("Registro não encontrado com o id: " + id);
    }

    public RecordNotFoundException(UUID id) {
        super("Register with id: " + id + " not found.");
    }
}
