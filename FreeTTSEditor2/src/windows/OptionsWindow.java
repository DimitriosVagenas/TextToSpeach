package windows;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import actionlistener.ActionListenerExe;
import actionlistener.ChangeListenerExe;
import actionlistener.TextToSpeachAPI;


public class OptionsWindow extends ActionListenerExe {
	
	private ChangeListenerExe changeListener = new ChangeListenerExe();
	private JFrame windowOptions = new JFrame("Voice Options");
	private JSlider pitch = new JSlider(JSlider.HORIZONTAL, 0,200,100);
	private JSlider rate = new JSlider(JSlider.HORIZONTAL, 40,500,150);
	private JSlider volume = new JSlider(JSlider.HORIZONTAL, 0,100,100);
	private JButton apply = new JButton("Apply");
	private JLabel pitchLabel=new JLabel("Pitch(Hrz)");
	private JLabel rateLabel=new JLabel("Rate(Words/min)");
	private JLabel volumeLabel=new JLabel("Volume");
	private JTextField pitchTextField = new JTextField(10);
	private JTextField rateTextField = new JTextField(10);
	private JTextField volumeTextField = new JTextField(10);

	//the voice options menu
	//implemented it with sliders
	
	
	public OptionsWindow(TextToSpeachAPI speaker) {
		pitchTextField.setText("100");
		rateTextField.setText("150");
		volumeTextField.setText("100");
		
		pitchTextField.setEditable(false);
		rateTextField.setEditable(false);
		volumeTextField.setEditable(false);
		//creating and setting up the window								
		windowOptions.setLayout(null); 
		
		pitchLabel.setBounds(50,10, 200, 20);
		pitch.setBounds(20,40,200, 20);
		
		rateLabel.setBounds(50,70,200, 20);
		rate.setBounds(20,100,200, 20);
		
		volumeLabel.setBounds(50,130,200, 20);
		volume.setBounds(20,160,200, 20);
		
		apply.setBounds(250,200,80, 30);
		
		pitchTextField.setBounds(230,40,50, 20);
		rateTextField.setBounds(230,100,50, 20);
		volumeTextField.setBounds(230,160,50, 20);
		
		windowOptions.add(pitchTextField);
		windowOptions.add(rateTextField);
		windowOptions.add(volumeTextField);
		
		
		windowOptions.add(pitchLabel);
		windowOptions.add(rateLabel);
		windowOptions.add(volumeLabel);
		windowOptions.add(apply);
		
		windowOptions.add(pitch);
		windowOptions.add(rate);
		windowOptions.add(volume);
		windowOptions.setSize(380,300);
		windowOptions.setLocationRelativeTo(null);
		windowOptions.setVisible(true);

		//ChangeListeners for getting new pitch rate and volume values
		pitch.addChangeListener(changeListener.getStatePitch(this,pitch));
		rate.addChangeListener(changeListener.getStateRate(this,rate));
		volume.addChangeListener(changeListener.getStateVolume(this,volume));
		
		apply.addActionListener(applyOptions(windowOptions,speaker,this));
		
		
	}
	
	
	//Setters and getters for the voice parametres
	
	public void  setP(int pitch) {
		this.pitchTextField.setText(""+pitch);
		
	}
	public void  setR(int rate) {
		this.rateTextField.setText(""+rate);
		
	}
	public void  setVol(int volume) {
		this.volumeTextField.setText(""+volume);
		
	}
	
	public int getP() {
		return Integer.parseInt(this.pitchTextField.getText());
	}
	
	public int getR() {
		return Integer.parseInt(this.rateTextField.getText());
	}
	
	public int getVol() {
		return Integer.parseInt(this.volumeTextField.getText());
	}
	
	
}