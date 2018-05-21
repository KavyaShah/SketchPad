package drawings;

import java.awt.Color;

import processing.core.PApplet;
/**
 * Represents a drawing tool with values for color and line thickness
 * 
 * @author Rebecca Refaee
 * @version 5/16/18
 */
public class Tool
{
	private Color color;
	private int thickness;
	private boolean isEraser;
	
	/**
	 * Creates a new Tool object with a specified Color and thickness
	 * @param c The Color object that represents the color of the Tool.
	 * @param t The thickness of the Tool in pixels
	 * @param eraser True if the Tool is an eraser
	 */
	public Tool(Color c, int t, boolean eraser)
	{
		isEraser = eraser;
		color = c;
		thickness = t;
	}
	
	/**
	 * Creates a new Tool object with the specified color and thickness
	 * @param r The red value for the Tool's color
	 * @param g The green value for the Tool's color
	 * @param b The blue value for the Tool's color
	 * @param t The thickness of the Tool in pixels
	 */
	public Tool(int r, int g, int b, int t)
	{
		color = new Color(r, g, b);
		thickness = t;
	}
	/**
	 * 
	 * @return True if this Tool is an eraser
	 */
	public boolean isEraser() {
		return isEraser;
	}

	/**
	 * Creates a new Tool with black as the default color and 10 pixels as the default thickness
	 */
	public Tool()
	{
		color = new Color(50, 50, 50);
		thickness = 10;
	}

	/**
	 * Sets the Tool's color to the specified color
	 * @param c The Color object that represents the Color to set the Tool to
	 */
	public void setColor(Color c)
	{
		color = c;
	}

	/**
	 * 
	 * @return The current Color object that represents the color of this Tool
	 */
	public Color getColor()
	{
		return color;
	}
/**
 * Sets the Tool's thickness to the specified value.
 * @param t The thickness the Tool should be in pixels
 */
	public void setThickness(int t)
	{
		thickness = t;
	}
/**
 * 
 * @return The current thickness of the Tool in pixels
 */
	public int getThickness()
	{
		return thickness;
	}

}