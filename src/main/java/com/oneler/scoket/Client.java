package com.oneler.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class Client {
    private static ExecutorService ex = Executors.newCachedThreadPool();
    private static final int int_sleep = 0;


    static class EchoClient implements Runnable {
        @Override
        public void run() {
            Socket client = null;
            PrintWriter printWriter = null;
            BufferedReader bufferedReader = null;

            try {
                client = new Socket();
                client.connect(new InetSocketAddress("localhost", 8000));
                printWriter = new PrintWriter(client.getOutputStream(), true);
                printWriter.write("H");
                LockSupport.parkNanos(int_sleep);
                printWriter.write("e");
                LockSupport.parkNanos(int_sleep);
                printWriter.write("l");
                LockSupport.parkNanos(int_sleep);
                printWriter.write("l");
                LockSupport.parkNanos(int_sleep);
                printWriter.write("o");
                LockSupport.parkNanos(int_sleep);


                printWriter.flush();
                bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("from server" + bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    client.close();
                } catch (IOException e) {

                }
            }
        }
    }

    public static void main(String[] args) {
        EchoClient c = new EchoClient();
        for(int i =0; i<1; i++) {
            ex.execute(c);
        }
    }
}
