
public class TestScoreClass {
	public static void main(String[] args) {
		
		String first = "John";
		String last = "Deer";
		String email = "jd123@gmail.com";
		String password = "abc123";
		
		//create player
		Player player = new Player(first, last, email, password);
	    System.out.println("Player Info: ");
		System.out.println("User Name: " + player.GetPlayerName());
		System.out.println("First Name: " + player.GetFirstName());
		System.out.println("Last Name: " + player.GetLastName());
		System.out.println("Email: " + player.GetEmail());
		System.out.println("Password: " + player.GetPassword());
		System.out.println();
		
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
