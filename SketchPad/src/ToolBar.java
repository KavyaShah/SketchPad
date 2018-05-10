
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

	private JRadioButton savedTool1, savedTool2, savedTool3, savedTool4,
			savedTool5, savedTool6, eraser;
	private JButton blue, navy, green, yellow, red, pink;
	JButton[][]colors = new JButton[7][7];
	private JButton saveTool;
	private JSlider thickness;
	private int savedTools = 0;
	private JMenuBar myMenu;
	private Tool currentTool;
	private Tool[] tools = new Tool[6];
	// @Override

	public ToolBar() {

		myMenu = new JMenuBar();
		
		/*JToolBar colorsBar = new JToolBar(JToolBar.VERTICAL);
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
		myMenu.add(colorsBar);*/

		
		ButtonGroup colorButtons = new ButtonGroup();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,3));
		navy = new JButton("Navy Blue");
		navy.addActionListener(this);
		colorButtons.add(navy);
		colors[0][0] = navy;
		panel.add(navy);

		blue = new JButton("Sky Blue");
		blue.addActionListener(this);
		colorButtons.add(blue);
		colors[0][1] = blue;
		panel.add(blue);
		
		green = new JButton("Green");
		green.addActionListener(this);
		colorButtons.add(green);
		colors[0][2] = green;
		panel.add(green);

		yellow = new JButton("Yellow");
		yellow.addActionListener(this);
		colorButtons.add(yellow);
		colors[1][0] = yellow;
		panel.add(yellow);
		
		red = new JButton("Red");
		red.addActionListener(this);
		colorButtons.add(red);
		colors[2][0] = red;
		panel.add(red);
		
		pink = new JButton("Pink");
		pink.addActionListener(this);
		colorButtons.add(pink);
		colors[3][0] = pink;
		panel.add(pink);
		
		
		//colorsBar.add(Box.createVerticalGlue());

		//colorsBar.add(new JLabel("Colors"));
	
		myMenu.add(panel);
		
		JToolBar savedToolBar = new JToolBar(JToolBar.VERTICAL);
		

		savedTool1 = new JRadioButton("Saved Tool 1");
		savedTool1.addActionListener(this);
		colorButtons.add(savedTool1);
		savedToolBar.add(savedTool1);

		savedTool2 = new JRadioButton("Saved Tool 2");
		savedTool2.addActionListener(this);
		savedToolBar.add(savedTool2);
		colorButtons.add(savedTool2);

		savedTool3 = new JRadioButton("Saved Tool 3");
		savedTool3.addActionListener(this);
		savedToolBar.add(savedTool3);
		colorButtons.add(savedTool3);

		savedTool4 = new JRadioButton("Saved Tool 4");
		savedTool1.addActionListener(this);
		savedToolBar.add(savedTool4);
		colorButtons.add(savedTool4);

		savedTool5 = new JRadioButton("Saved Tool 5");
		savedTool5.addActionListener(this);
		savedToolBar.add(savedTool5);
		colorButtons.add(savedTool5);

		savedTool6 = new JRadioButton("Saved Tool 6");
		savedTool6.addActionListener(this);
		savedToolBar.add(savedTool6);
		colorButtons.add(savedTool6);
		
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

		
		eraser = new JRadioButton("Eraser");
		eraser.addActionListener(this);
		colorButtons.add(eraser);
		myMenu.add(eraser);

		saveTool = new JButton("Save Tool");
		saveTool.addActionListener(this);
		myMenu.add(saveTool);

		
		
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
		} else if (s.getText().equals("Save Tool")) {
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
