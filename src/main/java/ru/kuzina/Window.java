package ru.kuzina;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame {

    public static final int W = 500;
    public static final int H = 500;
    private Convex convex;


    public Window(Convex convex){
        this.convex = convex;
        this.setSize(W, H);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void add(){
        this.update(this.getGraphics());
    }

    @Override
    public void paint(Graphics g){
        // Начало координат выставляется автоматически

        g.translate(W/2,H/2);
        g.drawLine(-W/2, 0, W/2, 0);
        g.drawLine(0, -H/2, 0, H/2);

        convex.draw(g);
    }
}
