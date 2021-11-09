package ru.job4j.ood.isp.store;

public class CabinetFurnitureStore implements FurnitureStore {
    @Override
    public boolean sale() {
        return true;
    }

    @Override
    public boolean delivery() {
        return true;
    }

    @Override
    public boolean utilizeOldFurniture() {
        return true;
    }
}
