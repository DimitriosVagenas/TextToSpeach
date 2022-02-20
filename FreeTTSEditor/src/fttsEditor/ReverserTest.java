package fttsEditor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverserTest {

	@Test
	void test() {
		Encoder encoder=new Encoder();
		String actual = "i am here";
		String expected = "here am i";
		actual= encoder.reverser(actual);
		assertEquals(expected, actual);
	}

}
