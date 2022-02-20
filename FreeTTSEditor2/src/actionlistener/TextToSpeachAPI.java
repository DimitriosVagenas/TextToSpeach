package actionlistener;

public interface TextToSpeachAPI {

	
	public void speak(String saying) ;
	public void setThePitch(float pitch);
	public void setTheVolume(float volume);
	public void setTheRate(float rate);	
	public float getPitch();
	public float getRate() ;
	public float getVolume() ;
	
}
