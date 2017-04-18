package com.oneler.random;

/**
 * Created by opure on 2017/4/12.
 */
public class RandomTest {
    public static void main(String[] args) {
        for(int i =0;i<100;i++) {
            final double d = Math.random();
            System.out.println("dd"+d);
            System.out.println((int)(d*2));
        }
    }
}
