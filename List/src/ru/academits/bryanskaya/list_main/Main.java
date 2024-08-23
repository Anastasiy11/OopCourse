package ru.academits.bryanskaya.list_main;

import ru.academits.bryanskaya.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addToTail(4);
        list.addToTail(5);
        list.addToTail(6);
        list.addToTail(14);
        list.addToTail(9);

        System.out.println("Односвязный список чисел:");
        list.print();

        list.add(3, 15);
        list.add(0, 7);
        list.add(1, 8);

        list.addFirstItem(24);

        System.out.println("Измененный односвязный список чисел:");
        list.print();

        System.out.println("Удаленный первый элемент списка: " + list.getRemovedFirstItem());

        System.out.println("Удаленный элемент списка по индексу: " + list.getRemovedItem(4));

        System.out.println("Удаление элемента списка по значению: " + list.removeItem(9));

        System.out.println("Первый элемент списка: " + list.getFirstListItem());

        System.out.println("Длина списка: " + list.getSize());

        System.out.println("Значение элемента по индексу: " + list.getItem(4));

        System.out.println("Предыдущее значение измененного элемента: " + list.setItem(2, 6));

        list.reverse();
        System.out.println("Развернутый список:");
        list.print();

        SinglyLinkedList<Integer> newList2 = list.copy();

        System.out.println("Копия списка:");
        newList2.print();
    }
}
