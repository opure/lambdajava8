package com.oneler.Thread.basic;

/**
 * 子循环10次，主循环100次，如此反复50次
 */
public class ConditionTest7 {

    public static void main(String[] args) throws InterruptedException {
        MyService ms = new MyService();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    ms.sub(i);
                }
            }
        }) {
        }.start();

        Thread.sleep(1000); // 目的是让子线程先跑

        // main方法本身即为主线程
        for (int i = 1; i <= 50; i++) {
            ms.main(i);
        }
    }

    static class MyService {
        boolean beShouldSub = true;

        public synchronized void sub(int i) {

            if (!beShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println("sub thread sequeue of " + j + "loop of " + i);
            }
            beShouldSub = false;
            this.notify();
        }

        public synchronized void main(int i) {
            if (beShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 20; j++) {
                System.out.println("Main thread sequeue of " + j + "loop of " + i);
            }

            beShouldSub = true;
            this.notify();
        }
    }
}