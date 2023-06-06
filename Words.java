import java.util.ArrayList;

public class Words {
  //Instance variables to setup the wordle game
  private String[] array;
  private String target;

  //Letters for the user to be printed out 
  private ArrayList<String> letters = new ArrayList<String>(); 
  
  public Words() {
    //Array to contain the 5 letter random words
    array = new String[] {"death", "power", "dream", "guard", "cable", "adult", "sight", "alarm", "force", "wound", "brave", "panic", "faith", "equal", "grade", "voice", "drive", "tiles", "track", "match", "games", "sport", "plane", "plain", "float", "sting", "party", "shore", "shine", "route", "quest", "unite", "final", "worth", "proud", "false", "blind", "crush", "grain", "quake", "sharp", "guide", "march", "image", "clout"};

    //Add the alphabet to the ArrayList to begin the game
    letters.add("a");
    letters.add("b");
    letters.add("c");
    letters.add("d");
    letters.add("e");
    letters.add("f");
    letters.add("g");
    letters.add("h");
    letters.add("i");
    letters.add("j");
    letters.add("k");
    letters.add("l");
    letters.add("m");
    letters.add("n");
    letters.add("o");
    letters.add("p");
    letters.add("q");
    letters.add("r");
    letters.add("s");
    letters.add("t");
    letters.add("u");
    letters.add("v");
    letters.add("w");
    letters.add("x");
    letters.add("y");
    letters.add("z");

    
    //Sets the mystery word for the user to guess 
    int index = (int) (Math.random() * array.length);
    target = array[index];
  }


  public String getArray(){
    //Prints out the array of letters for user
    String output = "{";
    for(int i = 0; i < letters.size(); i++){
        output += letters.get(i) + ", ";
    }
    output += "}";
    return output;
  }

  public String getTarget(){ //Getter for the target/mystery word
    return target;
  }

  //After a user inputs a word, each of the letters are systematically removed from the ArrayList of the alphabet to make it easier for them to guess
  public void removeGuess(String user){ 
    for(int i = 0; i < letters.size(); i++){
      if(letters.get(i).equals(user)){
        letters.remove(i);
      }
    }
  }

  //Meat of the code 
   public void compareGuess(String user) {
    for (int i = 0; i < user.length(); i++) {
      if (user.substring(i, i + 1).equals(target.substring(i, i + 1))){ //Code for a Green (CORRECT PLACE) letter, hence the direct .equals method
        System.out.print("G");
      } 
      else if (target.indexOf(user.substring(i,i+1)) > -1){ //Code for a Yellow (NOT IN THE RIGHT PLACE) letter, hence the indexOf
        System.out.print("Y");
      } 
      else { //Everything else is printing out a X
        System.out.print("X"); 
      }
      removeGuess(user.substring(i,i+1)); //Removes the letters systematically
    }
    System.out.print("\nThese are the available letters for guessing: ");
    System.out.println(getArray() + "\n"); 
     //Prints out the array of alphabet letters for the best user experience and clarity
   }
}