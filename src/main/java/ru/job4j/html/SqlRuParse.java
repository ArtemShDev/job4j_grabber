package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.Parse;
import ru.job4j.grabber.post.Post;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {

    private final DateTimeParser dateTimeParser;

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public static void main(String[] args) throws Exception {
        SqlRuParse srp = new SqlRuParse(new SqlRuDateTimeParser());
        List<Post> list = srp.list("https://www.sql.ru/forum/job-offers");
        System.out.println(list);
    }

    @Override
    public List<Post> list(String link) {
        List<Post> lp = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(String.format(link)).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                Post post = detail(td.child(0).attr("href"));
                lp.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lp;
    }

    @Override
    public Post detail(String link) {
        try {
            Document doc = Jsoup.connect(link).get();
            Elements tabs = doc.select(".msgTable");
            Element tb = tabs.first();
            String title = tb.select(".messageHeader").text();
            String strDesc = tb.child(0).child(1).text();
            String strDate = tb.child(0).select(".msgFooter").text().substring(0, 16);
            LocalDateTime ldt = dateTimeParser.parse(strDate);
            return new Post(title, link, strDesc, ldt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}