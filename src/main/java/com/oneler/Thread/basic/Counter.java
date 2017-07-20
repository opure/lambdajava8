package com.oneler.Thread.basic;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    public static int count = 0;

    static AtomicInteger atomic = new AtomicInteger(0);

    public static void inc() {

        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        synchronized (Counter.class) {
            count++;

        }
    }

    public static void main(String[] args) {

        for (int j = 0; j < 30; j++) {

            //同时启动1000个线程，去进行i++计算，看看实际结果

            for (int i = 0; i < 1000; i++) {
                new Thread(() -> {
                    Counter.inc();
                    atomic.incrementAndGet();
                }).start();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            //这里每次运行的值都有可能不同,可能为1000
   		System.out.println("运行结果:Counter.count=" + Counter.count);
            System.out.println("运行结果1:Counter.count=" + atomic.get());
        }
    }
}