package ru.academits.bryanskaya.range.main;

import ru.academits.bryanskaya.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальное число диапазона:");
        double from = scanner.nextDouble();

        System.out.println("Введите конечное число диапазона:");
        double to = scanner.nextDouble();

        System.out.println("Введите число для проверки:");
        double numberToCheck = scanner.nextDouble();

        Range range = new Range(from, to);

        if(range.isInside(numberToCheck)){
            System.out.println("Число в пределах диапазона.");
        }else {
            System.out.println("Число за пределами диапазона.");
        }

        System.out.println("Длина диапазона от " + from + " до " + to + " = " + range.getLength(from, to));

        range.setFrom(4);
        range.setTo(12);

        double newFrom = range.getFrom();
        double newTo = range.getTo();

        System.out.println("Длина диапазона от " + newFrom + " до " + newTo + " = " + range.getLength(newFrom, newTo));
    }
}
