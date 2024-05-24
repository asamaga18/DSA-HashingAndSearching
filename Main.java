import java.util.*;

class Main {
  public static void main(String[] args) {

    // Declare variables
    String[] hash = new String[13];
    Scanner userScan = new Scanner(System.in);
    String initial[] = {"DOLPHINS", "PATRIOTS", "JETS", "BILLS", "STEELERS", "BROWNS", "OILERS"};
    int key = 0;
    
    // Fill array with teams
    for(int i = 0; i < 7; i++)
    {
      key = hasher(initial[i]);

      // Increase key if spot is filled
      while(hash[key] != null){
        key+=1;
        if(key == 13)
          key = 0;
      }
      hash[key] = initial[i];
    }

    String input = "";
    // Loop for new teams
    for(int i = 0; i < 6; i++)
    {
      // Get user input
      System.out.print("Enter Team Name(All-Caps): ");
      input = userScan.nextLine();
      
      key = hasher(input);

      // Increase key if spot is filled      
      while(hash[key] != null){
        
        // Prints if input is already in array
        if(hash[key].equals(input))
        {
          System.out.println(input+ " is already in array at #" + key + "\n");
          break;
        }
        key+=1;
        if(key == 13)
          key = 0;
      }
      if(hash[key] == null)
      {
        hash[key] = input;
        System.out.println(input + " stored in #" + key +"\n");
      }
    }

    // Loop through array to print it
    for(int i = 0; i < 13; i++)
    {
      if(hash[i] == null)
        System.out.println(i + ".");
      else
        System.out.println(i + ". " + hash[i]);
    }
    userScan.close();
  }

  // method to get key value
  public static int hasher(String team){

    // declare variables
    int k = 0;
    int valtemp = 0;
    int value = 0;

    // loop through each character of the string
    for(int i = 0; i < team.length(); i++){
      valtemp = (int) team.charAt(i);
      valtemp -= 64;

      // adds value if character is a capital letter
      if (valtemp >= 1 && valtemp <= 26)
        value += valtemp;

      // Case to print any ignored non-letter values
      else {
        System.out.println("Ignored: " + team.charAt(i));
      }
    }

    // Ignores input if word is empty
    if (value != 0) {

      // Get hash index
      k = value % 13;
    }
    return k;
  }
}