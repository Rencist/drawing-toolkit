package com.dynamicdrawingtoolkit.drawingobject;

import java.awt.Color;
import java.awt.Graphics;

public abstract class DrawingObject {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int offsetX;
    private int offsetY;
    private Color color;

    public DrawingObject() {
        this.x1 = 0; this.y1 = 0;
        this.x2 = 0; this.y2 = 0;
        this.color = Color.BLACK;
    }
    
    public DrawingObject(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1; this.y1 = y1;
        this.x2 = x2; this.y2 = y2;
        this.color = color;
    }

    public abstract void draw(Graphics g);

    public void drawBoundingBox(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(
            this.getUpperLeftX(), this.getUpperLeftY(),
            this.getWidth(), this.getHeight()
            );
    }

    public boolean isCollide(int x, int y) {
        int x1 = Math.min(this.x1, this.x2);
        int x2 = Math.max(this.x1, this.x2);
        int y1 = Math.min(this.y1, this.y2);
        int y2 = Math.max(this.y1, this.y2);

        return x1 <= x && x <= x2 && y1 <= y && y <= y2;
    }

    public Color getColor() {
        return this.color;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }
    
    public int getX1() {
        return this.x1;
    }

    public int getY1() {
        return this.y1;
    }

    public int getX2() {
        return this.x2;
    }

    public int getY2() {
        return this.y2;
    }

    public int getOffsetX() {
        return this.offsetX;
    }

    public int getOffsetY() {
        return this.offsetY;
    }

    public int getUpperLeftX() {
        return Math.min(this.getX1(), this.getX2());
    }

    public int getUpperLeftY() {
        return Math.min(this.getY1(), this.getY2());
    }

    public int getWidth() {
        return Math.abs(this.getX1() - this.getX2());
    }

    public int getHeight() {
        return Math.abs(this.getY1() - this.getY2());
    }
}
