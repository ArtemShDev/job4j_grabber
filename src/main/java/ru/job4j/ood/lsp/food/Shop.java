package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

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
        double different = useExpiryDate(food.getExpiryDate(), food.getCreateDate());
        if (different >= 75 && different < 100) {
            food.setDiscount(30.00);
        }
        return different >= 25 && different < 100;
    }
}
