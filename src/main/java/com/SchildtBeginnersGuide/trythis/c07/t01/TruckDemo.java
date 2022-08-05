package com.SchildtBeginnersGuide.trythis.c07.t01;

class Vehicle {
    private int passengers;
    private int fuelCap;
    private int mpg;

    Vehicle(int passengers, int fuelCap, int mpg) {
        this.passengers = passengers;
        this.fuelCap = fuelCap;
        this.mpg = mpg;
    }

    int range() {
        return fuelCap * mpg;
    }

    double fuelNeeded(int kilometers) {
        return (double) kilometers / mpg;
    }

    int getPassengers() {
        return passengers;
    }

    int getFuelCap() {
        return fuelCap;
    }

    int getMpg() {
        return mpg;
    }
}

class Truck extends Vehicle {
    private int cargoCap;
    Truck(int cargoCap, int passengers, int fuelCap, int mpg) {
        super(passengers, fuelCap, mpg);
        this.cargoCap = cargoCap;
    }

    public int getCargoCap() {
        return cargoCap;
    }

    public void setCargoCap(int cargoCap) {
        this.cargoCap = cargoCap;
    }
}

public class TruckDemo {
    public static void main(String[] args) {
        Truck truck1 = new Truck(1000, 3, 60, 10);
        System.out.println(truck1.range());
        System.out.println(truck1.fuelNeeded(536));
    }
}
