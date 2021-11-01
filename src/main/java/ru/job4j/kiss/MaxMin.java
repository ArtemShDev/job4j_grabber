package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return calc(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return calc(value, comparator);

    }

    public <T> T calc(List<T> value, Comparator<T> comparator) {
        T val = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            val = comparator.compare(value.get(i), val) > 0 ? value.get(i) : val;
        }
        return val;
    }
}