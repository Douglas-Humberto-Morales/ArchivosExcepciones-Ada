package org.douglasalvarado.main;

import org.douglasalvarado.clases.ArchivoNoEncontradoException;
import org.douglasalvarado.clases.ArchivoYaExisteException;

import java.util.Scanner;

import static org.douglasalvarado.clases.FileManager.*;

public class Main {
    public static void main(String[] args) {
        // TODO: Implementa el código necesario para probar las funcionalidades descritas.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo:");
        String nombreArchivo = scanner.nextLine();

        try {
            verificarArchivo(nombreArchivo);
        } catch (ArchivoNoEncontradoException e) {
            System.out.println(e.getMessage());
            try {
                crearArchivo(nombreArchivo);
            } catch (ArchivoYaExisteException ex) {
                System.out.println(ex.getMessage());
            }
        }

        while (true) {
            System.out.println("\nElige una opción:");
            System.out.println("1. Agregar nuevas líneas al archivo.");
            System.out.println("2. Mostrar el contenido del archivo.");
            System.out.println("3. Mostrar una línea específica del archivo.");
            System.out.println("4. Salir.");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el texto a agregar:");
                    String texto = scanner.nextLine();
                    try {
                        agregarLinea(nombreArchivo, texto);
                    } catch (ArchivoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        mostrarContenido(nombreArchivo);
                    } catch (ArchivoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el número de línea que desea mostrar:");
                    int numeroLinea = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        mostrarLineaEspecifica(nombreArchivo, numeroLinea);
                    } catch (ArchivoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}