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
	static HashMap<Integer,Integer> playerPlace = new HashMap<>();
	
	Game(int numP){
		numPlayer =numP ;
		currPlayer = 0;
		for(int i =0;i<numPlayer;i++) {
			playerPlace.put(i, 0);
		}
	}
	void startGame() {
		JFrame game = new JFrame();
		Dimension boardSize = new Dimension(400, 400);
		chessBoard = new JPanel();
		chessBoard.setLayout( new GridLayout(8, 8,20,20) );
		chessBoard.setPreferredSize( boardSize );
		chessBoard.setBounds(0, 0, boardSize.width,boardSize.height);
		getSquares();
		game.add(chessBoard);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setSize(900,700);
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
			if(i==27) {
				square.setLayout(new GridLayout(1,1));
			}
			if(i==28) {
				square.setLayout(new GridLayout(1,1));
				JButton dice = new JButton("Roll Dice");
				dice.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						Dice d = new Dice();
						int roll = d.roll();
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
						if(currPlayer==numPlayer-1) {
							currPlayer =1;
						}
						else {
							currPlayer++;
						}
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
