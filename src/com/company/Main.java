package com.company;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(3, 7);

        for (int i = 0; i < list.size; i++) {
            System.out.println(list.get(i));
        }

        int indexOfOne = list.indexOf(1);
        System.out.println("Number one is found for the first time at position " + indexOfOne);

        int lastIndexOfOne = list.lastIndexOf(1);
        System.out.println("Number one is found for the last time at position " + lastIndexOfOne);

        list.remove(1);
        for (int i = 0; i < list.size; i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Is the value of four present in the list: " + list.isPresent(4));
        System.out.println("Is the value of fourteen present in the list: " + list.isPresent(14));

        list.removeAll();
        for (int i = 0; i < list.size; i++) {
            System.out.println(list.get(i));
        }
    }
}
