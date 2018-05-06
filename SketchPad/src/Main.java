
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import processing.awt.PSurfaceAWT;

public class Main  {

	public static void main(String args[]) {

		
		ToolBar tools = new ToolBar();
		DrawingSurface drawing = new DrawingSurface(tools);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		
		JFrame window = (JFrame) canvas.getFrame();

		
		
		window.setSize(600, 500);
		window.setMinimumSize(new Dimension(100, 100));
		
	
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setJMenuBar(tools.getMenu());
		
		window.setVisible(true);

	}


	

}
