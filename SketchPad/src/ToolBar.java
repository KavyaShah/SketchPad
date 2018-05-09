
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;

public class ToolBar implements ActionListener, ChangeListener {

	private JRadioButton blue, navy, green, yellow, red, pink, savedTool1, savedTool2, savedTool3, savedTool4,
			savedTool5, savedTool6;
	private JButton saveTool, eraser;
	private JSlider thickness;
	private int savedTools = 0;
	private JMenuBar myMenu;
	private Tool currentTool;
	private Tool[] tools = new Tool[6];
	// @Override

	public ToolBar() {

		myMenu = new JMenuBar();
		
		JToolBar colorsBar = new JToolBar(JToolBar.VERTICAL);
		ButtonGroup colorButtons = new ButtonGroup();

		navy = new JRadioButton("Navy Blue");
		navy.addActionListener(this);
		colorButtons.add(navy);
		colorsBar.add(navy);

		blue = new JRadioButton("Sky Blue");
		blue.addActionListener(this);
		colorButtons.add(blue);
		colorsBar.add(blue);
		
		green = new JRadioButton("Green");
		green.addActionListener(this);
		colorButtons.add(green);
		colorsBar.add(green);

		yellow = new JRadioButton("Yellow");
		yellow.addActionListener(this);
		colorButtons.add(yellow);
		colorsBar.add(yellow);

		red = new JRadioButton("Red");
		red.addActionListener(this);
		colorButtons.add(red);
		colorsBar.add(red);

		pink = new JRadioButton("Pink");
		pink.addActionListener(this);
		colorButtons.add(pink);
		colorsBar.add(pink);
		colorsBar.add(Box.createVerticalGlue());

		colorsBar.add(new JLabel("Colors"));
		myMenu.add(colorsBar);

		JToolBar savedToolBar = new JToolBar(JToolBar.VERTICAL);
		ButtonGroup savedTools = new ButtonGroup();

		savedTool1 = new JRadioButton("Saved Tool 1");
		savedTool1.addActionListener(this);
		savedTools.add(savedTool1);
		savedToolBar.add(savedTool1);

		savedTool2 = new JRadioButton("Saved Tool 2");
		savedTool2.addActionListener(this);
		savedToolBar.add(savedTool2);
		savedTools.add(savedTool2);

		savedTool3 = new JRadioButton("Saved Tool 3");
		savedTool3.addActionListener(this);
		savedToolBar.add(savedTool3);
		savedTools.add(savedTool3);

		savedTool4 = new JRadioButton("Saved Tool 4");
		savedTool1.addActionListener(this);
		savedToolBar.add(savedTool4);
		savedTools.add(savedTool4);

		savedTool5 = new JRadioButton("Saved Tool 5");
		savedTool5.addActionListener(this);
		savedToolBar.add(savedTool5);
		savedTools.add(savedTool5);

		savedTool6 = new JRadioButton("Saved Tool 6");
		savedTool6.addActionListener(this);
		savedToolBar.add(savedTool6);
		savedTools.add(savedTool6);
		
		savedToolBar.add(Box.createVerticalGlue());
		myMenu.add(savedToolBar);
		savedToolBar.add(new JLabel("Saved Tools"));
	

		thickness = new JSlider(JSlider.VERTICAL, 0, 50, 25);
		thickness.addChangeListener(this);
		thickness.setMajorTickSpacing(10);
		thickness.setPaintTicks(true);
		thickness.setLabelTable(thickness.createStandardLabels(10));
		thickness.setPaintLabels(true);
		myMenu.add(thickness);

		
		eraser = new JButton("Eraser");
		eraser.addActionListener(this);
		myMenu.add(eraser);

		saveTool = new JButton("Save");
		saveTool.addActionListener(this);
		myMenu.add(saveTool);

		myMenu.add(new JLabel("Tools"));
		
		currentTool = new Tool(Color.BLACK, 10);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AbstractButton s = (AbstractButton) e.getSource();
		if (s.getText().equals("Sky Blue"))
			currentTool = new Tool(Color.CYAN, currentTool.getThickness());
		else if (s.getText().equals("Yellow")) {
			currentTool = new Tool(Color.YELLOW, currentTool.getThickness());
		} else if (s.getText().equals("Red")) {
			currentTool = new Tool(Color.RED, currentTool.getThickness());
		} else if (s.getText().equals("Pink")) {
			currentTool = new Tool(Color.MAGENTA, currentTool.getThickness());
		} else if (s.getText().equals("Navy Blue")) {
			currentTool = new Tool(Color.BLUE, currentTool.getThickness());
		} else if (s.getText().equals("Green")) {
			currentTool = new Tool(Color.GREEN, currentTool.getThickness());
		} else if (s.getText().equals("Save")) {
			if (savedTools <= 5) {
				tools[savedTools] = new Tool(currentTool.getColor(), currentTool.getThickness());
				savedTools++;
			}

		} else if (s.getText().equals("Saved Tool 1")) {
			if (tools[0] != null)
				currentTool = tools[0];
		} else if (s.getText().equals("Saved Tool 2")) {
			if (tools[1] != null)
				currentTool = tools[1];
		} else if (s.getText().equals("Saved Tool 3")) {
			if (tools[2] != null)
				currentTool = tools[2];
		} else if (s.getText().equals("Saved Tool 4")) {
			if (tools[3] != null)
				currentTool = tools[3];
		} else if (s.getText().equals("Saved Tool 5")) {
			if (tools[4] != null)
				currentTool = tools[4];
		} else if (s.getText().equals("Saved Tool 6")) {
			if (tools[5] != null)
				currentTool = tools[5];
		} else if (s.getText().equals("Eraser")) {
			currentTool = new Tool(Color.WHITE, currentTool.getThickness());
		}

	}

	public Tool getCurrentTool() {
		return currentTool;
	}

	public JMenuBar getMenu() {
		return myMenu;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			int thick = (int) source.getValue();
			currentTool = new Tool(currentTool.getColor(), thick);
		}

	}
}
