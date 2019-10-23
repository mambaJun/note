package com.jun.demo.java8.code;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

/**
 * @author Jun
 * @date: 19-10-22 下午4:17
 */
public class TimeDemo {
    @Test
    public void test() {
        Clock clock = new Clock() {
            @Override
            public ZoneId getZone() {
                return null;
            }

            @Override
            public Clock withZone(ZoneId zoneId) {
                return null;
            }

            @Override
            public Instant instant() {
                return null;
            }
        };
    }
}
