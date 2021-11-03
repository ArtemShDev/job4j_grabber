package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;

public class FormatJSON implements Format {
    @Override
    public String toFormat(Object report) {
        var lib = new GsonBuilder().create();
        return lib.toJson(report);
    }
}
