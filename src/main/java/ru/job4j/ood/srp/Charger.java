package ru.job4j.ood.srp;

public interface Charger<T> {
    int charge(T device);
    void notifyTimeExpired();
}
