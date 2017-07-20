package com.oneler.Thread.basic;

/**
 * Created by opure on 2017/7/17.
 */
public class Thread01 {

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("01"+Thread.currentThread().getName());
                    System.out.println("02"+this.getName());
                }
            }
        };
        thread.run();
        thread.run();
        System.out.println("a");
    }
}
