package com.dynamicdrawingtoolkit.drawingobject;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends DrawingObject {

    private int diameter = 0;

    public Circle() {
        super();
    }

    public Circle(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    @Override
    public int getUpperLeftX() {
        if (this.getX2() >= this.getX1()) {
            this.setX2(this.getX1() + this.diameter);
            return this.getX1();
        }
        this.setX2(this.getX1() - this.diameter);
        return this.getX2();
    }

    @Override
    public int getUpperLeftY() {
        if (this.getY2() >= this.getY1()) {
            this.setY2(this.getY1() + this.diameter);
            return this.getY1();
        }
        this.setY2(this.getY1() - this.diameter);
        return this.getY2();
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        this.diameter = Math.min(this.getWidth(), this.getHeight());
        g.drawOval(
            this.getUpperLeftX(), this.getUpperLeftY(),
            this.diameter, this.diameter
            );
    }
}
