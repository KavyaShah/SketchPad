package drawings;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.*;  // for Point2D.Double
import java.util.ArrayList;      // for ArrayList

import processing.core.PApplet;	// for Processing

/**
 * Represents a single brushstroke made by the artist. 
 * Has an ArrayList of points to store the coordinates of the curved line drawn.
 * 
 * @author Rebecca Refaee
 * @version 5/16/18
 */
public class Layer extends Shape {
   private ArrayList <Point2D.Double> myPolygon; 
   private Tool toolUsed;
   
   // constructors
   public Layer() 
   {   
	   super(0,0);
	  
	   myPolygon = new ArrayList<Point2D.Double>();
   }
   
   public Layer(Point2D.Double startingPoint)
   {   
	   super(0,0);
	   myPolygon = new ArrayList<Point2D.Double>();
	   myPolygon.add(startingPoint);
   }
   
   /**
    * Saves the tool used to draw the layer.
    * @param t The tool used to draw the layer.
    */
   public void setToolUsed(Tool t)
   {
	   toolUsed = t;
   }
  
   
   // public methods
   /**
    * Adds a point to the layer.
    * @param aPoint the Point2D object to be added to the layer
    */
   public void add(Point2D.Double aPoint) 
   {
	   myPolygon.add(aPoint);
   }
   
   /**
    * Adds a point to the layer.
    * @param x The x-coordinate of the point to be added
    * @param y The y- coordinate of the point to be added
    */
   public void add(double x, double y)
   {
	   myPolygon.add(new Point2D.Double(x, y));
   }
   
   /**
    * Draws the layer to the screen.
    * @param marker The PApplet object needed for drawing
    */
   public void draw(PApplet marker) 
   {
	   marker.pushStyle();
	   float x1, x2 = 0, y1, y2 = 0;
	   marker.strokeWeight(toolUsed.getThickness());
	   marker.stroke(toolUsed.getColor().getRGB());
	   for (int i = 0; i < myPolygon.size() - 1; i++)
	   {
		   x1 = (float)myPolygon.get(i).x;
		   y1 = (float)myPolygon.get(i).y;
		   x2 = (float)myPolygon.get(i+1).x;
		   y2 = (float)myPolygon.get(i+1).y;
		   marker.line(x1, y1, x2, y2);
	   }
	   marker.popStyle();

   }
   
   /**
    * 
    * @return The tool used to draw the Layer.
    */
   public Tool getToolUsed() {
	   return toolUsed;
   }
   
   /**
    * Checks whether a specified point is within the layer.
    * @param x The x- coordinate of the point to be checked
    * @param y The y- coordinate of the point to be checked
    */
   public boolean isPointInside(double x, double y) 
   {
	   Polygon p = new Polygon();
	   for (int i = 0; i < myPolygon.size(); i++)
	   {
		   p.addPoint((int)(myPolygon.get(i).x), (int)(myPolygon.get(i).y));
	   }
	   if (p.contains(x, y))
		   return true;
	   else
		   return false;
   }
 
}
