package ru.job4j.ood.isp.boat;

public class RubberBoat implements Boats {
    @Override
    public boolean checkAnchor() {
        return true;
    }

    @Override
    public boolean checkPressureInBalloons() {
        return true;
    }

    @Override
    public void run() {
        System.out.println("Let's go!");
    }
}
