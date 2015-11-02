package com.geekhub.hw4;

public class Car implements Comparable<Car>{

    private String model;

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return model;
    }

    @Override
    public int compareTo(Car anotherCar) {
        return model.compareTo(anotherCar.getModel());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return model.equals(car.model);

    }

    @Override
    public int hashCode() {
        return model.hashCode();
    }
}
