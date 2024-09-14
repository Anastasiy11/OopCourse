package ru.academits.bryanskaya.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    // Получение размерности вектора
    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора = " + dimension + ". Размерность вектора должна быть положительным числом.");
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
            throw new IllegalArgumentException("Размерность вектора: " + components.length + ". Размерность вектора должна быть положительным числом.");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    // Заполнение вектора значениями из массива. Если длина массива < n, заполнение остальных компонент нулями
    public Vector(int dimension, double[] components) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора: " + dimension + ". Размерность вектора должна быть положительным числом.");
        }

        this.components = Arrays.copyOf(components, dimension);
    }

    // Возвращение размерности массива
    public int getSize() {
        return components.length;
    }

    // Преобразование значений массива в строку
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        stringBuilder.append(components[0]);

        for (int i = 1; i < components.length; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(components[i]);
        }

        stringBuilder.append('}');

        return stringBuilder.toString();
    }

    // Прибавление к вектору второго вектора
    public void add(Vector vector) {
        if (components.length < vector.getSize()) {
            components = Arrays.copyOf(components, vector.getSize());
        }

        for (int i = 0; i < vector.getSize(); i++) {
            components[i] += vector.components[i];
        }
    }

    // Вычитание из вектора другого вектора
    public void subtract(Vector vector) {
        if (components.length < vector.getSize()) {
            components = Arrays.copyOf(components, vector.getSize());
        }

        for (int i = 0; i < vector.getSize(); i++) {
            components[i] -= vector.components[i];
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
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Индекс: " + index + " выходит за границы вектора. Допустимые границы: от 0 до " + (components.length - 1));
        }

        return components[index];
    }

    // Изменение компонента вектора по индексу
    public void setComponent(int index, double newValue) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Индекс: " + index + " выходит за границы вектора. Допустимые границы: от 0 до " + (components.length - 1));
        }

        components[index] = newValue;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
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
        Vector vectorsSum = new Vector(vector1);
        vectorsSum.add(vector2);

        return vectorsSum;
    }

    // Вычитание двух векторов
    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vectorsDifference = new Vector(vector1);
        vectorsDifference.subtract(vector2);

        return vectorsDifference;
    }

    // Скалярное произведение двух векторов
    public static double getScalarProduct(Vector vector1, Vector vector2) {
        int minSize = Math.min(vector1.getSize(), vector2.getSize());
        double scalarProduct = 0;

        for (int i = 0; i < minSize; i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}
