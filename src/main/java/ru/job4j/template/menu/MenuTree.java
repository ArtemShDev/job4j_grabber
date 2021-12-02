package ru.job4j.template.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuTree implements Menu {

    private List<Item> menu = new ArrayList<>();

    public void add(String parentName, String childName, Action action) {

        if (parentName.equals("")) {
            menu.add(new Item(childName, action));
            return;
        }

        Item currentItem = findItem(parentName, menu);
        if (currentItem == null)  {
            throw new NoSuchElementException("Отсутствует пункт подменю: " + parentName);
        }

        currentItem.getItems().add(new Item(childName, action));
    }

    private Item findItem(String parentName, List<Item> subMenu) {

        Item findItem = null;
        for (Item item : subMenu) {
            if (parentName.equals(item.getName())) {
                return item;
            } else {
                findItem = findItem(parentName, item.getItems());
                if (findItem != null) {
                    break;
                }
            }
        }
        return findItem;
    }

    private String printMenu(List<Item> subMenu) {
        StringBuilder sb = new StringBuilder();
        for (Item item : subMenu) {
            sb.append(item.getName()).append(System.lineSeparator())
                    .append(printMenu(item.getItems()));
        }
        return sb.toString();
    }

    public Action select(String itemName) {
        Item currentItem = findItem(itemName, menu);
        if (currentItem == null)  {
            throw new NoSuchElementException("Отсутствует пункт меню: " + itemName);
        }
        return currentItem.getItemAction();
    }

    @Override
    public String toString() {
        return printMenu(menu);
    }
}

class ShowMenu {

    public static void main(String[] args) {
        Menu menu = new MenuTree();
        menu.add("", "Задача 1.", new ItemAction("Выполняем действие Задача 1."));
        menu.add("Задача 1.", "Задача 1.1.", new ItemAction("Выполняем действие Задача 1.1."));
        menu.add("Задача 1.1.", "Задача 1.1.1.", new ItemAction("Выполняем действие Задача 1.1.1."));
        menu.add("Задача 1.", "Задача 1.2.", new ItemAction("Выполняем действие Задача 1.2."));
        menu.add("Задача 1.1.", "Задача 1.1.2.", new ItemAction("Выполняем действие Задача 1.1.2."));
        while (true) {
            System.out.println(menu);
            System.out.print("Введите название пункта меню (Для выхода наберите Exit): ");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if (str.equals("Exit")) {
                break;
            }
            try {
                menu.select(str).act();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
    }
}
