package ru.job4j.ood.isp.repair;

public class ElectricCarRepairShop implements ElectricVehicleRepairShop {
    @Override
    public boolean upOnTheLift() {
        return true;
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
