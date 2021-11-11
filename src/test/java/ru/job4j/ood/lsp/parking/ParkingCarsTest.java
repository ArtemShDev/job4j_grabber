package ru.job4j.ood.lsp.parking;

import org.junit.Ignore;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingCarsTest {

    @Ignore
    public void parkingResultWhenFullButOKTest() {
        List<Car> queue = List.of(new SimpleCar("5588AA"), new SimpleCar("1188AA"),
                new SimpleCar("78tr55"), new SimpleCar("18SA"), new Truck("5588AA", 3),
                new Truck("1188AA", 2), new Truck("11AA", 4));
        Parking parking = new CityParking(8, 2);
        boolean result = false;
        for (Car car : queue) {
            result = parking.park(car);
        }
        assertTrue(result);
    }

    @Ignore
    public void parkingResultWhenParkingIsBusyTest() {
        List<Car> queue = List.of(new SimpleCar("5588AA"), new SimpleCar("1188AA"),
                new SimpleCar("78tr55"), new SimpleCar("18SA"), new Truck("5588AA", 3),
                new Truck("1188AA", 2), new Truck("11AA", 6));
        Parking parking = new CityParking(8, 2);
        boolean result = false;
        for (Car car : queue) {
            result = parking.park(car);
        }
        assertFalse(result);
    }

    @Ignore
    public void countFreePlacesWhenTrackParkingOnSimplePlaceTest() {
        List<Car> queue = List.of(new SimpleCar("5588AA"), new SimpleCar("1188AA"),
                new SimpleCar("78tr55"), new SimpleCar("18SA"), new Truck("5588AA", 3),
                new Truck("1188AA", 2), new Truck("11AA", 3));
        Parking parking = new CityParking(8, 2);
        int[] getFreePlaces = parking.getFreePlaces();
        assertThat(getFreePlaces[0], is(1));
        assertThat(getFreePlaces[1], is(0));
    }

    @Ignore
    public void countFreePlacesForSimpleCarAndTracksTest() {
        List<Car> queue = List.of(new SimpleCar("5588AA"), new SimpleCar("1188AA"),
                new SimpleCar("78tr55"), new SimpleCar("18SA"), new Truck("5588AA", 3),
                new Truck("1188AA", 2));
        Parking parking = new CityParking(8, 3);
        int[] getFreePlaces = parking.getFreePlaces();
        assertThat(getFreePlaces[0], is(4));
        assertThat(getFreePlaces[1], is(1));
    }
}