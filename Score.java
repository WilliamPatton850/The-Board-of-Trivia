//calculates and stores game scores
//calculates and stores player rankings 
//methods for easy, medium and hard questions (each worth different points)

public class Score {
   private int playerScore;
   private int playerRanking;
  
   //default constructor
   public Score() {
		playerScore = 0;
   		playerRanking = 0;
	}
	
	//easy questions (each question worth 5 points) 
	public void easyQuestion() {
		playerScore += 5;
	}
  
	//medium questions (each question worth 10 points)
	public void mediumQuestion() {
		playerScore += 10;
	}
	
	//hard questions (each question worth 15 points)
	public void hardQuestion() {
		playerScore += 15;
	}

	//returns player score 
	public int getScore() {
		return playerScore; 
	}

	//returns player ranking 
	public int getRanking() {
		return playerRanking;	
	}

	//calculate player ranking
	public int calculateRanking() {
		playerRanking = playerScore * 2;
		return playerRanking; 
	}

	
}
