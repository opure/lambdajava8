package com.oneler.Service;

import java.util.function.Supplier;

interface DefaulableFactory {
    static Defaulable create(Supplier<Defaulable> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(MyClass::new);
        System.out.println(defaulable.notRequired());
        Defaulable defaulable1 = DefaulableFactory.create(MyClassi::new);
        System.out.println(defaulable1.notRequired());
    }
}