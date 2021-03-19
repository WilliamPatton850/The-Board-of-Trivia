import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayerClassJUnit {

	@Test
	//default constructor test
	void test1() {
		Player test = new Player();
		assertEquals("", test.GetFirstName());
		assertEquals("",test.GetLastName());
		assertEquals("", test.GetPassword());
		assertEquals("", test.GetEmail());
		assertEquals(test.GetPlayerName(), test.GetPlayerName());
	}
	
	@Test
	//overloaded constructor test
	void test2() {
		Player test = new Player("John","Deer","Bobbie@gmail.com", "abc123");
		assertEquals("John", test.GetFirstName());
		assertEquals("Deer",test.GetLastName());
		assertEquals("abc123", test.GetPassword());
		assertEquals("Bobbie@gmail.com", test.GetEmail());
		assertEquals(test.GetPlayerName(), test.GetPlayerName());
	}
	
	@Test
	//copy constructor test
	void test3() {
		Player test1 = new Player("John","Deer","Bobbie@gmail.com", "abc123");
		Player test2 = new Player(test1);
		assertEquals(test2.GetFirstName(), test1.GetFirstName());
		assertEquals(test2.GetLastName(),test1.GetLastName());
		assertEquals(test2.GetPassword(), test1.GetPassword());
		assertEquals(test2.GetEmail(), test1.GetEmail());
		assertEquals(test2.GetPlayerName(), test1.GetPlayerName());
	}

}
