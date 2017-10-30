package com.oneler.domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hanoi {
    static int a =0;
    public static void main(String args[]) throws Exception {

        int n;
        BufferedReader buf =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入盘数：");
        n = Integer.parseInt(buf.readLine());
        Hanoi hanoi = new Hanoi();
        int x =hanoi.move(n, 'A', 'B', 'C');
        System.out.println(x+"步数");
    }

    public  int move(int n, char a, char b, char c) {
        a++;
        if (n == 1) {
            System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);
        } else {
            move(n - 1, a, c, b);
            System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);
            move(n - 1, b, a, c);
        }
        return a;
    }
}