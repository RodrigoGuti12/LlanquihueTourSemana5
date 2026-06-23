package service;

import model.Colaborador;
import model.Direccion;
import model.GuiaTuristico;
import model.OperadorLocal;
import util.LectorArchivo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase gestora que administra la colección de colaboradores.
 * Separa la lógica del negocio de la clase Main.
 * Aplica modularidad y reutilización de código.
 */
public class GestorColaboradores {

    private List<Colaborador> colaboradores;

    public GestorColaboradores() {
        this.colaboradores = new ArrayList<>();
    }

    // Carga los colaboradores desde el archivo CSV usando LectorArchivo
    public void cargarDesdeArchivo(String ruta) {
        List<String[]> lineas = LectorArchivo.leerCSV(ruta);

        for (String[] partes : lineas) {
            try {
                // Formato esperado:
                // rut;nombre;telefono;tipo;especialidadORservicio;rubro;calle;numero;comuna;region;activo
                if (partes.length < 11) {
                    System.out.println("Linea ignorada por datos incompletos.");
                    continue;
                }

                String  rut         = partes[0].trim();
                String  nombre      = partes[1].trim();
                String  telefono    = partes[2].trim();
                String  tipo        = partes[3].trim();
                String  campo1      = partes[4].trim(); // especialidad o servicio
                String  campo2      = partes[5].trim(); // anios experiencia o rubro
                String  calle       = partes[6].trim();
                int     numero      = Integer.parseInt(partes[7].trim());
                String  comuna      = partes[8].trim();
                String  region      = partes[9].trim();
                boolean activo      = Boolean.parseBoolean(partes[10].trim());

                Direccion direccion = new Direccion(calle, numero, comuna, region);

                if (tipo.equalsIgnoreCase("Guia")) {
                    int anios = Integer.parseInt(campo2);
                    GuiaTuristico guia = new GuiaTuristico(
                            rut, nombre, telefono, activo, direccion, campo1, anios);
                    colaboradores.add(guia);

                } else if (tipo.equalsIgnoreCase("Operador")) {
                    OperadorLocal op = new OperadorLocal(
                            rut, nombre, telefono, activo, direccion, campo1, campo2);
                    colaboradores.add(op);
                }

            } catch (NumberFormatException e) {
                System.out.println("Error al convertir datos de una linea: " + e.getMessage());
            }
        }

        System.out.println("Colaboradores cargados: " + colaboradores.size());
    }

    // Mostrar todos los colaboradores
    public void mostrarTodos() {
        if (colaboradores.isEmpty()) {
            System.out.println("No hay colaboradores cargados.");
            return;
        }
        System.out.println("\n=== TODOS LOS COLABORADORES ===");
        for (Colaborador c : colaboradores) {
            System.out.println(c);
        }
    }

    // Filtrar solo colaboradores activos
    public void mostrarActivos() {
        System.out.println("\n=== COLABORADORES ACTIVOS ===");
        boolean encontrado = false;
        for (Colaborador c : colaboradores) {
            if (c.isActivo()) {
                System.out.println(c);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron colaboradores activos.");
        }
    }

    // Buscar por nombre (búsqueda parcial)
    public void buscarPorNombre(String nombre) {
        System.out.println("\n=== RESULTADOS BUSQUEDA: " + nombre + " ===");
        boolean encontrado = false;
        for (Colaborador c : colaboradores) {
            if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                System.out.println(c);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron colaboradores con ese nombre.");
        }
    }

    // Filtrar por comuna
    public void filtrarPorComuna(String comuna) {
        System.out.println("\n=== COLABORADORES EN: " + comuna + " ===");
        boolean encontrado = false;
        for (Colaborador c : colaboradores) {
            if (c.getDireccion().getComuna().toLowerCase().contains(comuna.toLowerCase())) {
                System.out.println(c);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron colaboradores en esa comuna.");
        }
    }

    // Filtrar por tipo
    public void filtrarPorTipo(String tipo) {
        System.out.println("\n=== COLABORADORES TIPO: " + tipo + " ===");
        boolean encontrado = false;
        for (Colaborador c : colaboradores) {
            if (c.getTipo().equalsIgnoreCase(tipo)) {
                System.out.println(c);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron colaboradores de ese tipo.");
        }
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }
}
