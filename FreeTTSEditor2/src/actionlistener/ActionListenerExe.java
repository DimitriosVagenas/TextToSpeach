package actionlistener;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import initiatorandmisc.Encoder;
import initiatorandmisc.TxtToString;
import windows.NewWindow;
import windows.OpenWindow;
import windows.OptionsWindow;
import windows.SaveWindow;
import windows.WindowCreator;

public class ActionListenerExe {

	
	private String saying;
	private TxtToString txtTostring = new TxtToString();
	private Encoder encoder= new Encoder();
	
	
	
	//Save file method is being called by WindowCreator class to Save a Textfile to SavedFiles/ location
	
	public ActionListener saveFile(JFrame window, JTextField save, TextArea text ) {
		
		ActionListener al =new ActionListener(){
			
			public void actionPerformed(ActionEvent ae)
			{
				try {
					
					FileWriter fileWriter = new FileWriter("SavedFiles/"+save.getText()+".txt");
					fileWriter.write(text.getText() );
					
					fileWriter.close();
					
					
				}catch(Exception e ) {
					
					JOptionPane.showMessageDialog(null, e+"");
				}
				window.dispose();
			}
		
		
		};
		return al;
		
	}
	

	
	//This is the method that decides what is going to anounce and in which mode
	
	public ActionListener speakAll(TextToSpeachAPI speaker,TextArea taDisplay,JRadioButton normal,JRadioButton rot13 ,JRadioButton atBash,JRadioButton reversed, JRadioButton selected) {
		
		ActionListener al =new ActionListener(){
					
			public void actionPerformed(ActionEvent ae)
			{
				
				if(selected.isSelected()){
					saying=taDisplay.getSelectedText();
				}else {
					saying=taDisplay.getText();
				}
				
				if(normal.isSelected()){
					speaker.speak(saying);
				}
				else if(rot13.isSelected()) {
					saying=encoder.rot13(saying);
					speaker.speak(saying);
				}
				else if(atBash.isSelected()) {
					saying=encoder.atBash(saying);
					speaker.speak(saying);
				}
				else if(reversed.isSelected()) {
					saying=encoder.reverser(saying);
					speaker.speak(saying);
				}
				
			}
			
				
		};
		return al;
				
	}
	
	
	//Just Clearing the text Area
	
	public ActionListener clearText(TextArea taDisplay) {
		
		ActionListener al =new ActionListener(){
					
			public void actionPerformed(ActionEvent ae)
			{
				
				taDisplay.setText("");
			}
			
				
		};
		return al;
				
	}
	
	
	//The method by which the user browses the directories to open a File
	
	public ActionListener openFile(JFrame window,TextArea taDisplay) {
		
		ActionListener al =new ActionListener(){
			
			public void actionPerformed(ActionEvent ae)
			{
				try {
					FileFilter filter = new FileNameExtensionFilter("txt","TXT");
					JFileChooser chooser = new JFileChooser();
					chooser.setAcceptAllFileFilterUsed(false);
					chooser.addChoosableFileFilter(filter );
					chooser.showOpenDialog(null);
					File f = chooser.getSelectedFile();
					String path = f.getAbsolutePath();
					saying=txtTostring.convertTxtToString(path);
					taDisplay.setText(saying);
					
				}catch(Exception e ) {
					
					JOptionPane.showMessageDialog(null, "\n Operation canceled");
				}
				window.dispose();

				
			}
		
		
		};
		return al;
		
	}
	
	//Method that implements the open a file from specific path story
	
	public ActionListener openSpecFile(JFrame window,TextArea taDisplay,JTextField pathing) {
		
		ActionListener al =new ActionListener(){
			
			public void actionPerformed(ActionEvent ae)
			{
				try {
					
					File f = new File(pathing.getText()+".txt");
					if (f.exists()) {
						saying=txtTostring.convertTxtToString(pathing.getText()+".txt");
						taDisplay.setText(saying);
						
					}else {
						JOptionPane.showMessageDialog(null, "\n Load Unsuccessful");
					}
				
				}catch(Exception e ) {
					
					JOptionPane.showMessageDialog(null, "\n Load Unsuccessful");
				}
				window.dispose();
			}
		
		
		};
		return al;
		
	}
	
	
	//opens the window for opening a file
	
	public ActionListener popWinOpen(WindowCreator window) {
		
		ActionListener al =new ActionListener(){
			
			public void actionPerformed(ActionEvent ae)
			{
				new OpenWindow(window);
			}
			
			
		};
		return al;
		
	}
	
	//opens the window for saving a file
	
	public ActionListener popWinSave(WindowCreator window) {
		
		ActionListener al =new ActionListener(){
			
			public void actionPerformed(ActionEvent ae)
			{
				new SaveWindow(window);
			}
			
			
		};
		return al;
		
	}

	//opens a window for creating a new file
	
	public ActionListener popWinNew() {
		
		ActionListener al =new ActionListener(){
			
			public void actionPerformed(ActionEvent ae)
			{
				new NewWindow();
			}
			
			
		};
		return al;
		
	}
	
	//Open a window for editing the voice 
	
	public ActionListener popWinOptions(TextToSpeachAPI speaker) {
		
		ActionListener al =new ActionListener(){
			
			public void actionPerformed(ActionEvent ae)
			{
				new OptionsWindow(speaker);
			}
			
			
		};
		return al;
		
	}
	
	
	//Method that creates an empty text file
	
	public ActionListener createIt(JFrame window,JTextField title) {
		
		ActionListener al =new ActionListener(){
			
			public void actionPerformed(ActionEvent ae)
			{
				try {

					FileWriter fileWriter = new FileWriter("SavedFiles/"+title.getText()+".txt");
					fileWriter.close();
						
				}catch(Exception e ) {
				
					JOptionPane.showMessageDialog(null, "\n Operation canceled");
			
				}
				window.dispose();
			}
		};

		return al;
	}
	
	//method that apply the voice changes
	
	public ActionListener applyOptions(JFrame window,TextToSpeachAPI speaker,OptionsWindow windowOpt) {
		
		ActionListener al =new ActionListener(){
			
			public void actionPerformed(ActionEvent ae)
			{
				speaker.setThePitch(windowOpt.getP());
				speaker.setTheRate(windowOpt.getR());
				speaker.setTheVolume((float)windowOpt.getVol()/(float)100);
				window.dispose();
			}
		};

		return al;
	}
	
	//method that allows editing or not the main text
	public ActionListener editToggle(WindowCreator window) {
		
		ActionListener al =new ActionListener(){
			
			public void actionPerformed(ActionEvent ae)
			{
				window.getMainText().setEditable(window.getSetToggle());
			}
		};
		return al;
	}	
}

