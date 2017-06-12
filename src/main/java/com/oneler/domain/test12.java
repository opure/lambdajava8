package com.oneler.domain;

import java.util.Optional;

/**
 * Created by opure on 2017/5/27.
 */
class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}

class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }
}

class Insurance {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class test12 {

    public String getCarInsuranceName(Optional<Person> p) {
        return p.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("UNKONW");
    }

    public static void main(String[] args) {
        Optional<Person> p = Optional.ofNullable(new Person());
         System.out.println(new test12().getCarInsuranceName(p));
    }

}
