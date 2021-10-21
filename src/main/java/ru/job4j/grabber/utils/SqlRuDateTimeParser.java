package ru.job4j.grabber.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

public class SqlRuDateTimeParser implements DateTimeParser {

    private static final Map<String, String> MONTHS =
            Map.ofEntries(Map.entry("янв", "1"), Map.entry("фев", "2"),
                    Map.entry("мар", "3"), Map.entry("апр", "4"),
                    Map.entry("май", "5"), Map.entry("июн", "6"),
                    Map.entry("июл", "7"), Map.entry("авг", "8"),
                    Map.entry("сен", "9"), Map.entry("окт", "10"),
                    Map.entry("ноя", "11"), Map.entry("дек", "12"));

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 5; i++) {
            Document doc = Jsoup.connect(
                    String.format("https://www.sql.ru/forum/job-offers/%s", i)).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                String str = td.parent().child(5).text();
                SqlRuDateTimeParser sp = new SqlRuDateTimeParser();
                LocalDateTime ldt = sp.parse(str);
                System.out.println(ldt);
            }
        }
    }

    @Override
    public LocalDateTime parse(String parse) {
        LocalDateTime ldt;
        String[] arrStr;
        if (parse.contains("сегодня") || parse.contains("вчера")) {
            Date date = new Date(System.currentTimeMillis() - (parse.contains("вчера") ? 24 * 60 * 60 * 1000 : 0));
            String strDate = new SimpleDateFormat("yy MMM dd").format(date);
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