package ru.job4j.ood.ocp;

import java.util.List;

public class FactoryAllToys {

    private static class FactoryToys {
        public String made(String figure, String material) {
            String res = "";
            if (figure.equals("ball")) {
                if (material.equals("glass")) {
                    res = "Glass ball";
                } else if (material.equals("wood")) {
                    res = "Wood ball";
                } else {
                    res = "We can't to made this toy!";
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        List<String> toys = List.of(
                new FactoryToys().made("ball", "glass"),
                new FactoryToys().made("ball", "wood"),
                new FactoryToys().made("car", "wood"),
                new FactoryToys().made("duc", "rubber"));
        toys.forEach(System.out::println);
    }
}
