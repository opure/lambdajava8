package com.oneler.Thread.basic;

import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by opure on 2017/7/17.
 */
public class Timer01{
    public static void main(String[] args) throws InterruptedException {
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("dddddd");
            }
        }, 10000);
        while (true) {
            System.out.println(LocalTime.now().getSecond());
            System.out.println("aa");
            Thread.sleep(1000);
        }
    }
}
