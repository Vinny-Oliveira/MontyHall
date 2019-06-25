import java.util.Scanner;

public class ChooseDoor {
	
    public static void main(String[] args) {

         
    	Scanner scan = new Scanner(System.in);
        System.out.println("Enter how many games:"); 
        int intNumberOfGames = scan.nextInt();
        System.out.println("Play " + intNumberOfGames + " times.");
        
        scan.close();
        
        if (intNumberOfGames < 1) { return; }
        
        int intSwitchAndWin = 0;
        int intNotSwitchAndWin = 0;
        
        for (int i = 0; i < intNumberOfGames; i++) {
        	boolean gameResult[] = playGame();
        	
        	if (gameResult[0] && gameResult[1]) {
        		intSwitchAndWin++;
        	} else if (!gameResult[0] && gameResult[1]) {
        		intNotSwitchAndWin++;
        	}
        }
        
        double ratioSwitchAndWin = (double)intSwitchAndWin / (double)intNumberOfGames;
//        double ratioNotSwitchAndWin = (double)intNotSwitchAndWin / (double)intNumberOfGames;
        
        System.out.println("Ratio for switching and winning: " + ratioSwitchAndWin);
//        System.out.println("Ratio for not switching and winning: " + ratioNotSwitchAndWin);
        
    }
    
    // Plays Monty Hall's game and returns: [Switch or Not , Win or Not]
    public static boolean[] playGame() {
        boolean[] result = new boolean[2];

        boolean blnWin = false;
    	int intNumberOfDoors = 3;
    	
        int intCarDoor = (int)(Math.random() * intNumberOfDoors + 1); // Door where the car is
        int intChoice = (int)(Math.random() * intNumberOfDoors + 1); // Door chosen by the player
        // System.out.println("Car: " + intCarDoor);
        // System.out.println("Choice: " + intChoice);
        
        // Door revealed
        int intDoorRevealed = 0;
        for (int i = 1; i < intNumberOfDoors + 1; i++) {
        	if (i != intCarDoor && i != intChoice) {
        		intDoorRevealed = i;
        	}
        }
        // System.out.println("Revealed: " + intDoorRevealed);
        
        // The player decides to switch or not
        boolean blnSwitch = getRandomBoolean();
        
        if (blnSwitch) {
        	for (int i = 1; i < intNumberOfDoors + 1; i++) {
            	if (i != intDoorRevealed && i != intChoice) {
            		intChoice = i;
            	}
            }
        }
    	
    	// System.out.println("Switch? " + blnSwitch);
    	// System.out.println("Choice: " + intChoice);
    	
    	// Check if the player made the right choice
    	if (intChoice == intCarDoor) {
    		blnWin = true;
    		// System.out.println("You win!");
        } 
        // else {
    	// 	System.out.println("You lose...");
        // }
        
    	result[0] = blnSwitch;
    	result[1] = blnWin;
        return result;
    }
    
    // Returns a random boolean
    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

}