
import java.awt.Color;

import processing.core.PApplet;

public class Tool
{
	private Color color;
	private int thickness;
	
	public Tool(Color c, int t)
	{
		color = c;
		thickness = t;
	}
	
	public Tool(int r, int g, int b, int t)
	{
		color = new Color(r, g, b);
		thickness = t;
	}

	public Tool()
	{
		color = new Color(50, 50, 50);
		thickness = 10;
	}

	public void setColor(Color c)
	{
		color = c;
	}

	public Color getColor()
	{
		return color;
	}

	public void setThickness(int t)
	{
		thickness = t;
	}

	public int getThickness()
	{
		return thickness;
	}

}