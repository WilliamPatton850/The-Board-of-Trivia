
public class TestScoreClass {
	public static void main(String[] args) {
		
		//create default score 
		Score score1 = new Score();
		System.out.println("Score: " + score1.getScore());
		System.out.println("Ranking: " + score1.getRanking());
		System.out.println();
		
		//player answers easy question correctly (+5 points)
		score1.easyQuestion();
		System.out.println("New score should be 5");
		System.out.println("New Score: " + score1.getScore());
		System.out.println();
		
		//player answers medium question correctly (+10 points)
		score1.mediumQuestion();
		System.out.println("New score should be 15");
		System.out.println("New Score: " + score1.getScore());
		System.out.println();
		
		//player answers hard question correctly (+15 points)
		score1.hardQuestion();
		System.out.println("New score should be 30");
		System.out.println("New Score: " + score1.getScore());
		System.out.println();
		
		//testing getRanking()
		
	}

}
