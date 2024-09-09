package org.douglasalvarado.clases;

// Excepción personalizada para manejar archivos no encontrados
public class ArchivoNoEncontradoException extends Exception {
    public ArchivoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}