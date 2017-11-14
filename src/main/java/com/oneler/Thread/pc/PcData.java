package com.oneler.Thread.pc;

public final class PcData {
    private final int intData;

    public PcData(int d) {
        intData = d;
    }
    public PcData(String d){
        intData = Integer.valueOf(d);
    }

    public int getData(){
        return intData;
    }
}
