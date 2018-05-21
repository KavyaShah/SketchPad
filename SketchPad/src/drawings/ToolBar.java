package drawings;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.AbstractButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tutorials.TutorialWindow;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import javax.swing.JLabel;
import javax.swing.JMenu;


import javax.swing.JSlider;
/**
 * The menu bar at the top of the window. Has all of the options to modify the current drawing tool, 
 * save the drawing, import an image, or open a tutorial.
 * 
 * @author Kavya Shah
 * @version 5/16/18
 */
public class ToolBar implements ActionListener, ChangeListener {

	private JButton eraser;
	private JButton background, chooseColor, quickTool, clear;
	private JSlider thickness;
	private JMenuBar myMenu;
	private Tool currentTool;
	private Tool  previousTool;

	// @Override
	private DrawingSurface canvas;
	
	/**
	 * Creates a new ToolBar with the following menus: File (containing the Save and Import buttons), Thickness (Containing a slider for the thickness), Coloring Book (containing the coloring page options), and Tutorial(containing the tutorial options), 
	 * and the following buttons: Set Color, Set Background, Eraser, Previous Tool, and Clear All
	 * @param d The DrawingSurface the ToolBar is used for
	 */
	public ToolBar(DrawingSurface d) {
		
		canvas = d;
		currentTool = d.getCurrentTool();
		
		myMenu = new JMenuBar();


		JMenu fileMenu = new JMenu("File");

		JButton importButton = new JButton("Import");
		importButton.addActionListener(this);
		fileMenu.add(importButton);

		JButton save = new JButton("Save");
		save.addActionListener(this);
		fileMenu.add(save);

		myMenu.add(fileMenu);

		JMenu thicknessMenu = new JMenu("Thickness");
	
		thickness = new JSlider(JSlider.VERTICAL, 0, 50, 10);
		thickness.addChangeListener(this);
		thickness.setMajorTickSpacing(10);
		thickness.setPaintTicks(true);
		thickness.setLabelTable(thickness.createStandardLabels(10));
		thickness.setPaintLabels(true);
		thicknessMenu.add(thickness);
		myMenu.add(thicknessMenu);

		JMenu tutorial = new JMenu("Tutorials");
		JButton mickey = new JButton("Mickey");
		mickey.addActionListener(this);
		tutorial.add(mickey);
		JButton horse = new JButton("Horse");
		horse.addActionListener(this);
		tutorial.add(horse);
		JButton bird = new JButton("Bird");
		bird.addActionListener(this);
		tutorial.add(bird);
		myMenu.add(tutorial);
		
		JMenu coloringBook = new JMenu("Coloring Book");
		JButton flowerColor = new JButton("Flower");
		flowerColor.addActionListener(this);
		coloringBook.add(flowerColor);
		myMenu.add(coloringBook);
		
		eraser = new JButton("Eraser");
		eraser.addActionListener(this);
		myMenu.add(eraser);

		background = new JButton("Set Background");
		background.addActionListener(this);
		myMenu.add(background);

		chooseColor = new JButton("Choose Color");
		chooseColor.addActionListener(this);
		myMenu.add(chooseColor);
		
		quickTool = new JButton("Previous Tool");
		quickTool.addActionListener(this);
		myMenu.add(quickTool);
		
		clear = new JButton("Clear All");
		clear.addActionListener(this);
		myMenu.add(clear);
		
		previousTool = currentTool;
		myMenu.add(new JLabel("Use the backspace key to undo."));
		
		

		
	}
/**
 * Calls the appropriate function when a button is pressed
 * @param e The ActionEvent that occured
 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AbstractButton s = (AbstractButton) e.getSource();
		if (s.getText().equals("Choose Color")) 
		{
			Color out = JColorChooser.showDialog(null, "Choose a color!", null);
			if (out != null) 
			{
				previousTool = currentTool;
				currentTool = new Tool(out, currentTool.getThickness(), false);
			}
		}

		else if (s.getText().equals("Import")) {
			String workingDir = System.getProperty("user.dir");
			JFileChooser chooser = new JFileChooser(workingDir);
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				canvas.loadImg(chooser.getSelectedFile().getAbsolutePath());
			}
		}

		else if (s.getText().equals("Eraser")) {
			previousTool = currentTool;
			currentTool = new Tool(Color.WHITE, currentTool.getThickness(), true);
		} else if (s.getText().equals("Set Background")) {
			Color out = JColorChooser.showDialog(null, "Choose a color!", null);
			if (out != null) 
			{
				canvas.setBackground(out);
			}
		} else if (s.getText().equals("Save")) {
			JFileChooser chooser = new JFileChooser();
			int returnVal = chooser.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				canvas.saveImg(chooser.getSelectedFile().getAbsolutePath()+".jpg");
			}
		
		} else if(s.getText().equals("Previous Tool")) {
			Tool t = currentTool;
			currentTool = previousTool;
			previousTool = t;
			thickness.setValue(currentTool.getThickness());
		}
		else if(s.getText().equals("Horse")|| s.getText().equals("Mickey")||s.getText().equals("Bird")) {
			new TutorialWindow(s.getText());
		} else if(s.getText().equals("Flower")) {
			canvas.loadImg("coloringBook/flower.png");
		}else if(s.getText().equals("Clear All")) {
			canvas.clearAll();
		}
		setCurrentTool();
	}

	/**
	 * 
	 * @return the current Tool in ToolBar
	 */
	public Tool getCurrentTool() {
		return currentTool;
	}
/**
 * 
 * @return The JMenuBar that graphically represents the ToolBar
 */
	public JMenuBar getMenu() {
		return myMenu;
	}

	/**
	 * Updates the DrawingSurface's Tool with the changes made in ToolBar 
	 */
	public void setCurrentTool() {
		canvas.setCurrentTool(currentTool);
	}


	@Override
	/**
	 * Changes the thickness of the current tool when the slider is used
	 * @param e The ChangeEvent that occurred
	 */
	public void stateChanged(ChangeEvent e) {
		
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) 
		{
			previousTool = currentTool;
			int thick = (int)source.getValue();
			if(currentTool.isEraser()) {
				currentTool = new Tool(currentTool.getColor(), thick, true);
			}
			else 
			{
				currentTool = new Tool(currentTool.getColor(), thick, false);
			}
			
			
		}
		
		setCurrentTool();

	}


}
