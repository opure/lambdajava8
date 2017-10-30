package com.oneler.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateAPIUtilities {

    public static void main(String[] args) {


        LocalDate today = LocalDate.now();
        System.out.println(today
        );

        System.out.println(new Date());

        LocalDate dateFromBase = LocalDate.ofEpochDay(366);
        System.out.println(dateFromBase);
        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 10);
        System.out.println("100th day of 2014=" + hundredDay2014);
        //Getting date from the base date i.e 01/01/1970
        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(60);
        System.out.println("10000th second time= " + specificSecondTime);

        //Get the Year, check if it's leap year
        System.out.println("Year " + today.getYear() + " is Leap Year? " + today.isLeapYear());

        //Compare two LocalDate for before and after
        System.out.println("Today is before 01/01/2015? " + today.isBefore(LocalDate.of(2015, 1, 1)));

        //Create LocalDateTime from LocalDate
        System.out.println("Current Time=" + today.atTime(LocalTime.now()));
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        //plus and minus operations
        System.out.println("10 days after today will be " + today.plusDays(10));
        System.out.println("3 weeks after today will be " + today.plusWeeks(3));
        System.out.println("20 months after today will be " + today.plusMonths(20));

        System.out.println("10 days before today will be " + today.minusDays(10));
        System.out.println("3 weeks before today will be " + today.minusWeeks(3));
        System.out.println("20 months before today will be " + today.minusMonths(20));

        //Temporal adjusters for adjusting the dates
        System.out.println("First date of this month= " + today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this year= " + lastDayOfYear);

        Period period = today.until(lastDayOfYear);
        System.out.println("Period Format= " + period);
        System.out.println("Months remaining in the year= " + period.getMonths());
        LocalDate dateOfBirth = LocalDate.of(2016, 4, 18);
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);

        if(currentMonthDay.equals(birthday)){
            System.out.println("好高兴今天是您的生日!!");
        }else{
            System.out.println("对不起，今天不是您的生日!!");
        }

        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(2); // 添加两小时
        System.out.println("当前时间:" + time + ",两小时后的时间: " +  newTime);

        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("今天是:" + today + ",一周以后的日期: " + nextWeek);
        // 得到UTC的时区的日期时间clock对象
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);

        // 得到基于当前时区的日期时间clock对象
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + clock);
        //信用卡到期
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("该月的天数 %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
        System.out.printf("您的信用卡到期是： %s%n", creditCardExpiry);

        LocalDate java8Release = LocalDate.of(2016, Month.APRIL, 21);
        Period periodToNext = Period.between(today, java8Release);
        System.out.println("2016年4月21日距离今天的天数：" + periodToNext.getYears()+periodToNext.getMonths());
        LocalDateTime datetime = LocalDateTime.of(2016, Month.APRIL, 19, 23, 35);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);
        System.out.println("包含时差信息的日期和时间 : " + date);

        String day = "20160418";
        LocalDate formatted = LocalDate.parse(day, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("从字符串中解析的日期: %s 是 %s %n", day, formatted);
    }
}