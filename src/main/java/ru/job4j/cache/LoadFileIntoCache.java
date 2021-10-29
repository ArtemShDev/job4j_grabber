package ru.job4j.cache;

public class LoadFileIntoCache implements UserAction {
    @Override
    public String name() {
        return "Load file into a cache";
    }

    @Override
    public boolean execute(ConsoleInput input, AbstractCache<String, String> cache) {
        System.out.println("=== Enter the file name ====");
        String name = input.askStr("Enter the file name into the directory : ");
        if (cache == null) {
            System.out.println("Please specify the caching directory!");
        } else {
            System.out.println(cache.load(name));
            System.out.println("File " + name + " was load");
        }
        return true;
    }
}
