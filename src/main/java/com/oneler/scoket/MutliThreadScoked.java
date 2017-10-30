package com.oneler.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MutliThreadScoked {

    private static ExecutorService ex = Executors.newCachedThreadPool();

    static class HandleMsg implements Runnable {
        Socket socket;

        public HandleMsg(Socket socket) {
            this.socket = socket;
        }


        @Override
        public void run() {
            BufferedReader is = null;
            PrintWriter os = null;

            try {
                long start = System.currentTimeMillis();
                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                os = new PrintWriter(socket.getOutputStream(), true);
                String inputLine = null;
                while ((inputLine = is.readLine()) != null) {
                    os.write(inputLine);
                }
                long end = System.currentTimeMillis();

                System.out.println("spend" + (end - start) + "ms");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(8000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            Socket accept = serverSocket.accept();
            System.out.println(accept.getRemoteSocketAddress() + "connected");
            ex.execute(new HandleMsg(accept));
        }

    }
}
