package choobTutorial;

import javax.swing.*;

public class DrawingTester {
    public static void main(String[] args) {
        int width = 800;
        int height = 600;
        JFrame frame = new JFrame();
        DrawingCanvas dc = new DrawingCanvas(width,height);
        frame.setSize(width,height);
        frame.setTitle("Drawing in JAVA");
        frame.add(dc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}