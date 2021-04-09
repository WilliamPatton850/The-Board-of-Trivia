import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionList {
	private int easySize = 0;
	private int medSize = 0;
	private int hardSize = 0;
	private String[] easyQuestions;
	private String[] medQuestions;
	private String[] hardQuestions;
	
	public void importEasy() {
		try {
			int i = 0;
			File easyQ = new File("easyQuestions.dat");
			Scanner easyReader = new Scanner(easyQ);
			easyReader.useDelimiter("\r");
			
			while (easyReader.hasNextLine()) {
				if (easyReader.hasNextInt()) {
					easySize = easyReader.nextInt();
					easyQuestions = new String[easySize];
				}
				else {
					if (i < easySize) {
						easyQuestions[i] = easyReader.nextLine();
						i++;
					}
					else {
						System.out.println("More questions than max number listed detected.  Ignoring inputs after question #" + easySize + ".");
					}
				}
			}
			
			easyReader.close();
		}
		
		catch (FileNotFoundException nofile) {
			System.out.println("Please insert a question file named 'easyQuestions.dat' into the folder, then try again.");
		}
	}
	
	public void importMed() {
		try {
			int i = 0;
			File medQ = new File("medQuestions.dat");
			Scanner medReader = new Scanner(medQ);
			medReader.useDelimiter("\r");
			
			while (medReader.hasNextLine()) {
				if (medReader.hasNextInt()) {
					medSize = medReader.nextInt();
					medQuestions = new String[medSize];
				}
				else {
					if (i < medSize) {
						medQuestions[i] = medReader.nextLine();
						i++;
					}
					else {
						System.out.println("More questions than max number listed detected.  Ignoring inputs after question #" + medSize + ".");
					}
				}
			}
			
			medReader.close();
		}
		
		catch (FileNotFoundException nofile) {
			System.out.println("Please insert a question file named 'medQuestions.dat' into the folder, then try again.");
		}
	}
	
	public void importHard() {
		try {
			int i = 0;
			File hardQ = new File("hardQuestions.dat");
			Scanner hardReader = new Scanner(hardQ);
			hardReader.useDelimiter("\r");
			
			while (hardReader.hasNextLine()) {
				if (hardReader.hasNextInt()) {
					hardSize = hardReader.nextInt();
					hardQuestions = new String[hardSize];
				}
				else {
					if (i < hardSize) {
						hardQuestions[i] = hardReader.nextLine();
						i++;
					}
					else {
						System.out.println("More questions than max number listed detected.  Ignoring inputs after question #" + hardSize + ".");
					}
				}
			}
			
			hardReader.close();
		}
		
		catch (FileNotFoundException nofile) {
			System.out.println("Please insert a question file named 'hardQuestions.dat' into the folder, then try again.");
		}
	}
	
	public String getEasyQ(int a) {
		return easyQuestions[a];
	}
	
	public String getMedQ(int a) {
		return medQuestions[a];
	}
	
	public String getHardQ(int a) {
		return hardQuestions[a];
	}
}
