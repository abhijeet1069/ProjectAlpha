package com.example.javafxdemo;

/*
Stage, Scene, Scene-Graph(Root-Node, Branch-Node, Leaf Node)
* */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BALL_RADIUS = 20;
    private static int BALL_SPEED_X = 2;
    private static int BALL_SPEED_Y = 3;


    @Override
    public void start(Stage primaryStage) {
        Circle ball = new Circle(BALL_RADIUS, Color.BLUE);
        ball.relocate(WIDTH / 2, HEIGHT / 2);

        Pane root = new Pane(ball);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle("Bouncing Ball");
        primaryStage.setScene(scene);
        primaryStage.show();

        animateBall(ball);
    }

    private void animateBall(Circle ball) {
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(16), event -> {
            // Move the ball
            ball.setLayoutX(ball.getLayoutX() + BALL_SPEED_X);
            ball.setLayoutY(ball.getLayoutY() + BALL_SPEED_Y);

            // Check boundaries and bounce
            if (ball.getLayoutX() <= 0 || ball.getLayoutX() >= WIDTH) {
                BALL_SPEED_X = -BALL_SPEED_X; // Reverse horizontal direction
            }
            if (ball.getLayoutY() <= 0 || ball.getLayoutY() >= HEIGHT) {
                BALL_SPEED_Y = -BALL_SPEED_Y; // Reverse vertical direction
            }
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}