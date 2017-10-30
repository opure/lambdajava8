package com.oneler.LabelFor;

public class BreakTest {
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            if(i ==5) {
                System.out.println(i);
                break;
            }
            System.out.println(i);

        }
    }
}
