package com.jun.demo;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jun
 * @date 2019/12/2 下午4:38
 */
class ColoredDimension<T extends Dimension & HasColor> {
    T item;

    ColoredDimension(T item) {
        this.item = item;
    }

    Color getColor() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }
}

class Dimension {
    public int x,y, z;
}

class Colored <T extends HasColor> {
    T item;

    Colored(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }
}

interface HasColor{
    Color getColor();
}

class Fibomacci implements  Generator<Integer> {

    int count = 0;

    @Override
    public Integer next() {
        return null;
    }
}

class Coffee{
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + id;
    }
}

interface Generator<T> {
    T next();
}

public class SwitchString {

    public static void main(String[] args) {
        Integer integer = null;
        String string = null;
    }
}

class TwoTuple<A,B>{
    public A a;
    public B b;

    public TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public static void main(String[] args) {
        TwoTuple<Integer, String> string = new TwoTuple<>(1, "string");
        System.out.println(string);
    }
}

class GeneraicToyTest{
    public static void main(String[] args) {
        Class<Square> squareClass = Square.class;
        Method[] methods = squareClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
        }
        Constructor<?>[] constructors = squareClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.toString());
        }
        System.out.println("----------------------------------------------------");
        Field[] fields = squareClass.getFields();
        for (Field field : fields) {
            System.out.println(field.toString());
        }
    }
}

class FilledList<T> {
    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int elements) {
        List<T> result = new ArrayList<>();
        try {
            result.add(type.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> countedIntegerFilledList = new FilledList<>(CountedInteger.class);
        System.out.println(countedIntegerFilledList.create(15));

    }
}

class CountedInteger{
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

class Shapes {
    public static void main(String[] args) {
        List<Shape> list = Arrays.asList(
                new Circle("Circle"),
                new Square("Square", 1)
        );
        for (Shape shape : list) {
            shape.draw();
        }
        Shape square = new Square("fsdfs", 2);
        System.out.println(square.hashCode());
        Square square1 = (Square) square;
        System.out.println(square1.hashCode());
        Field[] declaredFields = square.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
            System.out.println(declaredField.getName());
            System.out.println(declaredField.getType());
        }
    }
}

class Square extends Shape{
    int area;

    public Square(String name, int area) {
        super(name);
        this.area = area;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Circle extends Shape {
    public Circle(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name;
    }
}

abstract class Shape {

    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    abstract public String toString();

    void draw() {
        System.out.println(this + " - draw()");
    }
}