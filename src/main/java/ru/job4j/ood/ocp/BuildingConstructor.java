package ru.job4j.ood.ocp;

import java.util.List;

public class BuildingConstructor {

    private static class BuildingAny {

        private final String desc;

        public BuildingAny(String desc) {
            this.desc = desc;
        }

        public String build() {
            return "we build any buildings the same way";
        }
    }

    public static void main(String[] args) {
        List<BuildingAny> list = List.of(new BuildingAny("1-level building"),
                new BuildingAny("5-level building"),
                new BuildingAny("private house"));
        list.forEach(b -> System.out.println(b.build()));
    }
}
