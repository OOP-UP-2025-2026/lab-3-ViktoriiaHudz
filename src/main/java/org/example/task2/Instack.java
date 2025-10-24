package org.example.task2;

public class Instack {

    private int[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public Instack() {
        this.elements = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void push(int value) {
        if (this.size == this.elements.length) {
            expandCapacity();
        }
        this.elements[this.size++] = value;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Стек порожній — неможливо витягти елемент");
        }
        return this.elements[--this.size];
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Стек порожній — немає елемента для перегляду");
        }
        return this.elements[this.size - 1];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.size = 0;
        this.elements = new int[INITIAL_CAPACITY];
    }

    private void expandCapacity() {
        int newCapacity = this.elements.length * 2;
        int[] newArray = new int[newCapacity];
        System.arraycopy(this.elements, 0, newArray, 0, this.size);
        this.elements = newArray;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Instack [");
        for (int i = 0; i < this.size; i++) {
            builder.append(this.elements[i]);
            if (i < this.size - 1) builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }
}
