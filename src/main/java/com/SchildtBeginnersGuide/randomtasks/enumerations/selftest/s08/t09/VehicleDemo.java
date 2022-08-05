package com.SchildtBeginnersGuide.randomtasks.enumerations.selftest.s08.t09;

interface VehicleInterface {
    default int currentRange() {
        return getMetersPerLitter() * getCurrentFuel();
    }
    default int maxRange() {
        return getMetersPerLitter() * getTankCapacity();
    }
    default double fuelNeeded(int range) {
        return (double) range / getMetersPerLitter();
    }
    int getPassengers();
    int getCurrentFuel();
    int getMetersPerLitter();
    int getTankCapacity();
}

class Truck implements VehicleInterface {
    private final int passengers;
    private final int mpl;
    private int currentFuel;
    private final int tankCapacity;

    Truck(int passengers, int mpl, int tankCapacity, int currentFuel) {
        this.mpl = mpl;
        this.passengers = passengers;
        this.currentFuel = currentFuel;
        this.tankCapacity = tankCapacity;
    }

    Truck(int passengers, int mpl, int tankCapacity) {
        this(passengers, mpl, tankCapacity, 0);
    }

    @Override
    public int getCurrentFuel() {
        return currentFuel;
    }

    @Override
    public int getMetersPerLitter() {
        return mpl;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }

    @Override
    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setCurrentFuel(int fuel) {
        if (currentFuel + fuel > tankCapacity) System.out.println("Not enough tank capacity!");
        else if (currentFuel + fuel < 0) System.out.println("Too big fuel change!");
        else {
            currentFuel += fuel;
        }
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Truck truck = new Truck(5, 10, 60);
        truck.setCurrentFuel(31);
        System.out.println(truck.currentRange());
        System.out.println(truck.fuelNeeded(155));
        System.out.println(truck.maxRange());
    }
}
