package fttsEditor;
import javax.swing.JOptionPane;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Speaker implements TextToSpeachAPI {
		 
	//This class controls the voice of the aplication and works as adapter 
	
	private Voice voice;
	private VoiceManager vm;
	
	//constructor getting the kevin16 anouncer
	public Speaker(){
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		
		vm = VoiceManager.getInstance();
		this.voice =vm.getVoice("kevin16");
		voice.allocate();
		
	}
	
	//this method anounces the text
	public void speak(String saying) {
		
		
		try {
			this.voice.speak(saying);
			
		}catch(Exception e ) {
			
			JOptionPane.showMessageDialog(null, e+"");
		}
	}
	
	
	//setters for editing the voice parametres
	
	public void setThePitch(float pitch){
		this.voice.setPitch(pitch);
	}
	
	public void setTheVolume(float volume){
		this.voice.setVolume(volume);
	}
	
	public void setTheRate(float rate){
		this.voice.setRate(rate);
		
	}
	public float getPitch() {
		return this.voice.getPitch();
	}
	public float getRate() {
		return this.voice.getRate();
	}
	public float getVolume() {
		return this.voice.getVolume();
	}
	
}





