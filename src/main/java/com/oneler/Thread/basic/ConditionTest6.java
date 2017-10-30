package com.oneler.Thread.basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 子循环10次，主循环100次，如此反复50次
 */
public class ConditionTest6 {

    public static void main(String[] args) throws InterruptedException {
        MyService ms = new MyService();

        new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                ms.sub(i);
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
        Lock lock = new ReentrantLock();
        Condition conditionSub = lock.newCondition();
        Condition conditionMain = lock.newCondition();
        boolean beShouldSub = true;

        public void sub(int i) {
            try {
                lock.lock();
                while (!beShouldSub) {
                    conditionSub.await();
                }
                for (int j = 1; j <= 10; j++) {
                    System.out.println("sub thread sequeue of " + j + "loop of " + i);
                }
                beShouldSub = false;
                conditionMain.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void main(int i) {
            try {
                lock.lock();
                while (beShouldSub) {
                    conditionMain.await();
                }
                for (int j = 1; j <= 20; j++) {
                    System.out.println("Main thread sequeue of " + j + "loop of " + i);
                }
                beShouldSub = true;
                conditionSub.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}