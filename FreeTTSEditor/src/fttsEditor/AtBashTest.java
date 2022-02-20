package fttsEditor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AtBashTest {

	@Test
	void test() {
		Encoder encoder=new Encoder();
		String actual = "i am here";
		String expected = "r zn sviv";
		actual= encoder.atBash(actual);
		assertEquals(expected, actual);
	}

		

	

}
