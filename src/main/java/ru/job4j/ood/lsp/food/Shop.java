package ru.job4j.ood.lsp.food;

import java.util.function.Predicate;

public class Shop extends Storage {

    public Shop(Predicate<Food> predicate) {
        super(predicate);
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
