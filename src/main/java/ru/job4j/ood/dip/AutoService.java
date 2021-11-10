package ru.job4j.ood.dip;

import java.util.*;

public class AutoService {

    private Map<Car, Set<Part>> partsToChange = new HashMap<>();

    public boolean add(Car car) {
        if ("diesel".equals(car.getTypeCar())) {
            return false;
        }
        partsToChange.put(car, new HashSet<>());
        return true;
    }

    private boolean diagnostic(Car car) {
        Set<Part> parts = partsToChange.getOrDefault(car, new HashSet<>());
        /**
         * diagnosting the car
         */
        boolean isNeedToRepair = true;
        if (isNeedToRepair) {
            parts.add(new Part("Oil filter", "ert45558ret"));
            parts.add(new Part("Glass", "3456rt777"));
            parts.add(new Part("generator", "555888io"));
            partsToChange.put(car, parts);
        }
        return isNeedToRepair;
    }

    public boolean repair(Car car) {
        if (!diagnostic(car))  {
            System.out.println("It doesn't need to repair!");
            return false;
        }
        /**
         * repairing the car
         */
        return true;
    }
}
