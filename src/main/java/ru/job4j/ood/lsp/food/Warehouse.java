package ru.job4j.ood.lsp.food;

import java.util.function.Predicate;

public class Warehouse extends Storage {

    public Warehouse(Predicate<Food> predicate) {
        super(predicate);
    }

    @Override
    public boolean accept(Food food) {
        double different = useExpiryDate(food.getExpiryDate(), food.getCreateDate());
        return different > 0 && different < 25;
    }
}
