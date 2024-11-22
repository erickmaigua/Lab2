package com.mycompany.p1lab2maiguaerick;

import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

// Clase Car que hereda de Vehiculo
public class Car extends Vehiculo {

    private String numberChassis; // Ahora es una cadena para permitir letras y números

    // Constructor que inicializa los atributos
    public Car(String numberChassis, String brand, String color) {
        super(brand, color);
        this.numberChassis = numberChassis;
    }

    // Métodos getter y setter para numberChassis
    public String getNumberChassis() {
        return numberChassis;
    }

    public void setNumberChassis(String numberChassis) {
        // Validación para asegurarse de que el número no esté vacío
        while (numberChassis.trim().isEmpty()) {
            System.out.println("Error: El numero de chasis no puede estar vacio. Intente de nuevo:");
            numberChassis = scanner.nextLine();
        }
        this.numberChassis = numberChassis;
    }

    // Método para solicitar el número de chasis al usuario
    public void NumberChassis() {
        System.out.println("Ingrese el numero de chasis (puede contener letras y numeros): ");
        setNumberChassis(scanner.nextLine());
    }

    // Implementación del método abstracto para pedir datos
    @Override
    public void askForData() {
        System.out.println("Ingrese la marca del vehiculo: ");
        setBrand(scanner.nextLine());
        System.out.println("Ingrese el color del vehiculo: ");
        setColor(scanner.nextLine());
        NumberChassis();
    }

    // Mostrar los datos del carro
    @Override
    public void showData() {
        System.out.println("La marca del vehiculo es: " + getBrand());
        System.out.println("El color del vehiculo es: " + getColor());
        System.out.println("El numero de chasis es: " + getNumberChassis());
    }

    // Guardar datos en un archivo CSV
    @Override
    public void saveCSV() {
        try (FileWriter file = new FileWriter("Carro.csv", true)) {
            file.append("Carro,")
                .append(getBrand()).append(",")
                .append(getColor()).append(",")
                .append(getNumberChassis()).append("\n");
            System.out.println("Carro guardado en CSV.");
        } catch (IOException e) {
            System.out.println("Error al guardar en CSV: " + e.getMessage());
        }
    }

    // Guardar datos en un archivo JSON
    @Override
    public void saveJson() {
        JSONObject jsonVehiculos = new JSONObject();
        jsonVehiculos.put("Tipo", "Carro");
        jsonVehiculos.put("Marca", getBrand());
        jsonVehiculos.put("Color", getColor());
        jsonVehiculos.put("Numero de chasis", getNumberChassis());
        try (FileWriter file = new FileWriter("Carro.json", true)) {
            file.write(jsonVehiculos.toString() + "\n");
            System.out.println("Carro guardado en JSON.");
        } catch (IOException e) {
            System.out.println("Error al guardar en JSON: " + e.getMessage());
        }
    }
}
