package com.oneler.lambda;

/**
 * Created by opure on 2017/5/24.
 */

public class zzz {

    public interface Adder {
        int add(int a, int b);
    }

    public  class  dd implements Adder {
        @Override
        public int add(int a, int b) {
            return a * b;
        }

    }

    public  void  test () {
        Adder a = new dd();
        int add = a.add(5, 6);
        System.out.println(add);

        Adder b = (a1, b1) -> {
            System.out.println(a1 * b1);
            return 0;
        };
    }

    public static void main(String[] args) {
        Adder b = (a1, b1) -> {
            System.out.println(a1 * b1);
            System.out.println("fsadfsf");
            return 0;
        };
        b.add(5,8);
        Adder bd = new Adder() {
            @Override
            public int add(int a, int b) {
                System.out.println("fasfdsa");
                return 0;
            }
        };

        bd.add(3,435);
    }
}

