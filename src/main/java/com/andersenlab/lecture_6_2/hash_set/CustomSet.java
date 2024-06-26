package com.andersenlab.lecture_6_2.hash_set;

public interface CustomSet<E> extends Iterable<E> {
    boolean put(E element);

    boolean remove(E element);

    boolean contains(E element);

    int size();
}
