package fttsEditor;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.TextArea;

import org.junit.jupiter.api.Test;

class WindowCreatorTest {

	@Test
	void test() {
		WindowCreator window = new WindowCreator();
		TextArea expected= new TextArea(30, 60);
		expected.setEditable(false);
		expected.setBounds(0, 0, 500, 500);
		expected.setText("I am");
		window.setMainText("I am");
		assertEquals(window.getMainText().getText() , expected.getText());
	}

}
