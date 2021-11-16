package ru.job4j.ood.lsp.parking;

import java.util.Arrays;

public class CityParking implements Parking {

    private int[] placesForSimpleCar;
    private int[] placesForTrucks;

    public CityParking(int placesForSimpleCar, int placesForTrucks) {
        this.placesForSimpleCar = new int[placesForSimpleCar];
        this.placesForTrucks = new int[placesForTrucks];
    }

    private int getFreeSpaceForTruck() {
        return placesForTrucks.length - Arrays.stream(placesForTrucks).sum();
    }

    private int getFreeSpaceSimple() {
        return placesForSimpleCar.length - Arrays.stream(placesForSimpleCar).sum();
    }

    private boolean parkCarOneToOne(int sizeCar) {
        int[] arr = sizeCar > 1 ? placesForTrucks : placesForSimpleCar;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i]++;
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
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean park(Car car) {
        int sizeCar = car.getSize();
        if ((sizeCar > 1 && getFreeSpaceForTruck() != 0) || sizeCar == 1) {
            return parkCarOneToOne(sizeCar);
        }
        return parkManyToOne(sizeCar);
    }

    @Override
    public ParkingInfo getFreePlaces() {
        return new ParkingInfo(getFreeSpaceSimple(), getFreeSpaceForTruck());
    }
}
