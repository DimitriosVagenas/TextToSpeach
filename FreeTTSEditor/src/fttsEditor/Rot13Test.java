package fttsEditor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Rot13Test {

	@Test
	void test() {
		Encoder encoder=new Encoder();
		String actual = "abcde fghijklm";
		String expected = "nopqr stuvwxyz";
		actual= encoder.rot13(actual);
		assertEquals(expected, actual);
	}

}
