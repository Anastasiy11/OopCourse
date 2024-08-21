package ru.academits.bryanskaya.shapes_main;

import ru.academits.bryanskaya.shapes_comparators.ShapeAreaComparator;
import ru.academits.bryanskaya.shapes_comparators.ShapePerimeterComparator;
import ru.academits.bryanskaya.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shape getMaxAreaShape(Shape[] shapes) {
        Arrays.sort(shapes, new ShapeAreaComparator());

        return shapes[shapes.length - 1];
    }

    public static Shape getSecondPerimeterShape(Shape[] shapes) {
        Arrays.sort(shapes, new ShapePerimeterComparator());

        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(3),
                new Rectangle(4, 7),
                new Triangle(3, 3, 7, 5, 4, 9),
                new Square(8),
                new Rectangle(8, 4),
                new Square(6),
                new Triangle(2, 1, 7, 3, 5, 5),
                new Circle(12),
                new Circle(4),
                new Square(4),
                new Rectangle(5, 12)
        };

        Shape maxAreaShape = getMaxAreaShape(shapes);
        Shape secondPerimeterShape = getSecondPerimeterShape(shapes);

        System.out.println("Фигура с максимальной площадью, среди массива фигур: " + maxAreaShape);
        System.out.println("Фигура со вторым по величине периметром, среди массива фигур: " + secondPerimeterShape);

        System.out.println(new Triangle(2, 3, 1, 5, 5, 4).hashCode());
    }
}
