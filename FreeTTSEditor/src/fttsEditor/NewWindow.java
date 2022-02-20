package fttsEditor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewWindow extends ActionListenerExe{

	
	private JFrame windowCreate = new JFrame("Create Document");
	private JTextField titleTF = new JTextField(20);
	private JButton createIt = new JButton("Create");
	private JLabel titleL = new JLabel("Title");
	
	public NewWindow(){
	
		//Creating the Create New Document window				
		windowCreate.setLayout(new FlowLayout()); 
		windowCreate.add(titleL);
		windowCreate.add(titleTF);
		windowCreate.add(createIt);
		windowCreate.setSize(400,100);
		windowCreate.setLocationRelativeTo(null);
		windowCreate.setVisible(true);
		createIt.addActionListener(createIt(windowCreate,titleTF));
		//
		
	
	}
	
	
}
