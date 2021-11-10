package ru.job4j.ood.dip;

import java.util.Objects;

public class Car {

    private String typeCar;
    private String vinNumber;

    public Car(String typeCar, String vinNumber) {
        this.typeCar = typeCar;
        this.vinNumber = vinNumber;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(vinNumber, car.vinNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vinNumber);
    }
}
