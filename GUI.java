// The main menu of the game display by GUI
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
			startButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					menuFrame.setVisible(false);
					selectNumPlayer();			//this is the number of players	
				}
			});
			
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
		void selectNumPlayer() {	
			
			int numReturn;
			JFrame numPlayerFrame = new JFrame("Number of Player");
			JLabel playerNumberLabel = new JLabel("Number of Player?");
			JButton num3Button = new JButton("3");
			JButton num4Button = new JButton("4");
			JButton num5Button = new JButton("5");
			JPanel numPlayerPanel = new JPanel();
			
			playerNumberLabel.setLocation(4,4);
			playerNumberLabel.setFont(new Font("TimesRoman",Font.BOLD,30));
			Dimension size = playerNumberLabel.getPreferredSize();
			playerNumberLabel.setBounds(285,100,size.width,size.height);
			
			num3Button.setFont(new Font("TimesRoman",Font.BOLD,30));
			num3Button.setBounds(325,200,120,70);
			
			num4Button.setFont(new Font("TimesRoman",Font.BOLD,30));
			num4Button.setBounds(325,300,120,70);
			
			num5Button.setFont(new Font("TimesRoman",Font.BOLD,30));
			num5Button.setBounds(325,400,120,70);
			
			numPlayerPanel.add(playerNumberLabel);
			numPlayerPanel.add(num3Button);
			numPlayerPanel.add(num4Button);
			numPlayerPanel.add(num5Button);
			numPlayerPanel.setLayout(null);
			
			numPlayerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			numPlayerFrame.add(numPlayerPanel);
			numPlayerFrame.setSize(800,600);
			numPlayerFrame.setVisible(true);
			
			num3Button.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					loginSelect(3);
				}
			});
			num4Button.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					loginSelect(4);								
				}
			});
			num5Button.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					loginSelect(5);								
				}
			});
		}
		void loginSelect(int numPlayer) {
			
			JFrame loginFrame = new JFrame("Login");
			JLabel loginLabel = new JLabel("Login");
			JLabel userNameLabel = new JLabel("User Name: ");
			JLabel passwordLabel = new JLabel("Password: ");
			JPanel loginPanel = new JPanel();
			JTextField userNameText = new JTextField();
			JTextField passwordText = new JTextField();
			JButton loginButton = new JButton("LOGIN");
			
			loginButton.setFont(new Font("TimesRoman",Font.BOLD,25));
			loginButton.setBounds(325,370,120,70);
			
			loginLabel.setLocation(4,4);
			loginLabel.setFont(new Font("TimesRoman",Font.BOLD,30));
			Dimension size = loginLabel.getPreferredSize();
			loginLabel.setBounds(320,100,size.width,size.height);
			
			userNameLabel.setLocation(3,3);
			userNameLabel.setFont(new Font("TimesRoman",Font.BOLD,30));
			Dimension size2 = userNameLabel.getPreferredSize();
			userNameLabel.setBounds(140,160,size2.width,size2.height);
			
			passwordLabel.setLocation(2,2);
			passwordLabel.setFont(new Font("TimesRoman",Font.BOLD,30));
			Dimension size3 = passwordLabel.getPreferredSize();
			passwordLabel.setBounds(140,220,size3.width,size3.height);
			
			userNameText.setBounds(320,160,180,40);
			
			passwordText.setBounds(320,220,180,40);
			
			loginPanel.add(loginLabel);
			loginPanel.add(userNameLabel);
			loginPanel.add(passwordLabel);
			loginPanel.add(userNameText);
			loginPanel.add(passwordText);
			loginPanel.add(loginButton);
			loginPanel.setLayout(null);
			
			loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loginFrame.add(loginPanel);
			loginFrame.setSize(800,600);
			loginFrame.setVisible(true);
		}
}
