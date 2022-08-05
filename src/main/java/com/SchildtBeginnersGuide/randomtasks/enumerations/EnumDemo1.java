package com.SchildtBeginnersGuide.randomtasks.enumerations;

public class EnumDemo1 {
    public enum Transport {
        CAR(10), TRUCK(10), AIRPLANE(10), BOAT(10), TRAIN(10);
        int speed;
        Transport(int speed) {
            this.speed = speed;
        }
    }
    public static void main(String[] args) {
        try {
            System.out.println(Transport.valueOf("CAR1"));
        }
        catch (IllegalArgumentException e) {
            System.out.println("Illegal argument in enum list");
        }
        Transport tp1 = Transport.CAR;
        Transport tp2 = Transport.CAR;
        tp2.speed = 20;
        System.out.println(tp1.speed);
        System.out.println(Transport.BOAT.ordinal());
    }
}
