package me.mineva22c.java8to11;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App6 {

    public static void main(String[] args) {

        Instant instant = Instant.now(); // UTC, GMT
        System.out.println(instant);
        System.out.println(instant.atZone(ZoneId.of("UTC")));
        System.out.println(instant.atZone(ZoneId.of("Asia/Seoul")));

        ZoneId zoneid = ZoneId.systemDefault();
        System.out.println(zoneid);
        ZonedDateTime zonedDateTime = instant.atZone(zoneid);
        System.out.println(zonedDateTime);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        ///////////////
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime birthday = LocalDateTime.of(1987, Month.MARCH, 1, 0, 0 , 0);
        System.out.println(birthday);
        System.out.println(birthday.plusMinutes(30));

        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthDay = LocalDate.of(2020,Month.MARCH,1);
        Period period = Period.between(thisYearBirthDay, today);
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println(period.getChronology());
        System.out.println(period.getUnits());

        // Human용 시간 비교
        Period until = thisYearBirthDay.until(today);
        System.out.println(until.get(ChronoUnit.DAYS));

        // Machine Time 비교
        Instant now1 = Instant.now();
        LocalDateTime plus = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, plus);
        System.out.println("Duration : " + between.getSeconds());

        LocalDateTime now2 = LocalDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");
        System.out.println("Formatted : " + now2.format(formatter1));
//        now2 = now2.plusMinutes(20);

        LocalDateTime parse = LocalDateTime.parse("20200301 130102", formatter1);
        System.out.println("Parsed : " + parse);

        // 기존 api와 호환
        Date date = new Date();
        Instant now3 = date.toInstant();
        Date newDate = Date.from(now3);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss").withZone(ZoneId.systemDefault());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmmss");
        System.out.println("Compatible : " + dtf.format(now3));
        System.out.println("Compatible : " + sdf.format(newDate));

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        ZonedDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar gregorianCalendar1 = GregorianCalendar.from(dateTime);

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        System.out.println("ZondId : " + zoneId);
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
        System.out.println("TimeZone : " + timeZone.getID());
    }

}
