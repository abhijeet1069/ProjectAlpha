package cherno.mineFront;

import javax.swing.*;

import cherno.mineFront.graphics.Render;
import cherno.mineFront.graphics.Screen;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Display extends Canvas implements Runnable{
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static final String TITLE = "MineFront Pre-Alpha 0.02";

    private Thread thread; //only Display can use this private thread
    private boolean running = false;
    private Screen screen;
    private Game game;
    private BufferedImage img;
    private Render render;
    private int[] pixels;
    
    public Display() {
    	Dimension size = new Dimension(WIDTH,HEIGHT);
    	setPreferredSize(size);
    	setMinimumSize(size);
    	setMaximumSize(size);
    	screen = new Screen(this.WIDTH,this.HEIGHT);
    	game = new Game();
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
    	int frames = 0;
    	double unprocessedSeconds = 0;
    	long previousTime = System.nanoTime();
    	double secondsPerTick = 1/60.0;
    	int tickCount = 0;
    	boolean ticked = false;
    	while(running) {
    		long currentTime = System.nanoTime();
    		long passedTime = currentTime - previousTime;
    		previousTime = currentTime;
    		unprocessedSeconds += passedTime/1_000_000_000.0;
    		
    		while(unprocessedSeconds > secondsPerTick) {
    			tick();
    			unprocessedSeconds -= secondsPerTick;
    			tickCount++;
    			if(tickCount%60 == 0) {
    				System.out.println(frames +" fps");
    				previousTime += 1000;
    				frames = 0;
    			}
    		}
    		if(ticked) {
    			render();
    			frames++;
    		}
    		render();
    		frames++;
    	}

    }
    
    private void tick() {
    	game.tick();
    	
    }
    
    private void render() {
    	BufferStrategy bs = this.getBufferStrategy();
    	if(bs == null) {
    		createBufferStrategy(3); //create a 3d game
    		return;
    	}
    	screen.render(game);
    	
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
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        System.out.println("Running..");
        game.start();
    }


}
