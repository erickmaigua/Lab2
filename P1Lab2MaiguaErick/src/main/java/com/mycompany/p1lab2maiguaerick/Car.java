package com.mycompany.p1lab2maiguaerick;
import com.google.gson.JsonObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONObject;

public class Car extends Vehiculo {

    private int numberChassis;
    
    public Car(int numberChassis, String brand, String color) {
        super(brand, color);
        this.numberChassis = numberChassis;
    }
    
    public int getNumberChassis() {
        return numberChassis;
    }
    
    public void setNumberChassis(int numberChassis) {
        while (numberChassis < 0){
            System.out.println("Eror el numero de Chassis no puede ser negativo, ingrese nuevamente:");
            numberChassis = scanner.nextInt();
        }
        this.numberChassis = numberChassis;
    }
   public void NumberChassis (){
       System.out.println("Ingrese el numero de Chassis: ");
        setNumberChassis(scanner.nextInt());
        scanner = new Scanner(System.in);
   }
    
    @Override
    public void askForData() {
        System.out.println("Ingrese el marca del vehiculo: ");
        setBrand(scanner.nextLine());
        System.out.println("Ingrese el color del vehiculo: ");
        setColor(scanner.nextLine());
        NumberChassis();
    }
    
    @Override
    public void showData() {
        System.out.println("La marca del vehiculo es: " +  getBrand());
        System.out.println("El color del vehiculo es: "+ getColor());
        System.out.println("El numero de puestas es: " + getNumberChassis());
    }
    
    @Override
    public void saveCSV() {
        try (FileWriter file = new FileWriter("Carro.csv", true)) {
            file.append("Digital,")
                .append(getBrand()).append(",")
                .append(getColor()).append(",")
                .append((char) getNumberChassis()).append("\n");
            System.out.println("Carro guardado en CSV.");
        } catch (IOException e) {
            System.out.println("Error al guardar en CSV: " + e.getMessage());
        }
    }
    
    @Override
    public void saveJson() {
        JSONObject jsonVehiculos = new JSONObject();
        jsonVehiculos.put("Tipo","Vehiculo");
        jsonVehiculos.put("Marca", getBrand());
        jsonVehiculos.put("Color", getColor());
        jsonVehiculos.put("Numero de Chassis",  getNumberChassis());
        try (FileWriter file = new FileWriter("Carro.json", true)) {
            file.write(jsonVehiculos.toString() + "\n");
            System.out.println("Libro fisico guardado en JSON.");
        } catch (IOException e) {
            System.out.println("Error al guardar en JSON: " + e.getMessage());
        }
    }
    
}
