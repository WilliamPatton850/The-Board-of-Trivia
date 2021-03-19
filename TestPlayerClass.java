
public class TestPlayerClass {
	public static void main(String[] args) {
	
	 //testing default constructor 
	  Player p1 = new Player(); 
	  System.out.println("Player 1: (default constructor)");
	  System.out.println("User Name: " + p1.GetPlayerName());
	  System.out.println("First Name: " + p1.GetFirstName());
	  System.out.println("Last Name: " + p1.GetLastName());
	  System.out.println("Email: " + p1.GetEmail());
	  System.out.println("Password: " + p1.GetPassword());
	  System.out.println();
		  
	  //testing overloaded constructor 
	  String first = "John";
	  String last = "Deer";
	  String email = "jd123@gmail.com";
	  String password = "abc123";
	  Player p2 = new Player(first, last, email, password);
	  System.out.println("Player 2: (overloaded constructor)");
	  System.out.println("User Name: " + p2.GetPlayerName());
	  System.out.println("First Name: " + p2.GetFirstName());
	  System.out.println("Last Name: " + p2.GetLastName());
	  System.out.println("Email: " + p2.GetEmail());
	  System.out.println("Password: " + p2.GetPassword());
	  System.out.println();
	  
	  //testing copy constructor 
	  //Should copy constructor assign a new user name???
	  Player p3 = new Player(p2);
	  System.out.println("Player 3: (copy constructor)");
	  System.out.println("User Name: " + p3.GetPlayerName());
	  System.out.println("First Name: " + p3.GetFirstName());
	  System.out.println("Last Name: " + p3.GetLastName());
	  System.out.println("Email: " + p3.GetEmail());
	  System.out.println("Password: " + p3.GetPassword());
	  System.out.println();
	  
	}

}
