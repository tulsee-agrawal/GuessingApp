/**
* use case 1 :game initialization
*
*this class is responsible for:
* - setting game boundaries
* -generating a random target number
* -displaying game rules
*
*demonstrates:
* -encapsulation
* -constructor initialization
* -random number generation

*/
import java.util.*;
class GameConfig{
private final int MIN=1;
private final int MAX=100;
private final int MAX_ATTEMPTS=7;
private final int MAX_HINTS=3;
int targetNumber;

/**
* constructor is automatically called when a gameconfig object is created.
* it initializes the random target number for the game.
*/

public GameConfig(){
Random random=new Random();
this.targetNumber=random.nextInt(MAX-MIN+1)+MIN;
}
public int getTargetNumber(){ return targetNumber;}
public int getMaxAttempts(){ return MAX_ATTEMPTS;}
public int getMaxHints() {return MAX_HINTS;}
public void showRules(){
System.out.println("guess a number between "+MIN+" and "+MAX);
System.out.println("you have " +MAX_ATTEMPTS+" attempts.");
System.out.println("Hints will be provided after wrong guesses.\n");;
}
}
