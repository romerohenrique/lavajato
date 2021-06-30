package br.com.lavajato.services.exceptionerror;

public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -8449709799151049925L;

    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
