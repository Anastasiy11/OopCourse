package ru.academits.bryanskaya.arrayListHome;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void removeEvenNumbers(ArrayList<Integer> numbers) {
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }
    }

    public static ArrayList<?> getListWithoutDuplicates(ArrayList<?> items) {
        ArrayList<Object> itemsWithoutDuplicates = new ArrayList<>(items.size());

        for (Object item : items) {
            if (!itemsWithoutDuplicates.contains(item)) {
                itemsWithoutDuplicates.add(item);
            }
        }

        return itemsWithoutDuplicates;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Lines"))) {
            System.out.println("Строки из файла:");

            String line;
            ArrayList<String> lines = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                System.out.println(line + " ");
                lines.add(line);
            }

            System.out.println("Список строк из файла:" + lines);
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом:" + e.getMessage());
        }

        Integer[] numbersArray = new Integer[]{1, 2, 4, 5, 6, 9, 7, 10};
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(numbersArray));

        System.out.println("Список целых чисел:" + numbers);

        removeEvenNumbers(numbers);
        System.out.println("Список нечетных целых чисел:" + numbers);

        Integer[] numbersArray2 = new Integer[]{2, 3, 2, 4, 5, 3, 6, 5};
        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(numbersArray2));

        System.out.println("Список целых чисел:" + numbers2);

        ArrayList<?> numbersWithoutDuplicates = getListWithoutDuplicates(numbers2);
        System.out.println("Список целых чисел, без повторений:" + numbersWithoutDuplicates);
    }
}
