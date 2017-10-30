package com.oneler.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by opure on 2017/4/30.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Integer a =2000;
        Integer b =2000;
        System.out.println(a<b);
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute( new Thread(() -> {
            System.out.println("fff");
        }));

    }
}
