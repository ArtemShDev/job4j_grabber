package ru.job4j.ood.lsp.food;

public class Trash extends Storage {
    @Override
    public boolean accept(Food food) {
        return useExpiryDate(food.getExpiryDate(), food.getCreateDate()) == 100;
    }
}
