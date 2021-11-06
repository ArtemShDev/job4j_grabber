package ru.job4j.ood.lsp;

class Gadgets {
    protected String typeDevice;
    protected boolean hasGSMModule;

    public Gadgets(String typeDevice, boolean hasGSMModule) {
        this.typeDevice = typeDevice;
        this.hasGSMModule = hasGSMModule;
    }

    public boolean needToTornOff() {
        return hasGSMModule;
    }
}

class LapTop extends Gadgets {

    public LapTop(String typeDevice, boolean hasGSMModule) {
        super(typeDevice, hasGSMModule);
    }

    @Override
    public boolean needToTornOff() {
        if (typeDevice.equals("Laptop")
                || typeDevice.equals("Notebook")) {
            return false;
        }
        return super.needToTornOff();
    }
}

public class UseLapTopWithsGSM {
    public static void main(String[] args) {
        Gadgets lt = new LapTop("Laptop", true);
        System.out.println(lt.needToTornOff());

    }
}
