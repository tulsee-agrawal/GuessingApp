/**
* MAIN CLASS
*
* Use Case 4: Error handling & ValidationEvent
*
* This class coordinates the game execution while ensuring
* all user inputs are safely validated before processing.
*
* Responsibilities:
* -Initialize game configuration
* -Accept user inputs
* -Validate input using ValidationSevice
* -Handle game flow without crashing on valid input
*
*@author Develloper
*@version 4.0
*/
import java.util.*;
public class GuessingApp{
 public static void main(String[] args) throws InvalidInputException{
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
	 int guess=ValidationService.validateInput(sc.nextLine());
	
	 
	 String result = GuessValidator.ValidateGuess(guess,gc.getTargetNumber()); 
	 
	 
	 /*
	 * stop the loop immediately
	 * if the correct number is guessed.
	 */
	 if("CORRECT".equals(result)){
		 System.out.println(result);
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
	System.out.println(result);
}
}
}
