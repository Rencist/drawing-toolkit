package com.dynamicdrawingtoolkit.ui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import com.dynamicdrawingtoolkit.drawingobject.*;

public class DrawingCanvas extends JPanel {

    public static final int SHAPE_LINE = 1;
    public static final int SHAPE_CIRCLE = 2;
    public static final int SHAPE_OVAL = 3;
    public static final int SHAPE_RECTANGLE = 4;

    public static final int STATE_DRAW = 1;
    public static final int STATE_SELECT = 2;

    private ArrayList<DrawingObject> shapes;
    private int state;
    private int currentShapeType;
    private DrawingObject currentShapeObject;
    private Color currentShapeColor;

    public JLabel statusLabel;
    
    public DrawingCanvas(JLabel statusLabel) {
        this.shapes = new ArrayList<DrawingObject>();
        this.currentShapeType = SHAPE_LINE;
        this.currentShapeObject = null;
        this.currentShapeColor = Color.BLACK;

        this.statusLabel = statusLabel;
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.add(this.statusLabel, BorderLayout.SOUTH);
        
        MouseHandler mouseHandler = new MouseHandler(this);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (DrawingObject shape : shapes) shape.draw(g);
        if (this.currentShapeObject != null) {
            switch (this.state) {
                case STATE_DRAW:
                    this.currentShapeObject.draw(g);
                    break;
                case STATE_SELECT:
                    this.currentShapeObject.drawBoundingBox(g);
                    break;
            }
        }
    }

    public void clearDrawing() {
        this.shapes.clear();
        this.currentShapeObject = null;
        repaint();
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setCurrentShapeType(int type) {
        this.currentShapeType = type;
    }

    public int getState() {
        return this.state;
    }

    public int getcurrentShapeType() {
        return this.currentShapeType;
    }

    public Color getcurrentShapeColor() {
        return this.currentShapeColor;
    }

    public DrawingObject getcurrentShapeObject() {
        return this.currentShapeObject;
    }

    public void setcurrentShapeObject(DrawingObject currentShapeObject) {
        this.currentShapeObject = currentShapeObject;
    }

    public ArrayList<DrawingObject> getShapes() {
        return this.shapes;
    }
}
