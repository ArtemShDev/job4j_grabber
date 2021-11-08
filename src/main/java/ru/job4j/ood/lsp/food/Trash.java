package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    List<Food> list = new ArrayList<>();

    @Override
    public void add(Food food) {
        list.add(food);
    }

    @Override
    public List<Food> getFood() {
        return List.copyOf(list);
    }

    @Override
    public boolean accept(Food food) {
        return useExpiryDate(food.getExpiryDate(), food.getCreateDate()) == 100;
    }
}
