package triviaGame;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
class GUI{
		int numOfPlayer;
		char startRankingLogin;
		char startOrRanking;
		GUI(){
		}
		void start() {
			menu();
		}
		void menu(){
			
			JFrame menuFrame = new JFrame("Menu");
			JLabel gameLabel = new JLabel("Pensatrivia");
			JButton startButton = new JButton("Start");
			JButton rankButton = new JButton("Ranking");
			Font f = new Font("TimesRoman",Font.BOLD,30);
			JPanel menuPanel = new JPanel();
			
			startButton.setFont(f);
			startButton.setBounds(310,200,150,50);
			ActionListener actionListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String s =e.getActionCommand();
					if (s.equals("s")) {
						selectNumPlayer();
					}
				}
			};
			startButton.addActionListener(actionListener);
			
			rankButton.setFont(f);
			rankButton.setBounds(310,300,150,50);
			
			gameLabel.setLocation(4,4);
			gameLabel.setFont(f);
			Dimension size = gameLabel.getPreferredSize();
			gameLabel.setBounds(310,100,size.width,size.height);
			
			menuPanel.add(gameLabel);
			menuPanel.add(startButton);
			menuPanel.add(rankButton);
			menuPanel.setLayout(null);	
			
			menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			menuFrame.add(menuPanel);
			menuFrame.setSize(800,600);
			menuFrame.setVisible(true);
			
			
		}
		int selectNumPlayer() {
			
			JFrame numPlayerFrame = new JFrame("Number of Player");
			JLabel playerNumberLabel = new JLabel("Number of Player?");
			JButton num3Button = new JButton("3");
			JButton num4Button = new JButton("4");
			JButton num5Button = new JButton("5");
			JPanel numPlayerPanel = new JPanel();
			
			playerNumberLabel.setLocation(4,4);
			playerNumberLabel.setFont(new Font("TimesRoman",Font.BOLD,30));
			Dimension size = playerNumberLabel.getPreferredSize();
			playerNumberLabel.setBounds(310,100,size.width,size.height);
			
			num3Button.setFont(new Font("TimesRoman",Font.BOLD,30));
			num3Button.setBounds(310,200,150,150);
			
			num4Button.setFont(new Font("TimesRoman",Font.BOLD,30));
			num4Button.setBounds(310,300,150,150);
			
			num5Button.setFont(new Font("TimesRoman",Font.BOLD,30));
			num5Button.setBounds(310,400,150,150);
			
			numPlayerPanel.add(playerNumberLabel);
			numPlayerPanel.add(num3Button);
			numPlayerPanel.add(num4Button);
			numPlayerPanel.add(num5Button);
			numPlayerPanel.setLayout(null);
			
			numPlayerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			numPlayerFrame.add(numPlayerPanel);
			numPlayerFrame.setSize(800,600);
			numPlayerFrame.setVisible(true);
			return 3;
			
		}
		
}
