package ru.academits.bryanskaya.range_main;

import ru.academits.bryanskaya.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальное число диапазона:");
        double from1 = scanner.nextDouble();

        System.out.println("Введите конечное число диапазона:");
        double to1 = scanner.nextDouble();

        System.out.println("Введите число для проверки:");
        double numberToCheck = scanner.nextDouble();

        Range range1 = new Range(from1, to1);

        if (range1.isInside(numberToCheck)) {
            System.out.println("Число в пределах диапазона.");
        } else {
            System.out.println("Число за пределами диапазона.");
        }

        System.out.println("Длина диапазона от " + from1 + " до " + to1 + " = " + range1.getLength());

        range1.setFrom(4);
        range1.setTo(12);

        double newFrom = range1.getFrom();
        double newTo = range1.getTo();

        System.out.println("Длина диапазона от " + newFrom + " до " + newTo + " = " + range1.getLength());

        System.out.println("Введите начальное число второго диапазона:");
        double from2 = scanner.nextDouble();

        System.out.println("Введите конечное число второго диапазона:");
        double to2 = scanner.nextDouble();

        Range range2 = new Range(from2, to2);

        Range intersection = range1.getIntersection(range2);
        System.out.println("Пересечение двух диапазонов: " + intersection);

        Range[] union = range1.getUnion(range2);
        System.out.println("Объединение двух диапазонов: " + Arrays.toString(union));

        Range[] difference = range1.getDifference(range2);
        System.out.println("Разность двух диапазонов: " + Arrays.toString(difference));
    }
}
