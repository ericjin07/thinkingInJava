package com.eric.typeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/08/2019 10:13 PM
 */
abstract class Shape {
    void draw() { System.out.println(this + ".draw()"); }
    abstract public String toString();

    public void rotate(Shape s) {
        if (!(s instanceof Circle))
            System.out.println(s + " rotate 180 degree");
    }
}

class Circle extends Shape {
    public String toString() { return "Circle"; }
}

class Square extends Shape {
    public String toString() { return "Square"; }
}

class Triangle extends Shape {
    public String toString() { return "Triangle"; }
}

class Rhomboid extends Shape {
    public String toString() { return "Rhomboid"; }
}

public class Shapes3 {
    public static void main(String[] args) {
        // upcasting to Shape:
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle(), new Rhomboid()
        );
        // downcasting back to specific shape:
        for(Shape shape : shapeList) {
            shape.draw();
            shape.rotate(shape);
        }
        Rhomboid r = new Rhomboid();
        Shape s = (Shape)r;
        s.draw();
        // inconvertible types:
        if (s instanceof Circle)
            ((Circle)s).draw();
        else System.out.println("s is not a Circle");
    }
}
