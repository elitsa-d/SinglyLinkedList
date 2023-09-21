package com.company;

import java.sql.SQLOutput;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(12);
        list.add(3, 7);

        System.out.println(list.isPresent(12));
        list.print();

        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        int indexOfOne = list.indexOf(1);
        System.out.println("Number one is found for the first time at position " + indexOfOne);

        int lastIndexOfOne = list.lastIndexOf(1);
        System.out.println("Number one is found for the last time at position " + lastIndexOfOne);

        list.removeDuplicates();
        list.print();

        list.remove(1);
        list.set(2, 50);
        list.print();

        System.out.println("Is the value of four present in the list: " + list.isPresent(4));
        System.out.println("Is the value of fourteen present in the list: " + list.isPresent(14));

        list.removeAll();
        System.out.println("Size of list after calling 'removeAll()' method: " + list.getSize());

        list.remove(0);
    }
}
