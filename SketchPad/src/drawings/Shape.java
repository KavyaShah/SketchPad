package drawings;

import java.awt.Color;

import processing.core.PApplet;

/**
 * This abstract class models a shape and can be extended to model
 * more specific types of shapes.
 * @author Rebecca Refaee
 * @version Last edited 10/1/17
 */
public abstract class Shape {
	
	/**
	 * The x-coordinate of the point the Shape is based off of
	 */
	protected double x;
	
	/**
	 * The y-coordinate of the point the Shape is based off of
	 */
	protected double y;
	private int strokeWidth;
	private Color strokeColor;
	
	/**
	 * Creates a Shape at the point (x, y) with a 1-pixel wide black outline 
	 * @param x The x-coordinate of the point the Shape is based off of
	 * @param y The y-coordinate of the point the Shape is based off of
	 */
	public Shape(double x, double y)
	{
		this.x = x;
		this.y = y;
		strokeWidth = 1;
		strokeColor = new Color(0);
	}
	
	public Shape() {}
	/**
     * Determines whether the point (x, y) is contained inside this Shape
     * @param x The x-coordinate of the point being tested
     * @param y The y-coordinate of the point being tested
     * @return True if the point is inside the Shape; false otherwise
     */
	public abstract boolean isPointInside(double x, double y);

	/**
	 * Sets the color of the outline of the Shape to the Color passed in
	 * @param c The Color the stroke will be set to
	 */
	public void setStrokeColor(Color c)
	{
		strokeColor = c;
	}
	
	/**
	 * Sets the width of the outline of the Shape to the int passed in
	 * @param w This number is used as the pixel width of the stroke
	 */
	public void setOutlineWidth(int w)
	{
		strokeWidth = w;
	}
	
	/**
     * Draws this Shape on the screen with the dimensions and location specified before 
     * @param drawer Draws the Shape
     * @pre The settings of the PApplet that are applied previously by the setOutineWidth and setStrokeColor methods
     * affect the drawing of this Shape. If these methods have not been called, the outline of the Shape will be black and one pixel wide
     * @post The settings of drawer are changed to those previously specified by the setOutineWidth and setStrokeColor 
     * methods or to the default values (black outline 1 pixel wide)
     */
	public void draw(PApplet drawer)
	{
		drawer.stroke(strokeColor.getRGB());
		drawer.strokeWeight(strokeWidth);
	}
	
	/**
	 * Translates the Shape to (x, y)
	 * @param x The new x-coordinate of the Shape
	 * @param y The new y-coordinate of the Shape
	 */
	public void move(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Sets the x-coordinate of the Shape to the double passed in
	 * @param x The value the x-coordinate of the Shape is set to
	 */
	public void setX(double x)
	{
		this.x = x;
	}
	
	/**
	 * Sets the y-coordinate of the Shape to the double passed in
	 * @param y The value the y-coordinate of the Shape is set to
	 */
	public void setY(double y)
	{
		this.y = y;
	}
	
	/**
	 * Returns the x-coordinate of the Shape
	 * @return The value of the x-coordinate of the Shape 
	 */
	public double getX()
	{
		return x;
	}
	
	/**
	 * Returns the y-coordinate of the Shape
	 * @return The value of the y-coordinate of the Shape 
	 */
	public double getY()
	{
		return y;
	}
	
	/**
	 * Adds x to the x-coordinate of the Shape and y to the y-coordinate, moving the Shape x units horizontally and y units vertically
	 * @param x The value added to the x-coordinate of the Shape
	 * @param y The value added to the y-coordinate of the Shape
	 */
	public void moveBy(double x, double y)
	{
		this.x += x;
		this.y += y;
	}
}  