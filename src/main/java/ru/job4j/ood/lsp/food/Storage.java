package ru.job4j.ood.lsp.food;

import java.util.Calendar;
import java.util.List;

public interface Storage {

    boolean add(Food food);
    List<Food> getFood();
    boolean accept(Food food);

    default double useExpiryDate(Calendar expiryDate, Calendar createDate) {
        if (expiryDate.getTimeInMillis() == createDate.getTimeInMillis()) {
            return 100;
        }
        return ((double) (Calendar.getInstance().getTimeInMillis() - createDate.getTimeInMillis())
                / (expiryDate.getTimeInMillis() - createDate.getTimeInMillis())) * 100;
    }
}
