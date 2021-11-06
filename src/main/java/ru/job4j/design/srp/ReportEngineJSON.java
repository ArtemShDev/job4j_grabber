package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportEngineJSON implements Report {

    private final Store store;
    private final Format converter;

    public ReportEngineJSON(Store store, Format converter) {
        this.store = store;
        this.converter = converter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            text.append((String) converter.toFormat(employee)).append(System.lineSeparator());
        }
        return text.toString();
    }
}