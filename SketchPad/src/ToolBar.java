
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
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

	private JButton blue, yellow, saveTool, savedTool1, savedTool2, savedTool3, savedTool4, savedTool5, savedTool6, eraser;
	private JSlider thickness;
	private int savedTools = 0;
	private JMenuBar myMenu;
	private Tool currentTool;
	private Tool[] tools = new Tool[6];
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
		
		savedTool1 = new JButton("Saved Tool 1");
		savedTool1.addActionListener(this);
		myMenu.add(savedTool1);
		
		savedTool2 = new JButton("Saved Tool 2");
		savedTool2.addActionListener(this);
		myMenu.add(savedTool2);
		
		savedTool3 = new JButton("Saved Tool 3");
		savedTool3.addActionListener(this);
		myMenu.add(savedTool3);
		
		savedTool4 = new JButton("Saved Tool 4");
		savedTool1.addActionListener(this);
		myMenu.add(savedTool4);
		
		savedTool5 = new JButton("Saved Tool 5");
		savedTool5.addActionListener(this);
		myMenu.add(savedTool5);
		
		savedTool6 = new JButton("Saved Tool 6");
		savedTool6.addActionListener(this);
		myMenu.add(savedTool6);
		
		saveTool = new JButton("Save");
		saveTool.addActionListener(this);
		myMenu.add(saveTool);
		
		eraser = new JButton("Eraser");
		eraser.addActionListener(this);
		myMenu.add(eraser);
		
		thickness = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
		thickness.addChangeListener(this);
		thickness.setMajorTickSpacing(10);
		thickness.setPaintTicks(true);
		thickness.setLabelTable(thickness.createStandardLabels(10));
		thickness.setPaintLabels(true);
		myMenu.add(thickness);
		
		
		currentTool = new Tool(Color.BLACK, 10);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton s = (JButton) e.getSource();
		if (s.getText().equals("Blue"))
			currentTool = new Tool(Color.BLUE, currentTool.getThickness());
		else if (s.getText().equals("Yellow")) {
			currentTool = new Tool(Color.YELLOW, currentTool.getThickness());
		}
		else if(s.getText().equals("Save")) {
			if(savedTools <=5) {
				tools[savedTools] = new Tool(currentTool.getColor(), currentTool.getThickness());
				savedTools++;
			}
			
		}
		else if(s.getText().equals("Saved Tool 1")) {
			if(tools[0]!=null)
			currentTool = tools[0];
		}
		else if(s.getText().equals("Saved Tool 2")) {
			if(tools[1]!=null)
			currentTool = tools[1];
		}
		else if(s.getText().equals("Saved Tool 3")) {
			if(tools[2]!=null)
			currentTool = tools[2];
		}
		else if(s.getText().equals("Saved Tool 4")) {
			if(tools[3]!=null)
			currentTool = tools[3];
		}
		else if(s.getText().equals("Saved Tool 5")) {
			if(tools[4]!=null)
			currentTool = tools[4];
		}
		else if(s.getText().equals("Saved Tool 6")) {
			if(tools[5]!=null)
			currentTool = tools[5];
		}
		else if(s.getText().equals("Eraser")) {
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
			currentTool= new Tool(currentTool.getColor(), thick);
		}
		
	}
}
