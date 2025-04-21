package org.example.views;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int option;

        do {
            System.out.println("\n--- MENÚ BIBLIOTECARIO ---");
            System.out.println("1 - Alta de usuario [RF01]");
            System.out.println("2 - Baja de usuario [RF01]");
            System.out.println("3 - Listar todos los usuarios [RF02]");
            System.out.println("4 - Listar usuarios con préstamos activos [RF03]");
            System.out.println("5 - Generar un préstamo nuevo [RF04]");
            System.out.println("6 - Marcar préstamo como devuelto [RF05]");
            System.out.println("7 - Visualizar todos los préstamos [RF06]");
            System.out.println("8 - Visualizar préstamos activos [RF07]");
            System.out.println("9 - Visualizar libro más prestado [RF08]");
            System.out.println("10 - Visualizar total de libros disponibles [RF09]");
            System.out.println("11 - Visualizar todos los libros [RF10]");
            System.out.println("12 - Visualizar usuario con más préstamos históricos [RF11]");
            System.out.println("13 - Visualizar promedio de préstamos por usuario [RF12]");
            System.out.println("0 - Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();  // limpiar buffer

            switch (option) {
                case 1 -> altaUsuario();
                case 2 -> bajaUsuario();
                case 3 -> listarUsuarios();
                case 4 -> listarUsuariosConPrestamosActivos();
                case 5 -> generarPrestamo();
                case 6 -> marcarPrestamoComoDevuelto();
                case 7 -> visualizarTodosLosPrestamos();
                case 8 -> visualizarPrestamosActivos();
                case 9 -> visualizarLibroMasPrestado();
                case 10 -> visualizarTotalLibrosDisponibles();
                case 11 -> visualizarTodosLosLibros();
                case 12 -> visualizarUsuarioConMasPrestamos();
                case 13 -> visualizarPromedioPrestamosPorUsuario();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }

        } while (option != 0);
    }

    private void altaUsuario() {
        System.out.println("[RF01] -> Alta de usuario");
        // Lógica para dar de alta un usuario
    }

    private void bajaUsuario() {
        System.out.println("[RF01] -> Baja de usuario");
        // Lógica para dar de baja un usuario
    }

    private void listarUsuarios() {
        System.out.println("[RF02] -> Listar todos los usuarios");
        // Lógica para listar usuarios
    }

    private void listarUsuariosConPrestamosActivos() {
        System.out.println("[RF03] -> Listar usuarios con préstamos activos");
        // Lógica para listar usuarios con préstamos activos
    }

    private void generarPrestamo() {
        System.out.println("[RF04] -> Generar un préstamo nuevo");
        // Lógica para crear préstamo
    }

    private void marcarPrestamoComoDevuelto() {
        System.out.println("[RF05] -> Marcar préstamo como devuelto");
        // Lógica para marcar préstamo como devuelto
    }

    private void visualizarTodosLosPrestamos() {
        System.out.println("[RF06] -> Visualizar todos los préstamos");
        // Lógica para mostrar todos los préstamos
    }

    private void visualizarPrestamosActivos() {
        System.out.println("[RF07] -> Visualizar préstamos activos");
        // Lógica para mostrar préstamos activos
    }

    private void visualizarLibroMasPrestado() {
        System.out.println("[RF08] -> Visualizar libro más prestado");
        // Lógica para mostrar libro más prestado
    }

    private void visualizarTotalLibrosDisponibles() {
        System.out.println("[RF09] -> Visualizar total de libros disponibles");
        // Lógica para contar libros disponibles
    }

    private void visualizarTodosLosLibros() {
        System.out.println("[RF10] -> Visualizar todos los libros");
        // Lógica para listar todos los libros
    }

    private void visualizarUsuarioConMasPrestamos() {
        System.out.println("[RF11] -> Visualizar usuario con más préstamos históricos");
        // Lógica para encontrar usuario con más préstamos
    }

    private void visualizarPromedioPrestamosPorUsuario() {
        System.out.println("[RF12] -> Visualizar promedio de préstamos por usuario");
        // Lógica para calcular promedio
    }
}

