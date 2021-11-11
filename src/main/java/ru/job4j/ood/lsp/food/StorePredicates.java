package ru.job4j.ood.lsp.food;

import java.util.function.Predicate;

public interface StorePredicates<K>  {
    boolean put(Storage storage, Predicate<K> predicate);
    Predicate<K> get(Storage storage);
}
