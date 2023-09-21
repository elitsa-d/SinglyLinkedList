package com.company;

import java.sql.SQLOutput;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(12);
        list.add(3);
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

        list.partition(7);
        list.print();

        list.removeAll();
        System.out.println("Size of list after calling 'removeAll()' method: " + list.getSize());

        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.add(7);
        list1.add(1);
        list1.add(6);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.add(5);
        list2.add(9);
        list2.add(2);

        SinglyLinkedList sum = sumLists(list1, list2);
        sum.print();
    }

    /**
     * Sums two numbers represented in a linked list. Every node contains a single digit and the digits are stored in reverse order.
     *
     * @param list1   the first number represented in a linked list
     * @param list2   the second number represented in a linked list
     *
     * @return a new linked list representing the result where digits are again in reverse
     */

    public static SinglyLinkedList sumLists(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList result = new SinglyLinkedList();
        int addend1 = 0;
        int addend2 = 0;
        int carry = 0;
        int length = Math.max(list1.getSize(), list2.getSize());
        int currentIndex = 0;

        while (currentIndex < length) {
            if (currentIndex < list1.getSize()) {
                addend1 = list1.get(currentIndex);
            }

            if (currentIndex < list2.getSize()) {
                addend2 = list2.get(currentIndex);
            }

            int sum = addend1 + addend2 + carry;
            result.add(sum % 10);

            carry = sum / 10;
            addend1 = 0;
            addend2 = 0;
            currentIndex++;
        }

        return result;
    }
}
