package com.oneler.Thread;

public class NumberCount implements Runnable {
    static int count = 0;

    @Override
    public void run() {
        synchronized (NumberCount.class) {

            for (int i = 0; i < 2000000; i++) {
                count++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new NumberCount());
        Thread t2 = new Thread(new NumberCount());
        t1.start();
        t2.start();
        System.out.println(count);
    }
}
