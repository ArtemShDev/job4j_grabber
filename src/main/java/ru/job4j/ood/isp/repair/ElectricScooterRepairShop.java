package ru.job4j.ood.isp.repair;

public class ElectricScooterRepairShop implements ElectricVehicleRepairShop {
    @Override
    public boolean upOnTheLift() {
        throw new UnsupportedOperationException("It doesn't need to lift for repair!");
    }

    @Override
    public boolean checkEnergySystem() {
        return true;
    }

    @Override
    public boolean changeBattery() {
        return true;
    }
}
