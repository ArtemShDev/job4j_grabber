package ru.job4j.cache;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder sb = new StringBuilder();
        if (cache.containsKey(key)) {
            System.out.printf("The file %s is already exist!%n", key);
            return get(key);
        }
        try (Scanner scanner = new Scanner(
                new FileInputStream(String.format("%s/%s", cachingDir, key)))) {
            while (scanner.hasNext()) {
                sb.append(scanner.next()).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String res = sb.toString();
        put(key, res);
        return res;
    }

}