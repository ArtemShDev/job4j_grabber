package ru.job4j.ood.lsp;

import java.util.List;
import java.util.NoSuchElementException;

class EquipmentRepairShop {
    protected List<String> list =
            List.of("Bosh", "Whirpool", "Indesit");
    public void repair(String equip) {
        if (!list.contains(equip)) {
            throw new NoSuchElementException("We don't repair that");
        }
    }
}

class WashingMachineRepairShop extends EquipmentRepairShop {
    @Override
    public void repair(String equip) {
        if (!list.contains(equip)) {
            throw new IllegalArgumentException("We don't repair that");
        }
    }
}

public class TestRepairShop {
    public static void main(String[] args) {
        EquipmentRepairShop ers = new WashingMachineRepairShop();
        ers.repair("LG");
    }
}
