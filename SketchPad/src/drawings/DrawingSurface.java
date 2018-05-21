package drawings;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class DrawingSurface extends PApplet {

	private ArrayList<Layer> poly;
	// private ToolBar t;
	private Color background;
	private Tool currentTool;
	private String save = null;
	private PImage img;
	private boolean add;
	
	/**
	 * Represents a canvas for the artist to draw on
	 * Saves all of the brushstrokes
	 * 
	 * @author Rebecca Refaee
	 * @version 5/16/18
	 */
	public DrawingSurface() {
		// this.t = t;
		poly = new ArrayList<Layer>();
		poly.add(new Layer());
		currentTool = new Tool(Color.BLACK, 10, false);
		background = Color.WHITE;
		// background = t.getBackground();

		runSketch();
	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {
		poly.get(poly.size() - 1).setToolUsed(currentTool);
		background(background.getRGB());
		

		// Clear the screen with a white background
		// size(0,0,PApplet.P3D);
	}
	
	public void saveImg(String fileName) {
		save = fileName;
	}

	public void loadImg(String fileName) {
		img = loadImage(fileName);
		
	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	/**
	 * Draws the shapes to the screen.
	 */
	public void draw() {
		background(background.getRGB()); // Clear the screen with a white background
		fill(255);
		textAlign(CENTER);
		// textSize(12);0
		
		if (img != null) {
			img.resize(width, height);
			image(img,0,0);
			//image(img, 0, 0);
		
		}
		for (Layer i : poly) {
			if(i.getToolUsed().isEraser()) 
			{
				i.getToolUsed().setColor(background);
			}
			i.draw(this);
		}
		
		if (save != null) {
			save(save);
			save = null;
		}
		

		stroke(0);
		strokeWeight(40);

	}

	public void mouseDragged() {
		if (mouseButton == LEFT) {
			poly.get(poly.size() - 1).setToolUsed(currentTool);
			if(add) {
				poly.get(poly.size() - 1).add(mouseX, mouseY);
			}
			add = !add;
			
		}

	}

	public void mouseReleased() {
		poly.add(new Layer());
		poly.get(poly.size() - 1).setToolUsed(currentTool);
	}

	

	public void keyPressed() {
		if(key == BACKSPACE) {
			if(poly.size()>=2) {
				poly.remove(poly.size() - 2);
				poly.remove(poly.size() - 1);
				poly.add(new Layer());
				poly.get(poly.size() - 1).setToolUsed(currentTool);
			}
		}
		
		
	}

	public void setCurrentTool(Tool ct) {
		currentTool = ct;

	}

	public Color getBackground() {
		return background;
	}
	public void setBackground(Color newBackground) {
		background = newBackground;
	}
	public Tool getCurrentTool() {
		return currentTool;
	}
	public void clearAll() {
		background = Color.WHITE;
		poly = new ArrayList<Layer>();
		poly.add(new Layer());
		img = null;
		poly.get(poly.size() - 1).setToolUsed(currentTool);
		
	}

}
