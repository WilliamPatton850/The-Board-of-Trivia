# Pensatrevia

1 User Interface: (GUI)
Player log in
Player enters their personal info (creates player object) (player class) 
Player selects trivia category (category / question bank class) 
Player starts game
Displays board 

2 Player Turn 
Player rolls dice (player turn class) 
Player moves on board (player turn class)
Player answers questions (questions will depend on where user lands on board) 
Player scores are recorded / rankings are updated (score class)  

3 Other Features to be added:
Ability for players to save their info, scores and rankings to a file 
Ability for players to create and upload their own questions
Ability for players to play against other people in real time???

------------------------------------------------------------------------------------------------------------------------

Classes:
User Interface class
	- log in
	- enter personal info 
	- select trivia category
- start game
- displays board 
 
Player class
- create player object for each player 

Score class
- records player scores 
- ability to compare scores of different players and rank the players 

Player turn class
- function for rolling dice 
- function for moving on board 
- function for providing trivia questions
 
Trivia Category class

Question bank class

------------------------------------------------------------------------------------------------------------------------
How will scores be calculated:
Player rolls dice 
Player moves on board
Player answers the questions for that spot on board
If a player answers enough questions correctly they receive a “property” for that spot on board?
Score is determined by how many properties player owns at end of game
Ability for players to steal other players properties on a specific spot if they answer more questions correctly? (Would this feature only work if players are playing against other people in real time?) 

--------------------------------------------------------------------------------------------------------------------------

Sprint 1 Tasks:

User Interface class:
Create user interface class
Log in 
Buttons (enter player info, select category, start game) 
Display board 

Player class:
Create player class
Declare variables and functions for player info (name, email, address, etc.)
Create function to assign player with unique ID  
