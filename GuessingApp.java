/**
* MAIN CLASS
* Coordinates the game flow:
* 1. Initialize game
* 2. Accept user guesses
* 3.Validate guesses
* 4. Stop when game ends
*
*@author Develloper
*@version 2.0
*/
import java.util.*;
public class GuessingApp{
 public static void main(String[] args){
 System.out.println("Welcome to guessing app");
 
 GameConfig gc=new GameConfig();
 gc.showRules();
 
 Scanner sc=new Scanner(System.in);
 int attempts=0;
int hintCount=1;
 /*
 * Game loop runs until the player
 * exhausts the maximun attempts.
 */
 
 while(attempts< gc.getMaxAttempts()){
	 System.out.print("Enter your guess: ");
	 int guess=sc.nextInt();
	
	 
	 String result = GuessValidator.ValidateGuess(guess,gc.getTargetNumber()); 
	 
	 
	 /*
	 * stop the loop immediately
	 * if the correct number is guessed.
	 */
	 if("CORRECT".equals(result)){
		 System.out.println(result);
		 break;
	 }
	 if(hintCount<4){
	 String hint = HintService.generateHint(gc.getTargetNumber(),hintCount);
	 hintCount++;
	 System.out.println(hint);
	 
	 }
	System.out.println(result);
}
}
}
