package com.oneler.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateParseFormatExample {

    public static void main(String[] args) {

        //Format examples
        LocalDate date = LocalDate.now();
        //default format
        System.out.println("Default format of LocalDate=" + date);
        //specific format
        System.out.println(date.format(DateTimeFormatter.ofPattern("d::MM::uuuu")));
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        LocalDateTime dateTime = LocalDateTime.now();
        //default format
        System.out.println("Default format of LocalDateTime=" + dateTime);
        //specific format
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

        Instant timestamp = Instant.now();
        //default format
        System.out.println("Default format of Instant=" + timestamp);

        //Parse examples
        LocalDateTime dt = LocalDateTime.parse("27::四月::2014 21::39::48",
                DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
        System.out.println("Default format after parsing = " + dt);
    }

}