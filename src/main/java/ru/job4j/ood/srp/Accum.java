package ru.job4j.ood.srp;

import java.util.HashMap;
import java.util.Map;

public class Accum {
    Map<Device, Float> modeCharge = new HashMap<>();
    Map<Device, Float> capacityAccumulator = new HashMap<>();
    public float getModeCharge(Device device) {
        return modeCharge.getOrDefault(device, 1.5F);
    }
    public float getCapacity(Device device) {
        return capacityAccumulator.get(device);
    }
}
