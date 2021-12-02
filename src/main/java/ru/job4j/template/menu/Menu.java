package ru.job4j.template.menu;

public interface Menu {
    Action select(String itemName);
    void add(String parentName, String childName, Action action);
}
