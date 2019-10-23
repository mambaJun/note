package com.jun.demo.java8.code.timeAPi;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Jun
 * @date: 19-10-22 下午4:27
 */
public class TestDateFormat {
    /*
        LocalDate;
        LocalTime;
        LocalDateTime;
        Instant：时间戳
        Duration：计算两个时间之间的间隔
        Period：计算两个日期之间的间隔
    */
    @Test
    public void localDateTimeDemo() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDate = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(strDate);
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(System.currentTimeMillis());
    }


    @Test
    public void testLocalDate() {
        LocalDate localDate = LocalDate.of(2016, 10, 22);
        LocalDate now = LocalDate.now();
        Period period = Period.between(localDate, now);
        System.out.println(period);
        System.out.println(period.getDays());
        System.out.println(period.getYears());

    }

    @Test
    public void test3() throws InterruptedException {
        Instant instant = Instant.now();
        Thread.sleep(1000);
        Instant instant1 = Instant.now();
        Duration duration = Duration.between(instant, instant1);
        System.out.println(duration);
        System.out.println(duration.toMillis());
    }

    @Test
    public void test2() {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.atOffset(ZoneOffset.ofHours(8)));
        System.out.println(now.atOffset(ZoneOffset.ofHours(8)).toEpochSecond());
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test1() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, 10, 22, 16, 33);
        System.out.println(localDateTime1);
        System.out.println(localDateTime.plusYears(1));
        System.out.println(localDateTime.minusYears(1));
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getMonthValue());
    }
}
