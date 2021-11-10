package ru.job4j.ood.lsp.food;

public class Warehouse extends Storage {
    @Override
    public boolean accept(Food food) {
        double different = useExpiryDate(food.getExpiryDate(), food.getCreateDate());
        return different > 0 && different < 25;
    }
}
