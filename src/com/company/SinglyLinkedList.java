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

        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.size++;
    }

    public void add(int index, int value) {
        Node newNode = new Node(value);

        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            if (index == 0) {
                newNode.next = this.head;
                this.head = newNode;
            } else if (index == this.size) {
                this.tail.next = newNode;
                this.tail = newNode;
            } else {
                Node currentNode = this.getNode(index - 1);
                newNode.next = currentNode.next;
                currentNode.next = newNode;
            }
        }

        this.size++;
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

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            if (index == 0) {
                this.head = this.head.next;
            } else if (index == this.size - 1) {
                this.tail = this.getNode(this.size - 2);
                this.tail.next = null;
            } else {
                Node nodeToRemove = this.getNode(index);
                Node currentNode = this.getNode(index - 1);
                currentNode.next = nodeToRemove.next;
            }
        }

        this.size--;
        return value;
    }

    public void removeAll() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
