package com.oneler.Thread;


/**
 * Created by opure on 2017/7/18.
 */
public class StopThreadUnsafe {

    private static User user = new User();

    private static class User {
        private int id;
        private String name;

        public User() {
            id = 0;
            name = "0";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return "[id=" + id + ",name" + name + "]";
        }

    }

    public static class ChangeObjectThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    int v = (int) (System.currentTimeMillis() / 1000);
                    user.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if (user.getId() != Integer.parseInt((user.getName()))) {
                        System.out.println(user.toString());
                    }
                    Thread.yield();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ReadObjectThread()).start();
        while (true) {
            Thread t = new Thread(new ChangeObjectThread());
            t.start();
            Thread.sleep(100);
            t.stop();
        }
    }
}
