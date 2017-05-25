package com.oneler.Thread;

import com.google.common.util.concurrent.ListenableFutureTask;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by opure on 2017/4/30.
 */
public class CallDemo implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        return 12444;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> submit = executorService.submit(new CallDemo());
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Callable<Integer> su = () -> new Random().nextInt(100);
        FutureTask<Integer> futureTask = new FutureTask<Integer>(su);
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
