package ru.academits.bryanskaya.shapes;

import java.util.Comparator;

public class PerimeterShapeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return (int) (o1.getPerimeter() - o2.getPerimeter());
    }
}
