package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return calc(value, comparator, x -> x > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return calc(value, comparator, x -> x < 0);
    }

    public <T> T calc(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T val = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            val = predicate.test(comparator.compare(value.get(i), val)) ? value.get(i) : val;
        }
        return val;
    }
}