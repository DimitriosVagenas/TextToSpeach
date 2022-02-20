package fttsEditor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TxtToStringTest {

	@Test
	void test() {
		TxtToString tts =new TxtToString();
		String path = "SavedFiles/test.txt";
		String actual = tts.convertTxtToString(path);
		assertEquals("test", actual);
	}

}
