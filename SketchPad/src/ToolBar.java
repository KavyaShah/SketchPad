import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener{

	
	private JButton color, size;
	Tool[] tools;
	//@Override
	
	public ToolBar() {
		setBackground(Color.WHITE);
		color = new JButton("Color");
		color.addActionListener(this);
		size = new JButton("Size");
		size.addActionListener(this);
		JPanel buttons = new JPanel(new GridLayout(3, 1, 5, 0));
	    buttons.setBackground(Color.BLUE);
	    buttons.add(color);
	    buttons.add(size);
	   

	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton)e.getSource();
		if(b== color) {
			tools[0] = new Tool(Color.BLUE, 10);
		}
		repaint();
	}
	public Tool getCurrentTool() {
		return tools[0];
	}
}
