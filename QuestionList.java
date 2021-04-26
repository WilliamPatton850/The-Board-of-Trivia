import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionList {
	int easyPoints = 5;
	int numEasy = 0;
	int currEasyQ = 0;
	int medPoints = 10;
	int numMed = 0;
	int currMedQ = 0;
	int hardPoints = 15;
	int numHard = 0;
	int currHardQ = 0;
	private ArrayList<Question> easyQuestions = new ArrayList<>();
	private ArrayList<Question> medQuestions = new ArrayList<>();
	private ArrayList<Question> hardQuestions = new ArrayList<>();
	
	public void importEasy() {
		try {
			FileReader easyQ = new FileReader("easyQuestions.dat");
			BufferedReader easyReader = new BufferedReader(easyQ);
			Scanner easyScan = new Scanner(easyReader);
			
			String currLine;
			String question = "";
			String a1 = "";
			String a2 = "";
			String a3 = "";
			String a4 = "";
			int correct = 0;
			
			while (easyScan.hasNext()) {				
				while (correct == 0) {
					currLine = easyScan.nextLine();
					
					if (currLine.contains("?")) {
						question = currLine;
					}
					else if (currLine.contains(")")) {
						if (Integer.valueOf(currLine.indexOf(0)) == 1) {
							a1 = currLine;
						}
						else if (Integer.valueOf(currLine.indexOf(0)) == 2) {
							a2 = currLine;
						}
						else if (Integer.valueOf(currLine.indexOf(0)) == 3) {
							a3 = currLine;
						}
						else if (Integer.valueOf(currLine.indexOf(0)) == 4) {
							a4 = currLine;
						}
					}
					else if (Character.isDigit(currLine.indexOf(0))) {
						correct = Integer.valueOf(currLine);
					}
				}
				
				easyQuestions.add(new Question(question, a1, a2, a3, a4, correct));
				numEasy++;
			}
			
			easyScan.close();
		}
		
		catch (IOException error) {
			error.printStackTrace();
		}
	}
	
	public void importMed() {
		try {
			FileReader medQ = new FileReader("medQuestions.dat");
			BufferedReader medReader = new BufferedReader(medQ);
			Scanner medScan = new Scanner(medReader);
			
			String currLine;
			String question = "";
			String a1 = "";
			String a2 = "";
			String a3 = "";
			String a4 = "";
			int correct = 0;
			
			while (medScan.hasNext()) {				
				while (correct == 0) {
					currLine = medScan.nextLine();
					
					if (currLine.contains("?")) {
						question = currLine;
					}
					else if (currLine.contains(")")) {
						if (Integer.valueOf(currLine.indexOf(0)) == 1) {
							a1 = currLine;
						}
						else if (Integer.valueOf(currLine.indexOf(0)) == 2) {
							a2 = currLine;
						}
						else if (Integer.valueOf(currLine.indexOf(0)) == 3) {
							a3 = currLine;
						}
						else if (Integer.valueOf(currLine.indexOf(0)) == 4) {
							a4 = currLine;
						}
					}
					else if (Character.isDigit(currLine.indexOf(0))) {
						correct = Integer.valueOf(currLine);
					}
				}
				
				medQuestions.add(new Question(question, a1, a2, a3, a4, correct));
				numMed++;
			}
			
			medScan.close();
		}
		
		catch (IOException error) {
			error.printStackTrace();
		}
	}
	
	public void importHard() {
		try {
			FileReader hardQ = new FileReader("hardQuestions.dat");
			BufferedReader hardReader = new BufferedReader(hardQ);
			Scanner hardScan = new Scanner(hardReader);
			
			String currLine;
			String question = "";
			String a1 = "";
			String a2 = "";
			String a3 = "";
			String a4 = "";
			int correct = 0;
			
			while (hardScan.hasNext()) {				
				while (correct == 0) {
					currLine = hardScan.nextLine();
					
					if (currLine.contains("?")) {
						question = currLine;
					}
					else if (currLine.contains(")")) {
						if (Integer.valueOf(currLine.indexOf(0)) == 1) {
							a1 = currLine;
						}
						else if (Integer.valueOf(currLine.indexOf(0)) == 2) {
							a2 = currLine;
						}
						else if (Integer.valueOf(currLine.indexOf(0)) == 3) {
							a3 = currLine;
						}
						else if (Integer.valueOf(currLine.indexOf(0)) == 4) {
							a4 = currLine;
						}
					}
					else if (Character.isDigit(currLine.indexOf(0))) {
						correct = Integer.valueOf(currLine);
					}
				}
				
				hardQuestions.add(new Question(question, a1, a2, a3, a4, correct));
				numHard++;
			}
			
			hardScan.close();
		}
		
		catch (IOException error) {
			error.printStackTrace();
		}
	}
	
	public void getEasyQ() {
		if (currEasyQ > numEasy-1) {
			currEasyQ = 0;
		}
		
		System.out.println(easyQuestions.get(currEasyQ).getQuestion());
		System.out.println(easyQuestions.get(currEasyQ).getAnswerOne());
		System.out.println(easyQuestions.get(currEasyQ).getAnswerTwo());
		System.out.println(easyQuestions.get(currEasyQ).getAnswerThree());
		System.out.println(easyQuestions.get(currEasyQ).getAnswerFour());
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number choice of the correct answer.");
		int answer = input.nextInt();
		if (answer == easyQuestions.get(currEasyQ).getCorrectAnswer()) {
			System.out.println("Correct!");
			currEasyQ++;
			//Increase current player's score
		}
		else {
			System.out.println("Incorrect.");
			currEasyQ++;
		}
		input.close();
	}
	
	public void getMedQ() {
		if (currMedQ > numMed-1) {
			currMedQ = 0;
		}
		
		System.out.println(medQuestions.get(currMedQ).getQuestion());
		System.out.println(medQuestions.get(currMedQ).getAnswerOne());
		System.out.println(medQuestions.get(currMedQ).getAnswerTwo());
		System.out.println(medQuestions.get(currMedQ).getAnswerThree());
		System.out.println(medQuestions.get(currMedQ).getAnswerFour());
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number choice of the correct answer.");
		int answer = input.nextInt();
		if (answer == medQuestions.get(currMedQ).getCorrectAnswer()) {
			System.out.println("Correct!");
			currMedQ++;
			//Increase current player's score
		}
		else {
			System.out.println("Incorrect.");
			currMedQ++;
		}
		input.close();
	}
	
	public void getHardQ() {
		if (currHardQ > numHard-1) {
			currHardQ = 0;
		}
		
		System.out.println(hardQuestions.get(currHardQ).getQuestion());
		System.out.println(hardQuestions.get(currHardQ).getAnswerOne());
		System.out.println(hardQuestions.get(currHardQ).getAnswerTwo());
		System.out.println(hardQuestions.get(currHardQ).getAnswerThree());
		System.out.println(hardQuestions.get(currHardQ).getAnswerFour());
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number choice of the correct answer.");
		int answer = input.nextInt();
		if (answer == hardQuestions.get(currHardQ).getCorrectAnswer()) {
			System.out.println("Correct!");
			currHardQ++;
			//Increase current player's score
		}
		else {
			System.out.println("Incorrect.");
			currHardQ++;
		}
		input.close();
	}
}
