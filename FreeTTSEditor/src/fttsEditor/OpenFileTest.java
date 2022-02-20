package fttsEditor;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

class OpenFileTest {

	@Test
	void test() throws IOException {
		ActionListenerExe ale = new ActionListenerExe();
		ActionListener al;
		JFrame window = new JFrame();
		JTextField tf = new JTextField();
		TextArea ta = new TextArea();
		JButton b=new JButton();
		tf.setText("SavedFiles/test");
		al=ale.openSpecFile(window,ta,tf);
		b.addActionListener(al);
		b.doClick();
		assertEquals(Files.readString(Paths.get("SavedFiles/test.txt")),ta.getText());
		
	}

}
