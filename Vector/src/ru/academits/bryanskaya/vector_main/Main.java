package ru.academits.bryanskaya.vector_main;

import ru.academits.bryanskaya.vector.Vector;

public class Main {
    public static void main(String[] args) {
        // Заполнение вектора значениями из массива
        Vector vector1 = new Vector(new double[]{1, 2, 3});
        System.out.println("Компоненты вектора: " + vector1);

        // Получение размерности вектора
        Vector vector2 = new Vector(4);
        System.out.println("Размерность нулевого вектора: " + vector2);

        // Копирование вектора
        Vector vector3 = new Vector(vector1);
        System.out.println("Копия вектора: " + vector3);

        // Если длина массива < n, заполнение остальных компонент нулями
        Vector vector4 = new Vector(6, new double[]{1, 2, 3});
        System.out.println("Компоненты вектора: " + vector4);

        // Возвращение размерности вектора
        System.out.println("Размерность вектора: " + vector4.getSize());

        // hashCode
        System.out.println("HashCode: " + vector4.hashCode());

        // equals
        System.out.println("Результат сравнения двух векторов: " + vector1.equals(vector4));
        System.out.println("Результат сравнения двух векторов: " + vector1.equals(vector3));

        // Получение компонента вектора по индексу
        System.out.println("Компонент вектора по указанному индексу: " + vector1.getComponent(1));

        // Изменение компонента вектора по индексу
        vector1.setComponent(2, 4.4);
        System.out.println("Компоненты вектора: " + vector1);

        // Разворот вектора в обратную сторону
        vector1.turn();
        System.out.println("Компоненты вектора: " + vector1);

        // Получение длины вектора
        System.out.println("Длина вектора: " + vector3.getLength());

        // Прибавление к вектору другого вектора
        vector3.add(new Vector(new double[]{1, 2, 3}));
        System.out.println("Результат сложения вектора с другим вектором: " + vector3);

        // Вычитание из вектора другого вектора
        vector3.subtract(new Vector(new double[]{2, 2}));
        System.out.println("Результат вычитания из вектора другого вектора: " + vector3);

        // Умножение вектора на скаляр
        Vector vector5 = new Vector(new double[]{1, 2, 3});
        vector5.multiplyByScalar(4);

        System.out.println("Вектор умноженный на скаляр: " + vector5);

        // Сложение двух векторов
        Vector v1 = new Vector(new double[]{1, 2, 3});
        Vector v2 = new Vector(new double[]{2, 3, 4, 5});

        Vector sum = Vector.getSum(v1, v2);
        System.out.println("Сумма двух векторов: " + sum);

        // Вычитание двух векторов
        Vector diff = Vector.getDifference(v2, v1);
        System.out.println("Разность двух векторов: " + diff);

        // Скалярное произведение двух векторов
        double scalarProduct = Vector.getScalarProduct(v1, v2);
        System.out.println("Скалярное произведение двух векторов: " + scalarProduct);
    }
}
