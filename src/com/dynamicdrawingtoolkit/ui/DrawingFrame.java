package com.dynamicdrawingtoolkit.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawingFrame extends JFrame {
    
    private JButton jbLine, jbRectangle, jbCircle, jbOval, jbClear, jbSelect;
    private JPanel toolboxPanel, toolboxPadding;
    public static DrawingCanvas canvas;

    public DrawingFrame() {
        super("Drawing Toolkit");
        JLabel statusLabel = new JLabel();

        canvas = new DrawingCanvas(statusLabel);
        canvas.setBorder(BorderFactory.createLineBorder(Color.GRAY, 15));

        this.jbClear = new JButton("Clear");
        this.jbSelect = new JButton("Select");
        this.jbLine = new JButton("Line");
        this.jbRectangle = new JButton("Rectangle");
        this.jbCircle = new JButton("Circle");
        this.jbOval = new JButton("Oval");

        this.toolboxPanel = new JPanel();
        this.toolboxPanel.setLayout(new GridLayout(1, 1, 1, 1));
        this.toolboxPadding = new JPanel();
        this.toolboxPadding.setLayout(new FlowLayout(FlowLayout.LEADING, 1, 1));

        this.toolboxPanel.add(jbClear);
        this.toolboxPanel.add(jbSelect);
        this.toolboxPanel.add(jbLine);
        this.toolboxPanel.add(jbRectangle);
        this.toolboxPanel.add(jbCircle);
        this.toolboxPanel.add(jbOval);
        this.toolboxPadding.add(toolboxPanel);
        
        this.add(toolboxPadding, BorderLayout.NORTH);
        this.add(canvas, BorderLayout.CENTER);

        ButtonHandler buttonHandler = new ButtonHandler();
        this.jbClear.addActionListener(buttonHandler);
        this.jbSelect.addActionListener(buttonHandler);
        this.jbLine.addActionListener(buttonHandler);
        this.jbRectangle.addActionListener(buttonHandler);
        this.jbCircle.addActionListener(buttonHandler);
        this.jbOval.addActionListener(buttonHandler);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);

                int choose = JOptionPane.showConfirmDialog(null,
                    "Do you really want to exit the application?",
                    "Confirm Close",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE
                );

                if (choose == JOptionPane.NO_OPTION) setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                else {
                    e.getWindow().dispose();
                    System.out.println("close");
                }
            }
        });

        this.setSize(500, 500);
        this.setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
    
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            if (command.equals("Select")) canvas.setState(DrawingCanvas.STATE_SELECT);
            else {
                canvas.setState(DrawingCanvas.STATE_DRAW);
                if (command.equals("Clear")) canvas.clearDrawing();
                else if (command.equals("Line")) canvas.setCurrentShapeType(DrawingCanvas.SHAPE_LINE);
                else if (command.equals("Rectangle")) canvas.setCurrentShapeType(DrawingCanvas.SHAPE_RECTANGLE);
                else if (command.equals("Circle")) canvas.setCurrentShapeType(DrawingCanvas.SHAPE_CIRCLE);
                else if (command.equals("Oval")) canvas.setCurrentShapeType(DrawingCanvas.SHAPE_OVAL);
            }
        }
    }
}
