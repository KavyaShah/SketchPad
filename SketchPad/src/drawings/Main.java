package drawings;

import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;

public class Main  {

	public static void main(String args[]) {

		DrawingSurface drawing = new DrawingSurface();
		ToolBar tools = new ToolBar(drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		
		JFrame window = (JFrame) canvas.getFrame();

		
		
		window.setSize(1200, 700);
		window.setMinimumSize(new Dimension(100, 100));
		
	
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setJMenuBar(tools.getMenu());
		window.setTitle("Artist's Studio");
		window.setVisible(true);

	}


	

}
