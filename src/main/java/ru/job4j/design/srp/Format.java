package ru.job4j.design.srp;

public interface Format {
    <T, S> T toFormat(S report);
}
