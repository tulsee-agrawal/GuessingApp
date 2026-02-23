/**
* use case 1 :game initialization
*
*this class serves as the application entry point.
* it initializes the game configuration and displays game rules.
*
*no user input or gameplay logic is implemented at this stage.
*
*@author Develloper
*@version 1.0
*/
import java.util.*;
public class GuessingApp{
 public static void main(String[] args){
 System.out.println("Welcome to guessing app");
 GameConfig gc=new GameConfig();
 gc.showRules();
 Scanner sc=new Scanner(System.in);
 int attemptsLeft=gc.getMaxAttempts();
 int target=gc.getTargetNumber();
}
}
