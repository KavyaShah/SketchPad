package tutorials;
import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
/**
 * The class that represents the tutorial showing inside the tutorial window. Contains methods to display previous and next steps.
 * 
 * @author Kavya Shah
 * @version 5/18/18
 */
public class Tutorial extends PApplet {
	private ArrayList<String> steps;
	private ArrayList<PImage> stepImages = new ArrayList<PImage>();
	String name;
	private int currentStep = 0;
	PImage img;
	
	/**
	 * Creates a tutorial with the specified image file paths as steps
	 * @param s The list of image file paths that show steps of a tutorial. 
	 */
	public Tutorial(ArrayList<String> s) {
		steps = s;
		super.sketchPath();
		super.initSurface();
		super.surface.startThread();
		
	}
	public void setup() {
		toPImage();
		img = stepImages.get(currentStep);
	}
	
	/**
	 * Converts a list of image file paths to a list of PImages
	 * 
	 * 	 */
	private void toPImage() {
		for(String s: steps) {
			stepImages.add((loadImage(s)));
		}
	}
	
	/**
	 * Draws the tutorial to the screen.
	 */
	public void draw() {
		img.resize(width, height);
		image(img,0,0);
		
		
	}
	/**
	 * Displays the image containing the next step in a tutorial.
	 */
	public void showNextStep() {
		if(currentStep<stepImages.size()-1) {
			currentStep++;
			img = stepImages.get(currentStep);
		}
		
		
	}
	/** 
	 * Displays the image containing the previous step in a tutorial.
	 */
	public void showPreviousStep() {
		if(currentStep>0) {
			currentStep--;
			img = stepImages.get(currentStep);
		}
	}
}
