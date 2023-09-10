package com.company;

public class SinglyLinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int getSize() {
        return this.size;
    }

    public Integer getFirst() {
        return this.head.getValue();
    }

    public Integer getLast() {
        return this.tail.getValue();
    }

    public Integer get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        int currentIndex = 0;
        Node currentNode = this.head;

        while (currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return currentNode.getValue();
    }

    public Integer set(int index, int value) {
        Node node = this.getNode(index);
        node.setValue(value);
        return node.getValue();
    }

    private Node getNode(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        int currentIndex = 0;
        Node currentNode = this.head;

        while (currentIndex < index) {
            currentNode = currentNode.getNext();
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
            this.tail.setNext(newNode);
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
                newNode.setNext(this.head);
                this.head = newNode;
            } else if (index == this.size) {
                this.tail.setNext(newNode);
                this.tail = newNode;
            } else {
                Node currentNode = this.getNode(index - 1);
                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
            }
        }

        this.size++;
    }

    public boolean isPresent(int value) {
        Node currentNode = this.head;

        do {
            if (currentNode.getValue() == value) {
                return true;
            }

            currentNode = currentNode.getNext();
        } while (currentNode != this.tail);

        return false;
    }

    public Integer indexOf(int value) {
        if (isPresent(value)) {
            int currentIndex = 0;
            Node currentNode = this.head;

            while (currentIndex < this.size) {
                if (currentNode.getValue() == value) {
                    return currentIndex;
                }

                currentNode = currentNode.getNext();
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
                if (currentNode.getValue() == value) {
                    lastIndex = currentIndex;
                }

                currentNode = currentNode.getNext();
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
                this.head = this.head.getNext();
            } else if (index == this.size - 1) {
                this.tail = this.getNode(this.size - 2);
                this.tail.setNext(null);
            } else {
                Node nodeToRemove = this.getNode(index);
                Node currentNode = this.getNode(index - 1);
                currentNode.setNext(nodeToRemove.getNext());
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
