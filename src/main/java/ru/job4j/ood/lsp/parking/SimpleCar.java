package ru.job4j.ood.lsp.parking;

public class SimpleCar implements Car {
    public static final int SIZE = 1;
    private String number;

    public SimpleCar(String number) {
        this.number = number;
    }

    @Override
    public int getSize() {
        return SIZE;
    }

    @Override
    public String getNumber() {
        return number;
    }
}
