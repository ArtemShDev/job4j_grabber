package ru.job4j.ood.lsp.parking;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingCarsTest {

    @Test
    public void parkingResultWhenFullButOKTest() {
        Parking parking = new CityParking(4, 1);
        parking.park(new SimpleCar("5588AA"));
        parking.park(new SimpleCar("1188AA"));
        parking.park(new Truck("188AA", 3));
        boolean result = parking.park(new Truck("11AA", 2));
        assertTrue(result);
    }

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

    @Test
    public void has1FreePlaceForSimpleCarTest() {
        Parking parking = new CityParking(6, 1);
        parking.park(new SimpleCar("5588AA"));
        parking.park(new SimpleCar("1188AA"));
        parking.park(new Truck("188AA", 2));
        parking.park(new Truck("11AA", 3));
        ParkingInfo parkingInfo = parking.getFreePlaces();
        assertThat(parkingInfo, is(new ParkingInfo(1, 0)));
    }

    @Test
    public void has4FreePlacesForSimpleCarAnd1ForTrucksTest() {
        Parking parking = new CityParking(6, 3);
        parking.park(new SimpleCar("5588AA"));
        parking.park(new SimpleCar("1188AA"));
        parking.park(new Truck("188AA", 3));
        parking.park(new Truck("11AA", 2));
        ParkingInfo parkingInfo = parking.getFreePlaces();
        assertThat(parkingInfo, is(new ParkingInfo(4, 1)));
    }
}