package com.andersenlab.lecture_6_2.hash_set;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public class CustomHashSet<E> implements CustomSet<E>{
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private List<E>[] buckets;
    private int size;

    public CustomHashSet() {
        this(DEFAULT_CAPACITY);
    }

    public CustomHashSet(int initialCapacity) {
        buckets = new LinkedList[initialCapacity];
        for (int i = 0; i < initialCapacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    private int getBucketIndex(E element) {
        int hashCode = element.hashCode();
        return Math.abs(hashCode % buckets.length);
    }

    @Override
    public boolean put(E element) {
        if (contains(element)) {
            return false;
        }

        int bucketIndex = getBucketIndex(element);
        buckets[bucketIndex].add(element);
        size++;

        if ((double) size / buckets.length > LOAD_FACTOR) {
            resize();
        }

        return true;
    }

    @Override
    public boolean contains(E element) {
        int bucketIndex = getBucketIndex(element);
        return buckets[bucketIndex].contains(element);
    }

    @Override
    public boolean remove(E element) {
        int bucketIndex = getBucketIndex(element);
        if (buckets[bucketIndex].remove(element)) {
            size--;
            return true;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize() {
        List<E>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;

        for (List<E> bucket : oldBuckets) {
            for (E element : bucket) {
                put(element);
            }
        }
    }

    public Iterator<E> iterator() {
        return new HashSetIterator();
    }

    private class HashSetIterator implements Iterator<E> {

        private int currentBucketIndex;
        private Iterator<E> currentIterator = buckets[0].iterator();

        @Override
        public boolean hasNext() {
            if (currentIterator.hasNext()) {
                return true;
            } else {
                while (currentBucketIndex < buckets.length - 1) {
                    currentBucketIndex++;
                    if (!buckets[currentBucketIndex].isEmpty()) {
                        currentIterator = buckets[currentBucketIndex].iterator();
                        return true;
                    }
                }
                return false;
            }
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements to iterate");
            }
            return currentIterator.next();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (List<E> bucket : buckets) {
            for (E element : bucket) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(element);
                first = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
