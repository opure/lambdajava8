package com.oneler.Thread.pc;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private volatile boolean isRunning = true;

    private BlockingQueue<PcData> queue;

    private static AtomicInteger count = new AtomicInteger();

    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<PcData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PcData data = null;
        Random random = new Random();
        System.out.println("start" + Thread.currentThread().getId());

        try {
            while (isRunning) {
                Thread.sleep(random.nextInt(SLEEPTIME));
                data = new PcData(count.incrementAndGet());
                System.out.println(data + " is put into queue");

                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("faild to put data:" + data);
                }
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }
}
