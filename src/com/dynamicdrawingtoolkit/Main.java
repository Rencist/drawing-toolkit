package com.dynamicdrawingtoolkit;

import java.awt.Dimension;

import com.dynamicdrawingtoolkit.ui.DrawingFrame;

public class Main {
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DrawingFrame canvasGUI = new DrawingFrame();
                canvasGUI.setSize(new Dimension(600, 600));
                canvasGUI.setVisible(true);
            }
        });
    }
}
