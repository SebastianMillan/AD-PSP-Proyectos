package com.salesianostriana.dam.UploadingFiles_Example.exceptions;

public class StorageException extends RuntimeException{
    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
