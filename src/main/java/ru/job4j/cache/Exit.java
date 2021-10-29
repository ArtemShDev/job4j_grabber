package ru.job4j.cache;

public class Exit implements UserAction {
    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(ConsoleInput input, AbstractCache<String, String> cache) {
        return false;
    }
}
