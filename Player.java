//Player class containing password, first name, last name, email, and userName
import java.util.*;

public class Player {

	private String password;
	private String first;
	private String last;
	private String email;
	private String userName;
	
	//default contructor
	public Player() {
		password = "";
		first = "";
		last = "";
		email = "";
		userName = "";
	}
	
	//overloaded constructor
	public Player(String first, String last, String email, String password){
		SetPassword(password);
		SetEmail(email);
		SetFirstName(first);
		SetLastName(last);
		SetPlayerName();
	}
	
	//copy constructor
	public Player(Player player) {
		this.email = player.email;
		this.password = player.password;
		this.first = player.first;
		this.last = player.last;
		this.userName = player.userName;
	}
	
	//set playerName as random from alphabet and numbers
	public void SetPlayerName() {
		userName = "";
		Random name = new Random();
		String alphabet = "abcdefghijklmnopqrtuvwxyz123456789";
		for(int i = 0; i < 8; i++) {
			userName += alphabet.charAt(name.nextInt(alphabet.length()));
		}
	}
	
	//setters
	public void SetPassword(String password) {
		this.password = password;
	}
	
	public void SetEmail(String email) {
		this.email = email;
	}
	
	public void SetFirstName(String first) {
		this.first = first;
	}
	
	public void SetLastName(String last) {
		this.last = last;
	}
	
	//getters
	public String GetPlayerName() {
		return userName;
	}
	
	public String GetEmail() {
		return email;
	}
	
	public String GetPassword() {
		return password;
	}
	
	public String GetFirstName() {
		return first;
	}
	
	public String GetLastName() {
		return last;
	}
	
}
