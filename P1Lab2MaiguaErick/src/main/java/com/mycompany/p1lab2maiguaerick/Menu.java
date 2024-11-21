package com.mycompany.p1lab2maiguaerick;

import com.mycompany.p1lab2maiguaerick.Car;
import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
    private ArrayList<Car> cars = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int numCar;
    Car car = new Car(0, "", "");

    public void Menu(){
        do{
            System.out.println("Ingrese la cantidad de vehiculos (1-3): ");
             numCar = scanner.nextInt();
        }while (numCar  < 1 || numCar > 3);
        for (int i = 0 ; i < numCar ; i++){
           car.askForData();
           car.saveJson();
           car.saveCSV();
           cars.add(car);
        }
        for (Car readCart : cars){
            System.out.println("-------------");
            car.showData();
        }
    }
}
