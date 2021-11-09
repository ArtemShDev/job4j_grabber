package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    private List<Food> list = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        if (!accept(food)) {
           return false;
        }
        return list.add(food);
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
