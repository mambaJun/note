package com.jun.demo.designmodel.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jun
 * @date 2019/12/11 上午10:02
 */
public class prototype {
    public static void main(String[] args) {
        ShapeCache.getShape(1);
        ShapeCache.getShape(2);
        ShapeCache.getShape(3);
    }
}

class ShapeCache {
    private static Map<Integer, Shape> map = new HashMap<>();

    static {
        Circle circle = new Circle();
        circle.setId(1);
        map.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId(2);
        map.put(rectangle.getId(), rectangle);

        Square square = new Square();
        square.setId(3);
        map.put(square.getId(), square);
    }

    public static Shape getShape(Integer shapeId) {
        Shape shape = map.get(shapeId);
        Shape clone = (Shape) shape.clone();
        System.out.println(shape);
        System.out.println(clone);
        System.out.println(shape == clone);
        return clone;
    }
}

class Circle extends Shape {

    public Circle() {
        this.type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Circle-draw");
    }
}

class Square extends Shape {

    public Square() {
        this.type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Square-draw");
    }
}

class Rectangle extends Shape {

    public Rectangle() {
        this.type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Rectangle-draw");
    }
}

abstract class Shape implements Cloneable {
    private Integer id;
    protected String type;

    /**
     * draw
     */
    abstract void draw();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}




