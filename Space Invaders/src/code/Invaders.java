/*Space Invader by Areeba Fazal
June 2019
Western Canada HighSchool

*/

package code;

import java.awt.*; //Import all
import java.awt.event.*;//Import all
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;//Import all

public class Invaders extends JPanel implements KeyListener, ActionListener{ //Include all info from the built in method 'JPanel', runs built in method 'KeyListener' and 'ActionListener'
	
	Timer timer = new Timer(40, this); //Create timer
	
	//Variables
	private static int playerXPosition = 100, playerYPosition = 480;
	private static int intPoints = 0, counter = 0;
	private static int alienColumnX1 = 0, alienColumnX2 = 100, alienColumnX3 = 200, alienColumnX4 = 300, alienColumnX5 = 400,  alienColumnX6 = 500;
	private static int alienRowY1 = 70, alienRowY2 = 130, alienRowY3 = 190;
	private static int alienXDirection = 5, alienYDirection = 30;
	private static int missileY = playerYPosition, missileYDirection = 0;
	
	private static boolean alien1 = true, alien2 = true, alien3 = true, alien4 = true, alien5 = true, alien6 = true, alien7 = true, alien8 = true, alien9 = true, alien10 = true, alien11 = true, alien12 = true, alien13 = true, alien14 = true, alien15 = true, alien16 = true, alien17 = true, alien18 = true, alienFiller = false;
	private static boolean endGame = false, startGame = false;
	
	private static String stringPoints = "0", playerName = "Player"; //The int version of 'points' counts, while the String is used to display
	
	private static String[] highScoreName = new String[11];
	private static int[] highScoreNumber = new int[11];
	
	
	public Invaders(){ //Constructor (called when object is created)
		timer.start();
		addKeyListener(this); //Add KeyListener to constructor
		setFocusable(true); //Allows constructor to 'focus' on whatever the user is interacting with
	}

	public void paintComponent(Graphics g) { //Built in method to draw onto the main JPanel, runs based on timer
		
		super.paintComponent(g);
		
		g.setColor(Color.black); //Draw background
		g.fillRect(0, 0, getWidth(), getHeight());
		
		//While the game is running
		if (endGame == false && startGame == true)
		{
			
			g.setColor(Color.gray);
			g.fillRect(0, 500, getWidth(), 5); //Draw ground
			
			g.setColor(Color.white);
			g.fillRect(playerXPosition, missileY, 5, 10); //Draw missile
			
			g.setColor(Color.blue);
			g.fillRect(playerXPosition, playerYPosition, 20, 20); //Draw player
			
			g.setColor(Color.white);
			Font myFont = new Font ("Courier New", 100, 20); //change font
			g.setFont (myFont);
			
			g.drawString("Points:", 30, 540); //Display current points
			g.drawString(stringPoints, 120, 540);
			
			g.drawString(playerName, 400, 540); //Display player's name
			
			myFont = new Font ("Courier New", 100, 40); //change font
			g.setFont (myFont);
			g.drawString("SPACE INVADERS", getWidth()/2 - 140, 40);	//Display title
			
			
			g.setColor(Color.red); //Change colour for all
			//Draw each alien only if set to true
			//First row
			if (alien1 == true)
				g.fillOval(alienColumnX1, alienRowY1, 40, 40);
			
			if (alien2 == true)
				g.fillOval(alienColumnX2, alienRowY1, 40, 40);
			
			if (alien3 == true)
				g.fillOval(alienColumnX3, alienRowY1, 40, 40);
			
			if (alien4 == true)
				g.fillOval(alienColumnX4, alienRowY1, 40, 40);
			
			if (alien5 == true)
				g.fillOval(alienColumnX5, alienRowY1, 40, 40);
			
			if (alien6 == true)
				g.fillOval(alienColumnX6, alienRowY1, 40, 40);
			
			
			//Second row
			if (alien7 == true)
				g.fillOval(alienColumnX1, alienRowY2, 40, 40);
			
			if (alien8 == true)
				g.fillOval(alienColumnX2, alienRowY2, 40, 40);
			
			if (alien9 == true)
				g.fillOval(alienColumnX3, alienRowY2, 40, 40);
			
			if (alien10 == true)
				g.fillOval(alienColumnX4, alienRowY2, 40, 40);
			
			if (alien11 == true)
				g.fillOval(alienColumnX5, alienRowY2, 40, 40);
			
			if (alien12 == true)
				g.fillOval(alienColumnX6, alienRowY2, 40, 40);
			
			
			//Third row
			if (alien13 == true)
				g.fillOval(alienColumnX1, alienRowY3, 40, 40);
			
			if (alien14 == true)
				g.fillOval(alienColumnX2, alienRowY3, 40, 40);
			
			if (alien15 == true)
				g.fillOval(alienColumnX3, alienRowY3, 40, 40);
			
			if (alien16 == true)
				g.fillOval(alienColumnX4, alienRowY3, 40, 40);
			
			if (alien17 == true)
				g.fillOval(alienColumnX5, alienRowY3, 40, 40);
			
			if (alien18 == true)
				g.fillOval(alienColumnX6, alienRowY3, 40, 40);	
		}
		
		else if (endGame == true) //Once game is lost/won
		{
			g.setColor(Color.gray);
			g.fillRect(0, 500, getWidth(), 20);
			
			g.fillRect(0, 75, getWidth(), 20);
			
			Font myFont = new Font ("Courier New", 100, 40);
			g.setFont (myFont);
			g.drawString("END GAME", getWidth()/2 - 80, 40); //Title
			
			myFont = new Font ("Courier New", 100, 20);
			g.setFont (myFont);
			g.drawString("Points:", 30, 550); //Points
			g.drawString(stringPoints, 120, 550);	
			
			g.drawString(playerName, 400, 550); //Name
			
			myFont = new Font ("Courier New", 100, 25);
			g.setFont (myFont);
			
			//Display High Score board
			g.drawString(highScoreName[0], 100, 150);
			String number = String.valueOf(highScoreNumber[0]);
			g.drawString(number, 540, 150);
			
			g.drawString(highScoreName[1], 100, 180);
			number = String.valueOf(highScoreNumber[1]);
			g.drawString(number, 540, 180);
			
			g.drawString(highScoreName[2], 100, 210);
			number = String.valueOf(highScoreNumber[2]);
			g.drawString(number, 540, 210);
			
			g.drawString(highScoreName[3], 100, 240);
			number = String.valueOf(highScoreNumber[3]);
			g.drawString(number, 540, 240);
			
			g.drawString(highScoreName[4], 100, 270);
			number = String.valueOf(highScoreNumber[4]);
			g.drawString(number, 540, 270);
			
			g.drawString(highScoreName[5], 100, 300);
			number = String.valueOf(highScoreNumber[5]);
			g.drawString(number, 540, 300);
			
			g.drawString(highScoreName[6], 100, 330);
			number = String.valueOf(highScoreNumber[6]);
			g.drawString(number, 540, 330);
			
			g.drawString(highScoreName[7], 100, 360);
			number = String.valueOf(highScoreNumber[7]);
			g.drawString(number, 540, 360);
			
			g.drawString(highScoreName[8], 100, 390);
			number = String.valueOf(highScoreNumber[8]);
			g.drawString(number, 540, 390);
			
			g.drawString(highScoreName[9], 100, 420);
			number = String.valueOf(highScoreNumber[9]);
			g.drawString(number, 540, 420);
			
		}
		

	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Invaders object = new Invaders(); //Create new object

		//Create JFrame for opening menu
		JFrame OpeningFrame = new JFrame();
		OpeningFrame.setBackground(Color.black);
		OpeningFrame.setTitle("ENTER  NAME");
		OpeningFrame.setResizable(false);
		OpeningFrame.setSize(290, 250);
		OpeningFrame.setLocationRelativeTo(null);
		OpeningFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane1 = new JPanel(); 
		
		//Add text to opening menu
		JLabel label2 = new JLabel("Welcome to Space Invaders");
		JLabel label3 = new JLabel("Use the left and right arrow keys to move");
		JLabel label4 = new JLabel("Use the space bar to shoot");
		JLabel label5 = new JLabel("Destroy all the aliens before they reach you!");
		JLabel label = new JLabel("Please enter a name");
		pane1.add(label2);
		pane1.add(label3);
		pane1.add(label4);
		pane1.add(label5);
		pane1.add(label);

		
		JTextField textField = new JTextField(20); //Create textfield (area for user to input words)
		
		pane1.add(textField);
		textField.setBounds(100, 100, 200, 50);

		JButton button = new JButton("Start Game"); //Create button
		pane1.add(button);
		OpeningFrame.add(pane1);
		OpeningFrame.setVisible(true);
		
		
		JFrame Frame = new JFrame(); //Create Main Game Frame
		Frame.setTitle("SPACE INVADERS");
		Frame.setResizable(false);
		Frame.setSize(700, 600);
		Frame.setLocationRelativeTo(null);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.add(object);
			
		button.addActionListener(new ActionListener() { //Create actionlistener for when button on opening frame is pressed
		        public void actionPerformed(ActionEvent e) {
		        	
		        		//This error traps in case the user doesn't input a name
		        		if (textField.getText().length() > 0) 
		        			playerName = textField.getText(); //Set player's name to be inputed string from textfield
		        		
		        		OpeningFrame.dispose(); //close opening frame
		        		startGame = true; //start the game
		        		Frame.setVisible(true); // Open Main Game Frame
		        	 }
		        
		    } );
		saveScore(); //Go to score board method (prevents error when PaintComponent tries to read empty arrays)
	}

	@Override
	public void actionPerformed(ActionEvent e) { //Auto-generated method that runs with the timer
		
		if (startGame == true) {
			
			missileY -= missileYDirection;
			
			//Move each entire column based on alienXDirection
			alienColumnX1 = moveAlienX(alienColumnX1, alienXDirection);
			alienColumnX2 = moveAlienX(alienColumnX2, alienXDirection);
			alienColumnX3 = moveAlienX(alienColumnX3, alienXDirection);
			alienColumnX4 = moveAlienX(alienColumnX4, alienXDirection);
			alienColumnX5 = moveAlienX(alienColumnX5, alienXDirection);
			alienColumnX6 = moveAlienX(alienColumnX6, alienXDirection);
	
			//If the last/first alien reaches the end of the screen, change its direction and move it down
			if (alienColumnX6 > getWidth() || alienColumnX1 < 0)
			{
				alienXDirection = -alienXDirection;
				alienRowY1 += alienYDirection;
				alienRowY2 += alienYDirection;
				alienRowY3 += alienYDirection;
			}
			//Only do once when endGame is true
			if (endGame && counter < 1)
			{
				try {
					saveScore();//Go to save Score board method
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				counter++;
			}
				
			redirectCollision(); //Method to manage whether or not each aliens was hit
			alienReached(); //Method for when the alien reaches the bottom of the screen
			repaint(); //Redraw the paintComponent method (this creates the 'animation')
			
		}
		
	}
	
	public static int moveAlienX(int alienX, int alienDirection){
		
		alienX += alienXDirection;
		return alienX;
	}
	
	public static void alienReached(){
		
		if (alien1 == false && alien2 == false &&  alien3 == false &&  alien4 == false && alien5 == false && alien6 == false && alien7 == false && alien8 == false && alien9 == false &&  alien10 == false &&  alien11 == false && alien12 == false && alien13 == false && alien14 == false && alien15 == false && alien16 == false &&  alien17 == false &&  alien18 == false)
		{
			endGame = true; //If player wins the game
		}
		else if (alien7 == false && alien8 == false && alien9 == false &&  alien10 == false &&  alien11 == false && alien12 == false && alien13 == false && alien14 == false && alien15 == false && alien16 == false &&  alien17 == false &&  alien18 == false)
		{
			if(alienRowY1 >= 460)
				endGame = true; // If the last two rows are destroyed, but the first reaches the bottom
		}
		else if (alien13 == false && alien14 == false && alien15 == false && alien16 == false &&  alien17 == false &&  alien18 == false)
		{
			if(alienRowY2 >= 460)
				endGame = true; // If the last rows is destroyed, but the second last reaches the bottom
		}
		else{
			
			if(alienRowY3 >= 460)
				endGame = true; // If no rows are destroyed, and the last row reaches the botom
			
		}
		
	}
	
	public static void redirectCollision(){
		
		//Check for every alien
		alien1 = collision(alienColumnX1, alien1, alienRowY1);
		alien2 = collision(alienColumnX2, alien2, alienRowY1);
		alien3 = collision(alienColumnX3, alien3, alienRowY1);
		alien4 = collision(alienColumnX4, alien4, alienRowY1);
		alien5 = collision(alienColumnX5, alien5, alienRowY1);
		alien6 = collision(alienColumnX6, alien6, alienRowY1);
		
		alien7 = collision(alienColumnX1, alien7, alienRowY2);
		alien8 = collision(alienColumnX2, alien8, alienRowY2);
		alien9 = collision(alienColumnX3, alien9, alienRowY2);
		alien10 = collision(alienColumnX4, alien10, alienRowY2);
		alien11 = collision(alienColumnX5, alien11, alienRowY2);
		alien12 = collision(alienColumnX6, alien12, alienRowY2);
		
		alien13 = collision(alienColumnX1, alien13, alienRowY3);
		alien14 = collision(alienColumnX2, alien14, alienRowY3);
		alien15 = collision(alienColumnX3, alien15, alienRowY3);
		alien16 = collision(alienColumnX4, alien16, alienRowY3);
		alien17 = collision(alienColumnX5, alien17, alienRowY3);
		alien18 = collision(alienColumnX6, alien18, alienRowY3);
	}
	
	public static boolean collision(int alienX, boolean alien, int alienY) {
		
		if ((missileY >= alienY - 5 && missileY <= alienY + 45) && (playerXPosition >= alienX - 5 && playerXPosition <= alienX + 45) && alien == true) //If missile poistion = alien position
		{
			alien = false; //If an alien is hit, return false
			missileY = playerYPosition; //If the missile hits an alien, reset its position
			missileYDirection = 0;
			if (endGame == false) //If the game hasn't ended yet
			{
				intPoints+=5; //Add to the player's score
				stringPoints = String.valueOf(intPoints);
			}
			
		}
		
		if (missileY <= 0) //If the missile goes out of bounds, reset its position
		{
			missileY = playerYPosition;
			missileYDirection = 0;
		}
		
		return alien;	
	}
	
	public static void descending () { //Sort the scores into descending order
		
		int currentHighest, position;
		String highestPlayer;
		for(int spot = 0; spot < highScoreName.length; spot++)
		{
			currentHighest = 0;
			position = 0;
			highestPlayer = "";
			for(int x = spot; x < highScoreName.length; x++)
			{
				if (highScoreNumber[x] >= currentHighest) //Compare every number to the last highest number
				{
					currentHighest = highScoreNumber[x];//set currentHighest to the highest number of the 2 until it reaches the end of the array
					highestPlayer = highScoreName[x]; //Change the player name to match the score
					position = x;
				}
					 
			
			}
			//Switch player name and score into descending order
			int temp = highScoreNumber[spot];
			String temp1 = highScoreName[spot];
			highScoreNumber[position] = temp;
			highScoreName[position] = temp1;
			highScoreNumber[spot] = currentHighest;
			highScoreName[spot] = highestPlayer;
		}
	}
	
	public static void saveScore() throws FileNotFoundException {//Create Score board
		
		
		File readScoreNumber = new File("ScoreNumber.txt"); //Read the ScoreNumber file (contains top 10 previous players scores
		Scanner inputNumber = new Scanner(readScoreNumber);
		
		int counter = 0;
		int score = 0;
		
		while(inputNumber.hasNextInt() && counter < highScoreNumber.length)//Add each score into an array
		{
			score = inputNumber.nextInt();
			highScoreNumber[counter] = 	score;
			counter++;
		}
		
		
		File readScoreName = new File("ScoreName.txt"); //Read the ScoreName file (contains top 10 previous players names
		Scanner inputName = new Scanner(readScoreName);
		
		String name = "";
		counter = 0; //reset counter
		while(inputName.hasNextLine() && counter < highScoreName.length)//Add each name into an array
		{
			name = inputName.nextLine();
			highScoreName[counter] = name;
			counter++;
		}
		descending(); //Sort into descending order
		
		if (intPoints >= highScoreNumber[10])//If the current players score is larger than the lowest on the score board
		{
			highScoreNumber[10] = intPoints; //Ass current player's score and name to the arrays
			highScoreName[10] = playerName;
			descending(); //Sort into descending order again
		}
		
		
		PrintWriter addScore = new PrintWriter("ScoreNumber.txt");
		
		for(int x = 0; x < highScoreNumber.length; x++)
		{
			addScore.println(highScoreNumber[x]); //Print out scores to file
		}
		
		addScore.close();
		
		PrintWriter addName = new PrintWriter("ScoreName.txt");
		
		for(int x = 0; x < highScoreName.length; x++)
		{
			addName.println(highScoreName[x]); //Print out names to file
		}
		
		addName.close();
		
	}

	@Override
	public void keyPressed(KeyEvent e) { //Auto-generated method to detect keyboard input
		
		int playerInput = e.getKeyCode();
		
		if (playerInput == KeyEvent.VK_LEFT && playerXPosition >= 20) //When left key pressed and the player is in the board
			playerXPosition-=20; //move player left
		
		
		if (playerInput == KeyEvent.VK_RIGHT && playerXPosition <= getWidth()-20) //When right key pressed and the player is in the board
			playerXPosition+=20; // move player right
		
		if (playerInput == KeyEvent.VK_SPACE) //When space bar pressed
			missileYDirection = 20; //Change missile Direction
		
			
	}
	

	@Override
	public void keyReleased(KeyEvent e) {//Auto-generated method to detect keyboard input
		//Auto-generated NOT USED
		
	}

	@Override
	public void keyTyped(KeyEvent e) {//Auto-generated method to detect keyboard input
		//Auto-generated NOT USED
		
	}
	

}
