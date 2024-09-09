package org.douglasalvarado.clases;

import java.io.*;
import java.util.Scanner;

public class FileManager {

    // Método para verificar la existencia de un archivo
    public static void verificarArchivo(String nombreArchivo) throws ArchivoNoEncontradoException {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            throw new ArchivoNoEncontradoException("El archivo no existe.");
        }
    }

    // Método para crear un archivo
    public static void crearArchivo(String nombreArchivo) throws ArchivoYaExisteException {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            throw new ArchivoYaExisteException("El archivo ya existe.");
        } else {
            try {
                archivo.createNewFile();
                System.out.println("Archivo creado exitosamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para agregar una nueva línea de texto a un archivo existente
    public static void agregarLinea(String nombreArchivo, String texto) throws ArchivoNoEncontradoException {
        verificarArchivo(nombreArchivo);
        try (FileWriter fw = new FileWriter(nombreArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(texto);
            System.out.println("Línea agregada al archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer y mostrar el contenido de un archivo
    public static void mostrarContenido(String nombreArchivo) throws ArchivoNoEncontradoException {
        verificarArchivo(nombreArchivo);
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer y mostrar una línea específica de un archivo
    public static void mostrarLineaEspecifica(String nombreArchivo, int numeroLinea) throws ArchivoNoEncontradoException {
        verificarArchivo(nombreArchivo);
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int contador = 1;
            while ((linea = br.readLine()) != null) {
                if (contador == numeroLinea) {
                    System.out.println("Línea " + numeroLinea + ": " + linea);
                    return;
                }
                contador++;
            }
            System.out.println("La línea " + numeroLinea + " no existe en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
