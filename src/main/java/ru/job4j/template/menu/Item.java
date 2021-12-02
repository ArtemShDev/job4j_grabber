package ru.job4j.template.menu;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private String name;
    private Action itemAction;
    private List<Item> items = new ArrayList<>();

    public Item(String name, Action itemAction) {
        this.name = name;
        this.itemAction = itemAction;
    }

    public String getName() {
        return name;
    }

    public Action getItemAction() {
        return itemAction;
    }

    public List<Item> getItems() {
        return items;
    }

}
