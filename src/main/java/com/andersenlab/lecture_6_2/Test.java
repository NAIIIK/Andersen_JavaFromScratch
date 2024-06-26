package com.andersenlab.lecture_6_2;

import com.andersenlab.lecture_6_2.array_list.CustomArrayList;
import com.andersenlab.lecture_6_2.hash_set.CustomHashSet;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        testArray();
        testSet();
    }

    public static void testArray() {
        CustomArrayList<Integer> list = new CustomArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);

        System.out.println(list.get(2));

        list.remove(3);

        System.out.println(list);
    }

    public static void testSet() {
        CustomHashSet<Integer> set = new CustomHashSet<>();

        for (int i = 1; i < 11; i++) {
            set.put(i);
        }

        System.out.println(set);

        set.put(3);

        System.out.println(set);

        System.out.println(set.contains(5));
        System.out.println(set.contains(12));

        Iterator<Integer> iterator = set.iterator();

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

        set.remove(8);

        System.out.println(set);
    }
}
