import java.util.*;
public class Player {
	private String password;
	private String email;
	private String userName = "";
	
	
	public Player(String email, String password){
		this.email = email;
		this.password = password;
	}

	public String GetPlayerName() {
		Random name = new Random();
		String alphabet = "abcdefghijklmnopqrtuvwxyz123456789";
		for(int i = 0; i < 8; i++) {
			userName += alphabet.charAt(name.nextInt(alphabet.length()));
		}
		return userName;
	}
	
}
