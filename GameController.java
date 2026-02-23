/**
* Handles game lifecycle decisions.
*
* This class is responsible for deciding 
* whether the game should restart or exit
* based on user choice.
*/
import java.util.*;
public class GameController{
	
	/*
	* Asks the player if they want to
	* restart the game after completion
	*
	* Returns true if the game should restart,
	* false i fthe application should exit.
	*/
	
	public static boolean restartGame(Scanner sc){
		System.out.print("Do you want to play again? (y/n):");
		return sc.nextLine().equalsIgnoreCase("y");
	}
}