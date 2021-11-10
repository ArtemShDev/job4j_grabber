package ru.job4j.ood.isp.menu;

public class Item implements MenuItem {

    private  String name;
    public Item(String name) {
        this.name = name;
    }

    @Override
    public boolean execute() {
        System.out.println("Execute : " + name);
        return true;
    }

    @Override
    public void printItem(int level) {
        System.out.println("----".repeat(level) + name);
    }
}
