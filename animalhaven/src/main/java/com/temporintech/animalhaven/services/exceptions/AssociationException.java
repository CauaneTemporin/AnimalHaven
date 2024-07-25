package com.temporintech.animalhaven.services.exceptions;

public class AssociationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AssociationException(String mensagem) {
        super(mensagem);
    }
}