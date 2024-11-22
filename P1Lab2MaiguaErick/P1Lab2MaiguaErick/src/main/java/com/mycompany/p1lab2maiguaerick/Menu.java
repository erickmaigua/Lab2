package com.mycompany.p1lab2maiguaerick;

import java.util.ArrayList;
import java.util.Scanner;

// Clase para manejar el menu principal
public class Menu {

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>(); // Lista para almacenar vehiculos
    private Scanner scanner = new Scanner(System.in);

    // Metodo para mostrar el menu y gestionar la interaccion del usuario
    public void startMenu() {
        int option;

        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Registrar carros");
            System.out.println("2. Registrar motocicletas");
            System.out.println("3. Mostrar vehiculos registrados");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (option) {
                case 1 -> registerCars();
                case 2 -> registerMotorcycles();
                case 3 -> showVehicles();
                case 4 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion invalida. Intente de nuevo.");
            }
        } while (option != 4);
    }

    // Metodo para registrar carros
    private void registerCars() {
        int numCars;
        do {
            System.out.println("Ingrese la cantidad de carros a registrar (1-3): ");
            numCars = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
        } while (numCars < 1 || numCars > 3);

        for (int i = 0; i < numCars; i++) {
            System.out.println("\n--- Carro " + (i + 1) + " ---");
            Car car = new Car("", "", ""); // Crear un nuevo objeto Car
            car.askForData(); // Pedir datos del carro
            car.saveJson(); // Guardar en formato JSON
            car.saveCSV(); // Guardar en formato CSV
            vehiculos.add(car); // Agregar el carro al ArrayList
        }
    }

    // Metodo para registrar motocicletas
    private void registerMotorcycles() {
        int numMotorcycles;
        do {
            System.out.println("Ingrese la cantidad de motocicletas a registrar (1-3): ");
            numMotorcycles = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
        } while (numMotorcycles < 1 || numMotorcycles > 3);

        for (int i = 0; i < numMotorcycles; i++) {
            System.out.println("\n--- Motocicleta " + (i + 1) + " ---");
            Motorcycle motorcycle = new Motorcycle("", "", false); // Crear un nuevo objeto Motorcycle
            motorcycle.askForData(); // Pedir datos de la motocicleta
            motorcycle.saveJson(); // Guardar en formato JSON
            motorcycle.saveCSV(); // Guardar en formato CSV
            vehiculos.add(motorcycle); // Agregar la motocicleta al ArrayList
        }
    }

    // Metodo para mostrar los vehiculos registrados
    private void showVehicles() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }

        System.out.println("\n--- Vehiculos registrados ---");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("----------------------------");
            vehiculo.showData();
        }
    }
}
