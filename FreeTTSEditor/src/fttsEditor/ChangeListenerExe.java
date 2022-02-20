package fttsEditor;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangeListenerExe {

//This class was made for editing the voice parametres pitch rate and volume
	
	//This gets the new pitch value
	public ChangeListener getStatePitch(OptionsWindow window ,JSlider pitch ) {
			
		ChangeListener cl =new ChangeListener(){
				
			public void stateChanged(ChangeEvent ce)
			{
				window.setP(pitch.getValue());
			}
			
			
			
		};
		return cl;
			
	}
	
	//This gets the new rate value
	public ChangeListener getStateRate(OptionsWindow window ,JSlider rate ) {
		
		ChangeListener cl =new ChangeListener(){
				
			public void stateChanged(ChangeEvent ce)
			{
				window.setR(rate.getValue());
			}
			
			
			
		};
		return cl;
			
	}
	
	//This gets the new Volume value *100
	public ChangeListener getStateVolume(OptionsWindow window ,JSlider volume ) {
		
		ChangeListener cl =new ChangeListener(){
				
			public void stateChanged(ChangeEvent ce)
			{
				window.setVol(volume.getValue());
			}
			
			
			
		};
		return cl;
			
	}
	
	
	
	
}
