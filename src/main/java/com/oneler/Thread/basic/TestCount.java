package com.oneler.Thread.basic;


public class TestCount {

    private volatile static int count = 0;

    public static void counts() {
        synchronized (TestCount.class) {
            count++;
        }
    }


    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                TestCount.counts();
            }).start();
        }
        System.out.println(TestCount.count);
    }

}
