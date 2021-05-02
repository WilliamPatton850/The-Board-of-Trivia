
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
	static JPanel chessBoard;
	static HashMap <Integer,ArrayList<JPanel>> tiles = new HashMap<>();
	static int numPlayer;
	static int currPlayer;
	static HashMap<Integer,Integer> playerScore = new HashMap<>();
	static HashMap<Integer,Integer> playerPlace = new HashMap<>();
	JLabel rolled;
	QuestionList qList = new QuestionList();
	
	JLabel p1;
	JLabel p2;
	JLabel p3;
	JLabel p4;
	JLabel p5;
	JLabel p6;
	
	Game(int numP){
		numPlayer =numP ;
		currPlayer = 0;
		for(int i =0;i<numPlayer;i++) {
			playerPlace.put(i, 0);
		}
	}
	void startGame() {
		JFrame game = new JFrame();
		Dimension boardSize = new Dimension(600, 600);
		chessBoard = new JPanel();
		chessBoard.setLayout( new GridLayout(8, 8,20,20) );
		chessBoard.setPreferredSize( boardSize );
		chessBoard.setBounds(0, 0, boardSize.width,boardSize.height);
		getSquares();
		game.add(chessBoard);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setSize(1400,1000);
		game.setVisible(true);
	}
	void getSquares() {
		for (int i = 0; i < 64; i++) {
			JPanel square = new JPanel( new BorderLayout() );
			square.setLayout(new GridLayout(2,8));
			Dimension pSize = new Dimension(1,1);
			square.setPreferredSize(pSize);
			square.setBounds(0,0,pSize.width,pSize.height);
			chessBoard.add( square );
			int row = (i / 8) % 2;
			if(i==17) {
				playerScore.put(0, 0);
				p1 = new JLabel("Player 1 score: 0");
				square.add(p1);
				//playerScore.put(1, 0);
			}
			if(i==18) {
				playerScore.put(1, 0);
				p2 = new JLabel("Player 2 score: 0");
				square.add(p2);
				//playerScore.put(2, 0);
			}
			if(i==19) {
				playerScore.put(2, 0);
				p3 = new JLabel("Player 3 score: 0");
				square.add(p3);
				//playerScore.put(3, 0);
			}
			if(i==20 && numPlayer>3) {
				playerScore.put(3, 0);
				p4 = new JLabel("Player 4 score: 0");
				square.add(p4);
				//playerScore.put(4, 0);
			}
			if(i == 21 && numPlayer >4) {
				playerScore.put(4, 0);
				p5 = new JLabel("Player 5 score: 0");
				square.add(p5);
				//playerScore.put(5, 0);
			}
			if(i==22 && numPlayer >5) {
				playerScore.put(5, 0);
				p6 = new JLabel("Player 6 score: 0");
				square.add(p6);
				//playerScore.put(6, 0);
			}
			if(i==27) {
				square.setLayout(new GridLayout(1,1));
				rolled = new JLabel("Hit dice to start!");
				square.add(rolled);
			}
			if(i==28) {
				square.setLayout(new GridLayout(1,1));
				JButton dice = new JButton("Roll Dice");
				dice.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						chooseHardness();
					}
				});
				square.add(dice);
			}
			else if(i < 8||i>55&&i<64 || i%8==0 || i%8==7){
				ArrayList<JPanel> t = new ArrayList<>();
				for(int j =0;j<6;j++) {
					JPanel player = new JPanel(new BorderLayout());
					player.setBackground(Color.blue );
					t.add(player);
					square.add(player);
				}
				tileAdd(i,t);
			}
			else{
				square.setBackground(Color.WHITE);
				
			}
		}
		for(int i =0;i<numPlayer;i++) {
			switch (i) {
			case 0:{
				tiles.get(0).get(i).setBackground(Color.black);
				break;
			}
			case 1:{
				tiles.get(0).get(i).setBackground(Color.green);
				break;
			}
			case 2:{
				tiles.get(0).get(i).setBackground(Color.orange);
				break;
			}
			case 3:{
				tiles.get(0).get(i).setBackground(Color.gray);
				break;
			}
			case 4:{
				tiles.get(0).get(i).setBackground(Color.cyan);
				break;
			}
			case 5:{
				tiles.get(0).get(i).setBackground(Color.magenta);
				break;
			}
			}
		}
	}
	void chooseHardness() {
		JPanel levelPanel = new JPanel();
		JFrame levelFrame = new JFrame("choose your question type");
		
		JButton easy = new JButton("easy");
		JButton medium = new JButton("medium");
		JButton hard = new JButton("hard");
		
		easy.setFont(new Font("TimesRoman",Font.BOLD,30));
		easy.setBounds(325,200,160,70);
		
		medium.setFont(new Font("TimesRoman",Font.BOLD,30));
		medium.setBounds(325,300,160,70);
		
		hard.setFont(new Font("TimesRoman",Font.BOLD,30));
		hard.setBounds(325,400,160,70);
		
		easy.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				levelFrame.setVisible(false);
				getQuestion('e');
			}
		});
		medium.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				levelFrame.setVisible(false);
				getQuestion('m');
			}
		});
		hard.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				levelFrame.setVisible(false);	
				getQuestion('h');
			}
		});
		levelPanel.add(easy);
		levelPanel.add(medium);
		levelPanel.add(hard);
		levelPanel.setLayout(null);
		
		levelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		levelFrame.add(levelPanel);
		levelFrame.setSize(800,600);
		levelFrame.setVisible(true);
	}
	void getQuestion(Character hardness) {
		//qList.importAll();
		qList.importEasy();
		qList.importMed();
		qList.importHard();
		Question q;
		int correctAns;
		JPanel qPanel = new JPanel();
		JFrame qFrame = new JFrame("question");
		if(hardness.equals('e')) {
			q = qList.getEasyQ();
		}
		else if (hardness.equals('m')) {
			q = qList.getMedQ();
		}
		else {
			q = qList.getHardQ();
		}
		correctAns = q.getCorrectAnswer();
		
		Dice d = new Dice();
		int roll = d.roll();
		
		int player = Integer.valueOf(currPlayer) + 1;
		JLabel rolled = new JLabel("Player"+player+" rolled " + roll);
		rolled.setLocation(4,4);
		rolled.setFont(new Font("TimesRoman",Font.BOLD,30));
		Dimension h = rolled.getPreferredSize();
		rolled.setBounds(285,100,h.width,h.height);
		
		JLabel question = new JLabel(q.getQuestion());
		question.setLocation(4,4);
		question.setFont(new Font("TimesRoman",Font.BOLD,30));
		Dimension size = question.getPreferredSize();
		question.setBounds(285,200,size.width,size.height);
		
		JButton ans1 = new JButton(q.getAnswerOne());
		ans1.setFont(new Font("TimesRoman",Font.BOLD,30));
		ans1.setBounds(325,300,700,100);
		
		JButton ans2 = new JButton(q.getAnswerTwo());
		ans2.setFont(new Font("TimesRoman",Font.BOLD,30));
		ans2.setBounds(325,400,700,100);
		
		JButton ans3 = new JButton(q.getAnswerThree());
		ans3.setFont(new Font("TimesRoman",Font.BOLD,30));
		ans3.setBounds(325,500,700,100);
		
		JButton ans4 = new JButton(q.getAnswerFour());
		ans4.setFont(new Font("TimesRoman",Font.BOLD,30));
		ans4.setBounds(325,600,700,100);
		
		ans1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				qFrame.setVisible(false);
				if(correctAns==1) {
					updatePlayer(hardness,roll);
				}
				else {
					showWrong(hardness,roll);
				}
			}
		});
		ans2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				qFrame.setVisible(false);
				if(correctAns==2) {
					updatePlayer(hardness,roll);
				}
				else {
					showWrong(hardness,roll);
				}
			}
		});
		ans3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				qFrame.setVisible(false);
				if(correctAns==3) {
					updatePlayer(hardness,roll);
				}
				else {
					showWrong(hardness,roll);
				}
			}
		});
		ans4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				qFrame.setVisible(false);
				if(correctAns==4) {
					updatePlayer(hardness,roll);
				}
				else {
					showWrong(hardness,roll);
				}
			}
		});
		
		qPanel.add(rolled);
		qPanel.add(question);
		qPanel.add(ans1);
		qPanel.add(ans2);
		qPanel.add(ans3);
		qPanel.add(ans4);
		qPanel.setLayout(null);
		
		qFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		qFrame.add(qPanel);
		qFrame.setSize(1200,1000);
		qFrame.setVisible(true);
	}
	void showWrong(char hardness, int roll) {
		if(hardness=='e') {
			tiles.get(playerPlace.get(currPlayer)).get(currPlayer).setBackground(Color.blue);
			Color c;
			if(currPlayer==0) {
				c = Color.black;
			}
			else if(currPlayer == 1) {
				c = Color.green;
			}
			else if(currPlayer ==2) {
				c = Color.orange;
			}
			else if(currPlayer == 3) {
				c = Color.gray;
			}
			else if(currPlayer == 4) {
				c = Color.cyan;
			}
			else{
				c = Color.magenta;
			}
			int place;
			if(playerPlace.get(currPlayer)+roll>27) {
				place = playerPlace.get(currPlayer)+roll-27;
			}
			else {
				place = playerPlace.get(currPlayer)+roll;
			}
			tiles.get(place).get(currPlayer).setBackground(c);
			playerPlace.put(currPlayer, place);
			rolled.setText("Player: "+currPlayer+1+" answered wrong!");
		}
		else if(hardness =='m') {
			tiles.get(playerPlace.get(currPlayer)).get(currPlayer).setBackground(Color.blue);
			Color c;
			if(currPlayer==0) {
				c = Color.black;
			}
			else if(currPlayer == 1) {
				c = Color.green;
			}
			else if(currPlayer ==2) {
				c = Color.orange;
			}
			else if(currPlayer == 3) {
				c = Color.gray;
			}
			else if(currPlayer == 4) {
				c = Color.cyan;
			}
			else{
				c = Color.magenta;
			}
			int place;
			if(playerPlace.get(currPlayer)+roll>27) {
				place = playerPlace.get(currPlayer)+roll-27;
			}
			else {
				place = playerPlace.get(currPlayer)+roll;
			}
			tiles.get(place).get(currPlayer).setBackground(c);
			playerPlace.put(currPlayer, place);
			int p = Integer.valueOf(currPlayer)+1;
			rolled.setText("Player"+ p+" subtract "+ roll);
			int score;
			score =Integer.valueOf(playerScore.get(currPlayer))-roll;
			playerScore.put(currPlayer, score);
			if(currPlayer == 0) {
				p1.setText("Player 1 score: " + playerScore.get(currPlayer));
			}
			else if(currPlayer == 1) {
				p2.setText("Player 2 score: " + playerScore.get(currPlayer));
			}
			else if(currPlayer == 2) {
				p3.setText("Player 3 score: " + playerScore.get(currPlayer));
			}
			else if(currPlayer == 3) {
				p4.setText("Player 4 score: " + playerScore.get(currPlayer));
			}
			else if(currPlayer == 4) {
				p5.setText("Player 5 score: " + playerScore.get(currPlayer));
			}
			else if(currPlayer == 5) {
				p6.setText("Player 6 score: " + playerScore.get(currPlayer));
			}
			rolled.setText("Wrong! subtract: "+roll+" Points.");
		}
		
		else {
			int score;
			score =Integer.valueOf(playerScore.get(currPlayer)) - roll;
			playerScore.put(currPlayer, score);
			if(currPlayer == 0) {
				p1.setText("Player 1 score: " + playerScore.get(0));
			}
			else if(currPlayer == 1) {
				p2.setText("Player 2 score: " + playerScore.get(1));
			}
			else if(currPlayer == 2) {
				p3.setText("Player 3 score: " + playerScore.get(2));
			}
			else if(currPlayer == 3) {
				p4.setText("Player 4 score: " + playerScore.get(3));
			}
			else if(currPlayer == 4) {
				p5.setText("Player 5 score: " + playerScore.get(4));
			}
			else if(currPlayer == 5) {
				p6.setText("Player 6 score: " + playerScore.get(5));
			}
			int p = Integer.valueOf(currPlayer)+1;
			rolled.setText("Worong! subtract: "+ roll+"Points.");
		}

		if(currPlayer==numPlayer-1) {
			currPlayer =0;
		}
		else {
			currPlayer++;
		}
	}
		
	void updatePlayer(char hardness,int roll) {
		tiles.get(playerPlace.get(currPlayer)).get(currPlayer).setBackground(Color.blue);
		Color c;
		if(currPlayer==0) {
			c = Color.black;
		}
		else if(currPlayer == 1) {
			c = Color.green;
		}
		else if(currPlayer ==2) {
			c = Color.orange;
		}
		else if(currPlayer == 3) {
			c = Color.gray;
		}
		else if(currPlayer == 4) {
			c = Color.cyan;
		}
		else{
			c = Color.magenta;
		}
		int place;
		if(playerPlace.get(currPlayer)+roll>27) {
			place = playerPlace.get(currPlayer)+roll-27;
		}
		else {
			place = playerPlace.get(currPlayer)+roll;
		}
		tiles.get(place).get(currPlayer).setBackground(c);
		playerPlace.put(currPlayer, place);
		rolled.setText("Player"+ (currPlayer+1)+" Rolled "+ roll);
		int score;
		score =playerScore.get(currPlayer) ;
		if(hardness == 'e') {
			playerScore.put(currPlayer, score+roll);
			if(currPlayer == 0) {
				p1.setText("Player 1 score: " + playerScore.get(0));
			}
			else if(currPlayer == 1) {
				p2.setText("Player 2 score: " + playerScore.get(1));
			}
			else if(currPlayer == 2) {
				p3.setText("Player 3 score: " + playerScore.get(2));
			}
			else if(currPlayer == 3) {
				p4.setText("Player 4 score: " + playerScore.get(3));
			}
			else if(currPlayer == 4) {
				p5.setText("Player 5 score: " + playerScore.get(4));
			}
			else if(currPlayer == 5) {
				p6.setText("Player 6 score: " + playerScore.get(5));
			}
		}
		else if(hardness =='m') {
			playerScore.put(currPlayer, (score+((roll)*2)));
			if(currPlayer == 0) {
				p1.setText("Player 1 score: " + playerScore.get(0));
			}
			else if(currPlayer == 1) {
				p2.setText("Player 2 score: " + playerScore.get(1));
			}
			else if(currPlayer == 2) {
				p3.setText("Player 3 score: " + playerScore.get(2));
			}
			else if(currPlayer == 3) {
				p4.setText("Player 4 score: " + playerScore.get(3));
			}
			else if(currPlayer == 4) {
				p5.setText("Player 5 score: " + playerScore.get(4));
			}
			else if(currPlayer == 5) {
				p6.setText("Player 6 score: " + playerScore.get(5));
			}
		}
		else {
			playerScore.put(currPlayer, (score + (roll*3)));
			if(currPlayer == 0) {
				p1.setText("Player 1 score: " + playerScore.get(0));
			}
			else if(currPlayer == 1) {
				p2.setText("Player 2 score: " + playerScore.get(1));
			}
			else if(currPlayer == 2) {
				p3.setText("Player 3 score: " + playerScore.get(2));
			}
			else if(currPlayer == 3) {
				p4.setText("Player 4 score: " + playerScore.get(3));
			}
			else if(currPlayer == 4) {
				p5.setText("Player 5 score: " + playerScore.get(4));
			}
			else if(currPlayer == 5) {
				p6.setText("Player 6 score: " + playerScore.get(5));
			}
		}

		if(currPlayer==numPlayer-1) {
			currPlayer =0;
		}
		else {
			currPlayer++;
		}
		
	}
	void tileAdd(int place, ArrayList<JPanel> t) {
		switch(place) {
		case 0:{
			tiles.put(0,t);
			break;
		}
		case 1:{
			tiles.put(1, t);
			break;
		}
		case 2:{
			tiles.put(2, t);
			break;
		}
		case 3:{
			tiles.put(3, t);
			break;
		}
		case 4:{
			tiles.put(4, t);
			break;
		}
		case 5:{
			tiles.put(5, t);
			break;
		}
		case 6:{
			tiles.put(6, t);
			break;
		}
		case 7:{
			tiles.put(7, t);
			break;
		}
		case 15:{
			tiles.put(8, t);
			break;
		}
		case 23:{
			tiles.put(9, t);
			break;
		}
		case 31:{
			tiles.put(10, t);
			break;
		}
		case 39:{
			tiles.put(11, t);
			break;
		}
		case 47:{
			tiles.put(12, t);
			break;
		}
		case 55:{
			tiles.put(13, t);
			break;
		}
		case 63:{
			tiles.put(14, t);
			break;
		}
		case 62:{
			tiles.put(15, t);
			break;
		}
		case 61:{
			tiles.put(16, t);
			break;
		}
		case 60:{
			tiles.put(17, t);
			break;
		}
		case 59:{
			tiles.put(18, t);
			break;
		}
		case 58:{
			tiles.put(19, t);
			break;
		}
		case 57:{
			tiles.put(20, t);
			break;
		}
		case 56:{
			tiles.put(21, t);
			break;
		}
		case 48:{
			tiles.put(22, t);
			break;
		}
		case 40:{
			tiles.put(23, t);
			break;
		}
		case 32:{
			tiles.put(24, t);
			break;
		}
		case 24:{
			tiles.put(25, t);
			break;
		}
		case 16:{
			tiles.put(26, t);
			break;
		}
		case 8:{
			tiles.put(27, t);
			break;
		}
		default:{
			break;
		}
		}
	}
}
