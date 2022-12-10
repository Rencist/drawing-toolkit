package com.dynamicdrawingtoolkit.drawingobject;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends DrawingObject {
    
    public Line() {
        super();
    }

    public Line(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawLine(
            this.getX1(), this.getY1(),
            this.getX2(), this.getY2()
            );
    }
}
