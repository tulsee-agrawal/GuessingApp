/**
* MAIN CLASS
*
* Use Case 6: Game Controller
*
* This class coordinates the complete game flow
* and persists the final result after completion.
*
* Responsibilities:
* -Initialize game configuration
* -Accept and validate user inputs
* -Generate hints when applicable
* -store game result at the end
*
*@author Develloper
*@version 6.0
*/
import java.util.*;
public class GuessingApp{
 public static void main(String[] args) throws InvalidInputException{
 System.out.println("Welcome to guessing app");
 Scanner sc=new Scanner(System.in);
 boolean restart;
 
 do{	 
 /*
 * Player name is captured once
 * and stored along with game results.
 */
 
 System.out.print("Enter player name:");
 String player= sc.nextLine();
 
 GameConfig gc=new GameConfig();
 gc.showRules();
 
 int attempts=0;
 int hintCount=1;
 
 /*
 * Tracks whether the player 
 * successfully guessed the number.
 */
 boolean win=false;
 
 /*
 * Game loop runs until the player
 * exhausts the maximun attempts.
 */
 
 while(attempts< gc.getMaxAttempts()){
	 System.out.print("Enter your guess: ");
	 int guess=ValidationService.validateInput(sc.nextLine());
	
	 
	 String result = GuessValidator.ValidateGuess(guess,gc.getTargetNumber()); 
	 
	 
	 /*
	 * stop the loop immediately
	 * if the correct number is guessed.
	 */
	 if("CORRECT".equals(result)){
		 win=true;
		 System.out.println(result);
		 attempts++;
		 break;
	 }
	 
	 /*
	 * A hint is generated only after
	 * an incorrect guess aand within
	 * the allowed hint limit.
	 */
	 
	 if(hintCount<4){
	 String hint = HintService.generateHint(gc.getTargetNumber(),hintCount);
	 hintCount++;
	 System.out.println(hint);
	 
	 }
	 attempts++;
	System.out.println(result);
 }
	/*
	* final game result is persisited
	* after the current session ends.
	*/
	StorageService.saveResult(player,attempts,win);
	
	/*
	*Player decides whether to* restart the gam eor exit.
	*/
	restart =GameController.restartGame(sc);
 }while(restart);
}
}
