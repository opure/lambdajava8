package com.oneler.Thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by opure on 2017/4/30.
 */
public class CallDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 12444;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> submit = executorService.submit(new CallDemo());
        try {
            Thread.sleep(100);
            System.out.println(submit.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        Callable<Integer> su = () -> new Random().nextInt(100);
        FutureTask<Integer> futureTask = new FutureTask<>(su);
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
