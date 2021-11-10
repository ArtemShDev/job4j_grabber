package ru.job4j.ood.lsp.food;

public class Shop extends Storage {

    @Override
    public boolean accept(Food food) {
        double different = useExpiryDate(food.getExpiryDate(), food.getCreateDate());
        if (different >= 75 && different < 100) {
            food.setDiscount(30.00);
        }
        return different >= 25 && different < 100;
    }
}
