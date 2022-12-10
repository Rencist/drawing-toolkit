package com.dynamicdrawingtoolkit.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.dynamicdrawingtoolkit.drawingobject.Circle;
import com.dynamicdrawingtoolkit.drawingobject.DrawingObject;
import com.dynamicdrawingtoolkit.drawingobject.Line;
import com.dynamicdrawingtoolkit.drawingobject.Oval;
import com.dynamicdrawingtoolkit.drawingobject.Rectangle;

public class MouseHandler extends MouseAdapter {
    private DrawingCanvas drawingCanvas;
    private DrawingObject currentShapeObject;
    
    public MouseHandler(DrawingCanvas drawingCanvas) {
        this.drawingCanvas = drawingCanvas;
    }
    
    public void mousePressed(MouseEvent e) {
        switch (drawingCanvas.getState()) {
            case 1:
            switch (drawingCanvas.getcurrentShapeType()) {
                case 1:
                currentShapeObject = new Line(e.getX(), e.getY(), e.getX(), e.getY(), drawingCanvas.getcurrentShapeColor());
                drawingCanvas.setcurrentShapeObject(currentShapeObject);
                break;

                case 2:
                currentShapeObject = new Circle(e.getX(), e.getY(), e.getX(), e.getY(), drawingCanvas.getcurrentShapeColor());
                drawingCanvas.setcurrentShapeObject(currentShapeObject);
                break;

                case 3:
                currentShapeObject = new Oval(e.getX(), e.getY(), e.getX(), e.getY(), drawingCanvas.getcurrentShapeColor());
                drawingCanvas.setcurrentShapeObject(currentShapeObject);
                break;

                case 4:
                currentShapeObject = new Rectangle(e.getX(), e.getY(), e.getX(), e.getY(), drawingCanvas.getcurrentShapeColor());
                drawingCanvas.setcurrentShapeObject(currentShapeObject);
                break;
            }
            break;

            case 2:
            boolean found = false;
            for (int i = drawingCanvas.getShapes().size()-1; i >= 0; i--) {
                if (drawingCanvas.getShapes().get(i).isCollide(e.getX(), e.getY())) {
                    currentShapeObject = drawingCanvas.getShapes().get(i);
                    drawingCanvas.setcurrentShapeObject(currentShapeObject);
                    drawingCanvas.getcurrentShapeObject().setOffsetX(
                        e.getX() -
                        drawingCanvas.getcurrentShapeObject().getUpperLeftX()
                        );
                    drawingCanvas.getcurrentShapeObject().setOffsetY(
                        e.getY() -
                        drawingCanvas.getcurrentShapeObject().getUpperLeftY()
                        );
                    found = true;
                    break;
                }
            }
            if (!found) drawingCanvas.setcurrentShapeObject(null);
            break;
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        switch (drawingCanvas.getState()) {
            case 1:
            drawingCanvas.getcurrentShapeObject().setX2(e.getX());
            drawingCanvas.getcurrentShapeObject().setY2(e.getY());
            drawingCanvas.getShapes().add(drawingCanvas.getcurrentShapeObject());
            drawingCanvas.setcurrentShapeObject(null);
            break;

            case 2:
            break;
        }

        this.drawingCanvas.repaint();
    }

	@Override
    public void mouseMoved(MouseEvent e) {
        this.drawingCanvas.statusLabel.setText(String.format(
            "Mouse Coordinates X: %d Y: %d",
            e.getX(), e.getY())
            );
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (drawingCanvas.getState()) {
            case 1:
            drawingCanvas.getcurrentShapeObject().setX2(e.getX());
            drawingCanvas.getcurrentShapeObject().setY2(e.getY());
            break;

            case 2:
            if (drawingCanvas.getcurrentShapeObject() == null) break;
            int width = drawingCanvas.getcurrentShapeObject().getWidth();
            int height = drawingCanvas.getcurrentShapeObject().getHeight();
            drawingCanvas.getcurrentShapeObject().setX1(
                e.getX() - 
                drawingCanvas.getcurrentShapeObject().getOffsetX()
                );
            drawingCanvas.getcurrentShapeObject().setY1(
                e.getY() - 
                drawingCanvas.getcurrentShapeObject().getOffsetY()
                );
            drawingCanvas.getcurrentShapeObject().setX2(
                e.getX() + width - 
                drawingCanvas.getcurrentShapeObject().getOffsetX()
                );
            drawingCanvas.getcurrentShapeObject().setY2(
                e.getY() + height - 
                drawingCanvas.getcurrentShapeObject().getOffsetY()
                );
            break;
        }

        this.drawingCanvas.statusLabel.setText(String.format(
            "Mouse Coordinates X: %d Y: %d",
            e.getX(), e.getY())
            );
        this.drawingCanvas.repaint();
    }
}
