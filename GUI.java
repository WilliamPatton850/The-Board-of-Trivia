import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
class GUI{
		private int numOfPlayer;
		private char startRankingLogin;
		private char startOrRanking;
		
		private PlayerStorage newPlayer;
		private Player playerTest;
		
		GUI(){
			newPlayer = new PlayerStorage();
			playerTest = new Player();
		}
		
		// function to start 
		public void start() {
			menu();
		}
		
		//The main page of the GUI
		public void menu(){
			
			JFrame menuFrame = new JFrame("Menu");
			JLabel gameLabel = new JLabel("Pensatrivia");
			JButton startButton = new JButton("Start");
			JButton registration = new JButton("Register");
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
			
			registration.setFont(f);
			registration.setBounds(310,400, 150, 50);
			registration.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					menuFrame.setVisible(false);
					loginPage();
					
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
			menuPanel.add(registration);
			menuPanel.setLayout(null);	
			
			menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			menuFrame.add(menuPanel);
			menuFrame.setSize(800,600);
			menuFrame.setVisible(true);
			
			
		}
		
		//The Registration Page
		public void loginPage() {
			JPanel registration = new JPanel();
			JFrame Register = new JFrame("Register");
			
			JLabel first = new JLabel("First Name: ");
			JLabel last = new JLabel("Last Name: ");
			JLabel email = new JLabel("Email: ");
			JLabel password = new JLabel("Password: ");
			
			JTextField firstT = new JTextField();
			JTextField lastT = new JTextField();
			JTextField emailT = new JTextField();
			JTextField passwordT = new JTextField();
			
			JButton RegisterButton = new JButton("Register");
			RegisterButton.setFont(new Font("TimesRoman",Font.BOLD,25));
			Dimension size0 = RegisterButton.getPreferredSize();
			RegisterButton.setBounds(320,400,size0.width,size0.height);
			
			//RegisterButton that redirect to Start Button if pass
			RegisterButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(firstT.getText().length() > 1 && lastT.getText().length() > 1 && emailT.getText().length() > 1 && passwordT.getText().length() > 1 ) {
						Register.setVisible(false);
						playerTest.setAll(firstT.getText(), lastT.getText(), emailT.getText(), passwordT.getText());
						newPlayer.input(playerTest);
						showUserName();
					}
	
					
				}
			});
			
			
			first.setFont(new Font("TimesRoman",Font.BOLD,30));
			Dimension size = first.getPreferredSize();
			first.setBounds(150,100,size.width,size.height);
			
			
			last.setFont(new Font("TimesRoman",Font.BOLD,30));
			Dimension size1 = last.getPreferredSize();
			last.setBounds(150,160,size1.width,size1.height);
			
			
			email.setFont(new Font("TimesRoman",Font.BOLD,30));
			Dimension size2 = email.getPreferredSize();
			email.setBounds(150,220,size2.width,size2.height);
			
			
			password.setFont(new Font("TimesRoman",Font.BOLD,30));
			Dimension size3 = password.getPreferredSize();
			password.setBounds(150,280,size3.width,size3.height);
			
			
			firstT.setBounds(320,100,180,40);
			
			lastT.setBounds(320,160,180,40);
			
			emailT.setBounds(320,220,180,40);
			
			passwordT.setBounds(320,280,180,40);
			
			registration.add(first);
			registration.add(last);
			registration.add(email);
			registration.add(password);
			registration.add(firstT);
			registration.add(lastT);
			registration.add(emailT);
			registration.add(passwordT);
			registration.add(RegisterButton);
			registration.setLayout(null);
			
			Register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Register.add(registration);
			Register.setSize(800,600);
			Register.setVisible(true);
			
		}
		
		//Show the userName so user can copy to login into game
		public void showUserName() {
			JPanel Continue = new JPanel();
			JFrame ContinuePage = new JFrame("Register");
			
			JLabel UserName = new JLabel("Your UserName: " + playerTest.GetPlayerName());
			
			JButton ContinueButton = new JButton("Continue");
			ContinueButton.setFont(new Font("TimesRoman",Font.BOLD,25));
			Dimension size0 = ContinueButton.getPreferredSize();
			ContinueButton.setBounds(320,400,size0.width,size0.height);
			
			//Select the Number of player
			ContinueButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					ContinuePage.setVisible(false);
					selectNumPlayer();
				}
			});
			
			UserName.setFont(new Font("TimesRoman",Font.BOLD,30));
			Dimension size = UserName.getPreferredSize();
			UserName.setBounds(220,100,size.width,size.height);
			
			Continue.add(UserName);
			Continue.add(ContinueButton);
			Continue.setLayout(null);
			
			ContinuePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ContinuePage.add(Continue);
			ContinuePage.setSize(800,600);
			ContinuePage.setVisible(true);
			
			
			
		}
		
		
		//show that the information is incorrect
		public void showWrongValidation() {
			JPanel Wrong = new JPanel();
			JFrame WrongFrame = new JFrame("Wrong");
			
			JLabel WrongLabel = new JLabel("Wrong UserName or Password");
			
			JButton Continue = new JButton("Continue back to login");
			Continue.setFont(new Font("TimesRoman",Font.BOLD,25));
			Dimension size0 = Continue.getPreferredSize();
			Continue.setBounds(260,400,size0.width,size0.height);
			
			Continue.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					WrongFrame.setVisible(false);
					menu();
				}
			});
			
			WrongLabel.setFont(new Font("TimesRoman",Font.BOLD,30));
			Dimension size = WrongLabel.getPreferredSize();
			WrongLabel.setBounds(200,100,size.width,size.height);
			
			
			Wrong.add(WrongLabel);
			Wrong.add(Continue);
			Wrong.setLayout(null);
			
			WrongFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			WrongFrame.add(Wrong);
			WrongFrame.setSize(800,600);
			WrongFrame.setVisible(true);
			
		}
		
		
		//3 4 5 players to login
		public void selectNumPlayer() {	
			
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
					numPlayerFrame.setVisible(false);
					loginSelect(3);
				}
			});
			num4Button.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					numPlayerFrame.setVisible(false);
					loginSelect(4);								
				}
			});
			num5Button.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					numPlayerFrame.setVisible(false);
					loginSelect(5);								
				}
			});
		}
		
		//login screen
		public void loginSelect(int numPlayer) {
			
			numOfPlayer = numPlayer;
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
			
			
			
			//Check if login available link to board
			loginButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(newPlayer.IsPlayerLogin(userNameText.getText(), passwordText.getText())) {
						loginFrame.setVisible(false);
						Game g = new Game(numPlayer);
						g.startGame();
					}
					
					else {
						loginFrame.setVisible(false);
						showWrongValidation();
					}
							
					
				}
			});
			
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
