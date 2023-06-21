package force;

import vector.Vector;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Bouncing Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Mover ball = new Mover();
        frame.add(ball);
        frame.setSize(400, 400);
        frame.setVisible(true);
        Vector wind = new Vector(0.1f,0,0);
        Vector gravity = new Vector(0,0.1f,0);

        while (true) {
            ball.applyForce(wind);
            ball.applyForce(gravity);
            ball.update();
            ball.checkEdges();
            ball.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
