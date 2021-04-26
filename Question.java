public class Question {
	private String question;
	private String answerOne;
	private String answerTwo;
	private String answerThree;
	private String answerFour;
	private int correctAnswer;
	
	public Question(String question, String a1, String a2, String a3, String a4, int correct) {
		this.question = question;
		answerOne = a1;
		answerTwo = a2;
		answerThree = a3;
		answerFour = a4;
		correctAnswer = correct;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getAnswerOne() {
		return answerOne;
	}
	
	public String getAnswerTwo() {
		return answerTwo;
	}
	
	public String getAnswerThree() {
		return answerThree;
	}
	
	public String getAnswerFour() {
		return answerFour;
	}
	
	public int getCorrectAnswer() {
		return correctAnswer;
	}
}
