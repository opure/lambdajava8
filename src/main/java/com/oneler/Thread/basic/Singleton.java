package com.oneler.Thread.basic;

public enum Singleton {
    INSTANCE {
        @Override
        protected void read() {

        }

        @Override
        protected void write() {

        }
    };
    protected abstract void read();
    protected abstract void write();
}