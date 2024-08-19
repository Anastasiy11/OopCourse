package ru.academits.bryanskaya.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    // Получение размерности вектора
    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора = " + dimension + ". " + "Размерность вектора должна быть положительным числом.");
        }

        components = new double[dimension];
    }

    // Копирование вектора
    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    // Заполнение вектора значениями из массива
    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("Размерность вектора: " + components.length + ". " + "Размерность вектора должна быть положительным числом.");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    // Заполнение вектора значениями из массива. Если длина массива < n, заполнение остальных компонент нулями
    public Vector(int dimension, double[] components) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора: " + dimension + ". " + "Размерность вектора должна быть положительным числом.");
        }

        this.components = new double[dimension];

        for (int i = 0; i < dimension; i++) {
            if (i < components.length) {
                this.components[i] = components[i];
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
        return Arrays.toString(components)
                .replace("[", "{")
                .replace("]", "}");
    }

    // Прибавление к вектору второго вектора
    public void add(Vector vector2) {
        if (getSize() != vector2.getSize()) {
            int maxSize = Math.max(getSize(), vector2.getSize());
            double[] result = new double[maxSize];

            for (int i = 0; i < maxSize; i++) {
                result[i] = getComponent(i) + vector2.getComponent(i);
            }

            components = result;
        } else {
            for (int i = 0; i < getSize(); i++) {
                components[i] += vector2.components[i];
            }
        }
    }

    // Вычитание из вектора другого вектора
    public void subtract(Vector vector2) {
        if (getSize() != vector2.getSize()) {
            int maxSize = Math.max(getSize(), vector2.getSize());
            double[] result = new double[maxSize];

            for (int i = 0; i < maxSize; i++) {
                result[i] = getComponent(i) - vector2.getComponent(i);
            }

            components = result;
        } else {
            for (int i = 0; i < getSize(); i++) {
                components[i] -= vector2.components[i];
            }
        }
    }

    // Умножение вектора на скаляр
    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    // Разворот вектора в обратную сторону
    public void turn() {
        multiplyByScalar(-1);
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
        if (index >= components.length) {
            return 0;
        }

        return components[index];
    }

    // Изменение компонента вектора по индексу
    public void setComponent(int index, double newValue) {
        components[index] = newValue;
    }

    @Override
    public int hashCode() {
        return 43 * Arrays.hashCode(components);
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

        return Arrays.equals(components, v.components);
    }

    // Сложение двух векторов
    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vectorSum = new Vector(vector1);
        vectorSum.add(vector2);

        return vectorSum;
    }

    // Вычитание двух векторов
    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vectorDifference = new Vector(vector1);
        vectorDifference.subtract(vector2);

        return vectorDifference;
    }

    // Скалярное произведение двух векторов
    public static double getScalarProduct(Vector vector1, Vector vector2) {
        int size = Math.min(vector1.getSize(), vector2.getSize());
        double scalarProduct = 0;

        for (int i = 0; i < size; i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}
