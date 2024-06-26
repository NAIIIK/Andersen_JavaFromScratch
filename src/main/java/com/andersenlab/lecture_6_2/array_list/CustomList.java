package com.andersenlab.lecture_6_2.array_list;

public interface CustomList<E> extends Iterable<E> {
    boolean isEmpty();

    int size();

    void add(E element);

    void remove(int index);

    E get(int index);
}
