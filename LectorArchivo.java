package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria para lectura de archivos CSV.
 * Separa la responsabilidad de lectura de archivos
 * del resto del sistema.
 */
public class LectorArchivo {

    /**
     * Lee un archivo CSV y retorna una lista de arreglos de String.
     * Cada arreglo representa una línea separada por ";".
     * Ignora líneas vacías y líneas que comienzan con "#" (comentarios).
     */
    public static List<String[]> leerCSV(String ruta) {
        List<String[]> resultado = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                // Ignorar líneas vacías o comentarios
                if (linea.isEmpty() || linea.startsWith("#")) {
                    continue;
                }

                String[] partes = linea.split(";");
                resultado.add(partes);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            System.out.println("Verifique que el archivo exista en: " + ruta);
        }

        return resultado;
    }
}
