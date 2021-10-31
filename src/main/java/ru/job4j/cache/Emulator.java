package ru.job4j.cache;

import java.util.ArrayList;
import java.util.List;

public class Emulator {

    private final ConsoleInput in = new ConsoleInput();
    private AbstractCache<String, String> cache;

    public void setCache(AbstractCache<String, String> cache) {
        this.cache = cache;
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i).name());
        }
    }

    private void init() {
        boolean run = true;
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CacheDir(this));
        actions.add(new LoadFileIntoCache());
        actions.add(new GetFromCache());
        actions.add(new Exit());
        while (run) {
            showMenu(actions);
            try {
                int n = in.askInt("Select number of menu: ");
                if (n < 0 || n >= actions.size()) {
                    continue;
                }
                run = actions.get(n).execute(in, cache);
            } catch (NumberFormatException e) {
                System.out.println("Please, enter a number!");
            }
        }
    }

    public static void main(String[] args) {
        Emulator em = new Emulator();
        em.init();
    }
}


