package fttsEditor;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.*;

import org.junit.jupiter.api.Test;

class ActionListenerTestSave {

	@Test
	void test() throws IOException {
		ActionListenerExe ale = new ActionListenerExe();
		ActionListener al;
		JFrame window = new JFrame();
		JTextField tf = new JTextField();
		TextArea ta = new TextArea();
		JButton b=new JButton();
		tf.setText("test");
		al=ale.saveFile(window,tf,ta);
		b.addActionListener(al);
		b.doClick();
		
		File f = new File("SavedFiles/test.txt");
		if (f.exists()) {
			assertEquals(Files.readString(Paths.get("SavedFiles/test.txt")),ta.getText());
		}
	}

}
