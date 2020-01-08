package com.jun.demo.designmodel.decorator;

/**
 * @author jun
 * @date 2019-12-12
 */
public class Decorator {

    public static void main(String[] args) {
        Shape circle = new Circle();
        RedShapeDecorator redShapeDecorator = new RedShapeDecorator(circle);
        circle.draw();
        System.out.println("---------------------------------");
        redShapeDecorator.draw();
        System.out.println("#########################################");
        Rectangle rectangle = new Rectangle();
        RedShapeDecorator redShapeDecorator1 = new RedShapeDecorator(rectangle);
        rectangle.draw();
        System.out.println("-------------------------");
        redShapeDecorator1.draw();
    }

}

class RedShapeDecorator extends AbstractShapeDecorator {

    public RedShapeDecorator(Shape decoratorShape) {
        super(decoratorShape);
    }

    @Override
    public void draw() {
        decoratorShape.draw();
        // 装饰器的精髓一步
        setRedBorder(decoratorShape);
    }

    private void setRedBorder(Shape decoratorShape) {
        System.out.println("Border Color: Red");
    }
}

abstract class AbstractShapeDecorator implements Shape {
    protected Shape decoratorShape;

    public AbstractShapeDecorator(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    @Override
    public void draw() {
        decoratorShape.draw();
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape - Circle");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape - Rectangle");
    }
}

interface Shape {
    void draw();
}
