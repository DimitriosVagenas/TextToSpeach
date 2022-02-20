package windows;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import actionlistener.ActionListenerExe;

public class OpenWindow extends ActionListenerExe {

	
	private JFrame windowOpen = new JFrame("Open Document");
	private JButton openIt = new JButton("Files..."); //Button for browsing
	private JButton openThis = new JButton("Open"); //Button for opening specific Document
	private JTextField pathing = new JTextField(25);
	
	public OpenWindow(WindowCreator window){
		//Creating the Open Document window
		
		windowOpen.setLayout(new FlowLayout()); 
		windowOpen.add(pathing);
		windowOpen.add(openThis);
		windowOpen.add(openIt);
		windowOpen.setSize(400,100);
		windowOpen.setLocationRelativeTo(null);
		windowOpen.setVisible(true);
		openIt.addActionListener(openFile(windowOpen,window.getMainText()));
		openThis.addActionListener(openSpecFile(windowOpen,window.getMainText(),pathing));
		//
	}
}

