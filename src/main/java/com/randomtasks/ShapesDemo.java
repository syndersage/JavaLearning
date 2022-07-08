package com.randomtasks;


public class ShapesDemo {
    public static void main(String[] args) {
        var rectangle = new Rectangle(5, "Square1");
        var triangle = new Triangle(3, 4, "Triangle1", "Pifagor");
        var circle = new Circle(5);
        var circle2 = new Circle(circle);
        var halfCircle1 = (HalfCircle) new HalfCircle(10);
        System.out.println(halfCircle1.area());
//        System.out.println(circle.hashCode());
//        System.out.println(circle2.hashCode());
//        var obj = (Circle) circle.makeObj(true);
//        System.out.println(obj.area());
//        System.out.println(obj.getClass());
//        System.out.println(obj.getRadius());
//        var obj2 = new Circle(obj);
    }

    private static void finalParams(final int a) {
    }
}

abstract class TwoDimShape {
    public double width;
    private final double height;
    private final String name;

    TwoDimShape(double width, double height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    TwoDimShape(double width, double height) {
        this.width = width;
        this.height = height;
        this.name = "None";
    }

    TwoDimShape(TwoDimShape shape) {
        this.name = shape.name;
        this.height = shape.height;
        this.width = shape.width;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    abstract public double area();
}

class Triangle extends TwoDimShape {
    private final String style;

    Triangle(int width, int height, String name, String style) {
        super(width, height, name);
        this.style = style;
    }

    Triangle(int width, int height, String style) {
        super(width, height);
        this.style = style;
    }

    Triangle(int side, String name, String style) {
        this(side, side, name, style);
    }

    Triangle(int side, String style) {
        this(side, side, style);
    }

    public double area() {
        return getHeight() * getWidth() / 2;
    }

    public String getStyle() {
        return style;
    }
}

class Rectangle extends TwoDimShape {

    Rectangle(int width, int height, String name) {
        super(width, height, name);
    }

    Rectangle(int width, int height) {
        super(width, height);
    }

    Rectangle(int side, String name) {
        this(side, side, name);
    }

    Rectangle(int side) {
        this(side, side);
    }

    public double area() {
        return getHeight() * getWidth();
    }
}

class Circle extends TwoDimShape {
    private final double radius;

    Circle(double radius, String name) {
        super(radius, radius, name);
        this.radius = radius;
    }

    Circle(double radius) {
        super(radius, radius);
        this.radius = radius;
    }

    Circle(Circle circle) {
        super(circle);
        this.radius = circle.radius;
    }

    TwoDimShape makeObj(boolean which) {
        return which ? new Circle(10) : new Triangle(1, 5, "TOP");
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }
}

class HalfCircle extends Circle {
    HalfCircle(double radius) {
        super(radius);
    }

    public double area() {
        return super.area() / 2;
    }
}
