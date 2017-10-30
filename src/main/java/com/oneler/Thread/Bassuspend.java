package com.oneler.Thread;

/**
 * Created by opure on 2017/7/19.
 */
public class Bassuspend {

    public static Object u = new Object();
    static ChangeObject t1 = new ChangeObject("t1");
    static ChangeObject t2 = new ChangeObject("t2");

    public static class ChangeObject extends Thread {
        public ChangeObject(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            super.run();
            synchronized (u) {
                System.out.println("in" + getName());
                Thread.currentThread().suspend();
                System.out.println("dd");
            }
        }

        public static void main(String[] args) throws InterruptedException {
            t1.start();
            Thread.sleep(100);
            t2.start();
            t1.resume();
            t2.resume();
            t1.join();
            t2.join();
        }
    }
}
