package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JunitCore {

    public static void main(String[] args) throws Exception{
        // найти классы с аннотацией @Test
        // работаем с классом SimpleTest

        Class clazz = SimpleTest.class;
        // запустить все методы с @Test
        for (Method method : clazz.getDeclaredMethods()) {
            Test methodAnnotation = method.getAnnotation(Test.class);
            if (methodAnnotation != null){
                //запустить метод с @Test
                try{
                    method.invoke(clazz.getConstructor().newInstance());
                } catch (InvocationTargetException e){
                    if (e.getCause() instanceof AssertionError) {
                        System.out.println("Test failed: " + method.getName());
                        continue;
                    } else {
                        System.out.println("Test broken: " + method.getName());
                        continue;
                    }
                }
                System.out.println("Test passed: " + method.getName());
            }
        }

        for (Method method : clazz.getDeclaredMethods()) {
            AfterEach methodAnnotation = method.getAnnotation(AfterEach.class);
            if (methodAnnotation != null){
                //запустить метод с @AfterEach
                try {
                    method.invoke(clazz.getConstructor().newInstance());
                } catch (InvocationTargetException e){
                    if (e.getCause()instanceof AssertionError) {
                        System.out.println("Test failed" + method.getName());
                        continue;
                    } else {
                        System.out.println("Test broken: " + method.getName());
                        continue;
                    }
                }
                System.out.println("Test passed: " + method.getName());
            }
        }

        for (Method method : clazz.getDeclaredMethods()) {
            BeforeEach methodAnnotation = method.getAnnotation(BeforeEach.class);
            if (methodAnnotation != null){
                //запустить метод с @AfterEach
                try {
                    method.invoke(clazz.getConstructor().newInstance());
                } catch (InvocationTargetException e){
                    if (e.getCause()instanceof AssertionError) {
                        System.out.println("Test failed" + method.getName());
                        continue;
                    } else {
                        System.out.println("Test broken: " + method.getName());
                        continue;
                    }
                }
                System.out.println("Test passed: " + method.getName());
            }
        }

        for (Method method : clazz.getDeclaredMethods()) {
            AfterAll methodAnnotation = method.getAnnotation(AfterAll.class);
            if (methodAnnotation != null){
                //запустить метод с @AfterEach
                try {
                    method.invoke(clazz.getConstructor().newInstance());
                } catch (InvocationTargetException e){
                    if (e.getCause()instanceof AssertionError) {
                        System.out.println("Test failed" + method.getName());
                        continue;
                    } else {
                        System.out.println("Test broken: " + method.getName());
                        continue;
                    }
                }
                System.out.println("Test passed: " + method.getName());
            }
        }

        for (Method method : clazz.getDeclaredMethods()) {
            BeforeAll methodAnnotation = method.getAnnotation(BeforeAll.class);
            if (methodAnnotation != null){
                //запустить метод с @AfterEach
                try {
                    method.invoke(clazz.getConstructor().newInstance());
                } catch (InvocationTargetException e){
                    if (e.getCause()instanceof AssertionError) {
                        System.out.println("Test failed" + method.getName());
                        continue;
                    } else {
                        System.out.println("Test broken: " + method.getName());
                        continue;
                    }
                }
                System.out.println("Test passed: " + method.getName());
            }
        }
        // вывести результаты
    }
}
