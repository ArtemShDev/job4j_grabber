package ru.job4j.kiss;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxMinTest {

    @Test
    public void maxInt() {
        Comparator<Integer> cmpInteger = Comparator.comparingInt(left -> left);
        List<Integer> listInt = Arrays.asList(5, 9, 1, 12, 7, 24);
        MaxMin maxMin = new MaxMin();
        assertThat(maxMin.max(listInt, cmpInteger), is(24));
    }

    @Test
    public void minInt() {
        Comparator<Integer> cmpInteger = Integer::compare;
        List<Integer> listInt = Arrays.asList(5, 9, 1, 12, 7, 24);
        MaxMin maxMin = new MaxMin();
        assertThat(maxMin.min(listInt, cmpInteger), is(1));
    }

    @Test
    public void maxStringLength() {
        Comparator<String> cmpInteger = Comparator.comparingInt(String::length);
        List<String> listInt = Arrays.asList("Test", "Ex", "Freedom");
        MaxMin maxMin = new MaxMin();
        assertThat(maxMin.max(listInt, cmpInteger), is("Freedom"));
    }

    @Test
    public void minStringLength() {
        Comparator<String> cmpInteger = Comparator.comparingInt(String::length);
        List<String> listInt = Arrays.asList("Test", "Ex", "Freedom");
        MaxMin maxMin = new MaxMin();
        assertThat(maxMin.min(listInt, cmpInteger), is("Ex"));
    }
}