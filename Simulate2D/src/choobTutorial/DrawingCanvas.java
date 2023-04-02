package choobTutorial;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import javax.swing.*;

public class DrawingCanvas extends JComponent {
    private int width;
    private int height;

    public DrawingCanvas(int width, int height) {
        this.width = width;
        this.height = height;
    }
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double r = new Rectangle2D.Double(50,75,100,250);
        g2d.setColor(new Color(100,149,237));
        g2d.fill(r);
        }
    }
