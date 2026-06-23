package app;

import service.GestorColaboradores;

import java.util.Scanner;

/**
 * Clase principal del sistema Llanquihue Tour.
 * Coordina la ejecución del programa mediante un menú de consola.
 *
 * Curso  : PRY2202 - Desarrollo Orientado a Objetos I
 * Semana : 5 - Actividad Sumativa 2
 * Caso   : Llanquihue Tour
 */
public class Main {

    private static final String RUTA_ARCHIVO = "resources/colaboradores.csv";
    private static GestorColaboradores gestor = new GestorColaboradores();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    gestor.cargarDesdeArchivo(RUTA_ARCHIVO);
                    break;
                case 2:
                    gestor.mostrarTodos();
                    break;
                case 3:
                    gestor.mostrarActivos();
                    break;
                case 4:
                    String nombre = leerTexto("Ingrese nombre a buscar: ");
                    gestor.buscarPorNombre(nombre);
                    break;
                case 5:
                    String comuna = leerTexto("Ingrese comuna a filtrar: ");
                    gestor.filtrarPorComuna(comuna);
                    break;
                case 6:
                    String tipo = leerTexto("Ingrese tipo (Guia / Operador): ");
                    gestor.filtrarPorTipo(tipo);
                    break;
                case 7:
                    System.out.println("Sistema finalizado. Hasta pronto.");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }

        } while (opcion != 7);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("       LLANQUIHUE TOUR - SISTEMA        ");
        System.out.println("========================================");
        System.out.println("1. Cargar colaboradores desde archivo");
        System.out.println("2. Mostrar todos los colaboradores");
        System.out.println("3. Mostrar colaboradores activos");
        System.out.println("4. Buscar colaborador por nombre");
        System.out.println("5. Filtrar colaboradores por comuna");
        System.out.println("6. Filtrar colaboradores por tipo");
        System.out.println("7. Salir");
        System.out.println("========================================");
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }
}
