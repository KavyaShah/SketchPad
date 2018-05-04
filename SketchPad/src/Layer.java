import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.*;  // for Point2D.Double
import java.util.ArrayList;      // for ArrayList
import processing.core.PApplet;	// for Processing

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
   
   public void setToolUsed(Tool t)
   {
	   toolUsed = t;
   }
   
   // public methods
   public void add(Point2D.Double aPoint) 
   {
	   myPolygon.add(aPoint);
   }
   
   public void add(double x, double y)
   {
	   myPolygon.add(new Point2D.Double(x, y));
   }
   
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
