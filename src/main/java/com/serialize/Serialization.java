package com.serialize;

import java.io.*;

public class Serialization implements Serializable {
    int a;
    int b;

    public Serialization(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a + " " + b;
    }

    public static void main(String[] args) {
        try(ObjectOutputStream ser = new ObjectOutputStream(new FileOutputStream("data"));
                ObjectInputStream des = new ObjectInputStream(new FileInputStream("data"))) {
            ser.writeObject(new Serialization(1, 5));
            System.out.println(des.readObject().toString());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Exception: " + e);
        }
    }
}
