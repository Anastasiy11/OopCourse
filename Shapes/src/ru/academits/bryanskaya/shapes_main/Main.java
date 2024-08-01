package ru.academits.bryanskaya.shapes_main;

import ru.academits.bryanskaya.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shape getMaxAreaShape(Shape[] shapes, AreaShapeComparator comparator) {
        Arrays.sort(shapes, comparator);

        return shapes[shapes.length - 1];
    }

    public static Shape getMaxPerimeterShape(Shape[] shapes, PerimeterShapeComparator comparator) {
        Arrays.sort(shapes, comparator);

        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = {new Circle(3), new Rectangle(4, 7), new Triangle(3, 3, 7, 5, 4, 9),
                new Square(8), new Rectangle(8, 4), new Square(6), new Triangle(2, 1, 7, 3, 5, 5),
                new Circle(12), new Circle(4), new Square(4), new Rectangle(5, 12)
        };

        Shape maxAreaShape = getMaxAreaShape(shapes, new AreaShapeComparator());
        Shape secondBySizePerimeterShape = getMaxPerimeterShape(shapes, new PerimeterShapeComparator());

        System.out.println("Фигура с максимальной площадью, среди массива фигур: " + maxAreaShape);
        System.out.println("Фигура со вторым по величине периметром, среди массива фигур: " + secondBySizePerimeterShape);
    }
}
