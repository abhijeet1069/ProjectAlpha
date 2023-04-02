package experiment;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MultiplePanelsDrawingExample {

    public static void main(String[] args) {

        // Create a new JFrame
        JFrame frame = new JFrame("Multiple Panels Drawing Example");

        // Create three new custom JPanels
        CirclePanel1 panel1 = new CirclePanel1(Color.RED);
        CirclePanel2 panel2 = new CirclePanel2(Color.GREEN);

        // Add the panels to the JFrame
        panel1.add(panel2);
        frame.add(panel1);

        // Set the size and visibility of the JFrame
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Custom JPanel class that draws a circle
    static class CirclePanel1 extends JPanel {
        private final Color color;

        public CirclePanel1(Color color) {
            this.color = color;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillOval(50, 50, 100, 100);
        }
    }

    static class CirclePanel2 extends JPanel {
        private final Color color;

        public CirclePanel2(Color color) {
            this.color = color;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillOval(100, 100, 100, 100);
        }
    }
}
