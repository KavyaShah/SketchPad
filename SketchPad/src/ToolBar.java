
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ToolBar implements ActionListener, ChangeListener {

	JButton blue, yellow;
	JSlider thickness;
	JMenuBar myMenu;
	Tool currentTool;
	Tool[] tools = new Tool[6];
	// @Override

	public ToolBar() {

		myMenu = new JMenuBar();

		myMenu.setLayout(new BoxLayout(myMenu, BoxLayout.PAGE_AXIS));

		blue = new JButton("Blue");
		blue.addActionListener(this);
		myMenu.add(blue);

		yellow = new JButton("Yellow");
		yellow.addActionListener(this);
		myMenu.add(yellow);
		thickness = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
		thickness.addChangeListener(this);
		thickness.setMajorTickSpacing(10);
		thickness.setPaintTicks(true);
		thickness.setLabelTable(thickness.createStandardLabels(10));
		thickness.setPaintLabels(true);

		myMenu.add(thickness);
		currentTool = new Tool(Color.RED, 10);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton s = (JButton) e.getSource();
		if (s.getText().equals("Blue"))
			currentTool = new Tool(Color.BLUE, 10);
		else if (s.getText().equals("Yellow"))
			currentTool = new Tool(Color.YELLOW, 10);

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
			currentTool= new Tool(currentTool.getColor(), thick);
		}
		
	}
}
