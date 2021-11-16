package ru.job4j.ood.lsp.parking;

public class Truck implements Car {
    private String number;
    private int size;

    public Truck(String number, int size) {
        this.number = number;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getNumber() {
        return number;
    }
}
