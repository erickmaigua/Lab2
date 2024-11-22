package com.mycompany.p1lab2maiguaerick;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

// Clase Motorcycle que extiende de Vehiculo
public class Motorcycle extends Vehiculo {

    private boolean hasSidecar; // Indica si la motocicleta tiene sidecar

    // Constructor
    public Motorcycle(String brand, String color, boolean hasSidecar) {
        super(brand, color);
        this.hasSidecar = hasSidecar;
    }

    // Getter para el atributo hasSidecar
    public boolean hasSidecar() {
        return hasSidecar;
    }

    // Setter para el atributo hasSidecar
    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    // Metodo para solicitar si tiene sidecar
    private void askHasSidecar() {
        String input;
        do {
            System.out.println("¿Tiene sidecar? (si/no): ");
            input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("si")) {
                setHasSidecar(true);
            } else if (input.equals("no")) {
                setHasSidecar(false);
            } else {
                System.out.println("Entrada invalida. Por favor escriba 'si' o 'no'.");
            }
        } while (!input.equals("si") && !input.equals("no")); // Repetir hasta recibir una entrada valida
    }

    @Override
    public void askForData() {
        System.out.println("Ingrese la marca de la motocicleta: ");
        setBrand(scanner.nextLine());
        System.out.println("Ingrese el color de la motocicleta: ");
        setColor(scanner.nextLine());
        askHasSidecar(); // Solicitar si tiene sidecar
    }

    @Override
    public void showData() {
        System.out.println("Marca de la motocicleta: " + getBrand());
        System.out.println("Color de la motocicleta: " + getColor());
        System.out.println("¿Tiene sidecar?: " + (hasSidecar() ? "Si" : "No"));
    }

    @Override
    public void saveCSV() {
        try (FileWriter file = new FileWriter("Motocicleta.csv", true)) {
            file.append(getBrand()).append(",")
                .append(getColor()).append(",")
                .append(hasSidecar() ? "Si" : "No").append("\n");
            System.out.println("Motocicleta guardada en CSV.");
        } catch (IOException e) {
            System.out.println("Error al guardar en CSV: " + e.getMessage());
        }
    }

    @Override
    public void saveJson() {
        JSONObject jsonVehiculo = new JSONObject();
        jsonVehiculo.put("Tipo", "Motocicleta");
        jsonVehiculo.put("Marca", getBrand());
        jsonVehiculo.put("Color", getColor());
        jsonVehiculo.put("Tiene Sidecar", hasSidecar() ? "Si" : "No");
        try (FileWriter file = new FileWriter("Motocicleta.json", true)) {
            file.write(jsonVehiculo.toString() + "\n");
            System.out.println("Motocicleta guardada en JSON.");
        } catch (IOException e) {
            System.out.println("Error al guardar en JSON: " + e.getMessage());
        }
    }
}
