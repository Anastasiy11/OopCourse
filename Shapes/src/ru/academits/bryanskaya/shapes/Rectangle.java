package ru.academits.bryanskaya.shapes;

import java.util.Objects;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getSide1() {
        return width;
    }

    public double getSide2() {
        return height;
    }

    public void setSide1(double width) {
        this.width = width;
    }

    public void setSide2(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle " + "Width: " + width + " Height: " + height + " Area: " + getArea() + " Perimeter: " + getPerimeter();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Rectangle r = (Rectangle) o;

        return width == r.width && height == r.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }
}
