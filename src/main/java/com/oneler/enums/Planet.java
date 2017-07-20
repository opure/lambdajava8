package com.oneler.enums;

/**
 * Created by opure on 2017/4/30.
 */
public enum  Planet {
    ORANGE(-1),APPLE(-2);
    private int code;
    private Planet ( int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }




    public static void main(String[] args) {
        System.out.println(Planet.APPLE.getCode());
        for (int i = 0; i <Planet.values().length ; i++) {
            System.out.printf("%s%n",123);
        }
    }

}
