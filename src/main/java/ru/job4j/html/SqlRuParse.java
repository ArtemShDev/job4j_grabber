package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.Parse;
import ru.job4j.grabber.post.Post;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;
import ru.job4j.quartz.AlertRabbit;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlRuParse implements Parse {

    private final DateTimeParser dateTimeParser;

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public void createTable() {
        try (Statement statement = getConnection(readProperties()).createStatement()) {
            statement.execute(String
                    .format("create table if not exists post%s",
                            "(id serial primary key, name text, text text, link text, created timestamp)"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection(Properties cfg) throws Exception {
        Class.forName(cfg.getProperty("driver-class-name"));
        return DriverManager.getConnection(
                cfg.getProperty("url"),
                cfg.getProperty("username"),
                cfg.getProperty("password"));
    }

    private Properties readProperties() {
        Properties cfg = new Properties();
        try (InputStream in = AlertRabbit.class.getClassLoader()
                .getResourceAsStream("rabbit.properties")) {
            cfg.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cfg;
    }

    public static void main(String[] args) {
        SqlRuParse srp = new SqlRuParse(new SqlRuDateTimeParser());
        srp.createTable();
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