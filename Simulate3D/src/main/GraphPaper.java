package main;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;

public class GraphPaper extends JPanel {
    private static final int SPACING = 10;
    private static final int LINE_WEIGHT = 1;
    private int width;
    private int height;

    private Coordinate origin;
    public GraphPaper(int width, int height) {
        this.width = width;
        this.height = height;

        // Add a component listener to detect when the window is resized
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // Update the size of the graph paper
                GraphPaper.this.width = e.getComponent().getWidth();
                GraphPaper.this.height = e.getComponent().getHeight();
                //change when once re-sized
                GraphPaper.this.origin = new Coordinate(e.getComponent().getWidth()/2,e.getComponent().getHeight()/2);
                GraphPaper.this.repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        drawGraph(g2d);
    }

    public void drawGraph(Graphics2D g){

        // Draw horizontal lines
        g.setColor(Color.LIGHT_GRAY);
        for (int y = SPACING; y < height; y += SPACING) {
            g.drawLine(0, y, width, y);
        }

        // Draw vertical lines
        for (int x = SPACING; x < width; x += SPACING) {
            g.drawLine(x, 0, x, height);
        }

        // Draw thicker lines for every 5th line
        g.setColor(Color.GRAY);
        for (int y = SPACING * 5; y < height; y += SPACING * 5) {
            g.fillRect(0, y - LINE_WEIGHT / 2, width, LINE_WEIGHT);
        }
        for (int x = SPACING * 5; x < width; x += SPACING * 5) {
            g.fillRect(x - LINE_WEIGHT / 2, 0, LINE_WEIGHT, height);
        }

        //Draw thick line for origin
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
        g.drawLine(origin.x,0,origin.x,height);
        g.drawLine(0,origin.y,width,origin.y);
    }
}
