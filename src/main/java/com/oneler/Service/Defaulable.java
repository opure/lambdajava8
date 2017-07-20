package com.oneler.Service;

interface Defaulable {
    default String notRequired() {
        return "Default implementation";
    }
}

class MyClass implements  Defaulable {
    @Override
    public String notRequired() {
        return null;
    }
}
class MyClassi implements Defaulable {

}
