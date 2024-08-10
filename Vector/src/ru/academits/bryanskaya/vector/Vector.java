package ru.academits.bryanskaya.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    // Получение размерности вектора
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительным числом.");
        }

        components = new double[n];
    }

    // Копирование вектора
    public Vector(Vector vector) {
        this.components = new double[vector.components.length];

        for (int i = 0; i < vector.components.length; i++) {
            this.components[i] = vector.components[i];
        }
    }

    // Заполнение вектора значениями из массива
    public Vector(double[] components) {
        this.components = new double[components.length];

        for (int i = 0; i < components.length; i++) {
            this.components[i] = components[i];
        }
    }

    // Заполнение вектора значениями из массива. Если длина массива < n, заполнение остальных компонент нулями
    public Vector(int n, double[] values) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительным числом.");
        }

        components = new double[n];

        for (int i = 0; i < n; i++) {
            if (i < values.length) {
                components[i] = values[i];
            } else {
                components[i] = 0;
            }
        }
    }

    // Возвращение размерности массива
    public int getSize() {
        return components.length;
    }

    // Преобразование значений массива в строку
    @Override
    public String toString() {
        return Arrays.toString(components);
    }

    public double getOrZero(int i) {
        if (i < components.length) {
            return components[i];
        }

        return 0;
    }

    // Прибавление к вектору второго вектора
    public void add(Vector vector2) {
        int maxSize = Math.max(getSize(), vector2.getSize());
        double[] result = new double[maxSize];

        for (int i = 0; i < maxSize; i++) {
            result[i] = this.getOrZero(i) + vector2.getOrZero(i);
        }

        components = result;
    }

    // Вычитание из вектора другого вектора
    public void subtract(Vector vector2) {
        int maxSize = Math.max(getSize(), vector2.getSize());
        double[] result = new double[maxSize];

        for (int i = 0; i < maxSize; i++) {
            result[i] = this.getOrZero(i) - vector2.getOrZero(i);
        }

        components = result;
    }

    // Умножение вектора на скаляр
    public void multiplyByScalar(double scalar) {
        double[] newComponents = new double[components.length];
        for (int i = 0; i < components.length; i++) {
            newComponents[i] = components[i] * scalar;
        }

        components = newComponents;
    }

    // Разворот вектора в обратную сторону
    public void turn() {
        double[] newComponents = new double[components.length];
        for (int i = 0; i < components.length; i++) {
            newComponents[i] = components[i] * (-1);
        }

        components = newComponents;
    }

    // Получение длины вектора
    public double getLength() {
        double sum = 0;

        for (double component : components) {
            sum += component * component;
        }

        return Math.sqrt(sum);
    }

    // Получение компонента вектора по индексу
    public double getComponent(int index) {
        return components[index];
    }

    // Изменение компонента вектора по индексу
    public void setComponent(int index, double newValue) {
        for (int i = 0; i < components.length; i++) {
            components[index] = newValue;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 43;
        int hash;

        hash = prime * Arrays.hashCode(components);

        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Vector v = (Vector) o;

        for (int i = 0; i < components.length; ++i) {
            if (v.getSize() == getSize()) {
                return components[i] == v.components[i];
            }
        }

        return false;
    }

    // Сложение двух векторов
    public static Vector getSum(Vector vector1, Vector vector2) {
        int size = Math.max(vector1.getSize(), vector2.getSize());
        double[] newComponents = new double[size];

        for (int i = 0; i < size; i++) {
            newComponents[i] = vector1.getOrZero(i) + vector2.getOrZero(i);
        }

        return new Vector(newComponents);
    }

    // Вычитание двух векторов
    public static Vector getDifference(Vector vector1, Vector vector2) {
        int size = Math.max(vector1.getSize(), vector2.getSize());
        double[] newComponents = new double[size];

        for (int i = 0; i < size; i++) {
            newComponents[i] = vector1.getOrZero(i) - vector2.getOrZero(i);
        }

        return new Vector(newComponents);
    }

    // Скалярное произведение двух векторов
    public static double getScalarProduct(Vector vector1, Vector vector2) {
        int size = Math.max(vector1.getSize(), vector2.getSize());
        double scalarProduct = 0;

        for (int i = 0; i < size; i++) {
            scalarProduct += vector1.getOrZero(i) * vector2.getOrZero(i);
        }

        return scalarProduct;
    }
}
