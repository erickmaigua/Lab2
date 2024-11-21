package com.mycompany.p1lab2maiguaerick;

import java.util.Scanner;

public abstract class Vehiculo {
    private String brand;
    private String color;
    Scanner scanner = new Scanner(System.in);
    public Vehiculo(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

   

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public abstract void askForData();
    public abstract void showData();
    public abstract void saveCSV ();
    public abstract void saveJson ();
}
