package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportEngineXML implements Report {

    private Store store;
    private Format converter;

    public ReportEngineXML(Store store, Format converter) {
        this.store = store;
        this.converter = converter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append((String) converter.toFormat(new Employees(store.findBy(filter))));
        return text.toString();
    }
}