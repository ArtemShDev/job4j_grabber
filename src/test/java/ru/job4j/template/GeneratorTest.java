package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {

    @Ignore
    @Test
    public void produce() {
        Generator gst = new GeneratorSmallTalk();
        Map<String, String> map = new HashMap<>();
        map.put("myName", "Alex");
        map.put("yourName", "Tom");
        String res = gst.produce("I am a ${myName}, Is your name ${yourName}? ", map);
        assertThat(res, is("I am a Alex, Is your name Tom? "));
    }

    @Ignore
    @Test(expected = NoSuchElementException.class)
    public void produceNotElemInMap() {
        Generator gst = new GeneratorSmallTalk();
        Map<String, String> map = new HashMap<>();
        map.put("yourName", "Tom");
        String res = gst.produce("I am a ${myName}, Is your name ${yourName}? ", map);
    }

    @Ignore
    @Test(expected = NoSuchElementException.class)
    public void produceNotElemInTemplate() {
        Generator gst = new GeneratorSmallTalk();
        Map<String, String> map = new HashMap<>();
        map.put("myName", "Alex");
        map.put("yourName", "Tom");
        String res = gst.produce("Is your name ${yourName}? ", map);
    }
}