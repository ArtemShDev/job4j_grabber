package ru.job4j.ood.lsp.parking;

import java.util.Objects;

public class ParkingInfo {

    private int freePlacesForSimpleCars;
    private int freePlacesForTrucks;

    public ParkingInfo() {
    }

    public ParkingInfo(int freePlacesForSimpleCars, int freePlacesForTrucks) {
        this.freePlacesForSimpleCars = freePlacesForSimpleCars;
        this.freePlacesForTrucks = freePlacesForTrucks;
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
        return freePlacesForSimpleCars == that.freePlacesForSimpleCars
                && freePlacesForTrucks == that.freePlacesForTrucks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(freePlacesForSimpleCars, freePlacesForTrucks);
    }
}
