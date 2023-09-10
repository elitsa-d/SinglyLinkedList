package com.company;

public class SinglyLinkedList {
    Node head = null;
    Node tail = null;
    int size = 0;

    public Integer get(int index) {

        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        int currentIndex = 0;
        Node currentNode = this.head;

        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode.value;
    }

    private Node getNode(int index) {

        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        int currentIndex = 0;
        Node currentNode = this.head;

        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode;
    }

    public void add(int value) {
        Node newNode = new Node(value);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void add(int index, int value) {
        Node newNode = new Node(value);

        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else if (index == this.size) {
                tail.next = newNode;
                tail = newNode;
            } else {
                Node currentNode = this.getNode(index - 1);
                newNode.next = currentNode.next;
                currentNode.next = newNode;
            }
        }

        size++;
    }

    public boolean isPresent(int value) {
        Node currentNode = this.head;

        do {
            if (currentNode.value == value) {
                return true;
            }

            currentNode = currentNode.next;
        } while (currentNode != this.tail);

        return false;
    }

    public Integer indexOf(int value) {
        if (isPresent(value)) {
            int currentIndex = 0;
            Node currentNode = this.head;

            while (currentIndex < this.size) {
                if (currentNode.value == value) {
                    return currentIndex;
                }

                currentNode = currentNode.next;
                currentIndex++;
            }
        }

        throw new IllegalArgumentException();
    }

    public Integer lastIndexOf(int value) {
        if (isPresent(value)) {
            int currentIndex = 0;
            Node currentNode = this.head;
            int lastIndex = 0;

            while (currentIndex < this.size) {
                if (currentNode.value == value) {
                    lastIndex = currentIndex;
                }

                currentNode = currentNode.next;
                currentIndex++;
            }

            return lastIndex;
        }

        throw new IllegalArgumentException();
    }

    public Integer remove(int index) {

        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        int value = this.get(index);

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            if (index == 0) {
                head = head.next;
            } else if (index == this.size - 1) {
                tail = this.getNode(this.size - 2);
                tail.next = null;
            } else {
                Node nodeToRemove = this.getNode(index);
                Node currentNode = this.getNode(index - 1);
                currentNode.next = nodeToRemove.next;
            }
        }

        size--;
        return value;
    }

    public void removeAll() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
