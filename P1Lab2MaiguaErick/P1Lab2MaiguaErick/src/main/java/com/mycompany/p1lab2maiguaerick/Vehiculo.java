package com.mycompany.p1lab2maiguaerick;

import java.util.Scanner;

// Clase abstracta que sirve como base para diferentes tipos de vehículos
public abstract class Vehiculo {

    private String brand; // Marca del vehículo
    private String color; // Color del vehículo
    protected Scanner scanner = new Scanner(System.in); // Scanner para entrada de datos

    // Constructor que inicializa la marca y el color
    public Vehiculo(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    // Getter y Setter para la marca
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter y Setter para el color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Métodos abstractos que deben ser implementados por las clases hijas
    public abstract void askForData(); // Solicitar datos al usuario
    public abstract void showData();  // Mostrar datos del vehículo
    public abstract void saveCSV();  // Guardar datos en un archivo CSV
    public abstract void saveJson(); // Guardar datos en un archivo JSON
}
