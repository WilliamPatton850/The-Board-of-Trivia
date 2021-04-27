import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class QuestionList {
	int numEasy = 2;
	int currEasyQ = 0;
	int numMed = 2;
	int currMedQ = 0;
	int numHard = 2;
	int currHardQ = 0;
	private ArrayList<Question> easyQuestions = new ArrayList<>();
	private ArrayList<Question> medQuestions = new ArrayList<>();
	private ArrayList<Question> hardQuestions = new ArrayList<>();
	
	public void importAll() {
		//importEasy();
		//importMed();
		//importHard();
		Question eq1 = new Question("String question", "String a1"," String a2", "String a3", "String a4", 1);
		Question eq2 = new Question("String question", "String b2"," String b2", "String b3", "String b4", 2);
		easyQuestions.add(eq1);
		easyQuestions.add(eq2);
	}
	
	public void importEasy() { 
	  try {
		FileReader easyQ = new FileReader("easyQuestions.txt"); 
		BufferedReader easyReader = new BufferedReader(easyQ);
		Scanner easyScan = new Scanner(easyReader);
		
		String currLine = "";
		String question = "";
		String a1 = "";
		String a2 = "";
		String a3 = "";
		String a4 = "";
		int correct = 0;
		
		
		while(easyScan.hasNextLine()) {
			  currLine = easyScan.nextLine();
			
		      if (currLine.contains("?")) {
			      question = currLine;
		      }
		      else if(currLine.contains("1)")) {
			      a1 = currLine;
		      }
		      else if(currLine.contains("2)")) {
			      a2 = currLine;
		      }
		      else if(currLine.contains("3)")) {
		       	  a3 = currLine;
	 	      }
		      else if(currLine.contains("4)")) {
			      a4 = currLine;
		      }
		      else if(currLine.contains("*")) {
			      correct = Integer.valueOf(currLine.indexOf(0));  //FIX: this is computing incorrect value 
		    	  System.out.println(correct); //checking value
			      easyQuestions.add(new Question(question, a1, a2, a3, a4, correct)); 
				  numEasy++;
		      }
		      
		}
			
			easyScan.close();
		}
			catch (IOException error) {
				error.printStackTrace();
			}
	}
	
	/*
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
	*/
	
	public void importMed() { 
		  try {
			FileReader medQ = new FileReader("medQuestions.txt"); 
			BufferedReader medReader = new BufferedReader(medQ);
			Scanner medScan = new Scanner(medReader);
			
			String currLine = "";
			String question = "";
			String a1 = "";
			String a2 = "";
			String a3 = "";
			String a4 = "";
			int correct = 0;
			
			
			while(medScan.hasNextLine()) {
				  currLine = medScan.nextLine();
				
			      if (currLine.contains("?")) {
				      question = currLine;
			      }
			      else if(currLine.contains("1)")) {
				      a1 = currLine;
			      }
			      else if(currLine.contains("2)")) {
				      a2 = currLine;
			      }
			      else if(currLine.contains("3)")) {
			       	  a3 = currLine;
		 	      }
			      else if(currLine.contains("4)")) {
				      a4 = currLine;
			      }
			      else if(currLine.contains("*")) {
				      correct = Integer.valueOf(currLine.indexOf(0));  //FIX: this is computing incorrect value 
			    	  System.out.println(correct); //checking value
				      medQuestions.add(new Question(question, a1, a2, a3, a4, correct)); 
					  numMed++;
			      }
			      
			}
				
				medScan.close();
			}
				catch (IOException error) {
					error.printStackTrace();
				}
		}
	
	
	/*
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
	*/
	
	public void importHard() { 
		  try {
			FileReader hardQ = new FileReader("hardQuestions.txt"); 
			BufferedReader hardReader = new BufferedReader(hardQ);
			Scanner hardScan = new Scanner(hardReader);
			
			String currLine = "";
			String question = "";
			String a1 = "";
			String a2 = "";
			String a3 = "";
			String a4 = "";
			int correct = 0;
			
			
			while(hardScan.hasNextLine()) {
				  currLine = hardScan.nextLine();
				
			      if (currLine.contains("?")) {
				      question = currLine;
			      }
			      else if(currLine.contains("1)")) {
				      a1 = currLine;
			      }
			      else if(currLine.contains("2)")) {
				      a2 = currLine;
			      }
			      else if(currLine.contains("3)")) {
			       	  a3 = currLine;
		 	      }
			      else if(currLine.contains("4)")) {
				      a4 = currLine;
			      }
			      else if(currLine.contains("*")) {
				      correct = Integer.valueOf(currLine.indexOf(0));  //FIX: this is computing incorrect value 
			    	  System.out.println(correct); //checking value
				      hardQuestions.add(new Question(question, a1, a2, a3, a4, correct)); 
					  numHard++;
			      }
			      
			}
				
				hardScan.close();
			}
				catch (IOException error) {
					error.printStackTrace();
				}
		}
	
	/*
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
	*/
	
	public Question getEasyQ() {
		if (currEasyQ > numEasy-1) {
			currEasyQ = 0;
		}
		
		Question q = easyQuestions.get(currEasyQ);
		currEasyQ++;
		return q;
	}
	
	public Question getMedQ() {
		if (currMedQ > numMed-1) {
			currMedQ = 0;
		}
		
		Question q = medQuestions.get(currMedQ);
		currMedQ++;
		return q;
	}
	
	public Question  getHardQ() {
		if (currHardQ > numHard-1) {
			currHardQ = 0;
		}
		Question q = hardQuestions.get(currHardQ);
		currHardQ++;
		return q;
	}
}
