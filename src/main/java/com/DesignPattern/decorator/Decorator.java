package com.DesignPattern.decorator;

public class Decorator {

    public static void main(String[] args){

        System.out.println(" Demo Decorator! ");
        Shape shape = new Circle();

        DecoratorAbstractClass decorator = new RedShape(shape);
        decorator.draw();
        decorator = new BorderShape(shape);
        decorator.draw();

        shape = new Rectangle();

        decorator = new RedShape(shape);
        decorator.draw();
        decorator = new BorderShape(shape);
        decorator.draw();


    }

}


interface Shape{

    public void draw();

}


class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println(" Rectangle drawn! ");
    }

}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println(" Circle drawn!");
    }
}

abstract class DecoratorAbstractClass implements Shape{

    private Shape shape;

    public DecoratorAbstractClass(Shape shape) {
        this.shape = shape;
    }

    public void draw() {
        shape.draw();
    }

}

class RedShape extends DecoratorAbstractClass{

    public RedShape(Shape shape) {
        super(shape);
    }

    public void draw() {
        super.draw();
        drwaRed();
    }

    public void drwaRed(){

        System.out.println(" Red shape Drawn");

    }

}

class BorderShape extends DecoratorAbstractClass{

    public BorderShape(Shape shape) {
        super(shape);
    }

    public void draw() {
        super.draw();
        drwaBorder();
    }

    public void drwaBorder(){

        System.out.println(" Border shape Drawn");

    }

}

