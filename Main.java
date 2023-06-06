import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    //Welcome message
    System.out.println("WELCOME TO WORDLE:");
    
    boolean user = true;
    while (user) {
      
      //Guess counter
      int guess = 6;
      
      //Object for the game to commence
      Words w1 = new Words();
      
      //Sets the mystery word for the user
      String target = w1.getTarget();
      
      //If the guess in the while loop reaches 0, the user has ran out of attempts 
      while (guess > 0) {
        
        //Initial instructions
        System.out.println("Enter a 5-letter guess (only lowercase letters): "); 
        String compare = input.next();

        //Direct comparison
        if(compare.equals(target)){ 
          System.out.println("You got it in " + (7 - guess) + " moves!");
          break;
        }

        //Else use the other, more exact method
        else{
          w1.compareGuess(compare);
        }
        
        //Decrease the number of guesses left
        guess--;
        
        //User clarity and FYI for the user
        System.out.println("\nYou have " + (guess) + " guesses remaining."); 
      }
      
      //Asks the user if they want to play again
      System.out.println("The game is now over! The word was: " + target + ". \nPlay again? (Y/N) ");
      String again = input.next();

      //What happens next is based on the previous user input
      if (again.equals("Y")){
        user = true;
      } 

      //If they don't want to play, the code ends  
      else { 
        System.out.println("Thank you for playing.");
        break;
      }
    }
  }
}