package ru.job4j.ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingCarsTest {
    @Ignore
    @Test
    public void parkingResultWhenFullButOKTest() {
        List<Car> queue = List.of(new SimpleCar("5588AA"), new SimpleCar("1188AA"),
                new Truck("188AA", 3), new Truck("11AA", 2));
        Parking parking = new CityParking(4, 1);
        boolean result = false;
        for (Car car : queue) {
            result = parking.park(car);
        }
        assertTrue(result);
    }

    @Ignore
    @Test
    public void parkingResultWhenParkingIsBusyTest() {
        Parking parking = new CityParking(4, 1);
        parking.park(new SimpleCar("5588AA"));
        parking.park(new SimpleCar("1188AA"));
        boolean result = parking.park(new Truck("188AA", 2));
        assertTrue(result);
        result = parking.park(new Truck("11AA", 4));
        assertFalse(result);
    }

    @Ignore
    @Test
    public void has1FreePlacesForSimpleCarTest() {
        List<Car> queue = List.of(new SimpleCar("5588AA"), new SimpleCar("1188AA"),
                new Truck("1188AA", 2), new Truck("11AA", 3));
        Parking parking = new CityParking(6, 1);
        for (Car car : queue) {
            parking.park(car);
        }
        ParkingInfo parkingInfo = parking.getFreePlaces();
        assertThat(parkingInfo, is(new ParkingInfo(1, 0)));
    }

    @Ignore
    @Test
    public void has4FreePlacesForSimpleCarAnd1ForTrucksTest() {
        List<Car> queue = List.of(new SimpleCar("5588AA"), new SimpleCar("1188AA"),
                new Truck("5588AA", 3),  new Truck("1188AA", 2));
        Parking parking = new CityParking(6, 3);
        for (Car car : queue) {
            parking.park(car);
        }
        ParkingInfo parkingInfo = parking.getFreePlaces();
        assertThat(parkingInfo, is(new ParkingInfo(4, 1)));
    }
}