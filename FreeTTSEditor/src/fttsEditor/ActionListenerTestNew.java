package fttsEditor;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

class ActionListenerTestNew {

	@Test
	void test() throws IOException {
		ActionListenerExe ale = new ActionListenerExe();
		ActionListener al;
		JFrame window = new JFrame();
		JTextField tf = new JTextField();
		JButton b=new JButton();
		tf.setText("test");
		al=ale.createIt(window,tf);
		b.addActionListener(al);
		b.doClick();
		
		File f = new File("SavedFiles/test.txt");
		if (f.exists()) {
			assertEquals(Files.readString(Paths.get("SavedFiles/test.txt")),"");
		}
	}

}
