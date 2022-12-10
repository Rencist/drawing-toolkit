package com.dynamicdrawingtoolkit.drawingobject;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends DrawingObject {

    public Rectangle() {
        super();
    }
    
    public Rectangle(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawRect(
            this.getUpperLeftX(), this.getUpperLeftY(),
            this.getWidth(), this.getHeight()
            );
    }
}
