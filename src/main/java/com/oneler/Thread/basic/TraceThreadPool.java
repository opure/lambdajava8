package com.oneler.Thread.basic;

import java.util.concurrent.*;

public class TraceThreadPool extends ThreadPoolExecutor {
    public TraceThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }


    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command, clientStack(), Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, clientStack(), Thread.currentThread().getName()));
    }

    public Exception clientStack() {
        return new Exception("client satck trace");
    }

    private Runnable wrap(final Runnable task, final Exception clientStack, String clientThreadName) {
        return () -> {
            try {
                task.run();
            } catch (Exception e) {
                clientStack.printStackTrace();
                throw e;
            }
        };
    }

    public static void main(String[] args) {
        TraceThreadPool traceThreadPool = new TraceThreadPool(0,Integer.MAX_VALUE,0L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5 ; i++) {
            int finalI = i;
            traceThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(100/ finalI);
                }
            });

        }

    }
}
