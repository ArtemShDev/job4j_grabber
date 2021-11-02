package ru.job4j.ood.srp;

public class FastCharger implements Charger<Device> {
    @Override
    public int charge(Device device) {
        Accum accum = new Accum();
        float mode = accum.getModeCharge(device);
        float hoursCharging = 0.5F;
        return (int) ((device.getCurrentChargeAmpHours() + mode * hoursCharging)
                / accum.getCapacity(device)) * 100;
    }

    @Override
    public void notifyTimeExpired() {
        System.out.println("30 minutes are expired!");
    }
}
