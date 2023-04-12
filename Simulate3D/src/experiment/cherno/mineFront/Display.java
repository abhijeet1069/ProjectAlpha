package experiment.cherno.mineFront;

import javax.swing.*;
import java.awt.*;

public class Display extends Canvas implements Runnable{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "MineFront Pre-Alpha 0.01";

    private Thread thread; //only Display can use this private thread
    private boolean running = false;


    private void start(){
        if(running){
            return; //if game is already running don't reinitialize the game
        }
        running = true;
        thread = new Thread(this);
        thread.start();
        System.out.println("Working!");
    }

    private void stop(){
        if(!running){
            return; //if not running get out of this method
        }
        running = false;
        try{
            thread.join(); //stop the thread. If couldn't stop then throw exception
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void run() {

    }

    public static void main(String[] args) {
        Display game = new Display();
        JFrame frame = new JFrame();
        frame.add(game);
        frame.pack(); //for centering frame to middle of screen
        frame.setTitle(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        System.out.println("Running..");
        game.start();
    }


}
