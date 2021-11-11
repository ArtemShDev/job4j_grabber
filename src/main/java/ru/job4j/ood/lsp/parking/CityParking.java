package ru.job4j.ood.lsp.parking;

public class CityParking implements Parking {

    public CityParking(int i, int i1) {
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public int[] getFreePlaces() {
        return new int[0];
    }
}
