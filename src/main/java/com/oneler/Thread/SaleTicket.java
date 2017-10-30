package com.oneler.Thread;

public class SaleTicket implements Runnable {

    public int total;
    public int count;

    public SaleTicket() {
        total = 1000000;
        count = 0;
    }

    public void run() {
        while (total > 0) {
            synchronized (SaleTicket.class) {
                if (total > 0) {
                    count++;
                    total--;
                    System.out.println(Thread.currentThread().getName() + "\t当前票号：" + count);
                }
            }
        }

    }

    public static void main(String[] args) {
        SaleTicket st = new SaleTicket();
        for (int i = 1; i <= 20; i++) {
            new Thread(st, "售票点" + i).start();
        }
    }
} 