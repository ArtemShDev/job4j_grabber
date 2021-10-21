package ru.job4j.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class AlertRabbit {

    private static Properties cfg;

    public static void main(String[] args) {
        try {
            readProperties();
            Class.forName(cfg.getProperty("driver-class-name"));
            try (Connection cn = DriverManager.getConnection(
                    cfg.getProperty("url"),
                    cfg.getProperty("username"),
                    cfg.getProperty("password"))) {
                List<Long> store = new ArrayList<>();
                Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
                scheduler.start();
                JobDataMap data = new JobDataMap();
                data.put("store", store);
                data.put("connection", cn);
                JobDetail job = newJob(Rabbit.class)
                        .usingJobData(data)
                        .build();
                SimpleScheduleBuilder times = simpleSchedule()
                        .withIntervalInSeconds(Integer.parseInt(cfg.getProperty("rabbit.interval")))
                        .repeatForever();
                Trigger trigger = newTrigger()
                        .startNow()
                        .withSchedule(times)
                        .build();
                scheduler.scheduleJob(job, trigger);
                Thread.sleep(10000);
                scheduler.shutdown();
                System.out.println(store);
            }
        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    private static void readProperties() {
        cfg = new Properties();
        try (InputStream in = AlertRabbit.class.getClassLoader()
                .getResourceAsStream("rabbit.properties")) {
            cfg.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Rabbit implements Job {

        public Rabbit() {
            System.out.println(hashCode());
        }

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("Rabbit runs here ...");
            List<Long> store = (List<Long>) context.getJobDetail().getJobDataMap().get("store");
            Connection cn = (Connection) context.getJobDetail().getJobDataMap().get("connection");
            Long t = System.currentTimeMillis();
            store.add(t);
            try (PreparedStatement statement = cn.
                    prepareStatement("insert into rabbit_(created_date) values (?)")) {
                statement.setTimestamp(1, new Timestamp(t));
                statement.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}