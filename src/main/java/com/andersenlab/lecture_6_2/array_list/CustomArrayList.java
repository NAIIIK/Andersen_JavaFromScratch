package com.andersenlab.lecture_6_2.array_list;

import java.util.Arrays;
import java.util.Iterator;

public class CustomArrayList<E> implements CustomList<E> {

    private E[] elements;

    private int size;

    public CustomArrayList(int size) {
        if (size < 0) throw new IllegalArgumentException("Size can not be negative");
        elements = (E[]) new Object[size];
    }

    public CustomArrayList() {
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        checkCapacity(size + 1);
        elements[size++] = element;
    }

    @Override
    public void remove(int index) {
        int moved = size - index - 1;
        if (moved > 0) {
            System.arraycopy(elements, index + 1, elements, index, moved);
        }
        elements[--size] = null;
    }

    @Override
    public E get(int index) {
        if (index < size) return elements[index];
        throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + size);
    }

    private void checkCapacity(int tailIndex) {
        if (tailIndex > elements.length) {
            Object[] oldArray = elements;
            int newSize =  size * 2;
            elements = (E[]) Arrays.copyOf(oldArray, newSize);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomArrayListIterator<>();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size - 1; i++) {
            if (elements[i] != null) stringBuilder.append(elements[i])
                    .append(", ");
        }
        stringBuilder.append(elements[size - 1])
                .append("]");

        return stringBuilder.toString();
    }

    private class CustomArrayListIterator<F> implements Iterator<F> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return this.current < size();
        }

        @Override
        public F next() {
            F value = (F) elements[current++];
            return value;
        }
    }
}
