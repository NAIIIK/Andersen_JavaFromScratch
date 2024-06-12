package com.andersenlab.lecture_2;

import java.lang.reflect.Field;

public class NullableWarningChecker {
    public static void checkNulls(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field: fields) {
            if (field.isAnnotationPresent(NullableWarning.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(o) == null) {
                        System.out.println("Variable [" + field.getName() + "] is null in [" + o.getClass().getSimpleName() + "]");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
