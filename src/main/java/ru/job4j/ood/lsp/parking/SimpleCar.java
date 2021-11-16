package ru.job4j.ood.lsp.parking;

public class SimpleCar implements Car {
    private String number;

    public SimpleCar(String number) {
        this.number = number;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public String getNumber() {
        return number;
    }
}
