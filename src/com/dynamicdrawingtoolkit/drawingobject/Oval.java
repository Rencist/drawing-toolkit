package com.dynamicdrawingtoolkit.drawingobject;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends DrawingObject {

    public Oval() {
        super();
    }

    public Oval(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawOval(
            this.getUpperLeftX(), this.getUpperLeftY(),
            this.getWidth(), this.getHeight()
            );
    }
}
