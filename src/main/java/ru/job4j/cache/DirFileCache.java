package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String res = "";
        if (cachingDir == null || cachingDir.equals("")) {
            System.out.println("Please specify the caching directory!");
            return res;
        }
        if (cache.containsKey(key)) {
            System.out.printf("The file %s is already exist!%n", key);
            return get(key);
        }
        try {
            res = Files.readString(Path.of(String.format("%s/%s", cachingDir, key)));
            put(key, res);
            System.out.printf("File %s was load into the cache!%n", key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

}