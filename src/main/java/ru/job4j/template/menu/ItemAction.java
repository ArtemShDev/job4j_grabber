package ru.job4j.template.menu;

public class ItemAction implements Action {

    private String name;

    public ItemAction(String name) {
        this.name = name;
    }

    @Override
    public void act() {
        System.out.println("Execute: " + name);
    }
}
