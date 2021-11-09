package ru.job4j.ood.isp.boat;

public class Yacht implements Boats {
    @Override
    public boolean checkAnchor() {
        return true;
    }

    @Override
    public boolean checkPressureInBalloons() {
        throw new UnsupportedOperationException("It hasn't balloons!");
    }

    @Override
    public void run() {
        System.out.println("Let's go!");
    }
}
