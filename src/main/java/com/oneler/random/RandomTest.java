package com.oneler.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by opure on 2017/4/12.
 */
public class RandomTest {
    public static void main(String[] args) {
        System.out.println( ThreadLocalRandom.current().nextInt(10));

        Random  r = new Random();
        r.nextInt();
        r.nextInt();
        System.out.println(r.nextInt());
        System.out.println(r.nextInt());
        System.out.println(Math.random());
        System.out.println(Math.random());
    }
}
