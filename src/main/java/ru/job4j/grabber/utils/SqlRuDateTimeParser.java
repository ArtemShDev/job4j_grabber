package ru.job4j.grabber.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.post.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class SqlRuDateTimeParser implements DateTimeParser {

    private static final Map<String, String> MONTHS =
            Map.ofEntries(Map.entry("янв", "1"), Map.entry("фев", "2"),
                    Map.entry("мар", "3"), Map.entry("апр", "4"),
                    Map.entry("май", "5"), Map.entry("июн", "6"),
                    Map.entry("июл", "7"), Map.entry("авг", "8"),
                    Map.entry("сен", "9"), Map.entry("окт", "10"),
                    Map.entry("ноя", "11"), Map.entry("дек", "12"));

    @Override
    public LocalDateTime parse(String parse) {
        LocalDateTime ldt;
        String[] arrStr;
        if (parse.contains("сегодня") || parse.contains("вчера")) {
            LocalDate ld = (parse.contains("вчера") ? LocalDate.now().minusDays(1) : LocalDate.now());
            String strDate = ld.format(DateTimeFormatter.ofPattern("yy MMM dd"));
            strDate = String.format("%s%s", strDate, parse.substring(parse.indexOf(",")))
                    .replace(".", "");
            arrStr = strDate.split(" ");
        } else {
            arrStr = parse.split(" ");
        }
        ldt = LocalDateTime.of(
                Integer.parseInt(String.format("%s%s", "20", arrStr[2].substring(0, 2))),
                Integer.parseInt(MONTHS.get(arrStr[1])), Integer.parseInt(arrStr[0]),
                Integer.parseInt(arrStr[3].substring(0, 2)),
                Integer.parseInt(arrStr[3].substring(3)));
        return ldt;
    }
}