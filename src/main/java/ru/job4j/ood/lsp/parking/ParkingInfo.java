package ru.job4j.ood.lsp.parking;

import java.util.Objects;

public class ParkingInfo {
    private int placesForSimpleCars;
    private int placesForTrucks;

    public ParkingInfo() {
    }

    public ParkingInfo(int placesForSimpleCars, int placesForTrucks) {
        this.placesForSimpleCars = placesForSimpleCars;
        this.placesForTrucks = placesForTrucks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParkingInfo that = (ParkingInfo) o;
        return placesForSimpleCars == that.placesForSimpleCars && placesForTrucks == that.placesForTrucks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(placesForSimpleCars, placesForTrucks);
    }
}
