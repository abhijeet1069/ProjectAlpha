package vector;

import javax.swing.*;
import java.awt.*;

public class BouncingBall extends JPanel {
    Vector location = new Vector(0,0,0);
    Vector velocity = new Vector(2,5,0);

    private void moveBall() {
        if (location.x + velocity.x < 0 || location.x + velocity.x > getWidth() - 50) {
            velocity.x = -velocity.x;
        }
        if (location.y + velocity.y < 0 || location.y + velocity.y > getHeight() - 50) {
            velocity.y = -velocity.y;
        }

        location.add(velocity);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval((int) location.x, (int) location.y, 50, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BouncingBall ball = new BouncingBall();
        frame.add(ball);
        frame.setSize(400, 400);
        frame.setVisible(true);

        while (true) {
            ball.moveBall();
            ball.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


