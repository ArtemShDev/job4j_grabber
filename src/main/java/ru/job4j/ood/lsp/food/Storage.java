package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

abstract class Storage {

    private List<Food> list = new ArrayList<>();

    public boolean add(Food food) {
        if (!accept(food)) {
            return false;
        }
        return list.add(food);
    }

    public List<Food> getFood() {
        return List.copyOf(list);
    }

    double useExpiryDate(Calendar expiryDate, Calendar createDate) {
        if (expiryDate.getTimeInMillis() == createDate.getTimeInMillis()) {
            return 100;
        }
        return ((double) (Calendar.getInstance().getTimeInMillis() - createDate.getTimeInMillis())
                / (expiryDate.getTimeInMillis() - createDate.getTimeInMillis())) * 100;
    }

    abstract boolean accept(Food food);
}
