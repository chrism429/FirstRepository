package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GUItest {

	@Test
	public void test() {
		Morris_Word_Occurences test = new Morris_Word_Occurences();
		int output = test.main("HashMap");
		assertEquals(2, output);
	}

}
