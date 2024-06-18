package com.andersenlab.lecture_2.interfaces;

public interface Printable {

    default void print() {
        System.out.println("print content in console");
    }
}
