package com.jun.demo;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jun
 * @date 2020/1/6 下午9:15
 */
public class Delete {
    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static void f1() {
        Apple apple = readExact(apples);
        Fruit fruit = readExact(fruits);
        fruit = readExact(apples);
    }

    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
//        Fruit fruit = fruitReader.readExact(apples);
    }


    static class ConvariantReader <T>{
        T readConvariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        ConvariantReader<Fruit> convariantReader = new ConvariantReader<>();
        convariantReader.readConvariant(apples);
        convariantReader.readConvariant(fruits);
    }
}

class Orange extends Fruit {}

class Jonathan extends Apple {}

class Apple extends Fruit{}

class Fruit {}