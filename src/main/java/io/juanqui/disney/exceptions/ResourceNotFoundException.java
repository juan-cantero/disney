package io.juanqui.disney.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("resouce not found");
    }
}
