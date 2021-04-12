//roll 2 dice when call

public class Dice {
	public static int roll() {
		int dice1;
		int dice2;
		
		dice1 = (int)(Math.random()*6+1);
		dice2 = (int)(Math.random()*6+1);
		
		return (dice1+dice2)%7 + 1;
		
	}
}
