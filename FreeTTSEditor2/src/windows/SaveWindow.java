package windows;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import actionlistener.ActionListenerExe;

public class SaveWindow extends ActionListenerExe {

	
	JTextField saveTF = new JTextField(20);
	JLabel fileNameL = new JLabel("File Name");
	JButton saveIt = new JButton("Save");
	JFrame windowSave = new JFrame("Save Document");
	
	public SaveWindow(WindowCreator window){
		//Creating the Save Document window				
		windowSave.setLayout(new FlowLayout()); 
		windowSave.add(fileNameL);
		windowSave.add(saveTF);
		windowSave.add(saveIt);
		windowSave.setSize(350,100);
		windowSave.setLocationRelativeTo(null);
		windowSave.setVisible(true);
		saveIt.addActionListener(saveFile(windowSave,saveTF,window.getMainText()));
		//
	}
}
