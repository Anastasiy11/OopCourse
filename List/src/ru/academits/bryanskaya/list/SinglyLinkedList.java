package ru.academits.bryanskaya.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            size++;
        }

        return size;
    }

    public T getFirstListItem() {
        return head.getData();
    }

    public T getItem(int index) {
        int count = 0;

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            if (count == index) {
                return item.getData();
            }

            count++;
        }

        throw new IndexOutOfBoundsException("Индекс выходит за пределы списка.");
    }

    public T setItem(int index, T newData) {
        int count = 0;

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            if (count == index) {
                T oldData = item.getData();
                item.setData(newData);

                return oldData;
            }

            count++;
        }

        throw new IndexOutOfBoundsException("Индекс выходит за пределы списка.");
    }

    public T getRemovedItem(int index) {
        if (index == 0) {
            head = head.getNext();
        }

        int count = 0;
        ListItem<T> previousItem = null;

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            if (count == index) {
                T oldData = item.getData();

                if (previousItem == null) {
                    head = item.getNext();
                } else {
                    if (item.getNext() == null) {
                        previousItem.setNext(null);
                    } else {
                        previousItem.setNext(item.getNext());
                    }
                }

                return oldData;
            }

            count++;
            previousItem = item;
        }

        throw new IndexOutOfBoundsException("Индекс выходит за пределы списка.");
    }

    public void addFirstItem(T data) {
        ListItem<T> newItem = new ListItem<>(data);

        newItem.setNext(head);
        head = newItem;
    }

    public void add(int index, T data) {
        if (index == 0) {
            addFirstItem(data);
        }

        int count = 0;
        ListItem<T> previousItem = null;

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            if (count == index) {
                ListItem<T> newItem = new ListItem<>(data);

                if (previousItem != null) {
                    previousItem.setNext(newItem);
                    newItem.setNext(item);
                }
            }

            previousItem = item;
            count++;
        }
    }

    public boolean removeItem(T data) {
        ListItem<T> previousItem = null;

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            if (item.getData() == data) {
                if (previousItem == null) {
                    head = item.getNext();
                } else {
                    if (item.getNext() == null) {
                        previousItem.setNext(null);
                    } else {
                        previousItem.setNext(item.getNext());
                    }
                }

                return true;
            }

            previousItem = item;
        }

        return false;
    }

    public T getRemovedFirstItem() {
        ListItem<T> oldHead = head;

        if (head.getNext() == null) {
            return head.getData();
        }

        head = head.getNext();

        return oldHead.getData();
    }

    public void reverse() {
        ListItem<T> previousItem = null;
        ListItem<T> currentItem = head;
        ListItem<T> nextItem;

        while (currentItem != null) {
            nextItem = currentItem.getNext();
            currentItem.setNext(previousItem);

            previousItem = currentItem;
            currentItem = nextItem;
        }

        head = previousItem;
    }

    public void addToTail(T data) {
        ListItem<T> newListItem = new ListItem<>(data);

        if (head == null) {
            head = newListItem;
        }

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            if (item.getNext() == null) {
                item.setNext(newListItem);
                newListItem.setNext(null);
            }
        }
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            newList.addToTail(item.getData());
        }

        return newList;
    }

    public void print() {
        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            System.out.print(item.getData() + " ");
        }

        System.out.println();
    }
}
