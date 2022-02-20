package windows;

import java.awt.TextArea;
import java.awt.event.KeyEvent;
import javax.swing.*;

import actionlistener.ActionListenerExe;
import actionlistener.Speaker;
import actionlistener.TextToSpeachAPI;

public class WindowCreator extends ActionListenerExe{

	
	private JMenuBar menu = new JMenuBar();
	private JMenu file= new JMenu("File");
	private JMenu edit= new JMenu("Edit");
	private JMenu help= new JMenu("Help");
	private JMenu info= new JMenu("Info");
	private JMenuItem newFile= new JMenuItem("New");
	private JMenuItem open= new JMenuItem("Open");
	private JMenuItem save= new JMenuItem("Save");
	private JMenuItem options= new JMenuItem("Voice Options");
	private JMenuItem credits= new JMenuItem("Credits");
	private JMenuItem helpMe= new JMenuItem("Help me!");
	private JFrame window = new JFrame("Text2Speech Gus Edition 2020");
	private JFrame fakeWindow= new JFrame();
	private JRadioButton normal = new JRadioButton("Normal");
	private JRadioButton rot13 = new JRadioButton("Rot13");
	private JRadioButton atBash = new JRadioButton("atBash");
	private JRadioButton reversed = new JRadioButton("Reversed");
	private JRadioButton selected = new JRadioButton("Selected");
	private TextArea taDisplay;
	private JTextField fakeTFcredits = new JTextField(1);;
	private JTextField fakeTFhelp = new JTextField(1);
	private JButton speakAllButton = new JButton("Speak");
	private JButton clearButton = new JButton("Clear");
	private JButton editTextButton = new JButton("Edit Toggle");
	private TextToSpeachAPI speaker = new Speaker();
	private Boolean toggle=false;
	
	//window Creator creates all the windows that are essential to the T2SE
	
	public WindowCreator(){	
		//Creating the Main T2SE window				
		window.setLayout(null);      //main window must be organized
		ButtonGroup mode = new ButtonGroup();
		mode.add(normal);
		mode.add(rot13);
		mode.add(atBash);
		mode.add(reversed); 						//Adding options for encoding text
		normal.setBounds(510, 30, 100, 30);
		rot13.setBounds(510, 60, 100, 30);
		atBash.setBounds(510, 90, 100, 30);
		reversed.setBounds(510, 120, 100, 30);
		normal.setSelected(true);
		selected.setBounds(510, 235, 100, 30);     //Option for reading all or selected text 	
		file.setMnemonic(KeyEvent.VK_F);           //Open file by typing 'f'
		
		//Creating Text area for document or for the user to write whatever he wants
		taDisplay = new TextArea(30, 60);
		taDisplay.setEditable(false);
		taDisplay.setBounds(0, 0, 500, 500);
		//
		
		
		
		
		//adding text area on my main window
		window.add(taDisplay);
		//adding choices
		window.add(selected);
		window.add(normal);
		window.add(rot13);
		window.add(atBash);
		window.add(reversed);
		
		//setting and adding buttons
		speakAllButton.setBounds(500, 200, 130, 30);
		clearButton.setBounds(500, 400, 130, 30);
		editTextButton.setBounds(500, 350, 130, 30);
	
		window.add(speakAllButton);
		window.add(clearButton);
		window.add(editTextButton);
		
			
		//creating actionListeners for all buttons and menus
		save.addActionListener(popWinSave(this));
		open.addActionListener(popWinOpen(this));
		newFile.addActionListener(popWinNew());
		options.addActionListener(popWinOptions(this.speaker));
		fakeTFcredits.setText("SavedFiles/credits");
		fakeTFhelp.setText("SavedFiles/help");
		credits.addActionListener(openSpecFile(fakeWindow,taDisplay,fakeTFcredits));
		helpMe.addActionListener(openSpecFile(fakeWindow,taDisplay,fakeTFhelp));
		//Buttons in the main window
		speakAllButton.addActionListener(speakAll(this.speaker,taDisplay,normal,rot13 , atBash, reversed,selected)); //Speaking the text with the choices use made
		clearButton.addActionListener(clearText(taDisplay)); //clear the text area
		editTextButton.addActionListener(editToggle(this));
		//
		
		//adding all the menu-bar options
		file.add(newFile);
		file.add(open);
		file.add(save);
		edit.add(options);
		help.add(helpMe);
		info.add(credits);
		menu.add(file);
		menu.add(edit);
		menu.add(help);
		menu.add(info);
		window.setJMenuBar(menu);
		
		//main window settings
		window.setSize(650,560);
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		
	}
	
	
	public  void setMainText(String text) {
		this.taDisplay.setText(text);
		
	}
	
	public TextArea getMainText() {
		return this.taDisplay;
		
	}
	
	public WindowCreator getWindow() {
		return this;
	}
	
	public boolean getSetToggle() {
		this.toggle=!(this.toggle);
		return this.toggle;
	}
	
	
	
}
