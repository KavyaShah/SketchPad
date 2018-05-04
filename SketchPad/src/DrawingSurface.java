
import java.util.ArrayList;

import processing.core.PApplet;



public class DrawingSurface extends PApplet {

	private ArrayList<Layer> poly;
	private ArrayList <Tool> tools;
	
	private int ANIMATION_TIME = 100;
	private float x,y,time;
	
	public DrawingSurface() 
	{
		tools = new ArrayList<Tool>();
		tools.add(new Tool(0, 100, 100, 10));
		tools.add(new Tool(100, 20, 100, 10));
		tools.add(new Tool(200, 100, 40, 10));
		tools.add(new Tool(30, 250, 60, 10));
		tools.add(new Tool(70, 180, 100, 10));
		tools.add(new Tool(80, 60, 80, 10));

		poly = new ArrayList<Layer>();
		poly.add(new Layer());
		poly.get(poly.size()-1).setToolUsed(tools.get(0));
		runSketch();
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		background(255);   // Clear the screen with a white background
		//size(0,0,PApplet.P3D);
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() 
	{
		background(255);   // Clear the screen with a white background
		fill(255);
		textAlign(CENTER);
		//textSize(12);0
		
		for (Layer i: poly)
		{
			i.draw(this);
		}
	
		stroke(0);
		strokeWeight(40);

			
	}
	
	public void mouseDragged() {
		if (mouseButton == LEFT) {
			poly.get(poly.size() -1).add(mouseX,mouseY);
			x = mouseX;
			y = mouseY;
			time = ANIMATION_TIME;
		} 
	}
	
	public void mouseReleased() 
	{
		poly.add(new Layer());
		poly.get(poly.size()-1).setToolUsed(tools.get((int)(Math.random()*6)));
	}
	
	public void keyPressed() {
		poly.remove(poly.size()-2);		
		poly.remove(poly.size()-1);
		poly.add(new Layer());
		poly.get(poly.size()-1).setToolUsed(tools.get(0));
	}

}



