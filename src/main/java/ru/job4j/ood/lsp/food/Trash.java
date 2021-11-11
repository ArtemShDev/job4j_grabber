package ru.job4j.ood.lsp.food;

import java.util.function.Predicate;

public class Trash extends Storage {

    public Trash(Predicate<Food> predicate) {
        super(predicate);
    }

    @Override
    public boolean accept(Food food) {
        return useExpiryDate(food.getExpiryDate(), food.getCreateDate()) == 100;
    }
}
