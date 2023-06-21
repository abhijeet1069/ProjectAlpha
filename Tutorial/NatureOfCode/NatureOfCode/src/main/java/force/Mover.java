package force;

import javax.swing.*;
import javax.swing.table.TableCellEditor;

import vector.BouncingBall;
import vector.Vector;

import java.awt.*;

public class Mover extends JPanel{
    Vector position = new Vector(30,30,0);
    Vector velocity = new Vector(0,0,0);
    Vector acceleration = new Vector(0,0,0);
    int mass = 1;
    int radius = 50;
    static Mover ball;
    void applyForce(Vector force){
        force.mult(1/mass); //F=ma , a = F/m
        acceleration.add(force);
    }
    void checkEdges() {
        if (position.x > getWidth()) {
            position.x = getWidth();
            velocity.x *= -1;
        } else if (position.x < 0) {
            velocity.x *= -1;
            position.x = 0;
        }

        if (position.y > getHeight()) {
            velocity.y *= -1;
            position.y = getHeight();
        }
    }

    void update(){
        velocity.add(acceleration);
        position.add(velocity);
        acceleration.mult(0);
    }

    protected void paintComponent(Graphics g) { //display()
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval((int) position.x, (int) position.y, radius, radius);
    }
}
