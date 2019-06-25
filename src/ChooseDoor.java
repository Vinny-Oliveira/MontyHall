//import java.util.Random;

public class ChooseDoor {
	
    public static void main(String[] args) {
    	boolean blnWin = false;
    	int intNumberOfDoors = 3;
    	
        int intCarDoor = (int)(Math.random() * intNumberOfDoors + 1); // Door where the car is
        int intChoice = (int)(Math.random() * intNumberOfDoors + 1); // Door chosen by the player
        System.out.println("Car: " + intCarDoor);
        System.out.println("Choice: " + intChoice);
        
        // Door revealed
        int intDoorRevealed = 0;
        for (int i = 1; i < intNumberOfDoors + 1; i++) {
        	if (i != intCarDoor && i != intChoice) {
        		intDoorRevealed = i;
        	}
        }
        System.out.println("Revealed: " + intDoorRevealed);
        
        // The player decides to switch or not
        boolean blnSwitch = getRandomBoolean();
        
        if (blnSwitch) {
        	for (int i = 1; i < intNumberOfDoors + 1; i++) {
            	if (i != intDoorRevealed && i != intChoice) {
            		intChoice = i;
            	}
            }
        }
    	
    	System.out.println("Switch? " + blnSwitch);
    	System.out.println("Choice: " + intChoice);
    	
    	// Check if the player made the right choice
    	if (intChoice == intCarDoor) {
    		blnWin = true;
    		System.out.println("You win!");
    	} else {
    		System.out.println("You lose...");
    	}
    }
    
    
    
    // Returns a random boolean
    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

}