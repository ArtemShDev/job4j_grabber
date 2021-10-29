package ru.job4j.cache;

public interface UserAction {
    String name();

    boolean execute(ConsoleInput input, AbstractCache<String, String> cache);
}
