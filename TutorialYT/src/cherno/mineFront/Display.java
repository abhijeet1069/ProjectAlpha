package cherno.mineFront;

import javax.swing.*;

import cherno.mineFront.graphics.Render;
import cherno.mineFront.graphics.Screen;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Display extends Canvas implements Runnable{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "MineFront Pre-Alpha 0.01";

    private Thread thread; //only Display can use this private thread
    private boolean running = false;
    private Screen screen;
    private BufferedImage img;
    private Render render;
    private int[] pixels;
    
    public Display() {
    	this.screen = new Screen(this.WIDTH,this.HEIGHT);
    	img = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_RGB);
    	pixels =((DataBufferInt) img.getRaster().getDataBuffer()).getData();
    }

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
    	while(running) {
    		tick();
    		render();
    	}

    }
    
    private void tick() {
    	
    	
    }
    
    private void render() {
    	BufferStrategy bs = this.getBufferStrategy();
    	if(bs == null) {
    		createBufferStrategy(3); //create a 3d game
    		return;
    	}
    	screen.render();
    	
    	for(int i = 0; i < WIDTH*HEIGHT; i++) {
    		pixels[i] = screen.pixels[i];
    	}
    	
    	Graphics g = bs.getDrawGraphics();
    	g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
    	g.dispose();
    	bs.show();
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
