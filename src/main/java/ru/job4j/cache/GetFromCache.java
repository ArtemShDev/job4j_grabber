package ru.job4j.cache;

public class GetFromCache implements UserAction {
    @Override
    public String name() {
        return "Get file from a cache";
    }

    @Override
    public boolean execute(ConsoleInput input, AbstractCache<String, String> cache) {
        System.out.println("=== Get file from a cache ====");
        String name = input.askStr("Get file from a cache (file name) : ");
        if (cache == null) {
            System.out.println("Please specify the caching directory!");
        } else {
            System.out.printf("File from the cache: %s%n%s%n", name, cache.get(name));
        }
        return true;
    }
}
