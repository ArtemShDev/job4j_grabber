package ru.job4j.ood.isp.store;

public class UpholsteredFurnitureStore implements FurnitureStore {
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
        throw new UnsupportedOperationException("We don't utilize the old furniture!");
    }
}
