package com.eric.polymorphism;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/16/2018 9:14 PM
 */
public class PolyConstructors {

    public static void main(String[] args) {
        RectangularGlyph rectangularGlyph = new RectangularGlyph(7);
        rectangularGlyph.draw();
    }
}

class Glyph{
    void draw(){
        System.out.println("Glyph.draw()");
    }

    public Glyph() {
        System.out.println("Glyph draw before");
        draw();
        System.out.println("Glyph draw after");
    }
}

class RectangularGlyph extends Glyph{
    private static int length = 5;

    public RectangularGlyph(int length) {
        this.length = length;
        System.out.println("create Rectangular with length " + length);
    }

    @Override
    void draw() {
        System.out.println("RectangularGlyph draw length = "+ length);
    }

}
