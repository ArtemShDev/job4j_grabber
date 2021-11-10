package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuItem {

    private List<MenuItem> menu = new ArrayList<>();
    private String name;
    private int level;

    public Menu(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public void add(MenuItem Item) {
        menu.add(Item);
    }

    private void remove(MenuItem Item) {
        menu.remove(Item);
    }

    @Override
    public boolean execute() {
        for (MenuItem item : menu) {
            item.execute();
        }
        return true;
    }

    @Override
    public void printItem(int level) {
        System.out.println("----".repeat(this.level) + name);
        for (MenuItem item : menu) {
            item.printItem(this.level + 1);
        }
    }
}

class ShowMenu {

    public static void main(String[] args) {
        Menu mainMenu = new Menu(0, "Задача 1.");
        Menu subMenu1 = new Menu(1, "Задача 1.1.");
        subMenu1.add(new Item("Задача 1.1.1."));
        subMenu1.add(new Item("Задача 1.1.2."));
        mainMenu.add(subMenu1);
        mainMenu.add(new Item("Задача 1.2."));
        mainMenu.printItem(0);
        mainMenu.execute();
    }
}