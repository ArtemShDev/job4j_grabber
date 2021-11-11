package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

abstract class Storage {

    private List<Food> list = new ArrayList<>();
    private Predicate<Food> predicate;

    public Storage(Predicate<Food> predicate) {
        this.predicate = predicate;
    }

    public boolean add(Food food) {
        if (!accept(food)) {
            return false;
        }
        return list.add(food);
    }

    public boolean addResort(Food food) {
        if (!predicate.test(food)) {
            return false;
        }
        return list.add(food);
    }

    public List<Food> getFood() {
        return List.copyOf(list);
    }

    public void clearAll() {
        list.clear();
    }

    public static double useExpiryDate(Calendar expiryDate, Calendar createDate) {
        if (expiryDate.getTimeInMillis() == createDate.getTimeInMillis()) {
            return 100;
        }
        return ((double) (Calendar.getInstance().getTimeInMillis() - createDate.getTimeInMillis())
                / (expiryDate.getTimeInMillis() - createDate.getTimeInMillis())) * 100;
    }

    abstract boolean accept(Food food);
}
