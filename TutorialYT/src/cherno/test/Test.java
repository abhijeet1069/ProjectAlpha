package cherno.test;

import java.awt.Canvas;
import java.awt.image.BufferStrategy;

public class Test extends Canvas{
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		//screen.render();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		
	}
}
