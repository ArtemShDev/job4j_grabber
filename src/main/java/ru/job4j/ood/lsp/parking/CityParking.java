package ru.job4j.ood.lsp.parking;

import java.util.Arrays;

public class CityParking implements Parking {

    private int[] placesForSimpleCar;
    private int[] placesForTrucks;
    private int truckPointer;
    private int simpleCarPointer;

    public CityParking(int placesForSimpleCar, int placesForTrucks) {
        this.placesForSimpleCar = new int[placesForSimpleCar];
        this.placesForTrucks = new int[placesForTrucks];
    }

    private int getFreeSpaceForTruck() {
        return placesForTrucks.length - truckPointer;
    }

    private int getFreeSpaceSimple() {
        return placesForSimpleCar.length - simpleCarPointer;
    }

    private boolean parkCarOneToOne(int sizeCar) {
        boolean isTruck = sizeCar > SimpleCar.SIZE;
        int[] arr = isTruck ? placesForTrucks : placesForSimpleCar;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i]++;
                if (isTruck) {
                    truckPointer++;
                } else {
                    simpleCarPointer++;
                }
                return true;
            }
        }
        return false;
    }

    private boolean parkManyToOne(int sizeCar) {
        if (getFreeSpaceSimple() >= sizeCar) {
            int finishPlace = -1;
            int countPlaces = 0;
            for (int i = 0; i < placesForSimpleCar.length && countPlaces < sizeCar; i++) {
                if (placesForSimpleCar[i] == 0) {
                    finishPlace = i;
                    countPlaces++;
                } else {
                    finishPlace = -1;
                    countPlaces = 0;
                }
            }
            if (countPlaces == sizeCar) {
                for (int i = finishPlace - sizeCar; i < finishPlace; i++) {
                    placesForSimpleCar[i]++;
                    simpleCarPointer++;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean park(Car car) {
        int sizeCar = car.getSize();
        if ((sizeCar > SimpleCar.SIZE && getFreeSpaceForTruck() != 0) || sizeCar == SimpleCar.SIZE) {
            return parkCarOneToOne(sizeCar);
        }
        return parkManyToOne(sizeCar);
    }

    @Override
    public ParkingInfo getFreePlaces() {
        return new ParkingInfo(getFreeSpaceSimple(), getFreeSpaceForTruck());
    }
}
