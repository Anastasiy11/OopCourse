package ru.academits.bryanskaya;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void removeEvenNumbers(ArrayList<Integer> numbers) {
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }
    }

    public static ArrayList<Integer> getListWithoutDuplicates(ArrayList<Integer> numbers) {
        ArrayList<Integer> numbersWithoutDuplicates = new ArrayList<>(numbers.size());

        for (Integer number : numbers) {
            if (!numbersWithoutDuplicates.contains(number)) {
                numbersWithoutDuplicates.add(number);
            }
        }

        return numbersWithoutDuplicates;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Lines"))) {
            System.out.println("Строки из файла: ");

            String line;
            ArrayList<String> lines = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                System.out.println(line + " ");
                lines.add(line);
            }

            System.out.println("Список строк из файла: " + lines);
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(9);
        numbers.add(7);
        numbers.add(10);

        System.out.println("Список целых чисел: " + numbers);

        removeEvenNumbers(numbers);
        System.out.println("Список нечетных целых чисел: " + numbers);

        ArrayList<Integer> numbers2 = new ArrayList<>();

        numbers2.add(2);
        numbers2.add(3);
        numbers2.add(2);
        numbers2.add(4);
        numbers2.add(5);
        numbers2.add(3);
        numbers2.add(6);
        numbers2.add(5);

        System.out.println("Список целых чисел: " + numbers2);

        ArrayList<Integer> numbersWithoutDuplicates = getListWithoutDuplicates(numbers2);

        System.out.println("Список целых чисел, без повторений: " + numbersWithoutDuplicates);
    }
}
