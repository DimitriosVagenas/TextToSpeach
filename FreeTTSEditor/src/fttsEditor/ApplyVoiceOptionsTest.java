package fttsEditor;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

class ApplyVoiceOptionsTest {

	@Test
	void test() {
		ActionListenerExe ale = new ActionListenerExe();
		ActionListener al;
		JFrame window=new JFrame();
		TextToSpeachAPI speaker=new Speaker();
		TextToSpeachAPI speakerTest=new Speaker();
		OptionsWindow windowOpt=new OptionsWindow(speaker);
		windowOpt.setP(50);
		windowOpt.setR(50);
		windowOpt.setVol(50);
		speakerTest.setThePitch(50);
		speakerTest.setTheRate(50);
		speakerTest.setTheVolume(50);
		JButton b=new JButton();
		al=ale.applyOptions(window,speaker, windowOpt);
		b.addActionListener(al);
		b.doClick();
		assertEquals(speaker.getRate(),speakerTest.getRate());
		assertEquals(speaker.getPitch(),speakerTest.getPitch());
		assertEquals(speaker.getVolume(),speakerTest.getVolume()/100);
	}

}
