package com.itmayiedu;

import java.time.Duration;
import java.time.Instant;
import java.time.Year;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class InstantExample {
    public static void main(String[] args) {
        //Current timestamp
        Instant timestamp = Instant.now();
        System.out.println("Current Timestamp = " + timestamp);
        //Instant from timestamp
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific Time = " + specificTime);
        //Duration example
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay);
        Date date = new Date(112,0,1);
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018,Calendar.OCTOBER,10);
        System.out.println(calendar.getTime());

        Calendar birth = Calendar.getInstance();
        birth.set(1975, Calendar.MAY, 26);
        Calendar now = Calendar.getInstance();
        System.out.println(daysBetween(birth, now));
        System.out.println(daysBetween(birth, now));
        Year now1 = Year.now();
        System.out.println(now1);
        ZonedDateTime now2 = ZonedDateTime.now();
        System.out.println(now2);
    }

    public static long daysBetween(Calendar begin, Calendar end) {
        Calendar calendar = (Calendar) begin.clone();
        long daysBetween = 0;
        while(calendar.before(end)) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
            }
        return daysBetween;
        }
}
