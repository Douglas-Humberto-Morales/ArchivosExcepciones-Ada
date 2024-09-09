package org.douglasalvarado.clases;

// Excepción personalizada para manejar la creación de un archivo que ya existe
public class ArchivoYaExisteException extends Exception {
    public ArchivoYaExisteException(String mensaje) {
        super(mensaje);
    }
}
