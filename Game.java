package triviaGame;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Game {
	ArrayList <Player> player = new ArrayList<>();
	ArrayList <Tiles> tile = new ArrayList<>();
	final int tileNumber = 28;
	
	void startGame() {
		JFrame game = new JFrame();
		JLayeredPane layeredPane;
		JPanel chessBoard;
		JPanel buttonPanel = new JPanel();
		Dimension boardSize = new Dimension(400, 400);
		layeredPane = new JLayeredPane();
		game.getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		chessBoard = new JPanel();
		layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout( new GridLayout(8, 8) );
		chessBoard.setPreferredSize( boardSize );
		chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		for (int i = 0; i < 64; i++) {
			JPanel square = new JPanel( new BorderLayout() );
			chessBoard.add( square );
			int row = (i / 8) % 2;
			if(i==28) {
				JButton dice = new JButton("Roll Dice");
				square.add(dice);
			}
			else if(i < 8||i>55&&i<64 || i%8==0 || i%8==7){
				if(row==0 ) {
				square.setBackground( i % 2 == 0 ? Color.yellow : Color.blue );
				}
				else {
					square.setBackground( i % 2 == 0 ? Color.blue : Color.yellow );
				}
			}
			else{
				square.setBackground(Color.white);
				
			}
		}
		game.add(buttonPanel);
		game.add(chessBoard);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setSize(900,700);
		game.setVisible(true);
	}
}
  