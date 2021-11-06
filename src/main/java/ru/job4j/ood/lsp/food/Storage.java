package ru.job4j.ood.lsp.food;

import java.util.List;

public interface Storage {
    void add(Food food);
    List<Food> getFood();
}
