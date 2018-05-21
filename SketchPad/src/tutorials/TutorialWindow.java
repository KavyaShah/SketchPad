package tutorials;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import processing.awt.PSurfaceAWT;
import processing.core.PImage;

/**
 * 
 * The window that contains a tutorial. Opens when the appropriate button is pressed in ToolBar.
 * @author Kavya Shah
 * @version 5/18/18
 */
public class TutorialWindow implements ActionListener{

	String name;
	
	Tutorial tutorial;
	public TutorialWindow(String name) {
	
	if(name.equals("Mickey")) {
		tutorial = new MickeyTutorial();
	} else if(name.equals("Horse")) {
		tutorial = new HorseTutorial();
	} else if(name.equals("Bird")) {
		tutorial = new ParakeetTutorial();
	}
	
	PSurfaceAWT surf = (PSurfaceAWT) tutorial.getSurface();
	PSurfaceAWT.SmoothCanvas canvas  = (PSurfaceAWT.SmoothCanvas) surf.getNative();
	
	JFrame window = new JFrame();
	window.add(canvas);
	
	
	window.setSize(600, 350);
	window.setMinimumSize(new Dimension(100, 100));

	
	window.addComponentListener(new ComponentAdapter() {
		public void componentResized(ComponentEvent arg0) 
		{
			Component x = (Component)arg0.getSource();
			surf.setSize(x.getWidth(),x.getHeight());
			

		}
		});

	window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	window.setResizable(true);
	JMenuBar menu = new JMenuBar();
	JButton previous = new JButton("Previous");
	previous.addActionListener(this);
	menu.add(previous);
	JButton next = new JButton("Next");
	next.addActionListener(this);
	menu.add(next);
	window.setJMenuBar(menu);
	window.setTitle(name);
	window.setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractButton s = (AbstractButton) e.getSource();
		if(s.getText().equals("Next")) {
			tutorial.showNextStep();
		} else if(s.getText().equals("Previous")) {
			tutorial.showPreviousStep();
		}
		
		
		
	}
}
