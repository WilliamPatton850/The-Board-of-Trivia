import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestScoreClassJUnit {
	

	@Test
	//Constructor test
	void test1() {
		Score test = new Score();
		assertEquals(0, test.getScore());
		assertEquals(0, test.getRanking());
	}
	
	@Test
	//Score increase tests
	void test2() {
		Score test = new Score();
		assertEquals(0, test.getScore());
		test.easyQuestion();
		assertEquals(5, test.getScore());
		test.mediumQuestion();
		assertEquals(15, test.getScore());
		test.hardQuestion();
		assertEquals(30, test.getScore());
	}
	
	@Test
	//Ranking calculation tests
	void test3() {
		Score test = new Score();
		assertEquals(0, test.getRanking());
		test.easyQuestion();
		test.calculateRanking();
		assertEquals(10, test.getRanking());
		test.mediumQuestion();
		test.calculateRanking();
		assertEquals(30, test.getRanking());
		test.hardQuestion();
		test.calculateRanking();
		assertEquals(60, test.getRanking());
	}
}
