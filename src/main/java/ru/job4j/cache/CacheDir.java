package ru.job4j.cache;

public class CacheDir implements UserAction {

    private Emulator em;
    public CacheDir(Emulator em) {
        this.em = em;
    }

    @Override
    public String name() {
        return "Specify the cache directory";
    }

    @Override
    public boolean execute(ConsoleInput input, AbstractCache<String, String> cache) {
        System.out.println("=== Specify the cache directory ====");
        String name = input.askStr("Specify the cache directory : ");
        em.setCache(new DirFileCache(name));
        System.out.println("Cache directory : " + name);
        return true;
    }
}
