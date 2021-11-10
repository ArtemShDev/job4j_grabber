package ru.job4j.ood.dip;

public class Service {
    public static void main(String[] args) {
        AutoService as = new AutoService();
        Car simpleCar = new Car("gasoline", "VIN55588877RT");
        if (as.add(simpleCar)) {
            System.out.println(as.repair(simpleCar));
        }
    }
}
